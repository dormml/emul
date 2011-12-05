/**
 * 
 */
package v9t9.tools.forthcomp.words;

import v9t9.tools.forthcomp.AbortException;
import v9t9.tools.forthcomp.HostContext;

/**
 * @author ejs
 *
 */
public class Host0Branch extends BaseHostBranch {

	/**
	 * 
	 */
	public Host0Branch() {
	}
	
	/**
	 * @param target
	 */
	public Host0Branch(int target) {
		this.target = target;
	}

	@Override
	public String toString() {
		return "0BRANCH " + target;
	}

	/* (non-Javadoc)
	 * @see v9t9.forthcomp.IWord#execute(v9t9.forthcomp.HostContext, v9t9.forthcomp.words.TargetContext)
	 */
	public void execute(HostContext hostContext, TargetContext targetContext)
			throws AbortException {
		if (hostContext.popData() == 0)
			hostContext.setHostPc(target);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() {
		return new Host0Branch(target);
	}
}