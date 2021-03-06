/*
  ISpeechSoundVoice.java

  (c) 2011-2013 Edward Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package v9t9.common.speech;

import ejs.base.sound.ISoundVoice;

/**
 * @author ejs
 *
 */
public interface ISpeechSoundVoice extends ISoundVoice {

	/** Remember one sample; this should be updated e.g. 8000 times a second */
	void addSample(short sample);

	/**
	 * @return
	 */
	int getSampleCount();

}