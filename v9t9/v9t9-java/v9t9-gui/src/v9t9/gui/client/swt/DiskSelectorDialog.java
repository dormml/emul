/**
 * 
 */
package v9t9.gui.client.swt;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import v9t9.base.properties.IProperty;
import v9t9.base.properties.IPropertyListener;
import v9t9.base.properties.SettingProperty;
import v9t9.common.dsr.IDiskDsr;
import v9t9.common.dsr.IDsrHandler;
import v9t9.common.dsr.IDsrSettings;
import v9t9.common.events.IEventNotifier;
import v9t9.common.files.Catalog;
import v9t9.common.files.CatalogEntry;
import v9t9.common.machine.IMachine;
import v9t9.common.settings.ISettingDecorator;
import v9t9.common.settings.IconSettingProperty;

/**
 * Select and set up disks
 * @author ejs
 *
 */
public class DiskSelectorDialog extends Composite {

	private final IMachine machine;
	
	abstract class SettingEntry extends Composite {
		protected final SettingProperty setting;
		private IPropertyListener enableListener;
		
		public SettingEntry(final Composite parent, SettingProperty setting_, int style) {
			super(parent, style);
			
			this.setting = setting_;
			
			enableListener = new IPropertyListener() {
				
				public void propertyChanged(IProperty setting) {
					updateSetting();
				}
			};
			setting.addListener(enableListener);
			
			addDisposeListener(new DisposeListener() {
				
				public void widgetDisposed(DisposeEvent e) {
					setting.removeListener(enableListener);
				}
			});
			
			if (setting instanceof ISettingDecorator) {
				ImageDescriptor descriptor = ((ISettingDecorator) setting).getIcon();
				Label icon = new Label(this, SWT.NONE);
				final Image iconImage = descriptor.createImage();
				icon.setImage(iconImage);
				parent.addDisposeListener(new DisposeListener() {
					
					public void widgetDisposed(DisposeEvent e) {
						iconImage.dispose();
					}
				});
				
			} else {
				new Label(this, SWT.NONE);
			}
			
			createControls(this);
		}
		
		protected void updateSetting() {
			boolean enabled = setting.isEnabled();
			SettingEntry.this.setVisible(enabled);
			GridData data = (GridData) SettingEntry.this.getLayoutData();
			data.exclude = !enabled;
			
			SettingEntry.this.getShell().layout(true, true);
			Point cursz = SettingEntry.this.getShell().getSize();
			Point sz = SettingEntry.this.getShell().computeSize(SWT.DEFAULT, 500, true);
			SettingEntry.this.getShell().setSize(Math.max(cursz.x, sz.x),
					Math.max(cursz.y, sz.y));
					
		}

		abstract protected void createControls(Composite parent);
		
	};

	class DiskEntry extends SettingEntry {
		private Combo combo;
		private Button browse;
		private Button catalog;
		
		public DiskEntry(final Composite parent, SettingProperty setting_) {
			super(parent, setting_, SWT.NONE);
			
		}
		
		/* (non-Javadoc)
		 * @see v9t9.emulator.clients.builtin.swt.DiskSelector.SettingEntry#createControls(org.eclipse.swt.widgets.Composite)
		 */
		@Override
		protected void createControls(final Composite parent) {
			GridLayoutFactory.fillDefaults().numColumns(5).applyTo(this);
			
			Label label = new Label(parent, SWT.NONE);
			label.setText(setting.getLabel() + ": ");
			GridDataFactory.fillDefaults().align(SWT.LEFT, SWT.CENTER).applyTo(label);
			
			label.setToolTipText(setting.getDescription());
			
			combo = new Combo(parent, SWT.BORDER | SWT.DROP_DOWN);
			GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).applyTo(combo);
			
			combo.setToolTipText(setting.getDescription());
			
			String[] history = getHistory(getHistoryName());
			if (history != null) {
				combo.setItems(history);
			}
			
			combo.setText(setting.getString());
			
			combo.addModifyListener(new ModifyListener() {
				
				public void modifyText(ModifyEvent e) {
					File dir = new File(combo.getText());
					String path = dir.getAbsolutePath();
					// always set for disks 
					if (isDiskImage())
						setting.setString(path);
					switchPath(combo, path);
				}

			});
			
			
			browse = new Button(parent, SWT.PUSH);
			GridDataFactory.fillDefaults().grab(false, false).applyTo(browse);
			browse.setText("Browse...");
			browse.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					if (isDiskImage()) {
						FileDialog dialog =  new FileDialog(parent.getShell(), SWT.OPEN);
						dialog.setText("Select image for " + setting.getName());
						String dir = new File(setting.getString()).getParent();
						String filename = new File(setting.getString()).getName();
						dialog.setFilterPath(dir);
						dialog.setFileName(filename);
						dialog.setFilterExtensions(new String[] { "*.dsk", "*.trk", "*.*" });
						dialog.setFilterNames(new String[] { "Sector disk images", "Track disk images", "All files" });
						if (filename.endsWith(".dsk"))  {
							dialog.setFilterIndex(0);
						} else if (filename.endsWith(".trk"))  {
							dialog.setFilterIndex(1);
						} else {
							dialog.setFilterIndex(2);
						}
						filename = dialog.open();
						if (filename != null) {
							switchPath(combo, filename);
							combo.setText(filename);
						}
					} else {
						DirectoryDialog dialog =  new DirectoryDialog(parent.getShell(), SWT.NONE);
						dialog.setText("Select path for " + setting.getName());
						dialog.setFilterPath(setting.getString());
						String dirname = dialog.open();
						if (dirname != null) {
							switchPath(combo, dirname);
							combo.setText(dirname);
						}
					}
				}
			});			
			
			catalog = new Button(parent, SWT.PUSH);
			GridDataFactory.fillDefaults().grab(false, false).applyTo(catalog);
			catalog.setText("Catalog...");
			catalog.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					for (IDsrHandler dsr : machine.getDsrManager().getDsrs()) {
						if (dsr instanceof IDiskDsr && ((IDiskDsr) dsr).isImageBased() == isDiskImage()) {
							Catalog catalog;
							try {
								catalog = ((IDiskDsr) dsr).getCatalog(setting);
								showCatalogDialog(setting, catalog);
							} catch (IOException e1) {
								machine.getClient().getEventNotifier().notifyEvent(
										setting, IEventNotifier.Level.ERROR,
										MessageFormat.format("Could not read catalog for disk image ''{0}''\n\n{1}",
												setting.getString(), e1.getMessage()));
							}
							
							break;
						}
					}
				}
			});
		}
		

		/**
		 * @param setting
		 * @param entries
		 */
		protected void showCatalogDialog(final SettingProperty setting,
				final Catalog catalog) {
			final List<CatalogEntry> entries = catalog.getEntries();
			Dialog dialog = new CatalogDialog(getShell(), machine, entries, catalog, setting);
			dialog.open();

			
		}

		private boolean isDiskImage() {
			return setting.getName().contains("Image");
		}
		/**
		 * @param combo 
		 * @param absolutePath
		 */
		protected void switchPath(Combo combo, String path) {
			if (path == null)
				return;
			setting.setString(path);
			for (String p : combo.getItems())
				if (p.equals(path))
					return;
			
			// only store history for real places
			if (new File(path).exists()) {
				combo.add(path);
				setHistory(getHistoryName(), combo.getItems());
			}
		}

		private String getHistoryName() {
			return isDiskImage() ? "Images" : "Directories";
		}
		
	};


	class BooleanEntry extends SettingEntry {
		public BooleanEntry(final Composite parent, SettingProperty setting_) {
			super(parent, setting_, SWT.NONE);
		}

		/* (non-Javadoc)
		 * @see v9t9.emulator.clients.builtin.swt.DiskSelector.SettingEntry#createControls(org.eclipse.swt.widgets.Composite)
		 */
		@Override
		protected void createControls(Composite parent) {
			GridLayoutFactory.fillDefaults().numColumns(2).applyTo(this);


			final Button checkbox = new Button(parent, SWT.CHECK);
			checkbox.setText(setting.getLabel());
			GridDataFactory.fillDefaults().grab(true, false).applyTo(checkbox);
			
			checkbox.setToolTipText(setting.getDescription());
			
			checkbox.setSelection(setting.getBoolean());
			
			checkbox.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					setting.setBoolean(checkbox.getSelection());
					
				};
			});
		}
		
		
	};


	private String[] getHistory(String name) {
		return machine.getClient().getSettingsHandler().getInstanceSettings().
			getHistorySettings().getArray("DiskSelector." + name);
	}
	private void setHistory(String name, String[] history) {
		machine.getClient().getSettingsHandler().getInstanceSettings().
			getHistorySettings().put("DiskSelector." + name, history);
		//EmulatorSettings.INSTANCE.save();
	}
	/**
	 * 
	 */
	public DiskSelectorDialog(Shell shell, IMachine machine) {
		
		super(shell, SWT.NONE);
		
		this.machine = machine;
		List<IDsrSettings> list = machine.getModel().getDsrSettings(machine);
		
		shell.setText("Disk Selector");

		GridLayoutFactory.fillDefaults().applyTo(this);

		Map<String, Group> groups = new HashMap<String, Group>();
		Map<String, List<SettingProperty>> allSettings = new LinkedHashMap<String, List<SettingProperty>>();
		

		for (IDsrSettings setting : list) {
			Map<String, Collection<SettingProperty>> settings = setting.getEditableSettingGroups();
			for (Map.Entry<String, Collection<SettingProperty>> entry : settings.entrySet()) {
				List<SettingProperty> groupSettings = allSettings.get(entry.getKey());
				if (groupSettings == null) {
					groupSettings = new ArrayList<SettingProperty>();
					allSettings.put(entry.getKey(), groupSettings);
				}
				groupSettings.addAll(entry.getValue());
			}
		}
		
		for (Map.Entry<String, List<SettingProperty>> entry : allSettings.entrySet()) {
			String name = entry.getKey();
			Group group = groups.get(name);
			
			List<SettingProperty> groupSettings = entry.getValue();
			Collections.sort(groupSettings,
					new Comparator<SettingProperty>() {

						public int compare(SettingProperty o1, SettingProperty o2) {
							if (o1 instanceof IconSettingProperty && o2 instanceof IconSettingProperty)
								return o1.getLabel().compareTo(o2.getLabel());
							else
								return 0;
						}
				
			});
			
			if (group == null) {
				Composite section = new Composite(this, SWT.NONE);
				GridDataFactory.fillDefaults().grab(true, false).applyTo(section);
				GridLayoutFactory.fillDefaults().applyTo(section);
				
				Label label = new Label(section, SWT.NONE);
				label.setText(name);
				GridDataFactory.fillDefaults().span(4, 1).applyTo(label);
				
				group = new Group(section, SWT.SHADOW_OUT);
				GridLayoutFactory.fillDefaults().margins(6, 6).applyTo(group);
				GridDataFactory.fillDefaults().grab(true, true).applyTo(group);
				
				groups.put(name, group);
			}
			
			for (SettingProperty setting : groupSettings) {
				SettingEntry comp = null;
				if (setting.getValue() instanceof String) {
					comp = new DiskEntry(group, setting);
				} else if (setting.getValue() instanceof Boolean) {
					comp = new BooleanEntry(group, setting);
				}
				if (comp != null) {
					GridDataFactory.fillDefaults().grab(true, false).applyTo(comp);
					comp.updateSetting();
				}
			}
		}
		
		this.pack();
	}

}