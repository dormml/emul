/**
 * 
 */
package org.ejs.eulang.ast;

import org.ejs.eulang.IUnaryOperation;

/**
 * An expression with a single operator.
 * 
 * @author eswartz
 *
 */
public interface IAstUnaryExpr extends IAstTypedExpr {
	IAstUnaryExpr copy();
	
    public IUnaryOperation getOp();

    public void setOp(IUnaryOperation operator);

    /** Get the target of the expression */
    public IAstTypedExpr getExpr();

    /** Set the target of the expression */
    public boolean setExpr(IAstTypedExpr expr);

}
