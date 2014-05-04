/**
 * 
 */
package v9t9.machine.printer;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import v9t9.common.dsr.IPrinterImageEngine;
import v9t9.common.dsr.IPrinterImageListener;
import v9t9.machine.EmulatorMachinesData;
import ejs.base.utils.ListenerList;

/**
 * @author ejs
 *
 */
public class EpsonPrinterImageEngine implements IPrinterImageEngine {
	
	/**
	 * 
	 */
	private static final int DOTS = 360;
	private ListenerList<IPrinterImageListener> listeners = new ListenerList<IPrinterImageListener>();
	private boolean firstPage = true;
	private boolean pageDirty = false;
	private int tabSize = 8;
	private boolean atEsc;
	private Image image;
	private int horizDpi;
	private int vertDpi;

	private Map<Character, CharacterMatrix> font = new HashMap<Character, CharacterMatrix>();
	private int charColumn;
	private int charRow;
	/** positions in 1/360 in */
	private int posX, posY;

	
	private int pixelWidth;
	private int pixelHeight;
//	private int charPixelHeight;
//	private int charPixelWidth;
	private int charMatrixHeight;
	private int charMatrixWidth;
	private double paperHeightInches;
	private double paperWidthInches;
	/** character size in 1/DOTS in */
	private int paperWidthDots;
	private int paperHeightDots;
	/** character size in 1/DOTS in */
	private int columnAdvanceDots = 4;
	/** character size in 1/DOTS in */
	private double charWidthDots = DOTS / 10.; //8. * 72 / 80;
	//private int charAdvanceDots = (int) (DOTS * 9. / 7 / 10.);
	private int charsPerLine = 80;
	/** character size in 1/72 in */
	private int lineHeightDots = DOTS / 6;
	
	private int marginLeftDots, marginRightDots;
	private int marginTopDots, marginBottomDots;
	
	private Command command;
	private ByteArrayOutputStream commandBytes = new ByteArrayOutputStream();
	private ByteArrayOutputStream buffer = new ByteArrayOutputStream();
	private int bufferToFill;
	private int previousColumnMask;
	private boolean enlarged;
	private boolean emphasized;
	private boolean condensed;
	
	/**
	 * 
	 */
	public EpsonPrinterImageEngine(int horizDpi, int vertDpi) {
		setPaperSize(8.5, 11.0);
		setDpi(300, 300);
		
		
		try {
			loadFont(EmulatorMachinesData.getResourceDataURL("printers/rx80_font.txt"), 9, 9);
		} catch (IOException e) {
			e.printStackTrace();
		}
		initPage();
	}
	
	/* (non-Javadoc)
	 * @see v9t9.common.dsr.IPrinterImageEngine#setDpi(int, int)
	 */
	@Override
	public void setDpi(int horizDpi, int vertDpi) {
		this.horizDpi = horizDpi;
		this.vertDpi = vertDpi;
		initPage();
	}
	/**
	 * @param dataURL
	 * @throws IOException 
	 */
	private void loadFont(URL dataURL, int width, int height) throws IOException {
		charMatrixWidth = width;
		charMatrixHeight = height;
		BufferedReader reader = new BufferedReader(new InputStreamReader(dataURL.openStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			if (line.length() == 3 && line.charAt(0) == '\'' && line.charAt(2) == '\'') {
				char ch = line.charAt(1);
				CharacterMatrix matrix = new CharacterMatrix(ch, width, height);
				for (int row = 0; row < height; row++) {
					line = reader.readLine();
					if (line == null)
						throw new IOException("missing row " + row + " for char " + ch);
					if (line.length() > width)
						throw new IOException("unexpected length in " + row + " for char " + ch);
					for (int col = 0; col < width; col++) {
						char c = col < line.length() ? line.charAt(col) : ' ';
						matrix.set(row, col, (c != '.' && c != ' '));
					}
				}
				font.put(ch, matrix);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see v9t9.machine.printer.IRS232HtmlHandler#addListener(v9t9.machine.printer.IRS232HtmlListener)
	 */
	@Override
	public void addListener(IPrinterImageListener listener) {
		listeners.add(listener);
	}
	/* (non-Javadoc)
	 * @see v9t9.machine.printer.IRS232HtmlHandler#removeListener(v9t9.machine.printer.IRS232HtmlListener)
	 */
	@Override
	public void removeListener(IPrinterImageListener listener) {
		listeners.remove(listener);
	}

	/* (non-Javadoc)
	 * @see v9t9.common.dsr.IPrinterImageEngine#flushPage()
	 */
	@Override
	public void flushPage() {
		if (firstPage || pageDirty) {
			newPage();
		}
	}
	/**
	 * 
	 */
	public void newPage() {
		if (pageDirty) {
			termPage();
			firePageUpdated();
		}
		initPage();
		fireNewPage();
	}
	/**
	 * 
	 */
	protected void fireNewPage() {
		pageDirty = false;
		firstPage = false;
		listeners.fire(new ListenerList.IFire<IPrinterImageListener>() {
			
			@Override
			public void fire(IPrinterImageListener listener) {
				listener.newPage(image);
			}
		});
	}
	/**
	 * 
	 */
	protected void firePageUpdated() {
		if (firstPage) {
			fireNewPage();
		}
		listeners.fire(new ListenerList.IFire<IPrinterImageListener>() {

			@Override
			public void fire(IPrinterImageListener listener) {
				listener.updated(image);
			}
		});
	}
	
	public void setPaperSize(double widthInches, double heightInches){
		this.paperWidthInches = widthInches;
		this.paperHeightInches = heightInches;
		paperHeightDots = (int) (paperHeightInches * DOTS);
		paperWidthDots = (int) (paperWidthInches * DOTS);
	}
	/**
	 * 
	 */
	protected void initPage() {
		pixelWidth = (int) (paperWidthInches * horizDpi);
		pixelHeight = (int)(paperHeightInches * vertDpi);
		
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				image = new Image(Display.getDefault(), pixelWidth, pixelHeight);
				GC gc = new GC(image);
				gc.setBackground(image.getDevice().getSystemColor(SWT.COLOR_WHITE));
				gc.fillRectangle(image.getBounds());
				gc.dispose();
				
			}
		});
		
		marginLeftDots = (int) (0.25 * DOTS);
		marginRightDots = paperWidthDots - marginLeftDots;
		marginTopDots  = (int) (0.5 * DOTS);
		marginBottomDots  = paperHeightDots - marginTopDots;
		
//		charPixelWidth = (int) ((rightPixel - leftPixel) / 80);
//		charPixelHeight = (int) ((bottomPixel - topPixel) / 66);
		
		posY = marginTopDots;
		
		carriageReturn();
		pageDirty = false;
		
		command = null;
		commandBytes.reset();
	}
	
	protected void termPage() {
	}

	/* (non-Javadoc)
	 * @see v9t9.common.dsr.IPrinterImageEngine#print(java.lang.String)
	 */
	@Override
	public void print(String text) {
		for (char ch : text.toCharArray())
			print(ch);
	}

	public enum Command {
		GRAPHICS_LINE_SPACING_1_8(0),
		LINE_SPACING_1_8('0'),
		LINE_SPACING_1_6('2'),
		//LINE_SPACING_DEFAULT('2'),
		LINE_SPACING('A', 1),
		EMPHASIZED_ON('E'),
		EMPHASIZED_OFF('F'),
		GRAPHICS_SINGLE_DENSITY('K', 2),
		GRAPHICS_DOUBLE_DENSITY('L', 2),
		;
		private char ch;
		private int count;

		Command(int ch) {
			this((char) ch, 0);
		}
		Command(char ch) {
			this(ch, 0);
		}
		Command(int ch, int count) {
			this((char) ch, count);
		}
		Command(char ch, int count) {
			this.ch = ch;
			this.count = count;
		}
		public char getCh() {
			return ch;
		}
		public int getCount() {
			return count;
		}
	}
	
	public void print(char ch) {
		if (command != null) {
			if (bufferToFill > 0) {
				buffer.write((byte) ch);
				bufferToFill--;
				if (bufferToFill == 0) {
					handleCommandWithBuffer();
					command = null;
					buffer.reset();
					commandBytes.reset();
				}
				return;
			}
			commandBytes.write((byte) ch);
			if (command.getCount() == commandBytes.size()) {
				handleCommand();
				commandBytes.reset();
				buffer.reset();
			}
			return;
		}
		if (atEsc) {
			atEsc = false;
			bufferToFill = 0;
			getCommand(ch);
			if (command != null && command.getCount() == 0) {
				handleCommand();
				commandBytes.reset();
				buffer.reset();
			}
			return;
		}

		if (ch == 0) {
			return;
		}

		switch (ch) {
		case 14:
			enlarged = true;
			break;
		case 15:
			condensed = true;
			break;
		case 18:
			condensed = false;
			break;
		case 20:
			enlarged = false;
			break;
		case '\r':
			carriageReturn();
			break;
		case '\n':
			newLine();
			break;
		case '\t':  {
			int space = (int) ((tabSize - charColumn % tabSize) * charWidthDots);
			if (space + posX >= marginRightDots) {
				carriageReturn();
				newLine();
			} else {
				posX += space; 
			}
			break;
		}
		case 27: {
			atEsc = true;
			break;
		}
			
		default:
			drawChar(ch);
			break;
		}
	}

	/**
	 * @param ch
	 */
	private void drawChar(char ch) {
		CharacterMatrix matrix = font.get(ch);
		if (matrix != null) {
			for (int cx = 0; cx < charMatrixWidth; cx++) {
				int by = matrix.getColumn(cx);
				
				if (!enlarged) {
					drawCharColumn(by);
				} else {
					int by2 = cx + 1 < charMatrixWidth ? matrix.getColumn(cx + 1) : 0;
					drawCharColumn(by | previousColumnMask);
					drawCharColumn(by | by2);
					previousColumnMask = by;
				}
			}
			pageDirty = true;
			previousColumnMask = 0;
		}
		advanceChar();
		firePageUpdated();
	}
	/**
	 * @param by
	 */
	private void drawCharColumn(final int by) {
		drawDots(0, by, 9);
		
		if (emphasized) {
			drawDots(columnAdvanceDots / 2, by, 9);
			
		}
		
		if (condensed) {
			posX += columnAdvanceDots / 2.;
		} else {
			posX += columnAdvanceDots;
		}
		
	}

	/**
	 * @param x
	 * @param y
	 */
	private void dot(final double x, final double y) {
		if (image == null || image.isDisposed()) {
			newPage();
		}
		GC gc = new GC(image);
		try {
			if ((horizDpi | vertDpi) < 200) {
				if (x - (int) x < 0.5 && y - (int) y < 0.5)
					gc.setForeground(gc.getDevice().getSystemColor(SWT.COLOR_BLACK));
				else
					gc.setForeground(gc.getDevice().getSystemColor(SWT.COLOR_DARK_GRAY));
				gc.drawPoint((int) x, (int) y);
			}
			else {
				gc.setBackground(gc.getDevice().getSystemColor(SWT.COLOR_BLACK));
				double w1 = horizDpi / 60., h1 = vertDpi / 60.;
				gc.setAlpha(192);
//				gc.fillOval((int) Math.round(x - w1/2.0), (int) Math.round(y - h1/2.0), (int) w1, (int) h1);
				w1 = horizDpi / 75.; h1 = vertDpi / 75.;
				gc.fillOval((int) Math.round(x - w1/2.0), (int) Math.round(y - h1/2.0), (int) w1, (int) h1);
			}
		} finally {
			gc.dispose();
		}
		
	}

	private double mapX(double pos) {
		return (pos * pixelWidth / paperWidthDots);
	}
	private int mapY(double pos) {
		return (int) (pos * pixelHeight / paperHeightDots);
	}
	/**
	 * 
	 */
	private void advanceChar() {
		charColumn++;
		if (charColumn >= charsPerLine) {
			carriageReturn();
			newLine();
			return;
		}
		posX += columnAdvanceDots * 2;
		//posX += charAdvanceDots;
		if (posX + charWidthDots >= paperWidthDots) {
			carriageReturn();
			newLine();
		}
				
	}
	protected void newLine() {
		charRow++;
		posY += lineHeightDots;
		if (posY + lineHeightDots >= marginBottomDots) {
			newPage();
		}
	}
	private void getCommand(char ch) {
		command = null;
		for (Command c : Command.values()) {
			if (c.getCh() == ch) {
				command = c;
				break;
			}
		}
		if (command == null) {
			System.err.println("unhandled command: 0x" + Integer.toHexString(ch));
		}
	}
	private void carriageReturn() {
		charColumn = 0;
		posX = marginLeftDots;
		firePageUpdated();
	}

	/**
	 * 
	 */
	private void handleCommand() {
		byte[] bytes = commandBytes.toByteArray();
		switch (command) {
		case LINE_SPACING_1_6:
			lineHeightDots = DOTS / 6;
			command = null;
			break;
		case LINE_SPACING_1_8:
			lineHeightDots = DOTS / 8;
			command = null;
			break;
		case LINE_SPACING:
			lineHeightDots = DOTS * (bytes[0] & 0xff) / 72;
			command = null;
			break;
		case EMPHASIZED_ON:
			emphasized = true;
			command = null;
			break;
		case EMPHASIZED_OFF:
			emphasized = false;
			command = null;
			break;
		case GRAPHICS_SINGLE_DENSITY:
			columnAdvanceDots = 6;
			bufferToFill = (bytes[0] & 0xff) | ((bytes[1] & 0xff) << 8);
			bufferToFill %= paperWidthDots;
			break;
		case GRAPHICS_DOUBLE_DENSITY:
			columnAdvanceDots = 3;
			bufferToFill = (bytes[0] & 0xff) | ((bytes[1] & 0xff) << 8);
			bufferToFill %= paperWidthDots;
			break;
		default:
			System.err.println("unhandled command: " + command);
			command = null;
			break;
		}
	}
	private void handleCommandWithBuffer() {
		byte[] bytes = buffer.toByteArray();
		switch (command) {
		case GRAPHICS_SINGLE_DENSITY:
			for (byte by : bytes) {
				drawDots(0, by, 8);
//				previousHeadDots = by;
				posX += columnAdvanceDots;
			}
			break;
		case GRAPHICS_DOUBLE_DENSITY:
			for (byte by : bytes) {
				drawDots(0, by, 8);
//				previousHeadDots = by;
				posX += columnAdvanceDots;
			}
			break;
		default:
			System.err.println("unhandled command: " + command);
		}
	}

	/**
	 * @param columnMask
	 */
	private void drawDots(int dotColumnOffs, int columnMask, int height) {
		double x = mapX(posX + dotColumnOffs);
		int mask = 1 << height;
		for (int cy = 0; cy < height; cy++) {
			int y = mapY(posY + cy * 6);
			if ((columnMask & mask) != 0) {
				dot(x, y);
				if (emphasized) {
//					dot(x2, y);
					int y2 = mapY(posY + cy * 6 + 3);
					dot(x, y2);
//					dot(x2, y2);
				}
			}
			mask >>= 1;
		}
		pageDirty = true;		
	}

	/* (non-Javadoc)
	 * @see v9t9.common.dsr.IPrinterImageEngine#getPageColumnPercentage()
	 */
	@Override
	public double getPageColumnPercentage() {
		return (double) posX / paperWidthDots;
	}
	/* (non-Javadoc)
	 * @see v9t9.common.dsr.IPrinterImageEngine#getPageRowPercentage()
	 */
	@Override
	public double getPageRowPercentage() {
		return (double) posY / paperHeightDots;
	}
}
