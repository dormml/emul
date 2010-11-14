/**
 * 
 */
package org.ejs.v9t9.forthcomp.words;

import org.ejs.v9t9.forthcomp.AbortException;
import org.ejs.v9t9.forthcomp.HostContext;
import org.ejs.v9t9.forthcomp.ITargetWord;

/**
 * @author ejs
 *
 */
public class HostBehavior extends BaseStdWord {
	public HostBehavior() {
	}

	/* (non-Javadoc)
	 * @see org.ejs.v9t9.forthcomp.IWord#execute(org.ejs.v9t9.forthcomp.IContext)
	 */
	public void execute(HostContext hostContext, TargetContext targetContext) throws AbortException {
		String countStr = hostContext.readToken();
		int count;
		try {
			count = Integer.parseInt(countStr);
		} catch (NumberFormatException e) {
			throw hostContext.abort("Expected a number: " + countStr);
		}
		String rparen = hostContext.readToken();
		if (!")".equals(rparen))
			throw hostContext.abort("Expected ): " + rparen);
		
		String word = hostContext.readToken();
		((ITargetWord) targetContext.getLatest()).getEntry().setHostBehavior(
				count, hostContext.require(word));
	}
	
	/* (non-Javadoc)
	 * @see org.ejs.v9t9.forthcomp.IWord#isImmediate()
	 */
	public boolean isImmediate() {
		return false;
	}
}
