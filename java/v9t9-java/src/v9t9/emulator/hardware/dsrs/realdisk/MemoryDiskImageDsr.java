/**
 * Mar 1, 2011
 */
package v9t9.emulator.hardware.dsrs.realdisk;

import v9t9.emulator.common.Machine;
import v9t9.emulator.hardware.dsrs.IMemoryIOHandler;

/**
 * This disk DSR assumes all control and ports are in MMIO.
 * 
 * Consumes 6 bytes from base:
 * 
 * 	0: write: cmd; read: status
 *  1: write/read: track addr
 *  2: write/read: sector addr
 *  3: write/read: data
 *  4: write/read: [0 | 0 | 0 | 0 | motor | hold | head | side ] 
 *  5: write/read: [0 | 0 | 0 | 0 | 0 | D2 | D1 | D0] 
 *  
 * @author ejs
 *
 */
public class MemoryDiskImageDsr extends BaseDiskImageDsr implements IMemoryIOHandler {

	public static final int COMMAND = 0; 
	public static final int STATUS = 0; 
	public static final int TRACK = 1; 
	public static final int SECTOR = 2; 
	public static final int DATA = 3; 
	public static final int DSK = 4;
	public static final int FLAGS = 5;
	public static final int FL_MOTOR = 0x1;
	public static final int FL_HEAD = 0x2;
	public static final int FL_SIDE = 0x4;
	public static final int FL_HOLD = 0x8;
	
	private final int baseAddr;

	private byte flags;
	
	/**
	 * 
	 */
	public MemoryDiskImageDsr(Machine machine, int baseAddr) {
		super(machine);
		this.baseAddr = baseAddr;
		flags = 0;
	}

	/* (non-Javadoc)
	 * @see v9t9.emulator.hardware.dsrs.IMemoryIOHandler#writeData(int, byte)
	 */
	@Override
	public void writeData(int offset, byte val) {
		if (offset >= baseAddr && offset < baseAddr + 5) {
			switch (offset - baseAddr) {
			case COMMAND:
				writeCommand(val);
				break;
			case TRACK:
				writeTrackAddr(val);
				break;
			case SECTOR:
				writeSectorAddr(val);
				break;
			case DATA:
				writeData(val);
				break;
			case DSK:
				if (val == 0)
					selectDisk(0, false);
				else
					selectDisk(val, true);
				break;
			case FLAGS: {
				byte oldflags = flags;
				flags = val;
				if (((flags ^ oldflags) & FL_SIDE) != 0) {
					setDiskSide((flags & FL_SIDE) != 0 ? 1 : 0);
				}
				if (((flags ^ oldflags) & FL_MOTOR) != 0) {
					setDiskMotor((flags & FL_MOTOR) != 0);
				}
				if (((flags ^ oldflags) & FL_HEAD) != 0) {
					setDiskHeads((flags & FL_HEAD) != 0);
				}
				if (((flags ^ oldflags) & FL_HOLD) != 0) {
					setDiskHold((flags & FL_HOLD) != 0);
				}
				
			}
			}
		}
	}

	/* (non-Javadoc)
	 * @see v9t9.emulator.hardware.dsrs.IMemoryIOHandler#readData(int)
	 */
	@Override
	public byte readData(int offset) {
		if (offset >= baseAddr && offset < baseAddr + 5) {
			switch (offset - baseAddr) {
			case COMMAND:
				return readStatus();
			case TRACK:
				return readTrackAddr();
			case SECTOR:
				return readSectorAddr();
			case DATA:
				return readData();
			case DSK:
				return (byte) getSelectedDisk();
			case FLAGS:
				flags = (byte) ((getSide() != 0 ? FL_SIDE : 0) 
					| (isMotorRunning() ? FL_MOTOR : 0)
					| (isDiskHeads() ? FL_HEAD : 0)
					| (isDiskHold() ? FL_HOLD : 0));
				return flags;
			}
		}
		return 0;
	}

}
