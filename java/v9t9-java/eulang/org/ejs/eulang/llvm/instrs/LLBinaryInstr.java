/**
 * 
 */
package org.ejs.eulang.llvm.instrs;

import org.ejs.eulang.llvm.ops.LLOperand;
import org.ejs.eulang.types.LLType;

/**
 * @author ejs
 *
 */
public class LLBinaryInstr extends LLAssignInstr {
	
	/**
	 * Create with ops= {ret, op1, op2}; 
	 */
	public LLBinaryInstr(String opName, LLOperand ret, LLType type, LLOperand... ops) {
		super(opName, ret, type, ops);
		if (ops.length != 2)
			throw new IllegalArgumentException();
	}
	
	/**  Return value:  llGetOperands()[0] */
	public LLOperand ret() { return (LLOperand) ops[0]; }
	/**  llGetOperands()[1] */
	public LLOperand op1() { return ops[1]; }
	/**  llGetOperands()[2] */
	public LLOperand op2() { return ops[2]; }
	
	
}
