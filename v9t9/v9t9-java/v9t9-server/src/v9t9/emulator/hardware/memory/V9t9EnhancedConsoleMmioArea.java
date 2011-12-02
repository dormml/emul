/**
 * 
 */
package v9t9.emulator.hardware.memory;

import v9t9.emulator.common.IMachine;
import v9t9.emulator.hardware.memory.mmio.ConsoleMmioArea;
import v9t9.engine.memory.MemoryDomain;
import v9t9.engine.memory.MemoryEntry;
import v9t9.engine.memory.MemoryListener;
import v9t9.engine.memory.MultiBankedMemoryEntry;
import v9t9.engine.memory.TIMemoryModel;

/**
 * Enhanced memory-mapped I/O area, which is much compacted (and yes, sheds any 
 * potential for expansion of the GPL area... like anyone needs that...)
 * <pre>
        >FF80=VDPRD
        >FF82=VDPST
        >FF84=VDPWD
        >FF86=VDPWA
        >FF88=VDPCL
        >FF8A=VDPWI
        
        >FF90=GPLRD
        >FF92=GPLRA
        >FF94=GPLWD
        >FF96=GPLWA
        
        >FFA0=sound
        
        >FFB0=speech
        
	    >FFC0=CPU ROM select               
	    >FFC2=FORTH ROM select             
	    >FFC4=>8400->9FFF is RAM            TODO
	    >FFC6=>8400->9FFF is MMIO (old-style)   TODO
	    >FFFC=NMI interrupt vector
        
</pre> 
 * @author ejs
 *
 */
public class V9t9EnhancedConsoleMmioArea extends ConsoleMmioArea implements MemoryListener {

	private static final int MMIO_BASE = 0xFF80;
	public static final int VDPRD = 0xFF80;
	public static final int VDPST = 0xFF82;
	public static final int VDPWD = 0xFF88;
	public static final int VDPWA = 0xFF8A;
	public static final int VDPCL = 0xFF8C;
	public static final int VDPWI = 0xFF8E;
	public static final int GPLRD = 0xFF90;
	public static final int GPLRA = 0xFF92;
	public static final int GPLWD = 0xFF94;
	public static final int GPLWA = 0xFF96;
	public static final int SPCHWT = 0xFF98;
	public static final int SPCHRD = 0xFF9A;
	public static final int SOUND = 0xFFA0;	// 0x20!
	public static final int BANKA = 0xFFC0;
	public static final int BANKB = 0xFFC2;
	public static final int NMI = 0xFFFC;
	
	private final IMachine machine;
	private MemoryEntry underlyingMemory;
	private MultiBankedMemoryEntry romMemory;
		
	V9t9EnhancedConsoleMmioArea(IMachine machine) {
		super(0);
		this.machine = machine;
		machine.getMemory().addListener(this);
    };
    
    @Override
	public boolean hasWriteAccess() {
		return true;
	}

    @Override
	public boolean hasReadAccess() {
		return true;
	}


    
    public void physicalMemoryMapChanged(MemoryEntry entry) {
		if ((entry.addr >= 0x10000 - MemoryDomain.AREASIZE || entry.addr + entry.size < 0x10000)
				|| (entry.addr < 0x4000)) {
			findUnderlyingMemory();
		}
	}
    public void logicalMemoryMapChanged(MemoryEntry entry) {
    	physicalMemoryMapChanged(entry);
    }

    private void findUnderlyingMemory() {
    	for (MemoryEntry entry : machine.getMemory().getDomain(MemoryDomain.NAME_CPU).getMemoryEntries()) {
    		if (entry.addr < MMIO_BASE && entry.addr + entry.size >= 0x10000 && entry.getArea() != this) {
    			underlyingMemory = entry;
    		}
    		else if (entry.addr < 0x4000) {
    			if (entry instanceof MultiBankedMemoryEntry) {
					romMemory = (MultiBankedMemoryEntry) entry;
				} else {
					romMemory = null;
					
				}
    		}

    	}
	}

    @Override
    public void writeByte(MemoryEntry entry, int addr, byte val) {
    	if (isRAMAddr(addr)) {
    		underlyingMemory.getArea().flatWriteByte(underlyingMemory, addr, val);
    		return;
    	}
    	if ((addr & 1) != 0)
    		return;
    	
    	writeMmio(addr, val);
    }

	private boolean isRAMAddr(int addr) {
		return addr < MMIO_BASE || addr >= NMI;
	}
    
	@Override
    public void writeWord(MemoryEntry entry, int addr, short val) {
    	if (isRAMAddr(addr)) {
    		underlyingMemory.getArea().flatWriteWord(underlyingMemory, addr, val);
    		return;
    	}
    	writeByte(entry, addr, (byte) (val >> 8));
    }


	@Override
	public byte readByte(MemoryEntry entry, int addr) {
		if (isRAMAddr(addr))
			return underlyingMemory.getArea().flatReadByte(underlyingMemory, addr);
    	if ((addr & 1) != 0)
    		return 0;
		return readMmio(addr);
	}
	
	@Override
	public short readWord(MemoryEntry entry, int addr) {
		if (isRAMAddr(addr))
			return underlyingMemory.getArea().flatReadWord(underlyingMemory, addr);
		return (short) (readByte(entry, addr) << 8);
	}

    private void writeMmio(int addr, byte val) {
    	switch (addr) {
    	case VDPWD:
    	case VDPWA:
    	case VDPCL:
    	case VDPWI:
    		getTIMemoryModel().getVdpMmio().write(addr, val);
    		break;
    	case GPLWA:
    		getTIMemoryModel().getGplMmio().write(addr, val);
    		break;
    	case SPCHWT:
    		getTIMemoryModel().getSpeechMmio().write(addr, val);
    		break;
    	case BANKA:
    		if (romMemory != null) {
    			romMemory.selectBank(0);
    		}
    		break;
    	case BANKB:
    		if (romMemory != null) {
    			romMemory.selectBank(1);
    		}
    		break;
    	}

    	if (addr >= SOUND && addr < SOUND + 0x20) {
    		getTIMemoryModel().getSoundMmio().write(addr, val);
    	}
	}

	private TIMemoryModel getTIMemoryModel() {
		return (TIMemoryModel) machine.getMemoryModel();
	}

	private byte readMmio(int addr) {
		switch (addr) {
    	case VDPRD:
    	case VDPST:
    		return getTIMemoryModel().getVdpMmio().read(addr);
    	case GPLRD:
    	case GPLRA:
    		return getTIMemoryModel().getGplMmio().read(addr);
    	case SPCHRD:
    		return getTIMemoryModel().getSpeechMmio().read(addr);
    	}
		return 0;
	}

	@Override
	public byte flatReadByte(MemoryEntry entry, int addr) {
		if (isRAMAddr(addr))
			return super.flatReadByte(entry, addr);
		return 0;
	}
	
	@Override
	public short flatReadWord(MemoryEntry entry, int addr) {
		if (isRAMAddr(addr))
			return super.flatReadWord(entry, addr);
		return 0;
	}
	
	@Override
	public void flatWriteByte(MemoryEntry entry, int addr, byte val) {
		if (isRAMAddr(addr))
			super.flatWriteByte(entry, addr, val);
	}

	@Override
	public void flatWriteWord(MemoryEntry entry, int addr, short val) {
		if (isRAMAddr(addr))
			super.flatWriteWord(entry, addr, val);
	}
	
	/* (non-Javadoc)
	 * @see v9t9.engine.memory.WordMemoryArea#getSize()
	 */
	@Override
	protected int getSize() {
		return 0x400;
	}
}