/*
  BaseSoundTest.java

  (c) 2011-2016 Edward Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package v9t9.audio.sound.test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import v9t9.audio.sound.ClockedSoundVoice;
import v9t9.common.sound.TMS9919Consts;
import ejs.base.internal.sound.SoundOutput;
import ejs.base.sound.ISoundEmitter;
import ejs.base.sound.ISoundOutput;
import ejs.base.sound.ISoundVoice;
import ejs.base.sound.SoundFactory;
import ejs.base.sound.SoundFormat;

/**
 * @author ejs
 *
 */
public class BaseSoundTest {

	private static ISoundEmitter soundListener;
	protected static ISoundOutput soundOutput;
	protected static SoundFormat format = new SoundFormat(55930, 
			2, 
			SoundFormat.Type.SIGNED_16_LE);

	@BeforeClass
	public static void setup() {
		soundListener = SoundFactory.createAudioListener();
		soundListener.started(format);
		soundListener.setBlockMode(true);
		
		soundOutput = new SoundOutput(format, 100);
		soundOutput.addEmitter(soundListener);
	}

	@Before
	public void setupPer() {
		soundListener.started(format);
	}
	@After
	public void tearDown() {
		soundListener.waitUntilSilent();
		soundListener.stopped();
	}

	@AfterClass
	public static void tearDownClass() {
		soundOutput.dispose();
	}

	/**
	 * 
	 */
	public BaseSoundTest() {
		super();
	}

	/**
	 * @param samples
	 * @param toneVoice
	 */
	protected void generate(int samples, ISoundVoice... voices) {
		soundOutput.generate(voices, samples);
		soundOutput.flushAudio(voices, 0);
	}

	protected int toSamples(TimeUnit unit, int i) {
		long ms = TimeUnit.MILLISECONDS.convert(i, unit);
		return (int) (ms * format.getFrameRate() / 1000); 
	}


	/**
	 * @param toneVoice
	 */
	protected void setupVoice(ClockedSoundVoice toneVoice) {
		toneVoice.setFormat(format);
		toneVoice.setReferenceClock(TMS9919Consts.CHIP_CLOCK);
		toneVoice.setVolume(192);
	}
}