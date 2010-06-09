/**
 * 
 */
package org.ejs.eulang.ast.impl;

import org.ejs.coffee.core.utils.Check;
import org.ejs.eulang.IUnaryOperation;
import org.ejs.eulang.TypeEngine;
import org.ejs.eulang.ast.IAstLitExpr;
import org.ejs.eulang.ast.IAstNode;
import org.ejs.eulang.ast.IAstTypedExpr;
import org.ejs.eulang.ast.IAstUnaryExpr;
import org.ejs.eulang.llvm.ops.LLConstOp;
import org.ejs.eulang.types.TypeException;

/**
 * @author eswartz
 *
 */
public class AstUnaryExpr extends AstTypedExpr implements
        IAstUnaryExpr {

    protected IAstTypedExpr expr;
    protected IUnaryOperation oper;

    /** Create a unary expression
     */
    public AstUnaryExpr(IUnaryOperation op, IAstTypedExpr operand) {
        setOp(op);
        setExpr(operand);
        dirty = false;
    }
    
    /* (non-Javadoc)
     * @see org.ejs.eulang.ast.IAstNode#copy()
     */
    @Override
    public IAstUnaryExpr copy() {
    	return fixup(this, new AstUnaryExpr(oper, doCopy(expr)));
    }
    /* (non-Javadoc)
     * @see v9t9.tools.decomp.expr.impl.AstNode#toString()
     */
    @Override
	public String toString() {
        return typedString(oper.getName());
    }
    
     /* (non-Javadoc)
     * @see v9t9.tools.decomp.expr.impl.AstNode#getChildren()
     */
    public IAstNode[] getChildren() {
        return new IAstNode[] { expr };
    }
    /* (non-Javadoc)
	 * @see org.ejs.eulang.ast.IAstNode#replaceChildren(org.ejs.eulang.ast.IAstNode[])
	 */
	@Override
	public void replaceChild(IAstNode existing, IAstNode another) {
		if (getExpr() == existing) {
			setExpr((IAstTypedExpr) another);
		} else {
			throw new IllegalArgumentException();
		}
	}
     /* (non-Javadoc)
     * @see org.ejs.eulang.ast.IAstUnaryExpr#getOp()
     */
    @Override
    public IUnaryOperation getOp() {
    	return oper;
    }

    /* (non-Javadoc)
     * @see org.ejs.eulang.ast.IAstUnaryExpr#setOp(org.ejs.eulang.ast.IOperation)
     */
    @Override
    public void setOp(IUnaryOperation op) {
    	Check.checkArg(op);
    	this.oper = op;
    }

    /* (non-Javadoc)
     * @see v9t9.tools.decomp.expr.IAstUnaryExpression#getOperand()
     */
    public IAstTypedExpr getExpr() {
        return expr;
    }

    /* (non-Javadoc)
     * @see v9t9.tools.decomp.expr.IAstUnaryExpression#setOperand(v9t9.tools.decomp.expr.IAstExpression)
     */
    public boolean setExpr(IAstTypedExpr expr) {
        org.ejs.coffee.core.utils.Check.checkArg(expr);
        if (expr != this.expr) {
	        this.expr = reparent(this.expr, expr);
	        dirty = true;
	        return true;
        }
        return false;
    }

    public boolean simplify(TypeEngine typeEngine) {
    	boolean changed = super.simplify(typeEngine);
    	if (expr instanceof IAstLitExpr) {
    		LLConstOp val = oper.evaluate(getType(), (IAstLitExpr) expr);
    		if (val != null) {
    			IAstLitExpr lit = typeEngine.createLiteralNode(val.getType(), val.getValue());
    			lit.setSourceRef(getSourceRef());
    			getParent().replaceChild(this, lit);
				return true;
    		}
    	}
        return changed;
    }
    
    /* (non-Javadoc)
     * @see v9t9.tools.decomp.expr.IAstExpression#equalValue(v9t9.tools.decomp.expr.IAstExpression)
     */
    public boolean equalValue(IAstTypedExpr expr) {
        return expr instanceof IAstUnaryExpr
        && ((IAstUnaryExpr) expr).getType().equals(getType())
        && ((IAstUnaryExpr) expr).getOp() == getOp()
        && ((IAstUnaryExpr) expr).getExpr().equalValue(getExpr())
        ;
    }
    
    /* (non-Javadoc)
     * @see org.ejs.eulang.ast.IAstTypedNode#inferTypeFromChildren(org.ejs.eulang.ast.TypeEngine)
     */
    @Override
    public boolean inferTypeFromChildren(TypeEngine typeEngine)
    		throws TypeException {
    	IUnaryOperation.OpTypes types = new IUnaryOperation.OpTypes();
    	types.expr = (expr.getType());
    	types.result = (getType());
    	oper.inferTypes(typeEngine, types);
    	boolean changed = updateType(expr, types.expr) | updateType(this, types.result);
    	
    	if (types.expr != null && types.result != null) {
			changed |= oper.transformExpr(this, typeEngine, types);
		}
    	return changed;
    }
    
	
	 /* (non-Javadoc)
    * @see org.ejs.eulang.ast.impl.AstNode#validateChildTypes()
    */
   @Override
   public void validateChildTypes(TypeEngine typeEngine) throws TypeException {
	   IUnaryOperation.OpTypes types = new IUnaryOperation.OpTypes();
		types.expr = (expr.getType());
		types.result = (getType());
		oper.validateTypes(typeEngine, types);
   }
}
