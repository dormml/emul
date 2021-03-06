/*
  Postpone.java

  (c) 2010-2014 Edward Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package v9t9.tools.forthcomp.words;

import v9t9.tools.forthcomp.AbortException;
import v9t9.tools.forthcomp.HostContext;
import v9t9.tools.forthcomp.ITargetWord;
import v9t9.tools.forthcomp.IWord;
import v9t9.tools.forthcomp.TargetContext;

/**
 * @author ejs
 *
 */
public class Postpone extends BaseStdWord {
	public Postpone() {
	}

	/* (non-Javadoc)
	 * @see v9t9.forthcomp.IWord#execute(v9t9.forthcomp.IContext)
	 */
	public void execute(HostContext hostContext, TargetContext targetContext) throws AbortException {
		String name = hostContext.readToken();

		IWord word = targetContext.find(name);
		if (word == null) {
			throw hostContext.abort("cannot find target definition of " + name);
		}
		
		if (!(word instanceof ITargetWord))
			throw hostContext.abort("cannot postpone host word " + name);
		
		ITargetWord targetWord = (ITargetWord) word;
		if (targetContext.isNativeDefinition()) {
			if (targetWord.getEntry().isImmediate()) {
				targetContext.compileCall(targetWord);
			} else {
				targetContext.compileTick(targetWord);
				targetContext.compile(targetContext.require("compile,"));
			}
		} else {
			if (targetWord.getEntry().isImmediate()) {
				targetContext.buildCall(targetWord);
			} else {
				targetContext.buildTick(targetWord);
				targetContext.buildXt(targetContext.require("compile,"));
			}
		}
		
		IWord hostWord = hostContext.find(name);
		hostContext.build(new HostPostponedWord(hostWord, targetWord));

	}
	
	/* (non-Javadoc)
	 * @see v9t9.forthcomp.IWord#isImmediate()
	 */
	public boolean isImmediate() {
		return true;
	}
}
