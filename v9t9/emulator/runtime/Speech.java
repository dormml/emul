/*
 * (c) Ed Swartz, 2005
 * 
 * Created on Dec 29, 2004
 *
 */
package v9t9.emulator.runtime;

import v9t9.emulator.Machine.ConsoleMmioWriter;
import v9t9.engine.Client;

/** 
 * Speech chip
 * @author ejs
 */
public class Speech implements ConsoleMmioWriter, v9t9.emulator.Machine.ConsoleMmioReader {

    private Client client;

	public Speech() {
    }

    public byte read(int addrMask) {
        return (byte) 0x00;
    }
    
    /**
     * @see v9t9.engine.memory.Memory.ConsoleMmioWriter#write 
     */
    public void write(int addr, byte val) {
        System.out.println("speech write: " + (val&0xff));
    }

	public void setClient(Client client) {
		this.client = client;
	}

}
