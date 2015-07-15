/*
  ManualTestTI99ModuleDetection.java

  (c) 2013 Ed Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package v9t9.machine.common.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileFilter;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import v9t9.common.client.ISettingsHandler;
import v9t9.common.files.IPathFileLocator;
import v9t9.common.machine.IMachine;
import v9t9.common.memory.IMemoryDomain;
import v9t9.common.memory.MemoryEntryInfo;
import v9t9.common.modules.IModule;
import v9t9.common.modules.IModuleDetector;
import v9t9.common.modules.IModuleManager;
import v9t9.common.settings.BasicSettingsHandler;
import v9t9.machine.ti99.machine.StandardTI994AMachineModel;

/**
 * @author ejs
 *
 */
public class DetectModules {

	private ISettingsHandler settings;
	private IMachine machine;
	private IModuleDetector detector;

	public DetectModules() {
		settings = new BasicSettingsHandler();  
		machine = new StandardTI994AMachineModel().createMachine(settings);
		
		URI databaseURI = URI.create("test.xml");
		detector = machine.createModuleDetector(databaseURI);
	}
	
	public void scan(String path) {
		File dir = new File(path);
		if (!dir.isDirectory()) {
			System.err.println("Not a directory: " + path);
			return;
		}
		
		Collection<IModule> modules = detector.scan(dir);
		System.out.println("Found " + modules.size() + " modules in " + dir);
	}
	
	public void list() {
		Collection<IModule> modules = detector.getModules();

		Map<String, List<IModule>> md5ToModules = new TreeMap<String, List<IModule>>();
		for (IModule module : modules) {
			String md5 = module.getMD5();
			List<IModule> mods = md5ToModules.get(md5);
			if (mods == null) {
				mods = new ArrayList<IModule>();
				md5ToModules.put(md5, mods);
			}
			mods.add(module);
		}
		for (Map.Entry<String, List<IModule>> ent : md5ToModules.entrySet()) {
			System.out.println(ent.getKey() + ":");
			for (IModule module : ent.getValue()) {
				System.out.println("\t" + module.getName() + "\n\t\t" + module.getMD5() );
				for (MemoryEntryInfo info : module.getMemoryEntryInfos()) {
					System.out.print("\t\t" + info.getFilename());
					if (info.getFilename2() != null)
						System.out.print(", " + info.getFilename2());
					if (info.isBanked())
						System.out.print(", banked");
					System.out.println();
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Run as DetectModules [path...]");
			return;
		}
		DetectModules modules = new DetectModules();
		for (String arg : args) {
			System.out.println("[" + arg + "]");
			modules.scan(arg);
		}
		modules.list();
	}
	
}
