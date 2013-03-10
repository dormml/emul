/*
  TI99Machine.java

  (c) 2010-2012 Edward Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package v9t9.machine.ti99.machine;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.w3c.dom.Element;

import ejs.base.settings.ISettingSection;
import ejs.base.utils.FileUtils;
import ejs.base.utils.HexUtils;
import ejs.base.utils.StorageException;
import ejs.base.utils.StreamXMLStorage;
import ejs.base.utils.TextUtils;
import ejs.base.utils.XMLUtils;
import v9t9.common.client.IKeyboardHandler;
import v9t9.common.client.ISettingsHandler;
import v9t9.common.dsr.IDsrManager;
import v9t9.common.files.DataFiles;
import v9t9.common.machine.IMachineModel;
import v9t9.common.memory.IMemoryDomain;
import v9t9.common.memory.MemoryEntryInfo;
import v9t9.common.modules.IModule;
import v9t9.common.modules.Module;
import v9t9.engine.hardware.CruManager;
import v9t9.engine.machine.MachineBase;
import v9t9.engine.memory.GplMmio;
import v9t9.engine.memory.MemoryEntryInfoBuilder;
import v9t9.engine.memory.SpeechMmio;
import v9t9.engine.memory.StdMultiBankedMemoryEntry;
import v9t9.engine.memory.TIMemoryModel;
import v9t9.engine.memory.VdpMmio;
import v9t9.machine.ti99.dsr.DsrManager;
import v9t9.machine.ti99.memory.BaseTI994AMemoryModel;

public class TI99Machine extends MachineBase {

	public static final String KEYBOARD_MODE_TI994A = "ti994a";
	public static final String KEYBOARD_MODE_TI994 = "ti994";
	public static final String KEYBOARD_MODE_LEFT = "left";
	public static final String KEYBOARD_MODE_RIGHT = "right";
	public static final String KEYBOARD_MODE_PASCAL = "pascal";
	
	private CruManager cruManager;
	protected DsrManager dsrManager;
	
	public TI99Machine(ISettingsHandler settings, IMachineModel machineModel) {
		super(settings, machineModel);
		
		getSettings().get(IKeyboardHandler.settingPasteKeyDelay).setInt(3);
	}

	@Override
	protected void init(IMachineModel machineModel) {
		super.init(machineModel);

		cruManager = new CruManager();
		dsrManager = new DsrManager(this);
	}
	
	@Override
	public void stop() {
		super.stop();
		 if (dsrManager != null)
			 dsrManager.dispose();
	}
	/* (non-Javadoc)
	 * @see v9t9.emulator.common.Machine#getMemoryModel()
	 */
	@Override
	public TIMemoryModel getMemoryModel() {
		return (TIMemoryModel) super.getMemoryModel();
	}
	/* (non-Javadoc)
	 * @see v9t9.emulator.common.Machine#doLoadState(v9t9.base.core.settings.ISettingSection)
	 */
	@Override
	protected void doLoadState(ISettingSection section) {
		super.doLoadState(section);
		getMemoryModel().getGplMmio().loadState(section.getSection("GPL"));
		if (dsrManager != null)
			dsrManager.loadState(section.getSection("DSRs"));
	}
	/* (non-Javadoc)
	 * @see v9t9.emulator.common.Machine#doSaveState(v9t9.base.core.settings.ISettingSection)
	 */
	@Override
	protected void doSaveState(ISettingSection settings) {
		super.doSaveState(settings);
		getMemoryModel().getGplMmio().saveState(settings.addSection("GPL"));
		if (dsrManager != null)
			dsrManager.saveState(settings.addSection("DSRs"));

	}

	/* (non-Javadoc)
	 * @see v9t9.emulator.hardware.TI99Machine#getSoundMmio()
	 */
	public v9t9.engine.memory.SoundMmio getSoundMmio() {
	    return ((BaseTI994AMemoryModel) memoryModel).soundMmio;
	}

	/* (non-Javadoc)
	 * @see v9t9.emulator.hardware.TI99Machine#getVdpMmio()
	 */
	public VdpMmio getVdpMmio() {
	    return ((BaseTI994AMemoryModel) memoryModel).vdpMmio;
	}

	/* (non-Javadoc)
	 * @see v9t9.emulator.hardware.TI99Machine#getGplMmio()
	 */
	public GplMmio getGplMmio() {
	    return ((BaseTI994AMemoryModel) memoryModel).gplMmio;
	}

	/* (non-Javadoc)
	 * @see v9t9.emulator.hardware.TI99Machine#getSpeechMmio()
	 */
	public SpeechMmio getSpeechMmio() {
		return ((BaseTI994AMemoryModel) memoryModel).speechMmio;
	}

	/* (non-Javadoc)
	 * @see v9t9.emulator.hardware.TI99Machine#getGplMemoryDomain()
	 */
	public IMemoryDomain getGplMemoryDomain() {
		return memory.getDomain(IMemoryDomain.NAME_GRAPHICS);
	}

	/* (non-Javadoc)
	 * @see v9t9.emulator.hardware.TI99Machine#getSpeechMemoryDomain()
	 */
	public IMemoryDomain getSpeechMemoryDomain() {
		return memory.getDomain(IMemoryDomain.NAME_SPEECH);
	}

	/* (non-Javadoc)
	 * @see v9t9.emulator.hardware.TI99Machine#getVdpMemoryDomain()
	 */
	public IMemoryDomain getVdpMemoryDomain() {
		return memory.getDomain(IMemoryDomain.NAME_VIDEO);
	}

	public CruManager getCruManager() {
		return cruManager;
	}
	
	public IDsrManager getDsrManager() {
		return dsrManager;
	}
	
	/* (non-Javadoc)
	 * @see v9t9.common.modules.IModuleManager#scanModules(java.io.File)
	 */
	@Override
	public Collection<IModule> scanModules(URI databaseURI, File base) {
		
		File[] files = base.listFiles(); 
		if (files == null) {
			return Collections.emptyList();
		}
		
		Map<String, IModule> moduleMap = new HashMap<String, IModule>();
		
		for (File file : files) {
			if (file.isDirectory())
				continue;

			if (analyzeV9t9ModuleFile(databaseURI, file.toURI(), file.getName(), moduleMap))
				continue;
			
			if (analyzeGRAMKrackerModuleFile(databaseURI, file, moduleMap))
				continue;
			
			if (analyzeRPKModuleFile(databaseURI, file, moduleMap))
				continue;
			
			if (analyzeZipModuleFile(databaseURI, file, moduleMap))
				continue;
			

		}

		
		// remove spurious modules
		for (Iterator<IModule> iter = moduleMap.values().iterator(); iter.hasNext(); ) {
			IModule module = iter.next();
			System.out.println(module);
			String moduleName = module.getName();
			if (TextUtils.isEmpty(moduleName) || !isASCII(moduleName)) {
				iter.remove();
			}
		}
		List<IModule> modules = new ArrayList<IModule>(moduleMap.values());
		Collections.sort(modules, new Comparator<IModule>() {

			@Override
			public int compare(IModule o1, IModule o2) {
				return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
			}
		});
		return modules;
	}

	/**
	 * Look for V9t9 module parts -- bare binaries with pieces identified
	 * by the final filename letter ('C' = console module ROM, 'D' = console module ROM,
	 * bank #2, 'G' = module GROM). 
	 */
	private boolean analyzeV9t9ModuleFile(URI databaseURI, URI uri,
			String fname,
			Map<String, IModule> moduleMap) {
		if (!fname.toLowerCase().endsWith(".bin"))
			return false;
		
		String base = fname.substring(0, fname.length() - 4); // remove extension
		String key = base.substring(0, base.length() - 1);	// minus indicator char
		int idx = key.lastIndexOf('/');
		if (idx < 0)
			idx = key.lastIndexOf('\\');
		if (idx > 0)
			key = base.substring(idx+1);
		
		return analyzeV9t9ModuleFile(databaseURI, uri, fname, key, moduleMap);
	}


	/**
	 * Look for V9t9 module parts -- bare binaries with pieces identified
	 * by the final filename letter ('C' = console module ROM, 'D' = console module ROM,
	 * bank #2, 'G' = module GROM). 
	 */
	private boolean analyzeV9t9ModuleFile(URI databaseURI, URI uri,
			String fname, String key,
			Map<String, IModule> moduleMap) {
		if (!fname.toLowerCase().endsWith(".bin"))
			return false;
		
		byte[] content = null;
		try {
			try {
				File file = new File(uri);
				content = DataFiles.readMemoryImage(file, 0, 0x2000);
			} catch (IllegalArgumentException e) {
				// not file
				content = FileUtils.readInputStreamContentsAndClose(uri.toURL().openStream());
			}
		} catch (IOException e) {
			return false;
		}
		
		String moduleName = readHeaderName(content);
	
		moduleName = cleanupTitle(moduleName);
		
		IModule module = moduleMap.get(key);
		if (module == null) {
			module = new Module(databaseURI, key);
		}
		if (moduleName.length() > 0)
			module.setName(moduleName);
		
		char last = fname.charAt(fname.length() - 4 - 1);	// '.bin' and last char
		switch (last) {
		case 'c': {
			
			injectModuleRom(module, databaseURI, moduleName, fname, 0);
			
			break;
		}
		case 'd': {
			injectModuleBank2Rom(module, databaseURI, moduleName, fname, 0);
			
			break;
		}

		case 'g': {
			injectModuleGrom(module, databaseURI, moduleName, fname, 0);
			break;
		}
		default:
			return false;
		}

		// register/update module
		moduleMap.put(key, module);

		return true;
	}

	private void injectModuleGrom(IModule module, URI databaseURI,
			String moduleName, String fileName, int fileOffset) {
		MemoryEntryInfo info = MemoryEntryInfoBuilder.standardModuleGrom(fileName)
				.withOffset(fileOffset)
				.create(moduleName);
		module.addMemoryEntryInfo(info);		
	}

	private void injectModuleRom(IModule module, URI databaseURI,
			String moduleName, String fileName, int fileOffset) {
		MemoryEntryInfo info;
		boolean found = false;
		for (MemoryEntryInfo ex : module.getMemoryEntryInfos()) {
			// modify a banked entry
			if (ex.isBanked() && ex.getAddress() == 0x6000 && IMemoryDomain.NAME_CPU.equals(ex.getDomainName())) {
				ex.getProperties().put(MemoryEntryInfo.FILENAME, fileName);
				ex.getProperties().put(MemoryEntryInfo.CLASS, StdMultiBankedMemoryEntry.class);
				ex.getProperties().put(MemoryEntryInfo.OFFSET, fileOffset);
				found = true;
				break;
			} 
		}
		if (!found) {
			info = MemoryEntryInfoBuilder.standardModuleRom(fileName)
					.withOffset(fileOffset)
					.create(moduleName);
			module.addMemoryEntryInfo(info);
		}
		
	}

	private void injectModuleBank2Rom(IModule module, URI databaseURI,
			String moduleName, String fileName, int fileOffset) {

		MemoryEntryInfo info;
		boolean found = false;
		for (MemoryEntryInfo ex : module.getMemoryEntryInfos()) {
			// modify a non-banked entry
			if (ex.getAddress() == 0x6000 && IMemoryDomain.NAME_CPU.equals(ex.getDomainName())) {
				ex.getProperties().put(MemoryEntryInfo.FILENAME2, fileName);
				ex.getProperties().put(MemoryEntryInfo.CLASS, StdMultiBankedMemoryEntry.class);
				ex.getProperties().put(MemoryEntryInfo.SIZE, -0x2000);
				ex.getProperties().put(MemoryEntryInfo.OFFSET, fileOffset);
				found = true;
				break;
			} 
		}
		if (!found) {
			// make temporary
			info = MemoryEntryInfoBuilder.standardModuleRom(fileName)
					.withFilename2(fileName)
					.withOffset2(fileOffset)
					.withBankClass(StdMultiBankedMemoryEntry.class)
					.create(moduleName);
			module.addMemoryEntryInfo(info);
		}
		
	}
	
	
	/**
	 * Analyze GRAM Kracker-format files
	 * 
	 * &lt;http://www.ninerpedia.org/index.php/GRAM_Kracker_format&gt;
	 *  
	 * @param databaseURI 
	 * @param file
	 * @param moduleMap
	 * @return
	 */
	private boolean analyzeGRAMKrackerModuleFile(URI databaseURI, File file,
			Map<String, IModule> moduleMap) {
		
		
		return false;
	}
	
	
	/**
	 * Analyze MESS *.rpk format files
	 *  
	 * @param databaseURI 
	 * @param file
	 * @param moduleMap
	 * @return
	 */
	private boolean analyzeRPKModuleFile(URI databaseURI, File file,
			Map<String, IModule> moduleMap) {
		
		if (!file.getName().toLowerCase().endsWith(".rpk")) {
			return false;
		}
		
		// it is a zip container: softlist.xml contains the info
		ZipFile zf;
		try {
			zf = new ZipFile(file);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		try {
			for (Enumeration<? extends ZipEntry> en = zf.entries(); en.hasMoreElements(); ) {
				ZipEntry ent = en.nextElement();
				if (ent.getName().equals("softlist.xml")) {
					InputStream is = zf.getInputStream(ent);
					IModule module = convertSoftList(databaseURI, file.toURI(), is);
					if (module != null) {
						moduleMap.put(module.getName(), module);
					}
					is.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				zf.close();
			} catch (IOException e) {
			}
		}
		
		return true;
	}
	
	/**
	 * Analyze *.zip files
	 *  
	 * @param databaseURI 
	 * @param file
	 * @param moduleMap
	 * @return
	 */
	private boolean analyzeZipModuleFile(URI databaseURI, File file,
			Map<String, IModule> moduleMap) {
		
		ZipFile zf;
		try {
			zf = new ZipFile(file);
		} catch (Exception e) {
			return false;
		}
		
		boolean any = false;
		try {
			boolean oneModule = zf.size() <= 4;
				
			for (Enumeration<? extends ZipEntry> en = zf.entries(); en.hasMoreElements(); ) {
				ZipEntry ent = en.nextElement();
				
				try {
					URI uri = makeZipUri(file.toURI(), ent.getName());
					
					if (oneModule) {
						// associate with zip file's module
						if (analyzeV9t9ModuleFile(databaseURI, uri, uri.toString(), file.getName(), moduleMap)) {
							System.out.println(ent.getName());
							// nice
						}
					} else {
						// associate with appropriate module
						if (analyzeV9t9ModuleFile(databaseURI, uri, uri.toString(), moduleMap)) {
							System.out.println(ent.getName());
							// nice
						}
					}
				} catch (URISyntaxException e) {
					continue;
				}
				
				any = true;
			}
		} finally {
			try {
				zf.close();
			} catch (IOException e) {
			}
		}
		
		return any;
	}
	
	/**
	 * @param is
	 * @return
	 */
	private IModule convertSoftList(URI databaseURI, URI zipUri, InputStream is) {
		IModule module;
		
		StreamXMLStorage storage = new StreamXMLStorage();
		storage.setInputStream(is);
		try {
			storage.load("software");
		} catch (StorageException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				is.close();
			} catch (IOException e) {
			}
		}
		
		String moduleName = storage.getDocumentElement().getAttribute("name");
		module = new Module(databaseURI, moduleName);
		
		for (Element el : XMLUtils.getChildElements(storage.getDocumentElement())) {
			if (el.getNodeName().equals("description")) {
				moduleName = XMLUtils.getText(el);
				module.setName(moduleName);
			}
			else if (el.getNodeName().equals("year")
					|| el.getNodeName().equals("publisher")
					|| el.getNodeName().equals("info")) {
				//
			}
		}
		for (Element partEl : XMLUtils.getChildElementsNamed(storage.getDocumentElement(),  "part")) {
			if (!partEl.getAttribute("interface").equals("ti99_cart"))
				return null;
			
			//Element[] feats = XMLUtils.getChildElementsNamed(partEl, "feature");
			
			Element[] dataAreas = XMLUtils.getChildElementsNamed(partEl, "dataarea");
			for (Element dataArea : dataAreas) {
				String name = dataArea.getAttribute("name");
				if (name.equals("rom_socket")) {
					for (Element rom : XMLUtils.getChildElementsNamed(dataArea, "rom")) {
						injectModuleRom(module, databaseURI, moduleName, 
								makeZipUriString(zipUri, rom.getAttribute("name")),
								HexUtils.parseInt(rom.getAttribute("offset")));
					}
				}
				else if (name.equals("rom2_socket")) {
					for (Element rom : XMLUtils.getChildElementsNamed(dataArea, "rom")) {
						injectModuleBank2Rom(module, databaseURI, moduleName, 
								makeZipUriString(zipUri, rom.getAttribute("name")),
								HexUtils.parseInt(rom.getAttribute("offset")));
					}
				}
				else if (name.equals("grom_socket")) {
					for (Element rom : XMLUtils.getChildElementsNamed(dataArea, "rom")) {
						injectModuleGrom(module, databaseURI, moduleName, 
								makeZipUriString(zipUri, rom.getAttribute("name")),
								HexUtils.parseInt(rom.getAttribute("offset")));
					}
				}
			}
			
		}

		return module;
	}

	private URI makeZipUri(URI zipUri, String name) throws URISyntaxException {
		return new URI("jar", zipUri + "!/" + name, null);
	}

	private String makeZipUriString(URI zipUri, String name) {
		try {
			return makeZipUri(zipUri, name).toString();
		} catch (URISyntaxException e) {
			assert false;
			return name;
		}
	}
	
	/**
	 * @param file
	 * @return
	 */
	private String readHeaderName(byte[] content) {
		for (int offs = 0; offs < content.length; offs += 0x2000) {
			if (content[offs] != (byte) 0xaa) {
				continue;
			}
			
			// program list
			int addr = readAddr(content, offs + 0x6);
			if (addr == 0)
				continue;
	
			// get the last name (ordered reverse, non-English first)
			String name;
			int next;
			do {
				next = readAddr(content, offs + (addr & 0x1fff));
				name = readString(content, offs + (addr & 0x1fff) + 4);
				addr = next;
			} while (next >= 0x6000);		/* else not really module? */
			
			return name.trim();
		}
		return "";
	}

	/**
	 * @param name
	 * @return
	 */
	private boolean isASCII(String name) {
		for (char ch : name.toCharArray()) {
			if (ch < 0x20 || ch >= 127)
				return false;
		}
		return true;
	}

	/**
	 * @param addr
	 * @return
	 */
	private String readString(byte[] content, int addr) {
		int len = content[addr++] & 0xff;
		StringBuilder sb = new StringBuilder();
		while (len != 0 && addr < content.length) {
			sb.append((char) content[addr++]);
			len--;
		}
		return sb.toString();
	}

	/**
	 * @param content
	 * @param i
	 * @return
	 */
	private int readAddr(byte[] content, int i) {
		return ((content[i] << 8) & 0xff00) | (content[i+1] & 0xff);
	}
	
	private String cleanupTitle(String allCaps) {
		// remove spurious quotes
		allCaps = TextUtils.unquote(allCaps, '"');
		
		// capitalize each word
		StringBuilder sb = new StringBuilder();
		boolean newWord = true;
		for (char ch : allCaps.toCharArray()) {
			
			if (Character.isLetter(ch)) {
				if (newWord) {
					ch = Character.toUpperCase(ch);
					newWord = false;
				} else {
					ch = Character.toLowerCase(ch);
				}
			} else {
				newWord = true;
			}
				
			sb.append(ch);
		}
		
		String titledName = sb.toString();
		
		// lowercase prepositions
		for (String prep : new String[] { "And", "Or", "Of", "In", "For", "The" }) {
			titledName = replaceWord(titledName, prep, prep.toLowerCase(), false);
		}
				
		// uppercase common acronyms
		for (String acr : new String[] { "Ti", "Ii", "Iii" }) {
			titledName = replaceWord(titledName, acr, acr.toUpperCase(), true);
		}
				
		return titledName;		
	}

	private String replaceWord(String str, String word, String repl, boolean allowAtStart) {
		int idx = str.indexOf(word);
		if (idx > (allowAtStart ? -1 : 0)) {
			str = str.substring(0, idx) + repl + str.substring(idx + word.length());
		}

		return str;
	}
}