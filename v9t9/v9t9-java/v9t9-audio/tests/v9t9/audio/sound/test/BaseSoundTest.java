/**
 * 
 */
package v9t9.audio.sound.test;

import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioFormat;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import v9t9.audio.sound.ClockedSoundVoice;
import v9t9.common.sound.TMS9919Consts;

import ejs.base.internal.sound.SoundOutput;
import ejs.base.sound.ISoundEmitter;
import ejs.base.sound.ISoundOutput;
import ejs.base.sound.ISoundVoice;
import ejs.base.sound.SoundFactory;

/**
 * @author ejs
 *
 */
public class BaseSoundTest {

	private static ISoundEmitter soundListener;
	private static ISoundOutput soundOutput;
	protected static AudioFormat format = new AudioFormat(55930, 16, 2, true, false);

	@BeforeClass
	public static void setup() {
		soundListener = SoundFactory.createAudioListener();
		soundListener.started(format);
		
		soundOutput = new SoundOutput(format, 100);
		soundOutput.addEmitter(soundListener);
	}

	@AfterClass
	public static void tearDown() {
		soundOutput.dispose();
		soundListener.waitUntilSilent();
		soundListener.stopped();
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
		toneVoice.setSoundClock((int) format.getFrameRate());
		toneVoice.setReferenceClock(TMS9919Consts.CHIP_CLOCK);
		toneVoice.setVolume(192);
	}
}