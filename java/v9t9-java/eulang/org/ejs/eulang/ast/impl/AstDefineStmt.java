/**
 * 
 */
package org.ejs.eulang.ast.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ejs.coffee.core.utils.Check;
import org.ejs.eulang.TypeEngine;
import org.ejs.eulang.ast.IAstDefineStmt;
import org.ejs.eulang.ast.IAstNode;
import org.ejs.eulang.ast.IAstNodeList;
import org.ejs.eulang.ast.IAstSymbolExpr;
import org.ejs.eulang.ast.IAstTypedExpr;
import org.ejs.eulang.symbols.IScope;
import org.ejs.eulang.symbols.ISymbol;
import org.ejs.eulang.types.LLType;
import org.ejs.eulang.types.TypeException;


/**
 * @author ejs
 *
 */
public class AstDefineStmt extends AstScope implements IAstDefineStmt {

	private IAstSymbolExpr id;
	//private IAstTypedExpr expr;
	private IAstNodeList<IAstTypedExpr> bodyList;
	//private Map<LLType, IAstTypedExpr> typedBodyMap = new HashMap<LLType, IAstTypedExpr>();
	
	private Map<Integer, List<IAstTypedExpr>> instanceIdMap = new HashMap<Integer, List<IAstTypedExpr>>();
	private Map<LLType, List<IAstTypedExpr>> instanceTypeMap = new HashMap<LLType, List<IAstTypedExpr>>();
	private boolean generic;

	public AstDefineStmt(IAstSymbolExpr name, boolean generic, IScope scope, IAstNodeList<IAstTypedExpr> bodyList) {
		super(scope);
		this.id = name;
		id.setParent(this);
		setSymbolExpr(name);
		setGeneric(generic);
		this.bodyList = reparent(this.bodyList, bodyList);
	}
	/* (non-Javadoc)
	 * @see org.ejs.eulang.ast.IAstNode#copy()
	 */
	@Override
	public IAstDefineStmt copy(IAstNode copyParent) {
		// TODO: copy expansions
		return (IAstDefineStmt) fixupScope(new AstDefineStmt(doCopy(id, copyParent), isGeneric(), 
				scope.newInstance(getCopyScope(copyParent)),
				doCopy(bodyList, copyParent)));
	}

	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((bodyList == null) ? 0 : bodyList.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (generic ? 19283 : 0);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null) return false;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AstDefineStmt other = (AstDefineStmt) obj;
		if (generic != other.generic)
			return false;
		if (bodyList == null) {
			if (other.bodyList != null)
				return false;
		} else if (!bodyList.equals(other.bodyList))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see v9t9.tools.ast.expr.impl.AstNode#toString()
	 */
	@Override
	public String toString() {
		return "DEFINE " + getSymbol();
	}
	

	/* (non-Javadoc)
	 * @see v9t9.tools.ast.expr.IAstNode#getChildren()
	 */
	@Override
	public IAstNode[] getChildren() {
		IAstNode[] kids = new IAstNode[2];
		kids[0] = id;
		kids[1] = bodyList;
		return kids;
	}
	
	/* (non-Javadoc)
	 * @see org.ejs.eulang.ast.impl.AstNode#getDumpChildren()
	 */
	@Override
	public IAstNode[] getDumpChildren() {
		Collection<IAstTypedExpr> exprs = new ArrayList<IAstTypedExpr>(bodyList.list()); 
		exprs.addAll(getConcreteInstances());
		return (IAstTypedExpr[]) exprs.toArray(new IAstTypedExpr[exprs.size()]);
	}

	/* (non-Javadoc)
	 * @see org.ejs.eulang.ast.IAstNode#replaceChild(org.ejs.eulang.ast.IAstNode, org.ejs.eulang.ast.IAstNode)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void replaceChild(IAstNode existing, IAstNode another) {
		if (getSymbolExpr() == existing) {
			setSymbolExpr((IAstSymbolExpr) another);
		}  else if (bodyList == existing) {
			this.bodyList =(IAstNodeList<IAstTypedExpr>) reparent(this.bodyList, another);
		}
		throw new IllegalArgumentException();
		
	}
	
	/* (non-Javadoc)
	 * @see org.ejs.eulang.ast.IAstDefineStmt#isGeneric()
	 */
	@Override
	public boolean isGeneric() {
		return generic;
	}
	/* (non-Javadoc)
	 * @see org.ejs.eulang.ast.IAstDefineStmt#setGeneric(boolean)
	 */
	@Override
	public void setGeneric(boolean generic) {
		this.generic = generic;
	}
	
	/* (non-Javadoc)
	 * @see org.ejs.eulang.ast.IAstAssignStmt#getExpr()
	 */
	/*
	@Override
	public IAstTypedExpr getExpr() {
		return bodyList.isEmpty() ? null : bodyList.get(0);
	}*/

	/* (non-Javadoc)
	 * @see org.ejs.eulang.ast.IAstAssignStmt#getId()
	 */
	@Override
	public IAstSymbolExpr getSymbolExpr() {
		return id;
	}

	/* (non-Javadoc)
	 * @see org.ejs.eulang.ast.IAstDefineStmt#getSymbol()
	 */
	@Override
	public ISymbol getSymbol() {
		return id.getSymbol();
	}
	
	/* (non-Javadoc)
	 * @see org.ejs.eulang.ast.IAstAssignStmt#setExpr(v9t9.tools.ast.expr.IAstExpression)
	 */
	/*
	@Override
	public void setExpr(IAstTypedExpr expr) {
		//this.expr = reparent(this.expr, expr);
		if (bodyList.isEmpty()) 
			bodyList.add(expr);
		else
			bodyList.set(0, expr);
		expr.setParent(this);
	}*/

	/* (non-Javadoc)
	 * @see org.ejs.eulang.ast.IAstAssignStmt#setId(v9t9.tools.ast.expr.IAstIdExpression)
	 */
	@Override
	public void setSymbolExpr(IAstSymbolExpr id) {
		Check.checkArg(id);
		this.id = reparent(this.id, id);
	}

	/* (non-Javadoc)
	 * @see org.ejs.eulang.ast.IAstTypedNode#inferTypeFromChildren()
	 */
	/*
	@Override
	public boolean inferTypeFromChildren(TypeEngine typeEngine) throws TypeException {
		return inferTypesFromChildren(new ITyped[] { expr, id });
	}
	*/

	/* (non-Javadoc)
	 * @see org.ejs.eulang.ast.IAstDefineStmt#expansions()
	 */
	/*
	@Override
	public Map<ISymbol, IAstTypedExpr> instances() {
		return expansions;
	}
	*/
	
	/* (non-Javadoc)
	 * @see org.ejs.eulang.ast.impl.AstNode#validateChildTypes()
	 */
	@Override
	public void validateChildTypes(TypeEngine typeEngine) throws TypeException {
		// don't worry about symbol type
	}
	/* (non-Javadoc)
	 * @see org.ejs.eulang.ast.IAstDefineStmt#bodyList()
	 */
	@Override
	public List<IAstTypedExpr> bodyList() {
		return bodyList.list();
	}
	
	
	/* (non-Javadoc)
	 * @see org.ejs.eulang.ast.IAstDefineStmt#typedBodyMap()
	 */
	//@Override
	//public Map<LLType, IAstTypedExpr> typedBodyMap() {
	//	return typedBodyMap;
	//}
	
	/* (non-Javadoc)
	 * @see org.ejs.eulang.ast.IAstDefineStmt#instanceMap()
	 */
	@Override
	public Map<LLType, List<IAstTypedExpr>> bodyToInstanceMap() {
		return Collections.unmodifiableMap(instanceTypeMap);
	}
	
	protected boolean typeMatchesExactly(LLType orig, LLType target) {
		if (orig == null)
			return false;
		if (orig.matchesExactly(target))
			return true;
		return false;
	}
	protected boolean typeMatchesCompatible(LLType orig, LLType target) {
		if (orig == null || target == null)
			return false;
		return orig.isMoreComplete(target);
	}
	protected boolean typeMatchesGeneric(LLType orig, LLType target) {
		if (orig == null || target == null)
			return true;
		return orig.isMoreComplete(target);
	}
	
	/* (non-Javadoc)
	 * @see org.ejs.eulang.ast.IAstDefineStmt#getMatchingExpr(org.ejs.eulang.types.LLType)
	 */
	@Override
	public IAstTypedExpr getMatchingBodyExpr(LLType type) {
		if (bodyList.nodeCount() == 0)
			return null;
		
		if (type == null) {
			// then the first
			if (bodyList.nodeCount() == 1)
				return bodyList.getFirst();
			else
				return null;
		}
		
		// look for exact matches
		for (IAstTypedExpr expr : bodyList.list()) {
			if (typeMatchesExactly(expr.getType(), type))
				return expr;
		}	
		
		// then compatible ones
		for (IAstTypedExpr expr : bodyList.list()) {
			if (typeMatchesCompatible(expr.getType(), type))
				return expr;
		}
		
		// then generic matches
		for (IAstTypedExpr expr : bodyList.list()) {
			if (typeMatchesGeneric(expr.getType(), type))
				return expr;
		}
		
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.ejs.eulang.ast.IAstDefineStmt#getMatchingInstance(org.ejs.eulang.types.LLType)
	 */
	@Override
	public IAstTypedExpr getMatchingInstance(LLType bodyType, LLType instanceType) {
        if (bodyType == null) {
        	return null;
        }
        if (bodyType.isComplete() && !bodyType.isGeneric()) {
        	//assert instanceType == null || bodyType.equals(instanceType);
        	return null;
        }
		List<IAstTypedExpr> list = instanceTypeMap.get(bodyType);
		if (list == null)
			return getMatchingBodyExpr(instanceType);
		
		for (IAstTypedExpr expr : list) {
			if (typeMatchesExactly(expr.getType(), instanceType))
				return expr;
		}
		/*
		for (IAstTypedExpr expr : list) {
			if (typeMatchesCompatible(expr.getType(), type))
				return expr;
		}
		for (IAstTypedExpr expr : list) {
			if (typeMatchesGeneric(expr.getType(), type))
				return expr;
		}
		*/
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.ejs.eulang.ast.IAstDefineStmt#registerInstance(org.ejs.eulang.types.LLType, org.ejs.eulang.ast.IAstTypedExpr)
	 */
	@Override
	public void registerInstance(IAstTypedExpr body, IAstTypedExpr expansion) {
		//if (type == null || !type.isGeneric()) {
		//	throw new IllegalArgumentException();
		//}

		List<IAstTypedExpr> list = instanceTypeMap.get(body.getType());
		if (list == null) {
			
			for (IAstTypedExpr xbody : bodyList.list()) {
				//if (typeMatchesExactly(xbody.getType(), body.getType())) {
					if (xbody.getType().equals(body.getType())) {
					list = new ArrayList<IAstTypedExpr>();
					//instanceIdMap.put(xbody.getId(), list);
					instanceTypeMap.put(body.getType(), list);
					break;
				}
			}
			//if (list == null)
			//	throw new IllegalArgumentException("type should match one inferred previously");
		}
		if (list == null) {
			list = instanceIdMap.get(body.getId());
			if (list == null) {
				
				//for (IAstTypedExpr body : bodyList.list()) {
				//	if (typeMatchesExactly(body.getType(), type)) {
						list = new ArrayList<IAstTypedExpr>();
						instanceIdMap.put(body.getId(), list);
						//instanceTypeMap.put(body.getType(), list);
				//		break;
				//	}
				//}
				if (list == null)
					throw new IllegalArgumentException("type should match one inferred previously");
			}
		}
		if (!list.contains(expansion)) {
			list.add(expansion);
			//expansion.setParent(this);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.ejs.eulang.ast.IAstDefineStmt#getConcreteInstances()
	 */
	@Override
	public Collection<IAstTypedExpr> getConcreteInstances() {
		Set<IAstTypedExpr> list = new HashSet<IAstTypedExpr>();
		for (IAstTypedExpr expr : bodyList.list()) {
			if (expr.getType() != null && expr.getType().isComplete() && !expr.getType().isGeneric())
				list.add(expr);
		}
		for (List<IAstTypedExpr> alist : instanceIdMap.values()) {
			list.addAll(alist);
		}
		for (List<IAstTypedExpr> alist : instanceTypeMap.values()) {
			list.addAll(alist);
		}
		return list;
	}
	
}
