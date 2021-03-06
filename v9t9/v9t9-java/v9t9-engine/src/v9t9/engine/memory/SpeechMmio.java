/*
  SpeechMmio.java

  (c) 2008-2014 Edward Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package v9t9.engine.memory;

import v9t9.common.hardware.ISpeechChip;
import v9t9.common.memory.IMemoryDomain;
import v9t9.engine.speech.BaseLpcDataFetcher;
import v9t9.engine.speech.SpeechTMS5220;
import ejs.base.utils.Check;

/** 
 * Speech chip
 * @author ejs
 */
public class SpeechMmio implements IConsoleMmioWriter, IConsoleMmioReader {


	private final ISpeechChip speech;
	private byte spchDirectAddrHi;
	private byte spchDirectAddrLo;
	private byte spchDirectLenHi;

	public SpeechMmio(final ISpeechChip speech) {
		Check.checkArg(speech);
		this.speech = speech;
    }

    public byte read(int addrMask) {
    	spchDirectAddrHi = 0;
    	spchDirectAddrLo = 0;
    	spchDirectLenHi = 0;
    	return speech.read();
    }
    
    /**
     * @see v9t9.common.memory.Memory.IConsoleMmioWriter#write 
     */
    public void write(int addr, byte val) {
    	spchDirectAddrHi = 0;
    	spchDirectAddrLo = 0;
    	spchDirectLenHi = 0;
        speech.write(val);
    }

	public ISpeechChip getSpeech() {
		return speech;
	}

	/**
	 * @param addr
	 * @param val
	 */
	public void writeDirect(final IMemoryDomain domain, int addr, byte val) {
		// direct equation, writing equation
		if ((addr & 3) == 0) {
			spchDirectAddrHi = val;
		} else if ((addr & 3) == 1) {
			spchDirectAddrLo = val;
		} else if ((addr & 3) == 2) {
			spchDirectLenHi = val;
		} else {
			final int caddr_ = ((spchDirectAddrHi << 8) & 0xff00) | (spchDirectAddrLo & 0xff); 
			final int len_ = ((spchDirectLenHi << 8) & 0xff00) | (val & 0xff); 
			final SpeechTMS5220 speech = (SpeechTMS5220) this.speech;
			
//			final LPCParameters params = new LPCParameters();
//			
//			// up to 13 bytes
//			params.energyParam = domain.readByte(caddr++) & 0xf;
//			if (params.energyParam != 0 && params.energyParam != 0xf) {
//				params.repeat = domain.readByte(caddr++) != 0;
//				params.pitchParam = domain.readByte(caddr++) & 0x3f;
//				if (!params.repeat) {
//					params.kParam[0] = domain.readByte(caddr++) & 0x1f;
//					params.kParam[1] = domain.readByte(caddr++) & 0x1f;
//					params.kParam[2] = domain.readByte(caddr++) & 0xf;
//					params.kParam[3] = domain.readByte(caddr++) & 0xf;
//					if (params.pitchParam != 0) {
//						params.kParam[4] = domain.readByte(caddr++) & 0xf;
//						params.kParam[5] = domain.readByte(caddr++) & 0xf;
//						params.kParam[6] = domain.readByte(caddr++) & 0xf;
//						params.kParam[7] = domain.readByte(caddr++) & 0x7;
//						params.kParam[8] = domain.readByte(caddr++) & 0x7;
//						params.kParam[9] = domain.readByte(caddr++) & 0x7;
//					}
//				}
//			}
			
			//speech.getLpcSpeech().frame(params, speech.getSamplesPerFrame());
			speech.speakUserPhrase(new BaseLpcDataFetcher() {
				int caddr = caddr_;
				int cnt = len_;
				
				@Override
				public int fetch(int bits) {
					byte byt = domain.readByte(caddr++);
					cnt--;
					int mask = ~(~0 << bits);
					return (byt & mask);
				}
				
				@Override
				public boolean isDone() {
					return cnt <= 0;
				}
			});
		}
		
	}
}
