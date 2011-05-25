/**
 * 
 */
package v9t9.emulator.clients.builtin.swt;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.opengl.GL20.*;

import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.opengl.GLCanvas;
import org.eclipse.swt.opengl.GLData;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.ejs.coffee.core.properties.IProperty;
import org.ejs.coffee.core.properties.IPropertyListener;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.OpenGLException;
import org.lwjgl.util.glu.GLU;

import v9t9.emulator.clients.builtin.BaseEmulatorWindow;
import v9t9.emulator.clients.builtin.video.ImageDataCanvas;
import v9t9.emulator.clients.builtin.video.ImageDataCanvas24Bit;
import v9t9.emulator.clients.builtin.video.VdpCanvas;
import v9t9.engine.files.DataFiles;

/**
 * Render video into an OpenGL canvas in an SWT window
 * @author ejs
 *
 */
public class SwtLwjglVideoRenderer extends SwtVideoRenderer implements IPropertyListener {
	static {
		//System.out.println(System.getProperty("java.library.path"));
	}
	private GLCanvas glCanvas;
	private GLData glData;
	// pfft, lwjgl doesn't handle all our modes
	//private MemoryCanvas memoryCanvas;
	private ImageDataCanvas imageCanvas;
	private int vdpCanvasTexture;
	private ByteBuffer vdpCanvasBuffer;
	
	private boolean supportsShaders = true;
	
	private int fragShader;
	private int vertexShader;
	private int programObject;
	
	private Rectangle glViewportRect;
	private Rectangle imageRect;
	private Listener resizeListener;
	private Texture monitorTextureData;

	protected VdpCanvas createVdpCanvas() {
		imageCanvas = new ImageDataCanvas24Bit();
		vdpCanvasBuffer = ByteBuffer.allocateDirect(imageCanvas.getImageData().bytesPerLine * imageCanvas.getImageData().height);

		return imageCanvas;
	}

	/* (non-Javadoc)
	 * @see v9t9.emulator.clients.builtin.swt.SwtVideoRenderer#dispose()
	 */
	@Override
	public void dispose() {
		BaseEmulatorWindow.settingMonitorDrawing.removeListener(this);
		glCanvas.getParent().removeListener(SWT.Resize, resizeListener);
		super.dispose();
	}
	
	/* (non-Javadoc)
	 * @see org.ejs.coffee.core.properties.IPropertyListener#propertyChanged(org.ejs.coffee.core.properties.IProperty)
	 */
	@Override
	public void propertyChanged(IProperty property) {
		if (property == BaseEmulatorWindow.settingMonitorDrawing) {
			updateShaders();
		}
	}

	protected void updateShaders() {
		if (!glCanvas.isDisposed()) {
			Display.getDefault().syncExec(new Runnable() {
				public void run() {

					glCanvas.setCurrent();
					try {
						GLContext.useContext(glCanvas);
						compileLinkShaders();
						glCanvas.redraw();
						updateWidgetSizeForMode();
						reblit();
					} catch (LWJGLException e) { 
						e.printStackTrace(); 
						return;
					}
					
				}
			});
		}
	}
	protected Canvas createCanvasControl(Composite parent, int flags) {
		glData = new GLData();
		glData.doubleBuffer = true;
		glCanvas = new GLCanvas(parent, flags | getStyleBits(), glData);
		
		BaseEmulatorWindow.settingMonitorDrawing.addListener(this);

		
		resizeListener = new Listener() {

			@Override
			public void handleEvent(Event event) {
				glCanvas.setCurrent();
				try {
					GLContext.useContext(glCanvas);
					updateWidgetSizeForMode();
				} catch (LWJGLException e) {
					e.printStackTrace();
				}

			} 
			
		};
		parent.addListener(SWT.Resize, resizeListener);

		glCanvas.setCurrent();
		try {
			GLContext.useContext(glCanvas);
		} catch (LWJGLException e) { 
			e.printStackTrace(); 
			return null;
		}
		
		
		glShadeModel(GL_FLAT);
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		glClearDepth(1.0f);
		
		setupCanvasTexture();
		setupMonitorTexture();
		
		defineShaders();
		
		return glCanvas;
	}


	private void setupCanvasTexture() {
		vdpCanvasTexture = glGenTextures();
		
		// do not read data until blit time
	}
	
	private void setupMonitorTexture() {
		
		try {
			monitorTextureData = new TextureLoader().getTexture("shaders/monitorRGB.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void defineShaders() {
		if (!supportsShaders) 
			return;
		
		try {
			fragShader = glCreateShader(GL_FRAGMENT_SHADER);
			vertexShader = glCreateShader(GL_VERTEX_SHADER);
			programObject = glCreateProgram();
		} catch (OpenGLException e) {
			System.out.println("OpenGL 2.0 shaders not supported");
			supportsShaders = false;
			return;
		}
		
		compileLinkShaders();
	}

	static class GLShaderException extends Exception {

		private static final long serialVersionUID = 3737775043188087342L;
		private final String filename;

		public GLShaderException(String filename, String message, 
				Throwable cause) {
			super(message, cause);
			this.filename = filename;
		}
		/* (non-Javadoc)
		 * @see java.lang.Throwable#toString()
		 */
		@Override
		public String toString() {
			return "Shader exception: " + filename + ": " + getMessage() +
			 (getCause() != null ? "\n("+getCause().toString()+")" : "");
		}
		/**
		 * @return the filename
		 */
		public String getFilename() {
			return filename;
		}
		
	}
	/**
	 * 
	 */
	private void compileLinkShaders() {
		if (!supportsShaders)
			return;
		
		try {
			String base = "shaders/" + (isMonitorEffectEnabled() ? "crt2" : "std");
			compileShader(fragShader, base + ".frag");
			compileShader(vertexShader, base + ".vert");
			
			linkShaders(programObject, fragShader, vertexShader);

		} catch (GLShaderException e) {
			glDeleteProgram(programObject);
			glDeleteShader(fragShader);
			glDeleteShader(vertexShader);
			programObject = fragShader = vertexShader = 0;
			e.printStackTrace();
		}
	}

	private boolean isMonitorEffectEnabled() {
		return BaseEmulatorWindow.settingMonitorDrawing.getBoolean();
	}

	private void compileShader(int shaderObj, String filename) throws GLShaderException {
		URL url = getClass().getClassLoader().getResource(filename);
		//System.out.println("Compiling " + file + " to " +shaderObj);
		String text;
		try {
			text = DataFiles.readInputStreamText(url.openStream());
		} catch (IOException e) {
			throw new GLShaderException(filename, "Cannot read file " + url, e);
		}
		glShaderSource(shaderObj, text);
		glCompileShader(shaderObj);
		
		int error = glGetShader(shaderObj, GL_COMPILE_STATUS);
		if (error != GL_TRUE) {
			throw new GLShaderException(filename, glGetShaderInfoLog(shaderObj, 65536),
					null);
		}
	}


	private void linkShaders(int programObj, int... shaders) throws GLShaderException {
		for (int shader : shaders) {
			//System.out.println("Linking " + shader + " to " + programObj);
			glDetachShader(programObj, shader);
			glAttachShader(programObj, shader);
		}
		
		glLinkProgram(programObj);
		
		int error = glGetShader(programObj, GL_LINK_STATUS);
		if (error != GL_TRUE) {
			throw new GLShaderException("<<program>>", 
					glGetShaderInfoLog(programObj, 65536),
					null);
		}
	}

	/* (non-Javadoc)
	 * @see v9t9.emulator.clients.builtin.swt.SwtVideoRenderer#canvasResized(v9t9.emulator.clients.builtin.video.VdpCanvas)
	 */
	@Override
	public void canvasResized(VdpCanvas canvas) {
		super.canvasResized(canvas);
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				updateWidgetSizeForMode();
			}
		});
	}

	/* (non-Javadoc)
	 * @see v9t9.emulator.clients.builtin.swt.SwtVideoRenderer#updateWidgetSizeForMode()
	 */
	@Override
	protected void updateWidgetSizeForMode() {
		super.updateWidgetSizeForMode();
		
		Rectangle bounds = glCanvas.getClientArea();
		//System.out.printf("updateWidgetSizeForMode at %s%n", glCanvas.getParent().getBounds());
		
		Rectangle destRect = new Rectangle(0, 0, 
				bounds.width, bounds.height);
		
		imageRect = physicalToLogical(destRect);
		glViewportRect = logicalToPhysical(imageRect);
		//glViewportRect = logicalToPhysical(new Rectangle(0, 0, vdpCanvas.getVisibleWidth(), vdpCanvas.getVisibleHeight()));
		//imageRect = physicalToLogical(glViewportRect);
		
		System.out.printf("Viewport: %d x %d --> %d x %d%n",
				bounds.width, bounds.height,
				destRect.width, destRect.height);
		glViewport(0, 0,
				glViewportRect.width, 
				glViewportRect.height);
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		GLU.gluOrtho2D(0.0f, 1.0f, 1.0f, 0);
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		
		if (programObject != 0) {
			// bind program so we can look up uniforms
			glUseProgram(programObject);
			
			System.out.printf("Sending sizes: %s and %s%n", imageRect, glViewportRect);
			glUniform2i(glGetUniformLocation(programObject, "visible"), imageRect.width, imageRect.height);
			glUniform2i(glGetUniformLocation(programObject, "viewport"), glViewportRect.width, glViewportRect.height);
			
			glUniform1i(glGetUniformLocation(programObject, "canvasTexture"), 0);
			glUniform1i(glGetUniformLocation(programObject, "pixelTexture"), 1);
			
			glActiveTexture(GL_TEXTURE1);
			
			glMatrixMode(GL_TEXTURE);
			
			glLoadIdentity();
			glScalef(vdpCanvas.getVisibleWidth() > 256 ? vdpCanvas.getVisibleWidth() / 2 : vdpCanvas.getVisibleWidth(), 
					vdpCanvas.isInterlacedEvenOdd() ? vdpCanvas.getVisibleHeight() / 2 : vdpCanvas.getVisibleHeight(), 1.0f);

			glMatrixMode(GL_MODELVIEW);
			
			glActiveTexture(GL_TEXTURE0);
			

		}
	}

	
	protected void doRepaint(GC gc, Rectangle updateRect) {
		reblit();
	}
	
	/* (non-Javadoc)
	 * @see v9t9.emulator.clients.builtin.swt.SwtVideoRenderer#doRedraw(org.eclipse.swt.graphics.Rectangle)
	 */
	@Override
	protected void doTriggerRedraw(Rectangle redrawRect) {

		reblit();
	}


	private void reblit() {
		glCanvas.setCurrent();
		try {
			GLContext.useContext(glCanvas);
		} catch (LWJGLException e) { 
			e.printStackTrace(); 
			return;
		}
		
		if (programObject != 0) {
			glUseProgram(programObject);
		}

		glClear(GL_COLOR_BUFFER_BIT);
		
		glEnable(GL_TEXTURE_2D);
		
		/*
		 * Main texture: the VDP canvas
		 */
		glActiveTexture(GL_TEXTURE0);
		
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);

		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
		glTexEnvf(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_REPLACE);
		
		glBindTexture(GL_TEXTURE_2D, vdpCanvasTexture);
		
		// copy current bitmap to texture (EXPENSIVE ON SLOW CARDS!)
		vdpCanvasBuffer = imageCanvas.copy(vdpCanvasBuffer);
		
		//System.out.printf("Texture size: %d x %d%n", 
		//		imageCanvas.getVisibleWidth(),
		//		imageCanvas.getVisibleHeight());
		glPixelStorei(GL_UNPACK_ALIGNMENT, 1);
		
		glTexImage2D(GL_TEXTURE_2D, 0, 
				GL_RGB,
				imageCanvas.getVisibleWidth(),
				imageCanvas.getVisibleHeight(),
				0, 
				GL_RGB,
				GL_UNSIGNED_BYTE, 
				vdpCanvasBuffer);		
		

		/*
		 * Second texture: the monitor overlay
		 */
		glActiveTexture(GL_TEXTURE1);
		if (isMonitorEffectEnabled()) {
			monitorTextureData.bind();


			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);

			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
			
		} else {
			glBindTexture(GL_TEXTURE_2D, 0);
		}
		
		glActiveTexture(GL_TEXTURE0);

		
		glColor3f(1.0f, 1.0f, 1.0f);
		
		glBegin(GL_QUADS);
		
		glMultiTexCoord2f(GL_TEXTURE1, 0, 0);
		glTexCoord2f(0f, 0f);		glVertex2i(0, 0);
		
		glMultiTexCoord2f(GL_TEXTURE1, 0, 1);
		glTexCoord2f(0f, 1.0f);		glVertex2i(0, 1);
		
		glMultiTexCoord2f(GL_TEXTURE1, 1, 1);
		glTexCoord2f(1.0f, 1.0f);	glVertex2i(1, 1);
		
		glMultiTexCoord2f(GL_TEXTURE1, 1, 0);
		glTexCoord2f(1.0f, 0f);		glVertex2i(1, 0);
		
		glEnd();
		
		/*
		glColor3f(0.2f, 0.4f, 0.6f);
		glBegin(GL_LINES);
		glVertex2i(0, 0);
		glVertex2i(vdpCanvas.getVisibleWidth(), vdpCanvas.getVisibleHeight());
		glEnd();
		*/
		
		glDisable(GL_TEXTURE_2D);

		if (programObject != 0) {
			glUseProgram(0); 
		
		}
		
		glCanvas.swapBuffers();
		
	}
	
}
