/**
 * 
 */
package v9t9.server.demo;

import java.io.IOException;
import java.io.OutputStream;

import v9t9.common.demo.IDemoEvent;
import v9t9.common.demo.IDemoOutputStream;
import v9t9.server.demo.DemoFormat.BufferType;
import v9t9.server.demo.events.SoundWriteRegisterEvent;
import v9t9.server.demo.events.VideoWriteDataEvent;
import v9t9.server.demo.events.VideoWriteRegisterEvent;

/**
 * Writer for TI Emulator v6.0 & V9t9 demo formats
 * @author ejs
 *
 */
public class OldDemoFormatWriter extends BaseDemoFormatWriter implements IDemoOutputStream {

	public OldDemoFormatWriter(OutputStream os) throws IOException {
		super(os);
		
		os.write(DemoFormat.DEMO_MAGIC_HEADER_V910);
	}
	

	@Override
	protected void writeTimerTick() throws IOException {
		flushAll();
		os.write(BufferType.TICK.getCode());
	}
	
	@Override
	protected void writeSpeechEvent(IDemoEvent event) throws IOException {
		CommonDemoFormat.writeSpeechEvent(event, speechBuffer);
	}

	@Override
	protected void writeSoundRegisterEvent(IDemoEvent event)
			throws IOException {
		if (!soundRegsBuffer.isAvailable(3)) {
			soundRegsBuffer.flush();
		}
		SoundWriteRegisterEvent ev = (SoundWriteRegisterEvent) event;
		soundRegsBuffer.pushWord(ev.getReg());
		soundRegsBuffer.pushWord(ev.getVal());
	}

	@Override
	protected void writeSoundDataEvent(IDemoEvent event)
			throws IOException {
		CommonDemoFormat.writeSoundDataEvent(event, soundDataBuffer);
	}

	@Override
	protected void writeVideoDataEvent(IDemoEvent event)
			throws IOException {
		VideoWriteDataEvent we = (VideoWriteDataEvent) event;
		int len = we.getLength();
		int offs = 0;
		while (len > 0) {
			int toUse = Math.min(255, len);
			if (!videoBuffer.isAvailable(toUse + 3)) {
				videoBuffer.flush();
			}
			videoBuffer.pushWord(we.getAddress() + offs);
			videoBuffer.push((byte) toUse);
			videoBuffer.pushData(we.getData(), offs + we.getOffset(), toUse);
			
			len -= toUse;
			offs += toUse;
		}
	}

	@Override
	protected void writeVideoRegisterEvent(IDemoEvent event)
			throws IOException {
		if (!videoBuffer.isAvailable(2)) {
			videoBuffer.flush();
		}
		videoBuffer.pushWord(((VideoWriteRegisterEvent) event).getAddr());
	}
}