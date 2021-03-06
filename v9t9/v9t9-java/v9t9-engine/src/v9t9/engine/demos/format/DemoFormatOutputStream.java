/*
  DemoFormatOutputStream.java

  (c) 2012-2014 Edward Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package v9t9.engine.demos.format;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import v9t9.common.demos.DemoFormat;
import v9t9.common.demos.DemoHeader;
import v9t9.common.demos.IDemoEvent;
import v9t9.common.demos.IDemoEventFormatter;
import v9t9.common.demos.IDemoFormatterRegistry;
import v9t9.common.demos.IDemoOutputBuffer;
import v9t9.common.demos.IDemoOutputEventBuffer;
import v9t9.common.demos.IDemoOutputStream;
import v9t9.engine.demos.events.TimerTick;
import v9t9.engine.demos.stream.BaseDemoOutputStream;

/**
 * Write demos in new format more amenable to a non-memory constrained host and
 * a variable machine model.
 * 
 * 
 * @author ejs
 * 
 */
public class DemoFormatOutputStream extends BaseDemoOutputStream implements IDemoOutputStream {

	private int timerTicks;
	private int ticks;
	private DemoHeader header;
	
	private Map<String, IDemoOutputEventBuffer> eventToBufferMap = 
			new HashMap<String, IDemoOutputEventBuffer>();
	private byte[] magic;

	public DemoFormatOutputStream(DemoHeader header, OutputStream os_) throws IOException {
		super(os_);
		this.header = header;
		
		this.magic = header.getMagic(); 
		os.write(magic);
		timerTicks = 0;
		
		for (Map.Entry<Integer, String> ent : header.getBufferIdentifierMap().entrySet()) {
			String bufferId = ent.getValue();
			final IDemoEventFormatter formatter = IDemoFormatterRegistry.INSTANCE.findFormatterByBuffer(bufferId);
			if (formatter != null) {
				int code = header.findOrAllocateIdentifier(bufferId);
				DemoOutputEventBuffer buffer = new DemoFormatterOutputEventBuffer(os, code,
						bufferId, formatter);
				registerBuffer(buffer, formatter.getEventIdentifier());
			}
			else {
				// callers should invoke #registerBuffer
				System.out.println(bufferId);
			}
		}

		header.write(os);

	}
	
	/* (non-Javadoc)
	 * @see v9t9.common.demos.IDemoOutputStream#getDemoFormat()
	 */
	@Override
	public byte[] getDemoFormat() {
		return magic;
	}

	/**
	 * Register a custom buffer and event type.
	 * @param buffer
	 * @param eventId
	 * @throws IOException
	 */
	public void registerBuffer(IDemoOutputEventBuffer buffer, String eventId) throws IOException {
		if (!buffers.contains(buffer))
			buffers.add((IDemoOutputBuffer) buffer);
		eventToBufferMap.put(eventId, buffer);
	}


	@Override
	public int getTimerRate() {
		return header.getTimerRate();
	}


	@Override
	public long getElapsedTime() {
		return ticks * 1000L / getTimerRate();
	}
	
	@Override
	protected void preClose() throws IOException {
		super.preClose();
		if (timerTicks > 0) {
			emitTimerTick();
		}
	}


	@Override
	public synchronized void writeEvent(IDemoEvent event) throws IOException {
		if (event instanceof TimerTick) {
			writeTimerTick();
		}
		else if (event != null) {
			String id = event.getIdentifier();
			IDemoOutputEventBuffer buffer = eventToBufferMap.get(id);
			if (buffer == null)
				throw new IOException("unknown buffer/event type: " + id);
			
			buffer.encodeEvent(event);
		}
	}

	
	protected void emitTimerTick() throws IOException {
		os.write(DemoFormat.TICK);
		os.write(timerTicks);
		timerTicks = 0;
	}
	
	@Override
	protected void writeTimerTick() throws IOException {
		if (anythingToFlush() || timerTicks == 255) {
			emitTimerTick();
			flushAll();
		}
		++timerTicks;
		ticks++;
	}
}
