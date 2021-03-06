/*
  TargetValue.java

  (c) 2010-2014 Edward Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package v9t9.tools.forthcomp.words;

import v9t9.tools.forthcomp.AbortException;
import v9t9.tools.forthcomp.DictEntry;
import v9t9.tools.forthcomp.HostContext;
import v9t9.tools.forthcomp.ISemantics;
import v9t9.tools.forthcomp.ITargetContext;
import v9t9.tools.forthcomp.TargetContext;

/**
 * @author ejs
 *
 */
public class TargetDefer extends TargetWord {
	private int offset;
	private int hostPc;

	/**
	 * @param addr 
	 * 
	 */
	public TargetDefer(DictEntry entry, int offset_) {
		super(entry);
		this.offset = offset_;
		
		setCompilationSemantics(new ISemantics() {
			
			public void execute(HostContext hostContext, TargetContext targetContext)
					throws AbortException {
				targetContext.buildCall(TargetDefer.this);
			}
		});
		setExecutionSemantics(new ISemantics() {
			
			public void execute(HostContext hostContext, TargetContext targetContext)
			throws AbortException {
				hostContext.pushCall(getHostPc());
				hostContext.interpret(hostContext, targetContext);
				//throw new AbortException("cannot execute");
			}
		});
	}

	/**
	 * @param value
	 */
	public void setValue(ITargetContext targetContext, int value) {
		targetContext.writeCell(getEntry().getParamAddr(), value);
	}

	/**
	 * @return
	 */
	public int getCells() {
		return offset;
	}
	
	/**
	 * @param hostPc the hostPc to set
	 */
	public void setHostPc(int hostPc) {
		this.hostPc = hostPc;
	}
	/**
	 * @return the hostPc
	 */
	public int getHostPc() {
		return hostPc;
	}
	
}
