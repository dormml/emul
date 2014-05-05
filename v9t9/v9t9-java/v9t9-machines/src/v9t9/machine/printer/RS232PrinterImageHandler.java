/**
 * 
 */
package v9t9.machine.printer;

import org.eclipse.swt.widgets.Display;

import v9t9.common.dsr.IOBuffer;
import v9t9.common.dsr.IPrinterImageEngine;
import v9t9.common.dsr.IPrinterImageHandler;
import v9t9.common.dsr.IRS232Handler;

/**
 * This handles 
 * @author ejs
 *
 */
public class RS232PrinterImageHandler implements IRS232Handler, IPrinterImageHandler {

	private DataSize dataSize;
	private Parity parity;
	private Stop stop;

	private IPrinterImageEngine engine = new EpsonPrinterImageEngine(360, 360);
	
	@Override
	public IPrinterImageEngine getEngine() {
		return engine;
	}
	
	/* (non-Javadoc)
	 * @see v9t9.common.dsr.IRS232Handler#updateControl(v9t9.common.dsr.IRS232Handler.DataSize, v9t9.common.dsr.IRS232Handler.Parity, v9t9.common.dsr.IRS232Handler.Stop)
	 */
	@Override
	public void updateControl(DataSize dataSize, Parity parity, Stop stop) {
		// ignore unless changing
		if (this.dataSize != dataSize || this.parity != parity || this.stop != stop) {
			this.dataSize = dataSize;
			this.parity = parity;
			this.stop = stop;

			engine.flushPage();
		}
	}
	
	/* (non-Javadoc)
	 * @see v9t9.common.dsr.IRS232Handler#setTransmitRate(int)
	 */
	@Override
	public void setTransmitRate(int bps) {
		// ignore
	}

	/* (non-Javadoc)
	 * @see v9t9.common.dsr.IRS232Handler#setReceiveRate(int)
	 */
	@Override
	public void setReceiveRate(int bps) {
		// ignore
	}

	/* (non-Javadoc)
	 * @see v9t9.common.dsr.IRS232Handler#transmitChars(v9t9.common.dsr.IRS232Handler.IOBuffer)
	 */
	@Override
	public void transmitChars(final IOBuffer buf) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				while (!buf.isEmpty()) {
					char ch = (char) buf.take();
					engine.print(ch);
				}
			}
		});
	}

}
