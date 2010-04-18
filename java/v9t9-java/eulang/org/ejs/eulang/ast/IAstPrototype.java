/**
 * 
 */
package org.ejs.eulang.ast;

import org.ejs.eulang.types.LLCodeType;


/**
 * @author ejs
 *
 */
public interface IAstPrototype extends IAstNode {
	IAstPrototype copy(IAstNode copyParent);
	
	IAstType returnType();
	
	IAstArgDef[] argumentTypes();

	int getArgCount();
	
	boolean adaptToType(LLCodeType newType);
	boolean hasDefaultArguments();
	
	/** index of first default argument, or # of arguments if none */
	int getDefaultArgumentIndex();
	
}
