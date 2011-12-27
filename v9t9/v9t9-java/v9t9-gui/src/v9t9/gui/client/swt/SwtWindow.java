/**
 * 
 */
package v9t9.gui.client.swt;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TreeMap;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.RTFTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import ejs.base.properties.IProperty;
import ejs.base.properties.IPropertyListener;
import v9t9.common.client.IClient;
import v9t9.common.client.ISettingsHandler;
import v9t9.common.client.ISoundHandler;
import v9t9.common.events.IEventNotifier;
import v9t9.common.events.IEventNotifier.Level;
import v9t9.common.machine.IMachine;
import v9t9.common.settings.SettingSchema;
import v9t9.common.settings.Settings;
import v9t9.gui.EmulatorGuiData;
import v9t9.gui.client.swt.bars.BaseEmulatorBar;
import v9t9.gui.client.swt.bars.EmulatorButtonBar;
import v9t9.gui.client.swt.bars.EmulatorRnDBar;
import v9t9.gui.client.swt.bars.EmulatorStatusBar;
import v9t9.gui.client.swt.bars.ImageProvider;
import v9t9.gui.client.swt.bars.MultiImageSizeProvider;
import v9t9.gui.client.swt.shells.IToolShellFactory;
import v9t9.gui.client.swt.shells.ToolShell;
import v9t9.gui.client.swt.svg.ISVGLoader;
import v9t9.gui.client.swt.svg.SVGImageProvider;
import v9t9.gui.client.swt.svg.SVGSalamanderLoader;
import v9t9.gui.common.BaseEmulatorWindow;
import v9t9.gui.common.PrefUtils;

/**
 * Provide the emulator in an SWT window
 * @author ejs
 *
 */
public class SwtWindow extends BaseEmulatorWindow {
	
	private static final SettingSchema settingEmulatorWindowBounds =
		new SettingSchema(ISettingsHandler.INSTANCE, "EmulatorWindowBounds", String.class, "");
	
	protected Shell shell;
	protected Control videoControl;
	private Map<String, ToolShell> toolShells;
	private Timer toolUiTimer;
	private IFocusRestorer focusRestorer;
	private final IEventNotifier eventNotifier;
	private Composite videoRendererComposite;
	BaseEmulatorBar buttonBar;
	private EmulatorStatusBar statusBar;

	private IPropertyListener fullScreenListener;
	private boolean isHorizontal;

	private ImageProvider buttonImageProvider;
	private ImageProvider statusImageProvider;
	private ImageProvider rndImageProvider;

	private IProperty fullScreen;

	private EmulatorRnDBar rndBar;

	private IProperty showRnDBar;


	class EmulatorWindowLayout extends Layout {

		private Point vidSz;
		private Point sbSz;
		private Point bbSz;

		/* (non-Javadoc)
		 * @see org.eclipse.swt.widgets.Layout#computeSize(org.eclipse.swt.widgets.Composite, int, int, boolean)
		 */
		@Override
		protected Point computeSize(Composite composite, int wHint, int hHint,
				boolean flushCache) {
			
			if (composite.getChildren().length != 3)
				throw new IllegalStateException();
			
			Rectangle cur = composite.getBounds();
			
			if (flushCache) {
				vidSz = sbSz = bbSz = null;
			}
			
			if (vidSz == null)
				vidSz = videoRendererComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT);
			
			if (!isHorizontal) {
				if (sbSz == null)
					sbSz = statusBar.getButtonBar().computeSize(SWT.DEFAULT, cur.height); 
				if (bbSz == null)
					bbSz = buttonBar.getButtonBar().computeSize(SWT.DEFAULT, cur.height);
				
				return new Point(sbSz.x + bbSz.x + vidSz.x, cur.height);
			} else {
				if (sbSz == null)
					sbSz = statusBar.getButtonBar().computeSize(cur.width, SWT.DEFAULT); 
				if (bbSz == null)
					bbSz = buttonBar.getButtonBar().computeSize(cur.width, SWT.DEFAULT);
				
				return new Point(cur.width, sbSz.y + bbSz.y + vidSz.y);
			}
		}

		/* (non-Javadoc)
		 * @see org.eclipse.swt.widgets.Layout#layout(org.eclipse.swt.widgets.Composite, boolean)
		 */
		@Override
		protected void layout(Composite composite, boolean flushCache) {
			if (composite.getChildren().length != 3)
				throw new IllegalStateException();
			
			Rectangle cur = composite.getClientArea();
			
			computeSize(composite, cur.width, cur.height, true);
			
			// take the same size for both bars, for symmetry,
			// and give the video renderer the rest of the space
			if (!isHorizontal) {
				int barSz = Math.min(sbSz.x, bbSz.x);
				int left = cur.width - barSz * 2;
				statusBar.getButtonBar().setBounds(0, 0, barSz, cur.height);
				videoRendererComposite.setBounds(barSz, 0, left, cur.height);
				buttonBar.getButtonBar().setBounds(barSz + left, 0, barSz, cur.height);
			} else {
				int barSz = Math.min(sbSz.y, bbSz.y);
				int left = cur.height - barSz * 2;
				statusBar.getButtonBar().setBounds(0, 0, cur.width, barSz);
				videoRendererComposite.setBounds(0, barSz, cur.width, left);
				buttonBar.getButtonBar().setBounds(0, barSz + left, cur.width, barSz);
				
			}
		}
		
	}
	
	public SwtWindow(Display display, final IMachine machine, 
			final ISwtVideoRenderer videoRenderer, final ISettingsHandler settingsHandler,
			final ISoundHandler soundHandler) {
		super(machine);
		
		fullScreen = Settings.get(machine, settingFullScreen);
		
		toolShells = new HashMap<String, ToolShell>();
		toolUiTimer = new Timer(true);
		
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.RESIZE);
		shell.setText("V9t9 [" + machine.getModel().getIdentifier() + "]");

		List<Image> icons = new ArrayList<Image>();
		for (int siz : new int[] { 128, 64, 32 }) {
			Image icon = EmulatorGuiData.loadImage(shell.getDisplay(), "icons/v9t9_" + siz + ".png");
			if (icon != null)
				icons.add(icon);
		}
		shell.setImages(icons.toArray(new Image[icons.size()]));

		TreeMap<Integer, Image> mainIcons = new TreeMap<Integer, Image>();
		for (int size : new int[] { 16, 32, 64, 128 }) {
			Image iconsImage = EmulatorGuiData.loadImage(shell.getDisplay(), "icons/icons_" + size + ".png");
			if (iconsImage != null) {
				mainIcons.put(size, iconsImage);
			}
		}
		
		shell.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				String boundsPref = PrefUtils.writeBoundsString(shell.getBounds());
				settingsHandler.get(settingEmulatorWindowBounds).setString(boundsPref);
				dispose();
				
				machine.getClient().close();
			}
			
		});
		
		shell.addControlListener(new ControlAdapter() {
			@Override
			public void controlMoved(ControlEvent e) {
				recenterToolShells();
			}
		});
		
		if (false) {
			Menu bar = new Menu(shell, SWT.BAR);
			createAppMenu(shell, bar, false);
			shell.setMenuBar(bar);
		}
		
		if (true) {
			ISVGLoader svgIconLoader = new SVGSalamanderLoader(EmulatorGuiData.getDataURL("icons/icons.svg"));
			buttonImageProvider = new SVGImageProvider(mainIcons, svgIconLoader);
			statusImageProvider = new SVGImageProvider(mainIcons, svgIconLoader);
			rndImageProvider = new SVGImageProvider(mainIcons, svgIconLoader);
		} else {
			buttonImageProvider = new MultiImageSizeProvider(mainIcons);
			statusImageProvider = buttonImageProvider;
			rndImageProvider = buttonImageProvider;
		}
		
		isHorizontal = false;

		Composite fullWindow = shell;
		GridLayoutFactory.fillDefaults().numColumns(1).spacing(0, 0).margins(0, 0).applyTo(fullWindow);
		
		
		
		Composite mainComposite = new Composite(fullWindow, SWT.NONE);

		GridLayoutFactory.fillDefaults().numColumns(1).margins(0, 0).applyTo(mainComposite);
		
		mainComposite.setLayout(new EmulatorWindowLayout());
		
		GridDataFactory.fillDefaults().grab(true, true).applyTo(mainComposite);

		statusBar = new EmulatorStatusBar(this, statusImageProvider, mainComposite, machine, 
				new int[] { SWT.COLOR_DARK_GRAY, SWT.COLOR_GRAY, SWT.COLOR_BLACK },
				new float[] { 0.25f, 0.75f },
				isHorizontal);

		//Composite videoAndBarComposite = new Composite(mainComposite, SWT.NONE);
		//GridLayoutFactory.fillDefaults().margins(0, 0).applyTo(videoAndBarComposite);
		//GridDataFactory.fillDefaults().grab(true, true).applyTo(videoAndBarComposite);

		videoRendererComposite = new Composite(mainComposite, SWT.NONE);
		videoRendererComposite.setBackground(videoRendererComposite.getDisplay().getSystemColor(SWT.COLOR_BLACK));
		GridLayoutFactory.fillDefaults().margins(0, 0).applyTo(videoRendererComposite);

		focusRestorer = new IFocusRestorer() {
			public void restoreFocus() {
				((ISwtVideoRenderer) videoRenderer).setFocus();
			}
		};
		

		eventNotifier = new GuiEventNotifier(this);

		setVideoRenderer(videoRenderer);
		

		this.videoControl = videoRenderer.createControl(videoRendererComposite, SWT.NONE);
		
		GridDataFactory.swtDefaults()
			.indent(0, 0)
			.align(SWT.CENTER, SWT.CENTER)
			.grab(true, true)
			.minSize(128, 64)
			.applyTo(videoControl);
		
		videoRenderer.addMouseEventListener(new MouseAdapter() {
			
			public void mouseDown(final MouseEvent e) {
				//System.out.println("Mouse detected " + e);
				if (!SWT.getPlatform().equals("win32") && e.button == 3) {
					showAppMenu(e);
				}
			}
			
			public void mouseUp(MouseEvent e) {
				if (e.button == 1) {
					handleClickOutsideToolWindow(videoControl.toDisplay(e.x, e.y));
					focusRestorer.restoreFocus();
				}
				if (SWT.getPlatform().equals("win32") && e.button == 3) {
					showAppMenu(e);
				}
			}

		});

		
		buttonBar = new EmulatorButtonBar(this, buttonImageProvider, mainComposite, machine,
				soundHandler,
				new int[] { SWT.COLOR_BLACK, SWT.COLOR_GRAY, SWT.COLOR_DARK_GRAY },
				new float[] { 0.75f, 0.25f },
				isHorizontal);
		
		

		rndBar = new EmulatorRnDBar(this, rndImageProvider, videoRendererComposite, machine,
				new int[] { SWT.COLOR_BLACK, SWT.COLOR_BLACK, SWT.COLOR_BLACK  },
				new float[] { 0.5f, 0.5f },
				!isHorizontal);
		
		showRnDBar = settingsHandler.get(settingShowRnDBar);
		showRnDBar.addListenerAndFire(new IPropertyListener() {
			
			@Override
			public void propertyChanged(final IProperty property) {
				if (shell.isDisposed())
					return;
				shell.getDisplay().asyncExec(new Runnable() {
					public void run() {
						((GridData) rndBar.getButtonBar().getLayoutData()).exclude = !property.getBoolean();
						rndBar.getButtonBar().setVisible(property.getBoolean());
						shell.layout(true, true);
					}
				});
			}
		});
		
		
		
		if (buttonImageProvider instanceof SVGImageProvider) {
			((SVGImageProvider) buttonImageProvider).setImageBar(buttonBar.getButtonBar());
		}
		if (statusImageProvider instanceof SVGImageProvider) {
			((SVGImageProvider) statusImageProvider).setImageBar(statusBar.getButtonBar());
		}
		if (rndImageProvider instanceof SVGImageProvider) {
			((SVGImageProvider) rndImageProvider).setImageBar(rndBar.getButtonBar());
		}

		
		String boundsPref = settingsHandler.get(settingEmulatorWindowBounds).getString();
		final Rectangle rect = PrefUtils.readBoundsString(boundsPref);
		if (rect != null) {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					adjustRectVisibility(shell, rect);
					shell.setBounds(rect);
				}
			});
		}
		

		fullScreenListener = new IPropertyListener() {

			public void propertyChanged(final IProperty setting) {
				Display.getDefault().syncExec(new Runnable() {
					public void run() {
						shell.setFullScreen(setting.getBoolean());
					}
				});
			}
			
		};
		fullScreen.addListener(fullScreenListener);
		
		shell.open();
		
		shell.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				focusRestorer.restoreFocus();
			}
		});
		videoRenderer.setFocus();
	}
	
	public static void adjustRectVisibility(Shell shell, Rectangle rect) {
		Rectangle screen = shell.getDisplay().getClientArea();
		
		// in GTK, for some reason, all bounds lose their positions
		if (rect.x == 0 && rect.y == 0) {
			rect.x = screen.width / 2 - rect.width / 2;
			rect.y = screen.height / 2 - rect.height / 2;
		}
		if (rect.x > screen.x + screen.width)
			rect.x = screen.x + screen.width - rect.width; 
		if (rect.y > screen.y + screen.height)
			rect.y = screen.y + screen.height - rect.height; 
		if (rect.x < screen.x)
			rect.x = 0;
		if (rect.y < screen.y)
			rect.y = 0;
	}

	protected void showAppMenu(MouseEvent e) {
		// we need this horrible hack or else the
		// menu will disappear immediately because SWT and AWT
		// don't agree on events
		final Shell menuShell = new Shell(getShell(), SWT.ON_TOP | SWT.TOOL);
		menuShell.setSize(16, 16);
		Point shellLoc = (((Control)e.widget).toDisplay(e.x, e.y));
		menuShell.setLocation(shellLoc);
		
		final Menu menu = createAppMenu(menuShell, menuShell, true);
		
		menuShell.open();
		menuShell.setVisible(false);
		menuShell.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				menu.dispose();
			}

			public void focusGained(FocusEvent e) {
				
			}
		});
		menuShell.getDisplay().syncExec(new Runnable() {
			public void run() {
				runMenu(null, 0, 0, menu);
				menuShell.dispose();		
			}
		});
		
	}

	/**
	 * @param debuggerToolId
	 * @param iToolShellFactory
	 * @return 
	 * @return 
	 */
	protected ToolShell showToolShell(String toolId, IToolShellFactory toolShellFactory) {
		ToolShell toolShell = toolShells.get(toolId);
		if (toolShell != null) {
			toolShell.restore();
		}
		else {
			toolShell = createToolShell(toolId, toolShellFactory);
		}
		return toolShell;
	}
	/**
	 * @param debuggerToolId
	 * @param iToolShellFactory
	 * @return 
	 */
	public ToolShell toggleToolShell(String toolId, IToolShellFactory toolShellFactory) {
		ToolShell toolShell = toolShells.get(toolId);
		if (toolShell != null) {
			toolShell.toggle();
		}
		else {
			toolShell = createToolShell(toolId, toolShellFactory);
		}
		return toolShell;
	}

	/**
	 * @param toolId
	 * @param boundsPref
	 * @param keepCentered
	 * @param dismissOnClickOutside
	 * @param toolShellFactory
	 * @return 
	 */
	protected ToolShell createToolShell(String toolId, IToolShellFactory toolShellFactory) {
		ToolShell toolShell;
		toolShell = new ToolShell(getShell(), 
				Settings.getSettings(machine),
				focusRestorer, isHorizontal, toolShellFactory.getBehavior());  
		Control tool = toolShellFactory.createContents(toolShell.getShell());
		toolShell.init(tool);
		addToolShell(toolId, toolShell);
		return toolShell;
	}
	
	public IFocusRestorer getFocusRestorer() {
		return focusRestorer;
	}

	public void recenterToolShells() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				for (ToolShell shell : toolShells.values()) {
					if (shell.isKeepCentered()) {
						shell.recenterTo(null);
						shell.centerShell();
					}
				}	
			}
		});
		
	}
	protected void hideShell(final Shell shell) {
		Thread hider = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						shell.setVisible(false);
						focusRestorer.restoreFocus();
					}
				});
			}
		};
		hider.start();
	}
	public boolean closeToolShell(String toolId) {
		ToolShell old = toolShells.get(toolId);
		if (old != null) {
			toolShells.remove(toolId);
			old.dispose();
			focusRestorer.restoreFocus();
			return true;
		} 
		return false;
	}
	
	protected void addToolShell(final String toolId, final ToolShell toolShell) {
		ToolShell old = toolShells.get(toolId);
		if (old != null)
			old.dispose();
		toolShells.put(toolId, toolShell);
		toolShell.getShell().addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolShells.remove(toolId);
				focusRestorer.restoreFocus();
			}
		});
	}

	/**
	 * Take down any transient tool windows when clicking outside them
	 * @param pt display click location
	 */
	public void handleClickOutsideToolWindow(final Point pt) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				@SuppressWarnings("unchecked")
				Map.Entry<String, ToolShell>[] toolShellArr =
					(Map.Entry[]) toolShells.entrySet().toArray(new Map.Entry[toolShells.entrySet().size()]);
				for (Map.Entry<String, ToolShell> ent : toolShellArr) {
					ToolShell toolShell = ent.getValue();
					Shell shell = toolShell.getShell();
					if (toolShell.isDismissOnClickOutside() && !shell.isDisposed() && shell.isVisible()
							&& System.currentTimeMillis() > toolShell.getClickOutsideCheckTime()) {
						Rectangle bounds = shell.getBounds();
						//System.out.println(pt + "/"+ bounds);
						if (pt.x < bounds.x - 16 || pt.y < bounds.y - 16 
								|| pt.x > bounds.x + bounds.width + 16 || pt.y > bounds.y + bounds.height + 16) {
							closeToolShell(ent.getKey());
						}
					}
				}
					
			}
		});
	}


	private Menu createAppMenu(Decorations control, Object parent, boolean isPopup) {
		Menu appMenu;
		if (parent instanceof Decorations)
			appMenu = new Menu((Decorations) parent, SWT.POP_UP);
		else if (parent instanceof Menu)
			appMenu = (Menu) parent;
		else if (parent instanceof MenuItem)
			appMenu = new Menu((MenuItem) parent);
		else if (parent instanceof Control)
			appMenu = new Menu((Control) parent);
		else
			throw new IllegalArgumentException(parent.toString());
		
		MenuItem fileMenuHeader = new MenuItem(appMenu, SWT.CASCADE);
		fileMenuHeader.setText("&File");
		
		Menu fileMenu = new Menu(control, SWT.DROP_DOWN);
		populateFileMenu(fileMenu, true);
		fileMenuHeader.setMenu(fileMenu);

		MenuItem editMenuHeader = new MenuItem(appMenu, SWT.CASCADE);
		editMenuHeader.setText("&Edit");
		
		Menu editMenu = new Menu(control, SWT.DROP_DOWN);
		populateEditMenu(editMenu);
		editMenuHeader.setMenu(editMenu);

		Menu viewMenu = appMenu;
		if (!isPopup) {
			MenuItem viewMenuHeader = new MenuItem(appMenu, SWT.CASCADE);
			viewMenuHeader.setText("&View");
			
			viewMenu = new Menu(control, SWT.DROP_DOWN);
			viewMenuHeader.setMenu(viewMenu);
		}

		final MenuItem fullScreenI = new MenuItem(viewMenu, SWT.CHECK);
		fullScreenI.setSelection(fullScreen.getBoolean());
		fullScreenI.setText("&Full Screen");
		fullScreenI.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				fullScreen.setBoolean(fullScreenI.getSelection());
			}
		});

		/*
		MenuItem zoom = new MenuItem(viewMenu, SWT.CASCADE);
		zoom.setText("&Zoom");
		
		Menu zoomMenu = new Menu(zoom);
		populateZoomMenu(zoomMenu);
		zoom.setMenu(zoomMenu);
		*/
		
		Menu emuMenu = appMenu;
		if (!isPopup) {
			MenuItem emuMenuHeader = new MenuItem(appMenu, SWT.CASCADE);
			emuMenuHeader.setText("&Emulation");
			
			emuMenu = new Menu(control, SWT.DROP_DOWN);
			emuMenuHeader.setMenu(emuMenu);
		}
		
		/*
		MenuItem accel= new MenuItem(emuMenu, SWT.CASCADE);
		accel.setText("&Accelerate");
		
		Menu accelMenu = new Menu(accel);
		populateAccelMenu(accelMenu);
		accel.setMenu(accelMenu);
		*/
		
		final MenuItem showRnDI = new MenuItem(viewMenu, SWT.CHECK);
		showRnDI.setSelection(showRnDBar.getBoolean());
		showRnDI.setText("Show &RnD Commands");
		showRnDI.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				showRnDBar.setBoolean(showRnDI.getSelection());
			}
		});
		
		return appMenu;
	}
	
	@Override
	public void dispose() {
		
		buttonBar.dispose();
		
		statusBar.dispose();
		
		toolUiTimer.cancel();
		
		ToolShell[] shellArray = (ToolShell[]) toolShells.values().toArray(new ToolShell[toolShells.values().size()]);
		for (ToolShell shell : shellArray) {
			shell.dispose();
		}
		toolShells.clear();
		
		super.dispose();
	}

	
	public Shell getShell() {
		return shell;
	}

	@Override
	protected void showErrorMessage(String title, String msg) {
		MessageDialog.openError(getShell(), title, msg);
	}


	@Override
	public String openFileSelectionDialog(String title, String directory,
			String fileName, boolean isSave, String[] extensions) {
		FileDialog dialog = new FileDialog(getShell(), isSave ? SWT.SAVE : SWT.OPEN);
		dialog.setText(title);
		dialog.setFilterPath(directory);
		dialog.setFileName(fileName);
		
		if (extensions != null) {
			String[] exts = new String[extensions.length];
			String[] names = new String[extensions.length];
			int idx = 0;
			for (String extension : extensions) {
				String[] split = extension.split("\\|");
				exts[idx] = "*" + split[0];
				names[idx] = split.length > 1 ? split[1] : split[0];
				idx++;
			}
			dialog.setFilterExtensions(exts);
			dialog.setFilterNames(names);
		}
		String filename = dialog.open();
		
		if (filename != null && extensions != null) {
			int extIdx = new File(filename).getName().lastIndexOf('.');
			if (extIdx < 0) {
				filename += '.' + dialog.getFilterExtensions()[dialog.getFilterIndex()];
			}
		}
		return filename;
	}
	
	@Override
	protected String openDirectorySelectionDialog(String title, String directory) {
		DirectoryDialog dialog = new DirectoryDialog(getShell(), SWT.NONE);
		dialog.setText(title);
		dialog.setFilterPath(directory);
		String dirname = dialog.open();
		return dirname;
	}

	/**
	 * @return
	 */
	public IEventNotifier getEventNotifier() {
		return eventNotifier;
	}

	public Timer getToolUiTimer() {
		return toolUiTimer;
	}

	public void runMenu(final Control parent, final int x, final int y,
			final Menu menu) {
		if (parent != null) {
			Point loc = parent.toDisplay(x, y); 
			menu.setLocation(loc);
		}
		//System.out.println("position: " + menu.getParent().getLocation());
		menu.setVisible(true);
		
		//System.out.println("Running menu");
		final Shell menuShell = getShell();
		Display display = menuShell.getDisplay();
		while (display.readAndDispatch()) /**/ ;

		while (!menu.isDisposed() && menu.isVisible()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		
	}
	

	public Menu populateFileMenu(final Menu menu, boolean withExit) {
		MenuItem open = new MenuItem(menu, SWT.NONE);
		open.setText("&Open machine state");
		open.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				loadMachineState();
			}
		});
		MenuItem save = new MenuItem(menu, SWT.NONE);
		save.setText("&Save machine state");
		save.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				saveMachineState();
			}
		});

		if (withExit) {
			MenuItem exit = new MenuItem(menu, SWT.NONE);
			exit.setText("E&xit");
			exit.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					machine.getClient().close();
				}
			});
		}
		
		return menu;
	}
	
	private Menu populateEditMenu(final Menu menu) {
		MenuItem paste = new MenuItem(menu, SWT.NONE);
		paste.setText("&Paste into keyboard");
		paste.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pasteClipboardToKeyboard();
			}
		});
		
		return menu;
	}
	

	public void pasteClipboardToKeyboard() {
		Clipboard clip = new Clipboard(getShell().getDisplay());
		String contents = (String) clip.getContents(TextTransfer.getInstance());
		if (contents == null) {
			contents = (String) clip.getContents(RTFTransfer.getInstance());
		}
		if (contents != null) {
			machine.getKeyboardState().pasteText(contents);
		} else {
			eventNotifier.notifyEvent(null, Level.WARNING, 
					"Cannot paste: no text on clipboard");
		}
		clip.dispose();
		
	}
	

	public void showMenu(Menu menu, final Control parent, final int x, final int y) {
		runMenu(parent, x, y, menu);
		menu.dispose();		
	}

	/**
	 * @return
	 */
	public IClient getClient() {
		return machine.getClient();
	}

	/**
	 * @return
	 */
	public ImageProvider getImageProvider() {
		return buttonImageProvider;
	}

	/**
	 * @return
	 */
	public BaseEmulatorBar getButtonBar() {
		return buttonBar;
	}
}
