/*
  ExpRamArea.java

  (c) 2008-2013 Edward Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package v9t9.machine.ti99.memory;

import ejs.base.properties.IProperty;
import ejs.base.properties.IPropertyListener;
import v9t9.common.client.ISettingsHandler;
import v9t9.common.settings.SettingSchema;

/** 99/4A expansion RAM, accessed over the peripheral bus */
public class ExpRamArea extends ConsoleMemoryArea {
    static public final SettingSchema settingExpRam = new SettingSchema(
    		ISettingsHandler.MACHINE,
    		"MemoryExpansion32K", Boolean.FALSE);
	private IProperty expRam;


    public ExpRamArea(ISettingsHandler settings, int size) {
    	this(settings, 4, size);
    	
    }
    public ExpRamArea(ISettingsHandler settings, int latency, int size) {
    	super(latency);
    	
        if (!(size == 0x2000 || size == 0x6000)) {
			throw new IllegalArgumentException("unexpected expanded RAM size");
		}
        
        this.expRam = settings.get(ExpRamArea.settingExpRam); 

        memory = new short[size/2];

        expRam.addListenerAndFire(new IPropertyListener() {

			public void propertyChanged(IProperty setting) {
				if (setting.getBoolean()) {
					read = memory;
					write = memory;
				} else {
					read = null;
					write = null;
				}
			}
        	
        });
    }
    
	@Override
	public boolean hasWriteAccess() {
        return expRam.getBoolean();
    }

}