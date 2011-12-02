package v9t9.emulator.hardware.memory.mmio;

import v9t9.emulator.common.Machine.ConsoleMmioReader;
import v9t9.emulator.common.Machine.ConsoleMmioWriter;
import v9t9.emulator.hardware.memory.VdpRamArea;
import v9t9.engine.VdpHandler;
import v9t9.engine.memory.ByteMemoryAccess;

public abstract class VdpMmio implements ConsoleMmioReader, ConsoleMmioWriter {

	protected int currentaccesscycles;
	protected VdpHandler vdpHandler;
	protected VdpRamArea fullRamArea;
	private int fullRamMask;

	public VdpMmio(VdpRamArea fullRamArea) {
		this.fullRamArea = fullRamArea;
		this.fullRamMask = fullRamArea.memory.length - 1;
		fullRamMask |= (fullRamMask >> 1) | (fullRamMask >> 2) | (fullRamMask >> 3);
	}

	abstract public int getAddr();

	public int getMemoryAccessCycles() {
		return currentaccesscycles;
	}
	
	/** Set the number of extra access cycles */
	public void setMemoryAccessCycles(int i) {
		currentaccesscycles = i;
	}

	public void setVdpHandler(VdpHandler vdp) {
		this.vdpHandler = vdp;
	}

	public byte readFlatMemory(int vdpaddr) {
		return fullRamArea.memory[vdpaddr & fullRamMask];
	}

	public void writeFlatMemory(int vdpaddr, byte byt) {
		fullRamArea.memory[vdpaddr & fullRamMask] = byt;
		vdpHandler.touchAbsoluteVdpMemory(vdpaddr, byt);
	}

	public ByteMemoryAccess getByteReadMemoryAccess(int addr) {
		return new ByteMemoryAccess(fullRamArea.memory, addr);
	}

	public int getMemorySize() {
		return fullRamArea.memory.length;
	}

	/**
	 * Get the base address for the current bank
	 * @return
	 */
	public int getBankAddr() {
		return 0;
	}


}