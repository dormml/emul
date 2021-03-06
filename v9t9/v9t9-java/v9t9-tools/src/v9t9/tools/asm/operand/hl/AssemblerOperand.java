/*
  AssemblerOperand.java

  (c) 2008-2013 Edward Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package v9t9.tools.asm.operand.hl;

import v9t9.common.asm.IInstruction;
import v9t9.common.asm.IOperand;
import v9t9.common.asm.ResolveException;
import v9t9.tools.asm.IAssembler;
import v9t9.tools.asm.operand.ll.LLOperand;


/**
 * @author ejs
 *
 */
public interface AssemblerOperand extends IOperand {
	/** 
	 * Resolve self to an LLOperand
	 * @param inst
	 * @return new LLOperand or self
	 * @throws ResolveException if cannot resolve
	 */
	LLOperand resolve(IAssembler assembler, IInstruction inst) throws ResolveException;

	/**
	 * Is this classified as a register?
	 */
	boolean isRegister();
	
	/**
	 * Is this classified as memory?
	 */
	boolean isMemory();
	
	boolean isConst();
	
	/**
	 * Replace the src with dst and return this or a new operand.
	 * @param src
	 * @param dst
	 * @return
	 */
	AssemblerOperand replaceOperand(AssemblerOperand src, AssemblerOperand dst);
	
	AssemblerOperand[] getChildren();

	/**
	 * @param i
	 * @return
	 */
	AssemblerOperand addOffset(int i);
	
	void accept(IOperandVisitor visitor);
}
