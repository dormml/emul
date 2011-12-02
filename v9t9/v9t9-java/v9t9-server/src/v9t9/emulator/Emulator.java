/*
 * (c) Ed Swartz, 2008
 * 
 * Created on Feb 19, 2006
 *
 */
package v9t9.emulator;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.ejs.coffee.core.properties.IProperty;
import org.ejs.coffee.core.properties.IPropertyListener;
import org.ejs.coffee.core.utils.Check;

import com.sun.jna.Native;

import v9t9.emulator.clients.builtin.ClientFactory;
import v9t9.emulator.clients.builtin.NotifyException;
import v9t9.emulator.clients.builtin.video.tms9918a.VdpTMS9918A;
import v9t9.emulator.common.EmulatorSettings;
import v9t9.emulator.common.IEventNotifier;
import v9t9.emulator.common.IMachine;
import v9t9.emulator.common.ModuleManager;
import v9t9.emulator.common.WorkspaceSettings;
import v9t9.emulator.hardware.EnhancedCompatibleMachineModel;
import v9t9.emulator.hardware.EnhancedMachineModel;
import v9t9.emulator.hardware.F99bMachineModel;
import v9t9.emulator.hardware.MachineModel;
import v9t9.emulator.hardware.MachineModelFactory;
import v9t9.emulator.hardware.StandardMachineModel;
import v9t9.emulator.hardware.StandardMachineV9938Model;
import v9t9.emulator.hardware.memory.mmio.GplMmio;
import v9t9.emulator.runtime.compiler.Compiler;
import v9t9.emulator.runtime.cpu.Cpu;
import v9t9.engine.Client;
import v9t9.engine.files.DataFiles;
import v9t9.engine.memory.Memory;
import v9t9.engine.memory.MemoryModel;

public class Emulator {

	private static final boolean sIsWebStarted = System.getProperty("javawebstart.version") != null;
	private static final boolean sIsDevBuild;
	
	private static final URL sBaseV9t9URL;
	private static final URL sBaseDataURL;
	static {
		URL url = Emulator.class.getClassLoader().getResource(".");
		URL burl = Emulator.class.getClassLoader().getResource(
				Emulator.class.getName().replace(".", "/") + ".class");
		System.out.println("\n\n\n\n");
		System.out.println("/ URL = " + url);
		System.out.println("Emulator.class URL = " + burl);
		System.out.flush();
		if (url != null) {
			// "." will be under "bin", go to parent of tree
			try {
				url = new URL(url, "..");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			
		}
		else {
			try {
				// get out of sources to build dir
				File cwdParentParent = new File(System.getProperty("user.dir"), "/../..");
				url = new URL("file", null, cwdParentParent.getAbsolutePath());
			} catch (MalformedURLException e) {
				e.printStackTrace();
				try {
					url = URI.create(".").toURL();
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
					System.exit(123);
				}
			}
		}
		
		if (burl != null) {
			// "." will be under "bin", go to parent of tree
			try {
				String burlString = burl.toString();
				if (!burlString.contains("!/")) {
					burl = new URL(burlString.substring(0, burlString.indexOf("bin/v9t9")));
					burl = new URL(burl, "data/");
				} else {
					burl = new URL(burlString.substring(0, burlString.indexOf(Emulator.class.getName().replace(".", "/"))));
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			
		}
		sBaseV9t9URL = url;
		sBaseDataURL = burl;
		System.out.println("sBaseV9t9URL = " + sBaseV9t9URL);
		System.out.println("sBaseBuildURL = " + sBaseDataURL);
		
		sIsDevBuild = sBaseV9t9URL != null && sBaseV9t9URL.getProtocol().equals("file");
	}
	
	static {
		if (sIsWebStarted && System.getProperty("jna.library.path") == null) {
			String path = Native.getWebStartLibraryPath("v9t9render");
			System.out.println("Native libs at " + path);
			if (path != null)
				System.setProperty("jna.library.path", path);
		}		
		
		DataFiles.settingBootRomsPath.addListener(new IPropertyListener() {
			
			@Override
			public void propertyChanged(IProperty setting) {
				if (setting.getList().isEmpty())
					addDefaultPaths();
			}

		});
		
		addDefaultPaths();
	}
	
	private static void addDefaultPaths() {
		if (sIsDevBuild) {
			DataFiles.addSearchPath("../../build/roms");
		}
	}


	static {
		MachineModelFactory.register(StandardMachineModel.ID, StandardMachineModel.class);
		MachineModelFactory.register(StandardMachineV9938Model.ID, StandardMachineV9938Model.class);
		MachineModelFactory.register(EnhancedCompatibleMachineModel.ID, EnhancedCompatibleMachineModel.class);
		MachineModelFactory.register(EnhancedMachineModel.ID, EnhancedMachineModel.class);
		MachineModelFactory.register(F99bMachineModel.ID, F99bMachineModel.class);
	}
	
	private Memory memory;
	private IMachine machine;
	private MemoryModel memoryModel;
	private Client client;

    public Emulator(IMachine machine, Client client) throws IOException {
    	Check.checkArg(machine);
    	Check.checkArg(client);
    	this.machine = machine;
    	this.memory = machine.getMemory();
    	this.memoryModel = memory.getModel();
    	
    	this.client = client;
    	machine.setClient(client);
    }
    
	protected void setupDefaults() {
    	WorkspaceSettings.CURRENT.register(IMachine.settingModuleList);
		WorkspaceSettings.CURRENT.register(Cpu.settingCyclesPerSecond);
		WorkspaceSettings.CURRENT.register(Cpu.settingRealTime);
		
		try {
			WorkspaceSettings.CURRENT.setDirty(false);
			WorkspaceSettings.loadFrom("workspace." + machine.getModel().getIdentifier());
		} catch (IOException e) {
		}
		
    	Cpu.settingRealTime.setBoolean(true);
    	
    	/*
    	// compile?  and waste a lot of effort to get nothing done?
    	if (false) {
    		Cpu.settingRealTime.setBoolean(false);
	    	Executor.settingCompile.setBoolean(true);
	    	//Compiler.settingDebugInstructions.setBoolean(true);
	    	//Compiler.settingOptimize.setBoolean(true);
	        Compiler.settingOptimizeRegAccess.setBoolean(true);
	        Compiler.settingOptimizeStatus.setBoolean(true);
	        //Compiler.settingCompileOptimizeCallsWithData.setBoolean(true);
	        //Compiler.settingCompileFunctions.setBoolean(true);
    	}
    	*/
    }
    
	protected void loadState() {
		int barrier = client.getEventNotifier().getErrorCount();
		memoryModel.loadMemory(client.getEventNotifier());
		
		if (machine.getModuleManager() != null) {
			try {
	    		String dbNameList = IMachine.settingModuleList.getString();
	    		if (dbNameList.length() > 0) {
	    			String[] dbNames = dbNameList.split(";");
	    			machine.getModuleManager().loadModules(dbNames, client.getEventNotifier());
	    		}
	        	if (ModuleManager.settingLastLoadedModule.getString().length() > 0)
	        		machine.getModuleManager().switchModule(ModuleManager.settingLastLoadedModule.getString());
	        	
	        } catch (NotifyException e) {
	        	machine.notifyEvent(e.getEvent());
	        }
	        
		}
		
		if (client.getEventNotifier().getErrorCount() > barrier) {
			machine.notifyEvent(IEventNotifier.Level.ERROR,
					"Failed to load startup ROMs; please edit your " + DataFiles.settingBootRomsPath.getName() + " in the file "
					+ WorkspaceSettings.CURRENT.getConfigFilePath());
			//EmulatorSettings.INSTANCE.save();
		}
	}
	
    public static void main(String args[]) throws IOException {
    	
    	try {
    		EmulatorSettings.INSTANCE.load();
    	} catch (IOException e) {
    		System.err.println("Setting up new instance");
    	}

		WorkspaceSettings.CURRENT.register(ModuleManager.settingLastLoadedModule);

    	try {
    		WorkspaceSettings.loadFrom(WorkspaceSettings.currentWorkspace.getString());
    	} catch (IOException e) {
    		System.err.println("Setting up new configuration");
    	}
    	
		EmulatorSettings.INSTANCE.register(DataFiles.settingBootRomsPath,
				EmulatorSettings.INSTANCE.getConfigDirectory() + "roms");
		EmulatorSettings.INSTANCE.register(DataFiles.settingStoredRamPath,
				EmulatorSettings.INSTANCE.getConfigDirectory() + "module_ram");
		DataFiles.addSearchPath(DataFiles.settingStoredRamPath.getString());
    	
        IMachine machine;
        
        String modelId = StandardMachineModel.ID;
        if (findArgument(args, "--f99b")) {
        	modelId = F99bMachineModel.ID;
        } else if (findArgument(args, "--enhanced")) {
        	modelId = EnhancedMachineModel.ID;
        } else if (findArgument(args, "--v9938")) {
        	modelId = StandardMachineV9938Model.ID;
        } else {
        	modelId = StandardMachineModel.ID;
        }
        
        MachineModel model = MachineModelFactory.createModel(modelId);
        assert (model != null);
        
        machine = model.createMachine();

        Client client = createClient(args, machine);
        
        if (findArgument(args, "--dump")) {
        	//Executor.settingDumpInstructions.setBoolean(true);
        	//Compiler.settingDebugInstructions.setBoolean(true);
        	Cpu.settingDumpFullInstructions.setBoolean(true);
        }
        VdpTMS9918A.settingDumpVdpAccess.setBoolean(true);
        GplMmio.settingDumpGplAccess.setBoolean(true);
        
        
        Emulator.createAndRun(machine, client);
    }

	/**
	 * @param machine2
	 * @param client2
	 * @throws IOException 
	 */
	public static void createAndRun(IMachine machine, Client client) throws IOException {
		if (client == null || machine == null) {
			System.err.println("Failed to create machine or client, exiting");
			System.exit(23);
		}
		
        final Emulator app = new Emulator(machine, client);
        
        app.setupDefaults();
        app.loadState();
        try {
        	app.run();
        } finally {
        	WorkspaceSettings.CURRENT.save();        	
        	EmulatorSettings.INSTANCE.save();   
        	
        	app.dispose();
        }
		
	}

	/**
	 * 
	 */
	private void dispose() {
		machine.getMemory().save();
	}

	private void run() {
		
		machine.getCpu().reset();
        machine.start();
        
        while (client.isAlive()) {
        	client.handleEvents();
	    	
	    	if (!machine.isAlive())
	    		break;
	    	
	    	// don't eat up CPU
	    	try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
        }
	}

 	private static boolean findArgument(String[] args, String string) {
    	for (String arg : args)
    		if (arg.equals(string))
    			return true;
		return false;
	}

	public static URL getDataURL(String string) {
		/*
		Bundle bundle = Platform.getBundle("v9t9-java");
		if (bundle != null) {
			URL url = FileLocator.find(bundle, new Path(string), Collections.emptyMap());
			if (url != null)
				return url;
		}
		*/
		
		/*
		URL url = Emulator.class.getClassLoader().getResource(string);
		        
		if (url != null) {
			return url;
		}
	        
		if (sIsDevBuild) {
			try {
				return new URL("file", null, "../v9t9-java/data/" + string);
			} catch (MalformedURLException e) {
				return null;
			}
		}
		*/
		
		try {
			return new URL(sBaseDataURL, string);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}

}

