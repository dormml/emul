/**
 * 
 */
package org.ejs.eulang.ast.impl;

import org.ejs.eulang.TypeEngine;
import org.ejs.eulang.ast.IAstRepeatExpr;
import org.ejs.eulang.ast.IAstTypedExpr;
import org.ejs.eulang.symbols.IScope;
import org.ejs.eulang.types.LLType;

/**
 * @author ejs
 *
 */
public class AstRepeatExpr extends AstTestBodyLoopExpr implements IAstRepeatExpr {

	/**
	 * @param doCopy
	 * @param doCopy2
	 */
	public AstRepeatExpr(IScope scope, IAstTypedExpr expr, IAstTypedExpr body) {
		super(scope, expr, body);
	}

	/* (non-Javadoc)
	 * @see org.ejs.eulang.ast.impl.AstNode#toString()
	 */
	@Override
	public String toString() {
		return typedString("REPEAT");
	}
	
	/* (non-Javadoc)
	 * @see org.ejs.eulang.ast.IAstNode#copy(org.ejs.eulang.ast.IAstNode)
	 */
	@Override
	public IAstRepeatExpr copy() {
		return (IAstRepeatExpr) fixupLoop(new AstRepeatExpr(getScope().newInstance(getCopyScope()), 
				doCopy(getExpr()), doCopy(getBody())));
	}

	/* (non-Javadoc)
	 * @see org.ejs.eulang.ast.impl.AstTestBodyLoopExpr#getExpressionType()
	 */
	@Override
	protected LLType getExpressionType(TypeEngine typeEngine) {
		return typeEngine.INT;
	}
}
