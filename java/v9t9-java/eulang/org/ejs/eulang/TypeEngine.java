/**
 * 
 */
package org.ejs.eulang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ejs.eulang.ast.IAstArgDef;
import org.ejs.eulang.ast.IAstLitExpr;
import org.ejs.eulang.ast.IAstType;
import org.ejs.eulang.ast.impl.AstBoolLitExpr;
import org.ejs.eulang.ast.impl.AstFloatLitExpr;
import org.ejs.eulang.ast.impl.AstIntLitExpr;
import org.ejs.eulang.ast.impl.AstName;
import org.ejs.eulang.ast.impl.AstType;
import org.ejs.eulang.symbols.GlobalScope;
import org.ejs.eulang.types.LLBoolType;
import org.ejs.eulang.types.LLCodeType;
import org.ejs.eulang.types.LLFloatType;
import org.ejs.eulang.types.LLIntType;
import org.ejs.eulang.types.LLLabelType;
import org.ejs.eulang.types.LLPointerType;
import org.ejs.eulang.types.LLRefType;
import org.ejs.eulang.types.LLType;
import org.ejs.eulang.types.LLVoidType;
import org.ejs.eulang.types.LLType.BasicType;

/**
 * @author ejs
 *
 */
public class TypeEngine {
	public LLType UNSPECIFIED = null;
	private int ptrBits;
	public LLIntType INT;
	public LLIntType BYTE;
	public LLFloatType FLOAT;
	public LLFloatType DOUBLE;

	public LLIntType INT_ANY;
	public LLBoolType BOOL;
	public LLVoidType VOID;
	public LLLabelType LABEL;
	public LLType NULL;
	
	private Map<String, LLCodeType> codeTypes = new HashMap<String, LLCodeType>();
	private Set<LLType> types = new HashSet<LLType>();
	private Map<LLType, LLPointerType> ptrTypeMap = new HashMap<LLType, LLPointerType>();
	private Map<LLType, LLRefType> refTypeMap = new HashMap<LLType, LLRefType>();
	private boolean isLittleEndian;
	private int ptrAlign;
	private int stackMinAlign;
	public int getStackMinAlign() {
		return stackMinAlign;
	}

	public void setStackMinAlign(int stackMinAlign) {
		this.stackMinAlign = stackMinAlign;
	}

	private int stackAlign;
	private int structAlign;
	private int structMinAlign;
	public LLType INTPTR;
	public LLType REFPTR;
	public LLBoolType LLBOOL;
	
	/**
	 * 
	 */
	public TypeEngine() {
		isLittleEndian = false;
		setPtrBits(16);
		setPtrAlign(16);
		setStackMinAlign(16);
		setStackAlign(16);
		setStructAlign(16);
		setStructMinAlign(8);
		VOID = register(new LLVoidType(null));
		NULL = register(new LLVoidType(null));
		LABEL = register(new LLLabelType());
		BOOL = register(new LLBoolType("Bool", 1));
		LLBOOL = register(new LLBoolType(null, 1));
		BYTE = register(new LLIntType("Byte", 8));
		INT = register(new LLIntType("Int", 16));
		FLOAT = register(new LLFloatType("Float", 32, 23));
		DOUBLE = register(new LLFloatType("Double", 64, 53));
		//REFPTR = register(new LLRefType(new LLPointerType(ptrBits, VOID), ptrBits));
		REFPTR = register(new LLPointerType("RefPtr", ptrBits, 
				getRefType(BYTE)));
		
		INT_ANY = new LLIntType("Int*", 0);
	}
	
	/**
	 * Add names for globally accessible types
	 * @param globalScope
	 */
	public void populateTypes(GlobalScope globalScope) {
		globalScope.add(new AstName("Int"), new AstType(INT));
		globalScope.add(new AstName("Float"), new AstType(FLOAT));		
		globalScope.add(new AstName("Double"), new AstType(DOUBLE));		
		globalScope.add(new AstName("Void"), new AstType(VOID));		
		globalScope.add(new AstName("Bool"), new AstType(BOOL));		
		globalScope.add(new AstName("Byte"), new AstType(BYTE));		
	}


	public <T extends LLType> T register(T type) {
		types.add(type);
		return type;
	}

	/**
	 * @return the isLittleEndian
	 */
	public boolean isLittleEndian() {
		return isLittleEndian;
	}
	
	/**
	 * Get the basic type, ignoring ptrs and refs
	 */
	public LLType getBaseType(LLType a) {
		while (a != null && (a.getBasicType() == BasicType.REF || a.getBasicType() == BasicType.POINTER))
			a = a.getSubType();
		return a;
	}
	/**
	 * Get the type to which a and b should be promoted 
	 * @param a
	 * @param b
	 * @return one of the types, or <code>null</code>
	 */
	public LLType getPromotionType(LLType a, LLType b) {
		if (a.equals(b))
			return a;
		
		a = getBaseType(a);
		b = getBaseType(b);
		
		if (a == null || b == null)
			return null;
		
		if (a.getBasicType() == BasicType.INTEGRAL && b.getBasicType() == BasicType.INTEGRAL)
			return a.getBits() > b.getBits() ? a : b;
		if (a.getBasicType() == BasicType.FLOATING && b.getBasicType() == BasicType.FLOATING)
			return a.getBits() > b.getBits() ? a : b;
			
		if (a.getBasicType() == BasicType.BOOL && b.getBasicType() == BasicType.INTEGRAL)
			return b;
		if (b.getBasicType() == BasicType.BOOL && a.getBasicType() == BasicType.INTEGRAL)
			return a;
			
		if ((a.getBasicType() == BasicType.INTEGRAL || a.getBasicType() == BasicType.BOOL) 
				&& b.getBasicType() == BasicType.FLOATING) {
			return b;
		}
		if ((b.getBasicType() == BasicType.INTEGRAL || b.getBasicType() == BasicType.BOOL)
				&& a.getBasicType() == BasicType.FLOATING) {
			return a;
		}
		
		if (a.getBasicType() != BasicType.VOID && b.getBasicType() == BasicType.VOID)
			return a;
		if (b.getBasicType() != BasicType.VOID && a.getBasicType() == BasicType.VOID)
			return b;
		if (a.getBasicType() != BasicType.VOID && b.getBasicType() == BasicType.VOID)
			return null;
		if (a.getBasicType() == BasicType.GENERIC || b.getBasicType() == BasicType.GENERIC)
			return null;
		/*
		if (a.getBasicType() == BasicType.GENERIC && b.getBasicType() != BasicType.GENERIC) {
			return b;
		}
		if (b.getBasicType() == BasicType.GENERIC && a.getBasicType() != BasicType.GENERIC) {
			return a;
		}
		if (a.getBasicType() == BasicType.GENERIC && b.getBasicType() == BasicType.GENERIC) {
			return a.getName().compareTo(b.getName()) <= 0 ? a : b;
		}
		*/
		
		// ptrs, refs, voids cannot be interconverted
		
		return null;
	}

	/**
	 * Get or create a type for code using the given return type and arguments
	 * @param retandArgTypes
	 * @return LLType
	 */
	public LLCodeType getCodeType(LLType retType, LLType[] argTypes) {
		String key = getCodeTypeKey(retType, argTypes);
		LLCodeType type = codeTypes.get(key);
		if (type == null) {
			type = new LLCodeType(retType, argTypes, getPtrBits());
			codeTypes .put(key, type);
		}
		return type;
	}

	/**
	 * @param retAndArgTypes
	 * @return
	 */
	private String getCodeTypeKey(LLType retType, LLType[] retAndArgTypes) {
		StringBuilder sb = new StringBuilder();
		if (retType != null)
			sb.append(retType.toString());
		else
			sb.append("<unknown>");
		boolean first = true;
		for (LLType type : retAndArgTypes) {
			if (first) {
				sb.append('='); first = false;
			}
			else
				sb.append(',');
			if (type != null)
				sb.append(type.toString());
			else
				sb.append("<unknown>");
		}
		return sb.toString();
	}

	/**
	 * @param retType
	 * @param argumentTypes
	 * @return
	 */
	public LLType getCodeType(IAstType retType, IAstArgDef[] argumentTypes) {
		LLType[] argTypes = new LLType[argumentTypes != null ? argumentTypes.length : 0];
		for (int i = 0; i < argTypes.length; i++)
			argTypes[i] = argumentTypes[i].getType();
		return getCodeType(retType != null ? retType.getType() : null, argTypes);
	}

	/**
	 * Create a new literal node with the given value
	 * @param type
	 * @param object
	 * @return
	 */
	public IAstLitExpr createLiteralNode(LLType type, Object object) {
		switch (type.getBasicType()) {
		case INTEGRAL: {
			if (object instanceof Number) {
				long newValue = ((Number) object).longValue() << (64 - type.getBits()) >> (64 - type.getBits());
				return new AstIntLitExpr(newValue+"", type, newValue);
			} else if (object instanceof Boolean) {
				long newValue = ((Boolean) object).booleanValue() ? 1 : 0;
				return new AstIntLitExpr(newValue+"", type, newValue);
			} else {
				return null;
			}
		}
		case FLOATING: {
			if (object instanceof Number) {
				double newValue = ((Number) object).doubleValue();
				if (type.getBits() <= 32) {
					newValue = (float) newValue;
				}
				return new AstFloatLitExpr(newValue+"", type, newValue);
			} else if (object instanceof Boolean) {
				double newValue = ((Boolean) object).booleanValue() ? 1 : 0;
				return new AstFloatLitExpr(newValue+"", type, newValue);
			} else {
				return null;
			}
		}
		case BOOL: {
			if (!(object instanceof Number))
				return null;
			boolean newValue = ((Number) object).longValue() != 0;
			return new AstBoolLitExpr(newValue+"", type, newValue);
		}
		}
		return null;
	}

	public void setPtrBits(int ptrBits) {
		this.ptrBits = ptrBits;
		INTPTR = getPointerType(new LLIntType("Int", ptrBits));
	}

	public int getPtrBits() {
		return ptrBits;
	}

	public void setPtrAlign(int ptrAlign) {
		this.ptrAlign = ptrAlign;
	}

	public int getPtrAlign() {
		return ptrAlign;
	}
	public void setStructAlign(int structAlign) {
		this.structAlign = structAlign;
	}
	
	public int getStructAlign() {
		return structAlign;
	}

	/**
	 * @return
	 */
	public int getStackAlign() {
		return stackAlign;
	}
	/**
	 * @param i
	 */
	public void setStackAlign(int i) {
		stackAlign = i;
	}

	public int getStructMinAlign() {
		return structMinAlign;
	}

	public void setStructMinAlign(int structMinAlign) {
		this.structMinAlign = structMinAlign;
	}

	public LLType getPointerType(LLType type) {
		LLPointerType ptrType = ptrTypeMap.get(type);
		if (ptrType == null) {
			ptrType = new LLPointerType(ptrBits, type);
			ptrTypeMap.put(type, ptrType);
		}
		return ptrType;
	}

	public LLRefType getRefType(LLType type) {
		LLRefType refType = refTypeMap.get(type);
		if (refType == null) {
			refType = new LLRefType(type, ptrBits, INT.getBits());
			refTypeMap.put(type, refType);
		}
		return refType;
	}

	/**
	 * @return
	 */
	public Collection<LLType> getTypes() {
		List<LLType> types = new ArrayList<LLType>();
		types.addAll(this.types);
		types.addAll(ptrTypeMap.values());
		types.addAll(refTypeMap.values());
		//types.addAll(codeTypes.values());
		return types;
	}
}
