/*
  VideoThread.java

  (c) 2015 Ed Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package v9t9.common.video;

import java.io.PrintWriter;

import ejs.base.properties.IProperty;
import ejs.base.settings.Logging;
import v9t9.common.client.ISettingsHandler;
import v9t9.common.client.IVideoRenderer;
import v9t9.common.cpu.ICpu;
import v9t9.common.hardware.IVdpChip;

/**
 * @author ejs
 *
 */
public class VideoThread extends Thread {

	private IVideoRenderer videoRenderer;
	private Object sync;
	private IProperty dumpVdpAccess;
	private IProperty dumpFullInstructions;

	public VideoThread(IVideoRenderer videoRenderer) {
		setName("Video Thread");
		this.videoRenderer = videoRenderer;
		sync = new Object();
		
		ISettingsHandler settings = videoRenderer.getVdpHandler().getMachine().getSettings();
		dumpVdpAccess = settings.get(IVdpChip.settingDumpVdpAccess);
		dumpFullInstructions = settings.get(ICpu.settingDumpFullInstructions);
	}
	
	/**
	 * Invoke Object#notifyAll() on this object to trigger
	 * a redraw.
	 * @return
	 */
	public Object getSync() {
		return sync;
	}
	
	@Override
	public void run() {
		synchronized (sync) {
			while (!isInterrupted()) {
				try {
					// attempt update at least once a second even if the
					// CPU and/or video threads are somehow frozen
					sync.wait(1000);
					
					// got notify
					synchronized (videoRenderer.getVdpHandler()) {
						synchronized (videoRenderer) {
							synchronized (videoRenderer.getCanvasHandler()) {
								synchronized (videoRenderer.getCanvas()) {
									updateVideo();
								}
							}
						}
					}
				} catch (InterruptedException e) {
					break;
				}
			}
			
		}
	}
	
	private void log(String msg) {
		if (dumpVdpAccess.getBoolean()) {
			PrintWriter pw = Logging.getLog(dumpFullInstructions);
			if (pw != null)
				pw.println("[VideoThread] " + msg);
		}
	}

	public void updateVideo() {
		if (videoRenderer.isIdle() && videoRenderer.isVisible()) {
			log("updating VDP canvas");
			videoRenderer.getCanvasHandler().update();
			videoRenderer.queueRedraw();
		}
	}
}
