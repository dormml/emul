/**
 * 
 */
package v9t9.forthcomp.words;

import v9t9.forthcomp.AbortException;
import v9t9.forthcomp.HostContext;

/**
 * @author ejs
 *
 */
public class HostEmit extends BaseStdWord {
	@Override
	public String toString() {
		return "EMIT";
	}

	/* (non-Javadoc)
	 * @see v9t9.forthcomp.IWord#execute(v9t9.forthcomp.HostContext, v9t9.forthcomp.TargetContext)
	 */
	public void execute(HostContext hostContext, TargetContext targetContext)
			throws AbortException {
		System.out.print((char) hostContext.popData());
	}

	/* (non-Javadoc)
	 * @see v9t9.forthcomp.IWord#isImmediate()
	 */
	public boolean isImmediate() {
		return false;
	}
}
