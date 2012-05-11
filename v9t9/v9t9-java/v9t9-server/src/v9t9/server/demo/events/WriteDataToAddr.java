/**
 * 
 */
package v9t9.server.demo.events;

import v9t9.common.demo.IDemoEvent;
import v9t9.common.machine.IMachine;
import v9t9.common.memory.IMemoryDomain;

/**
 * Write data all to the same address
 * @author ejs
 *
 */
public abstract class WriteDataToAddr implements IDemoEvent {
	private int address;
	private byte[] data;
	
	public WriteDataToAddr(int address, byte[] data) {
		this.address = address;
		this.data = data;
	}
	public int getAddress() {
		return address;
	}
	public byte[] getData() {
		return data;
	}
	

	protected abstract IMemoryDomain getDomain(IMachine machine);
	
	/* (non-Javadoc)
	 * @see v9t9.common.demo.IDemoEvent#execute(v9t9.common.machine.IMachine)
	 */
	@Override
	public void execute(IMachine machine) {
		for (int i = 0; i < data.length; i++) {
			getDomain(machine).writeByte(address, data[i]);
		}
	}
}