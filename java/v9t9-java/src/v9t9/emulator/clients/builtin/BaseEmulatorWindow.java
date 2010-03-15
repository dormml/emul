package v9t9.emulator.clients.builtin;

import java.io.File;
import java.io.IOException;

import org.eclipse.jface.dialogs.DialogSettings;
import org.ejs.coffee.core.properties.DialogSettingsPropertyStorage;
import org.ejs.coffee.core.properties.IProperty;
import org.ejs.coffee.core.properties.IPropertyStorage;
import org.ejs.coffee.core.properties.SettingProperty;

import v9t9.emulator.EmulatorSettings;
import v9t9.emulator.Machine;
import v9t9.emulator.clients.builtin.video.VideoRenderer;
import v9t9.emulator.runtime.Cpu;

public abstract class BaseEmulatorWindow {

	/**
	 * 
	 */
	private static final String[] MACHINE_SAVE_FILE_EXTENSIONS = new String[] { ".sav|V9t9 machine save file" };
	protected VideoRenderer videoRenderer;
	protected final Machine machine;
	static public final SettingProperty settingMonitorDrawing = new SettingProperty("MonitorDrawing", new Boolean(true));
	static public final SettingProperty settingZoomLevel = new SettingProperty("ZoomLevel", new Integer(3));

	// not persisted
	static public final SettingProperty settingMachineStatePath = new SettingProperty("MachineStatePath", "");
	static public final SettingProperty settingScreenShotsBase = new SettingProperty("ScreenShotsBase", "");
	
	public BaseEmulatorWindow(Machine machine) {
		this.machine = machine;
		EmulatorSettings.INSTANCE.load();
	}
	
	public void dispose() {
		EmulatorSettings.INSTANCE.save();
	}
	
	public void setVideoRenderer(VideoRenderer videoRenderer) {
		this.videoRenderer = videoRenderer;
	}

	protected String selectFile(String title, IProperty configVar, String defaultSubdir,
			String fileName, boolean isSave, boolean ifUndefined, String[] extensions) {
		
		boolean isUndefined = false;
		IPropertyStorage settings = EmulatorSettings.INSTANCE.getApplicationSettings();
		settings.read(configVar);
		String configPath = configVar.getString();
		if (configPath == null || configPath.length() == 0) {
			configPath = EmulatorSettings.INSTANCE.getBaseConfigurationPath() + defaultSubdir + File.separatorChar + fileName;
			isUndefined = true;
			File saveDir = new File(configPath);
			saveDir.getParentFile().mkdirs();
		} else if (ifUndefined) {
			return configPath;
		}
		
		File dir = new File(configPath);
		if (!dir.isDirectory())
			dir = dir.getParentFile();
		
		String filename = openFileSelectionDialog(title, dir.getAbsolutePath(), fileName, 
				isSave, extensions);
		if (filename != null && isUndefined) {
			configVar.setString(filename);
		}
		return filename;
	}

	protected String selectDirectory(String title, IProperty configVar, String defaultSubdir,
			boolean ifUndefined) {
		boolean isUndefined = false;
		IPropertyStorage settings = EmulatorSettings.INSTANCE.getApplicationSettings();
		settings.read(configVar);
		String configDir = configVar.getString();
		if (configDir == null || configDir.length() == 0) {
			configDir = EmulatorSettings.INSTANCE.getBaseConfigurationPath() + File.separatorChar + defaultSubdir + File.separatorChar;
			File saveDir = new File(configDir);
			saveDir.mkdirs();
			isUndefined = true;
		} else if (ifUndefined) {
			return configDir;
		}
		
		String dirname = openDirectorySelectionDialog(title, configDir);
		if (dirname != null && isUndefined) {
			configVar.setString(dirname);
			settings.write(configVar);
		}
		return dirname;
	}
	/**
	 * Open a file selection dialog (which is used to open or save files).
	 * @param title title of dialog
	 * @param directory base directory, or <code>null</code>
	 * @param fileName base filename
	 * @param isSave true: saving a file, false: opening
	 * @param extensions array of entries in the form "extension|label"; first entry is default extension
	 * @return full path to selected file, or <code>null</code> if canceled
	 */
	abstract protected String openFileSelectionDialog(String title, String directory,
			String fileName, boolean isSave, String[] extensions);
	abstract protected String openDirectorySelectionDialog(String title, String directory);

	protected void sendNMI() {
		machine.getCpu().setPin(Cpu.PIN_LOAD);
	}
	
	protected void sendReset() {
		machine.getCpu().setPin(Cpu.PIN_RESET);
	}
	protected void loadMachineState() {
		String filename = selectFile(
				"Select saved machine state", settingMachineStatePath, "saves", 
				"save0.sav", false, false, MACHINE_SAVE_FILE_EXTENSIONS);
		
		if (filename != null) {
			try {
				IPropertyStorage settings = new DialogSettingsPropertyStorage(new DialogSettings("state"));
				settings.load(filename);
				
				machine.loadState(settings);
			} catch (Throwable e1) {
				showErrorMessage("Load error", 
						"Failed to load machine state:\n\n" + e1.getMessage());
			
			}
		}
	}

	abstract protected void showErrorMessage(String title, String msg);

	protected void saveMachineState() {
		
		// get immediately
		IPropertyStorage settings = new DialogSettingsPropertyStorage(new DialogSettings("state"));
		machine.saveState(settings);
		
		String filename = selectFile(
				"Select location to save machine state", settingMachineStatePath, 
				"saves", "save0.sav", true, false, MACHINE_SAVE_FILE_EXTENSIONS);
		
		if (filename != null) {
			try {
				settings.save(filename);
			} catch (Throwable e1) {
				showErrorMessage("Save error", 
						"Failed to save machine state:\n\n" + e1.getMessage());
			}
		}
	}

	protected File screenshot() {
		
		String filenameBase = selectFile(
				"Select screenshot file", settingScreenShotsBase, "screenshots", "screen.png", true, true, 
				new String[] { ".png|PNG file" });
		if (filenameBase != null) {
			File saveFile = getUniqueFile(filenameBase);
			if (saveFile == null) {
				showErrorMessage("Save error", 
						"Too many screenshots here!");
				EmulatorSettings.INSTANCE.clearConfigVar("ScreenShotsBase");
				return screenshot();
			} else {
				try {
					videoRenderer.saveScreenShot(saveFile);
					return saveFile;
				} catch (IOException e) {
					showErrorMessage("Save error", 
						"Failed to write file:\n\n" + e.getMessage());
					return null;
				}
			}
		}
		return null;
	}
	
	protected File getUniqueFile(String filenameBase) {
		File fileBase = new File(filenameBase);
		File dir = fileBase.getParentFile();
		String base = fileBase.getName();
		int extPtr = base.lastIndexOf('.');
		if (extPtr < 0) extPtr = base.length();
		String ext = base.substring(extPtr);
		base = base.substring(0, extPtr);
		
		File saveFile = null; 
		for (int count = 0; count < 10000; count++) {
			saveFile = new File(dir, base + (count != 0 ? "" + count : "") + ext);
			if (!saveFile.exists())
				break;
		}
		if (saveFile.exists())
			return null;
		return saveFile;
	}
}