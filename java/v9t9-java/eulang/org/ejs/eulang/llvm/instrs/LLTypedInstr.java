/**
 * 
 */
package org.ejs.eulang.llvm.instrs;

import org.ejs.eulang.llvm.ops.LLOperand;
import org.ejs.eulang.types.LLType;

/**
 * An instruction with a (primary) type.  This type defines the result of the instruction, if any.
 * @author ejs
 *
 */
public abstract class LLTypedInstr extends LLBaseInstr {
	
	private LLType type;

	public LLTypedInstr(String name, LLType type, LLOperand... ops) {
		super(name, ops);
		this.type = type;
		
	}
	public LLType getType() {
		return type;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(LLType type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see org.ejs.eulang.llvm.instrs.LLBaseInstr#appendOptionString(java.lang.StringBuilder)
	 */
	@Override
	protected void appendOptionString(StringBuilder sb) {
		sb.append(type.getLLVMName()).append(' ');
	}
}
