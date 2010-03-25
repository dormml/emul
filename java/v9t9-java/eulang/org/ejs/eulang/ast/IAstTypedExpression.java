/**
 * 
 */
package org.ejs.eulang.ast;

import org.ejs.eulang.llvm.types.LLType;

import v9t9.tools.ast.expr.IAstNode;

/**
 * @author ejs
 *
 */
public interface IAstTypedExpression extends IAstNode {

	LLType getType();
	void setType(LLType type);
}
