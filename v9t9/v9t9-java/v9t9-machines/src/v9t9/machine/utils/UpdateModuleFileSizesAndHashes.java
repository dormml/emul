/*
  UpdateModuleXmlMd5Hashes.java

  (c) 2012-2015 Edward Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package v9t9.machine.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import v9t9.common.events.NotifyException;
import v9t9.common.files.MD5FilterAlgorithms;
import v9t9.common.files.PathFileLocator;
import v9t9.common.memory.MemoryEntryInfo;
import v9t9.common.modules.IModule;
import v9t9.common.modules.ModuleDatabase;
import v9t9.common.settings.BasicSettingsHandler;
import v9t9.common.settings.SettingSchemaProperty;
import v9t9.engine.memory.Memory;
import v9t9.engine.memory.MemoryEntryFactory;
import ejs.base.properties.IProperty;

/**
 * Some external versions of module ROMs have bogus sizes -- ensure stock_modules.xml
 * does not include extraneous stuff
 * @author ejs
 *
 */
public class UpdateModuleFileSizesAndHashes {

	public static void main(String[] args) throws IOException {
		UpdateModuleFileSizesAndHashes runner = new UpdateModuleFileSizesAndHashes();
		runner.run(args);
	}

	private Memory memory;
	private PathFileLocator locator;
	private BasicSettingsHandler settings;
	
	/**
	 * 
	 */
	public UpdateModuleFileSizesAndHashes() {
		memory = new Memory();
		locator = new PathFileLocator();
		
		IProperty prop = new SettingSchemaProperty("Paths", String.class, new ArrayList<String>());
		prop.getList().add("/usr/local/src/v9t9-data/roms");
		prop.getList().add("/usr/local/src/v9t9-data/modules");
		prop.getList().add("/usr/local/src/v9t9-data/modules/mess");
		prop.getList().add("/usr/local/src/v9t9-data/modules/tosec");
		prop.getList().add("/usr/local/src/v9t9-data/modules/ftp.whtech.com/emulators/cartridges/zip");
		prop.getList().add("/usr/local/src/v9t9-data/modules/ftp.whtech.com/emulators/cartridges/rpk");
		prop.getList().add("/usr/local/src/v9t9-data/modules/ftp.whtech.com/emulators/cartridges/rpk.old");
		
		locator.addReadOnlyPathProperty(prop);
		
		settings = new BasicSettingsHandler();
		
		memory.setMemoryEntryFactory(new MemoryEntryFactory(settings, memory, locator));
	}
	
	protected void run(String[] args) throws IOException {
		
		for (String arg : args) {
			File file = new File(arg);
			URI dbUri = file.toURI();
			
			InputStream is = new FileInputStream(file);
			
			try {
				List<IModule> modules = ModuleDatabase.loadModuleListAndClose(memory, null, is, dbUri);
				
				for (IModule module : modules) {
					for (MemoryEntryInfo info : module.getMemoryEntryInfos()) {
						updateSize(MemoryEntryInfo.SIZE, 
								MemoryEntryInfo.FILE_MD5, 
								MemoryEntryInfo.FILE_MD5_OFFSET, 
								MemoryEntryInfo.FILE_MD5_LIMIT, 
								info, info.getFilename());
						updateSize(MemoryEntryInfo.SIZE2, 
								MemoryEntryInfo.FILE2_MD5, 
								MemoryEntryInfo.FILE2_MD5_OFFSET, 
								MemoryEntryInfo.FILE2_MD5_LIMIT, 
								info, info.getFilename2());
					}
				}
				
				File backup = new File(file.getAbsolutePath() + "~");
				backup.delete();
				file.renameTo(backup);
				
				OutputStream os = new FileOutputStream(file);
				ModuleDatabase.saveModuleListAndClose(memory, os, dbUri, modules);
				
			} catch (NotifyException e) {
				e.printStackTrace();
			}
			
		}
	}

	/**
	 * @param info
	 * @param filename
	 * @param fileMD5
	 * @return
	 * @throws IOException 
	 */
	private void updateSize(String sizeProperty, 
			String md5Property, String md5OffsetProperty, String md5SizeProperty,  
			MemoryEntryInfo info, String filename) throws IOException {
		if (filename == null)
			return;
		
		URI uri = locator.findFile(filename);
		if (uri == null) {
			System.err.println("Could not find " + filename);
			return;
		}
	
		int size = locator.getContentLength(uri);
		if (size >= 0x1000) {
			size &= ~0x7ff;
		}
		
		String alg = md5Property.equals(MemoryEntryInfo.FILE_MD5_ALGORITHM)
				? info.getEffectiveFileMD5Algorithm() : info.getEffectiveFile2MD5Algorithm();
		
		String md5 = locator.getContentMD5(uri, 
				MD5FilterAlgorithms.create(alg));

		System.out.println(filename + " ==> " + size + " & " + md5);
		
		info.getProperties().put(sizeProperty, size);
		info.getProperties().put(md5Property, md5);
	}
}
