/**
 * 
 */
package org.ejs.v9t9.forthcomp.words;

import org.ejs.v9t9.forthcomp.AbortException;
import org.ejs.v9t9.forthcomp.HostContext;
import org.ejs.v9t9.forthcomp.ITargetWord;
import org.ejs.v9t9.forthcomp.IWord;

/**
 * @author ejs
 *
 */
public class Postpone extends BaseWord {
	public Postpone() {
	}

	/* (non-Javadoc)
	 * @see org.ejs.v9t9.forthcomp.IWord#execute(org.ejs.v9t9.forthcomp.IContext)
	 */
	public void execute(HostContext hostContext, TargetContext targetContext) throws AbortException {
		String name = hostContext.readToken();

		IWord word = targetContext.find(name);
		if (word == null) {
			throw hostContext.abort("cannot find target definition of " + name);
		}
		
		if (!(word instanceof ITargetWord))
			throw hostContext.abort("cannot postpone host word " + name);
		
		ITargetWord targetWord = (ITargetWord)word;
		if (targetWord.isImmediate()) {
			targetContext.compileCall(targetWord);
		} else {
			targetContext.compilePostpone(targetWord);
		}
		
		IWord hostWord = hostContext.find(name);
		//IWord hostWord = targetWord.getEntry().getHostBehavior();
		//if (hostWord == null)
		//	hostContext.find(name);
		
		if ((targetWord.getEntry().isTargetOnly() && hostWord != null)
				|| (!(targetWord instanceof TargetColonWord) && hostWord != null)) {
			//System.out.println(hostContext.getStream().getLocation()+": using host definition when emulating " + name);
			if (hostWord.isImmediate())
				hostContext.compile(hostWord);
			else
				hostContext.compile(new HostPostponedWord(hostWord, targetWord));
		} else if (targetWord.getEntry().getHostBehavior() != null) {
			if (targetWord.isImmediate())
				hostContext.compile(targetWord.getEntry().getHostBehavior());
			else
				hostContext.compile(new HostPostponedWord(targetWord.getEntry().getHostBehavior(), targetWord));
		} else if (targetWord instanceof TargetColonWord) {
			if (targetWord.isImmediate())
				hostContext.compile(targetWord);
			else
				hostContext.compile(new HostPostponedWord(targetWord, targetWord));
		} else {
			targetContext.markHostExecutionUnsupported();
		}
		
	}
	
	/* (non-Javadoc)
	 * @see org.ejs.v9t9.forthcomp.IWord#isImmediate()
	 */
	public boolean isImmediate() {
		return true;
	}
}
