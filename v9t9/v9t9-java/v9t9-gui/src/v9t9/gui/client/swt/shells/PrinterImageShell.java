/*
  PrinterImageShell.java

  (c) 2014 Ed Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package v9t9.gui.client.swt.shells;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MenuDetectEvent;
import org.eclipse.swt.events.MenuDetectListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Scrollable;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.ejs.gui.common.SwtUtils;

import ejs.base.properties.IProperty;
import v9t9.common.dsr.IPrinterImageEngine;
import v9t9.common.dsr.IPrinterImageListener;
import v9t9.gui.EmulatorGuiData;

/**
 * @author ejs
 *
 */
public class PrinterImageShell implements IPrinterImageListener {
	private static Logger log = Logger.getLogger(PrinterImageShell.class);
	
	private Shell shell; 
	private CTabFolder tabFolder;
	
	// all for the current page; old pages are abandoned
	private Canvas canvas;
	/** scaled image of current page */
	private Image canvasImage; 
	
	private double zoom = 1.0;
	
	protected int pageNum;
	
	/** unscaled images with raw data */
	private Map<Integer, Image> pageImages = new HashMap<Integer, Image>();
	
	
	protected long nextUpdateTime;
	protected long lastUpdateTime;
	private GridData tabFolderData;
	private IPrinterImageEngine engine;

	protected boolean contentsChanged;

	public PrinterImageShell(IPrinterImageEngine engine) {
		log.info("creating shell for engine " + engine.getPrinterId());
		this.engine = engine;
		newShell();
		engine.addListener(this);
	}
	
	/**
	 * 
	 */
	private void newShell() {
		shell = new Shell(SWT.TOOL | SWT.TITLE | SWT.RESIZE | SWT.CLOSE);

		shell.setText("Printer Output");
		shell.setSize(400, 400);
		
		shell.addDisposeListener(new DisposeListener() {
			
			@Override
			public void widgetDisposed(DisposeEvent e) {
				for (Image image : pageImages.values()) {
					image.dispose();
				}
				pageImages.clear();
				if (canvasImage != null)
					canvasImage.dispose();
				canvasImage = null;
			}
		});
		
		GridLayoutFactory.fillDefaults().applyTo(shell);
		
		tabFolder = new CTabFolder(shell, SWT.TOP);
		tabFolderData = GridDataFactory.fillDefaults().grab(true, true).create();
		tabFolder.setLayoutData(tabFolderData);
		
		GridLayoutFactory.fillDefaults().applyTo(tabFolder);
		tabFolder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CTabItem item = tabFolder.getSelection();
				if (item != null) {
					Scrollable scrollable = (Scrollable) item.getControl();
					if (scrollable != null) {
						scrollable.getVerticalBar().setSelection(0);
					}
					contentsChanged = true;
				}
			}
		});
	
		ToolBar toolbar = new ToolBar(tabFolder, SWT.NONE);
		tabFolder.setTopRight(toolbar);
		
		tabFolder.addMenuDetectListener(new MenuDetectListener() {
			
			@Override
			public void menuDetected(MenuDetectEvent e) {
				populateMenu(e.x, e.y);
			}
		});

		final ToolItem zoomIn = new ToolItem(toolbar, SWT.PUSH);
		zoomIn.setImage(EmulatorGuiData.loadImage(tabFolder.getDisplay(), "icons/zoom_plus.gif"));
		zoomIn.setToolTipText("Zoom In");
		zoomIn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				zoom(zoom * 2);
			}
		});
		final ToolItem zoomOut = new ToolItem(toolbar, SWT.PUSH);
		zoomOut.setImage(EmulatorGuiData.loadImage(tabFolder.getDisplay(), "icons/zoom_minus.gif"));
		zoomOut.setToolTipText("Zoom Out");
		zoomOut.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				zoom(zoom / 2);
			}
		});
		final ToolItem zoomReset = new ToolItem(toolbar, SWT.PUSH);
		zoomReset.setImage(EmulatorGuiData.loadImage(tabFolder.getDisplay(), "icons/zoom_equal.gif"));
		zoomReset.setToolTipText("Zoom to 1.0");
		zoomReset.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				zoom(1.0);
			}
		});
		final ToolItem newPage = new ToolItem(toolbar, SWT.DROP_DOWN);
		newPage.setImage(EmulatorGuiData.loadImage(tabFolder.getDisplay(), "icons/formfeed.gif"));
		newPage.setToolTipText("Start new page");
		newPage.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (e.detail != SWT.ARROW)
					engine.newPage();
				else
					populateMenu(e.x, e.y);
			}
		});
		
		tabFolder.setTabHeight(28);
	}


	/**
	 * @param e
	 */
	protected void populateMenu(int x, int y) {
		Menu menu = new Menu(tabFolder);
		
		MenuItem deleteItem = new MenuItem(menu, SWT.PUSH);
		deleteItem.setText("Delete older pages");
		deleteItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (tabFolder.getItemCount() > 0) {
					CTabItem last = tabFolder.getItem(tabFolder.getItemCount() - 1);
					for (CTabItem item : tabFolder.getItems()) {
						if (item != last)
							item.dispose();
					}
				}
				for (Iterator<Map.Entry<Integer, Image>> iterator = pageImages.entrySet().iterator(); iterator
						.hasNext();) {
					Map.Entry<Integer, Image> ent = iterator.next();
					if (ent.getKey() != pageNum) {
						ent.getValue().dispose();
						iterator.remove();
					}
				}
				
			}
		});

		MenuItem inkItem = new MenuItem(menu, SWT.CASCADE);
		inkItem.setText("Ink Level");
		
		Menu inkMenu = new Menu(inkItem);
		
		addInkItem(inkMenu, "Low", 0.25);
		addInkItem(inkMenu, "Medium", 0.5);
		addInkItem(inkMenu, "High", 0.75);
		addInkItem(inkMenu, "Black", 1.0);
		
		inkItem.setMenu(inkMenu);

		SwtUtils.runMenu(null, x, y, menu);
	}

	/**
	 * @param inkMenu
	 * @param label
	 * @param level
	 */
	private void addInkItem(Menu inkMenu, String label, final double level) {
		final IProperty inkLevel = engine.getInkLevel();
		MenuItem inkItem = new MenuItem(inkMenu, SWT.RADIO);
		inkItem.setText(label);
		inkItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				inkLevel.setDouble(level);
			}
		});
		if (Math.abs(inkLevel.getDouble() - level) < 0.001) {
			inkItem.setSelection(true);
		}
	}

	protected void zoom(double toZoom) {
		this.zoom = toZoom;
		updatePageZooms();
	}

	/**
	 * 
	 */
	private void updatePageZooms() {
		CTabItem[] items = tabFolder.getItems();
		for (int i = 0; i < items.length; i++) {
			CTabItem item = items[i];
			ScrolledComposite scrolled = (ScrolledComposite) item.getControl();
			Composite canvas = (Composite) scrolled.getContent();
			Image image = pageImages.get(item.getData());
			if (image != null) {
				Rectangle bounds = image.getBounds();
				if (canvasImage != null)
					canvasImage.dispose();
				
				Point sz = new Point((int) (bounds.width * zoom), (int) (bounds.height * zoom));
				canvas.setSize(sz);
	            canvas.layout();
	            canvasImage = new Image(canvas.getDisplay(), sz.x, sz.y);
	            contentsChanged = true;
			}
		}
		tabFolder.redraw();
	}

	/* (non-Javadoc)
	 * @see v9t9.common.dsr.IPrinterImageListener#bytesProcessed(byte[])
	 */
	@Override
	public void bytesProcessed(byte[] bytes) {
		// ignore
	}
	
	/* (non-Javadoc)
	 * @see v9t9.common.dsr.IRS232HtmlListener#updated(java.lang.String)
	 */
	@Override
	public void updated(final Object imageObj) {
		contentsChanged = true;
		
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				if (canvas == null || canvas.isDisposed() || tabFolder.getItemCount() == 0) {
					newPage(imageObj);
				}
				long now = System.currentTimeMillis();
				lastUpdateTime = now;
				if (now >= nextUpdateTime) {
					canvas.redraw();
					nextUpdateTime = now + 500;
					
					queueRedrawSoon();
				}
			}
		});
	}

	/**
	 * 
	 */
	protected void queueRedrawSoon() {
		Display.getDefault().timerExec(100, new Runnable() {
			public void run() {
				if (canvas == null || canvas.isDisposed())
					return;
				
				// still printing?
				long now = System.currentTimeMillis();
				if (lastUpdateTime + 5000 > now) {
					nextUpdateTime = now + 500;
					if (lastUpdateTime + 1000 < now)
						engine.flushBuffer();
					canvas.redraw();
					queueRedrawSoon();
				}
			}
		});		
	}

	/* (non-Javadoc)
	 * @see v9t9.common.dsr.IRS232HtmlListener#newPage()
	 */
	@Override
	public void newPage(final Object imageObj) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				
				Image image = (Image) imageObj;
				
				createNewPage(image);
			}
		});
	}

	/**
	 * @return
	 */
	public Shell getShell() {
		return shell;
	}

	/**
	 * @param image
	 */
	protected void createNewPage(Image image) {
		final int thisPage = ++pageNum;
		
		log.info("new page: " + thisPage + " for canvas: " + canvas);
		
		if (canvas == null || canvas.isDisposed()) {
			if (shell.isDisposed()) {
				newShell();
			}
			shell.open();
		}
		
		CTabItem item = new CTabItem(tabFolder, SWT.NONE | SWT.CLOSE);
		item.setData(thisPage);
		
		item.addDisposeListener(new DisposeListener() {
			
			@Override
			public void widgetDisposed(DisposeEvent e) {
				pageImages.remove(thisPage);
			}
		});
		
		pageImages.put(thisPage, image);
		
		ScrolledComposite scrolled = new ScrolledComposite(tabFolder, SWT.V_SCROLL | SWT.H_SCROLL);
		scrolled.setAlwaysShowScrollBars(false);
		item.setControl(scrolled);
		GridLayoutFactory.swtDefaults().applyTo(scrolled);
		
		canvas = new Canvas(scrolled, SWT.BORDER | SWT.DOUBLE_BUFFERED);
		
		scrolled.setContent(canvas);

		GridDataFactory.fillDefaults().grab(true, true).applyTo(canvas);
		
		item.setText("Page " + thisPage);
		
		if (pageNum == 1) {
			zoom = 1.0;
			Rectangle bounds = image.getBounds();
			while (zoom * bounds.height > shell.getDisplay().getBounds().height)
				zoom /= 2;
			
		}
		
		updatePageZooms();
		if (pageNum == 1)
			shell.pack();

		canvas.addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				if (contentsChanged) {
					reprintPage(thisPage);
					contentsChanged = false;
				}

				if (canvasImage != null && !canvasImage.isDisposed()) {
					Rectangle bounds = canvasImage.getBounds();
					
//					int cx1 = Math.max(0, e.x);
//					int cy1 = Math.max(0, e.y);
//					int cx2 = Math.min(bounds.width, e.x + e.width);
//					int cy2 = Math.min(bounds.height, e.y + e.height);
//					
//					e.gc.drawImage(canvasImage, cx1, cy1, cx2-cx1, cy2-cy1, cx1, cy1, cx2-cx1, cy2-cy1);
					
					// FIXME
					e.gc.drawImage(canvasImage, 0, 0);
					
					if (thisPage == pageNum) {
						// draw "print head" in appropriate position
						
						double rowPerc = engine.getPageRowPercentage();
						double colPerc = engine.getPageColumnPercentage();
						int pixX = (int) (colPerc * bounds.width);
						int pixY = (int) (rowPerc * bounds.height);
						
						e.gc.setForeground(e.gc.getDevice().getSystemColor(SWT.COLOR_GREEN));
						e.gc.setLineWidth(4);
						e.gc.drawLine(0, pixY, bounds.width, pixY);
						e.gc.drawLine(pixX, pixY, pixX, pixY + 16);
					}

				}
			}
		});
		
		tabFolder.setSelection(item);
	}

	/**
	 * @param thisPage
	 * @param e
	 */
	protected void reprintPage(final int thisPage) {
		GC gc = new GC(canvasImage);
		
		//System.out.println(System.currentTimeMillis() + ": start");
		Image swtImage = pageImages.get(thisPage);
		if (swtImage == null) {
			gc.fillRectangle(canvasImage.getBounds());
		} else {
			if (zoom < 1) {
				// these are very slow when zooming out
				gc.setAntialias(SWT.ON);
				gc.setInterpolation(SWT.DEFAULT);
			}
			Transform xfrm = new Transform(gc.getDevice());
			xfrm.scale((float) zoom, (float) zoom);
			gc.setTransform(xfrm);
			gc.drawImage(swtImage, 0, 0);
			gc.setTransform(null);
			xfrm.dispose();
		}
		gc.dispose();
		//System.out.println(System.currentTimeMillis() + ": end");
	}

}
