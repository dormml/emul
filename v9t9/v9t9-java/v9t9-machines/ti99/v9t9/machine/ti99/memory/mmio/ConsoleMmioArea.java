/*
  ConsoleMmioArea.java

  (c) 2008-2013 Edward Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package v9t9.machine.ti99.memory.mmio;

import v9t9.engine.memory.WordMemoryArea;
import v9t9.engine.memory.ZeroWordMemoryArea;

public class ConsoleMmioArea extends WordMemoryArea {
	private byte oddLatency;
	
    public ConsoleMmioArea(int latency) {
    	this(latency, latency);
    }
    public ConsoleMmioArea(int latency, int oddLatency) {
    	super(latency);
    	this.oddLatency = (byte) oddLatency;
    	bWordAccess = true;
    	memory = ZeroWordMemoryArea.zeroes;
    }
    
    @Override
    public boolean hasReadAccess() {
    	return false;
    }
    
    /* (non-Javadoc)
     * @see v9t9.engine.memory.MemoryArea#getLatency()
     */
    @Override
    protected byte getLatency(int addr) {
    	if ((addr & 1) != 0)
    		return oddLatency;
    	return super.getLatency(addr);
    }

}