/**
 * 
 */
package org.ejs.eulang.llvm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.ejs.coffee.core.utils.Pair;
import org.ejs.eulang.IBinaryOperation;
import org.ejs.eulang.IOperation;
import org.ejs.eulang.ISourceRef;
import org.ejs.eulang.ITarget;
import org.ejs.eulang.Message;
import org.ejs.eulang.TypeEngine;
import org.ejs.eulang.TypeEngine.Alignment;
import org.ejs.eulang.ast.ASTException;
import org.ejs.eulang.ast.IAstAddrOfExpr;
import org.ejs.eulang.ast.IAstAddrRefExpr;
import org.ejs.eulang.ast.IAstAllocStmt;
import org.ejs.eulang.ast.IAstAllocTupleStmt;
import org.ejs.eulang.ast.IAstArgDef;
import org.ejs.eulang.ast.IAstAssignStmt;
import org.ejs.eulang.ast.IAstAssignTupleStmt;
import org.ejs.eulang.ast.IAstBinExpr;
import org.ejs.eulang.ast.IAstBlockStmt;
import org.ejs.eulang.ast.IAstBreakStmt;
import org.ejs.eulang.ast.IAstCodeExpr;
import org.ejs.eulang.ast.IAstCondExpr;
import org.ejs.eulang.ast.IAstCondList;
import org.ejs.eulang.ast.IAstDataType;
import org.ejs.eulang.ast.IAstDefineStmt;
import org.ejs.eulang.ast.IAstDoWhileExpr;
import org.ejs.eulang.ast.IAstExprStmt;
import org.ejs.eulang.ast.IAstFieldExpr;
import org.ejs.eulang.ast.IAstFuncCallExpr;
import org.ejs.eulang.ast.IAstGotoStmt;
import org.ejs.eulang.ast.IAstIndexExpr;
import org.ejs.eulang.ast.IAstInitListExpr;
import org.ejs.eulang.ast.IAstInitNodeExpr;
import org.ejs.eulang.ast.IAstLabelStmt;
import org.ejs.eulang.ast.IAstLitExpr;
import org.ejs.eulang.ast.IAstLoopStmt;
import org.ejs.eulang.ast.IAstModule;
import org.ejs.eulang.ast.IAstNode;
import org.ejs.eulang.ast.IAstNodeList;
import org.ejs.eulang.ast.IAstRepeatExpr;
import org.ejs.eulang.ast.IAstStmt;
import org.ejs.eulang.ast.IAstStmtListExpr;
import org.ejs.eulang.ast.IAstSymbolExpr;
import org.ejs.eulang.ast.IAstTupleExpr;
import org.ejs.eulang.ast.IAstType;
import org.ejs.eulang.ast.IAstTypedExpr;
import org.ejs.eulang.ast.IAstTypedNode;
import org.ejs.eulang.ast.IAstUnaryExpr;
import org.ejs.eulang.ast.IAstDerefExpr;
import org.ejs.eulang.ast.IAstWhileExpr;
import org.ejs.eulang.ast.impl.AstTypedNode;
import org.ejs.eulang.llvm.directives.LLConstantDirective;
import org.ejs.eulang.llvm.directives.LLDefineDirective;
import org.ejs.eulang.llvm.directives.LLGlobalDirective;
import org.ejs.eulang.llvm.directives.LLTargetDataTypeDirective;
import org.ejs.eulang.llvm.directives.LLTargetTripleDirective;
import org.ejs.eulang.llvm.instrs.LLAllocaInstr;
import org.ejs.eulang.llvm.instrs.LLBinaryInstr;
import org.ejs.eulang.llvm.instrs.LLBranchInstr;
import org.ejs.eulang.llvm.instrs.LLCallInstr;
import org.ejs.eulang.llvm.instrs.LLCastInstr;
import org.ejs.eulang.llvm.instrs.LLExtractValueInstr;
import org.ejs.eulang.llvm.instrs.LLGetElementPtrInstr;
import org.ejs.eulang.llvm.instrs.LLInsertValueInstr;
import org.ejs.eulang.llvm.instrs.LLLoadInstr;
import org.ejs.eulang.llvm.instrs.LLRetInst;
import org.ejs.eulang.llvm.instrs.LLStoreInstr;
import org.ejs.eulang.llvm.instrs.LLUnaryInstr;
import org.ejs.eulang.llvm.instrs.LLUncondBranchInstr;
import org.ejs.eulang.llvm.instrs.LLCastInstr.ECast;
import org.ejs.eulang.llvm.ops.LLArrayOp;
import org.ejs.eulang.llvm.ops.LLConstOp;
import org.ejs.eulang.llvm.ops.LLOperand;
import org.ejs.eulang.llvm.ops.LLStructOp;
import org.ejs.eulang.llvm.ops.LLSymbolOp;
import org.ejs.eulang.llvm.ops.LLTempOp;
import org.ejs.eulang.llvm.ops.LLUndefOp;
import org.ejs.eulang.llvm.ops.LLVariableOp;
import org.ejs.eulang.llvm.ops.LLZeroInit;
import org.ejs.eulang.symbols.IScope;
import org.ejs.eulang.symbols.ISymbol;
import org.ejs.eulang.symbols.LocalScope;
import org.ejs.eulang.types.BaseLLField;
import org.ejs.eulang.types.BasicType;
import org.ejs.eulang.types.LLAggregateType;
import org.ejs.eulang.types.LLArrayType;
import org.ejs.eulang.types.LLCodeType;
import org.ejs.eulang.types.LLDataType;
import org.ejs.eulang.types.LLInstanceField;
import org.ejs.eulang.types.LLPointerType;
import org.ejs.eulang.types.LLStaticField;
import org.ejs.eulang.types.LLTupleType;
import org.ejs.eulang.types.LLType;
import org.ejs.eulang.types.LLVoidType;
import org.ejs.eulang.types.TypeException;

/**
 * Generate LLVM instructions
 * @author ejs
 *
 */
public class LLVMGenerator {

	private List<Message> messages;
	private final TypeEngine typeEngine;
	private final ITarget target;
	private LLModule ll;
	private ILLCodeTarget currentTarget;
	private LLVariableStorage varStorage;

	public LLVMGenerator(ITarget target) {
		this.typeEngine = target.getTypeEngine();
		this.target = target;
		
		messages = new ArrayList<Message>();
		varStorage = new LLVariableStorage();
	}
	
	private Map<String, String[]> fileText = new HashMap<String, String[]>();
	
	protected String getSource(ISourceRef ref) {
		if (ref == null || ref.getFile() == null) return "";
		
		String[] fileC = fileText.get(ref.getFile());
		if (fileC == null) {
			try {
				File file = new File(ref.getFile());
				FileInputStream fis = new FileInputStream(file);
				byte[] text = new byte[(int) file.length()];
				fis.read(text);
				String fileT = new String(text);
				fileText.put(ref.getFile(), fileT.split("\n"));
			} catch (IOException e) {
				return "";
			}
		}
		
		int offset = Math.max(1, ref.getLine());
		return fileC[offset-1].substring(ref.getColumn());
	}
	
	/**
	 * @return the messages
	 */
	public List<Message> getMessages() {
		return messages;
	}
	
	public String getUnoptimizedText() {
		return ll.toString();
	}
	
	/**
	 * @param stmt
	 */
	private void ensureTypes(IAstNode node) throws ASTException {
		if (node instanceof IAstDefineStmt) {
			//ensureTypes(((IAstDefineStmt) node).getExpr());
			return;
		} else if (node instanceof IAstSymbolExpr) {
			// don't get stuck on definition and don't recurse up
			IAstSymbolExpr symExpr = (IAstSymbolExpr) node;
			if (symExpr.getDefinition() != null) {
				IAstTypedExpr instance = symExpr.getInstance();
				if (instance == null)
					throw new ASTException(node, "could not find an instance for " + symExpr.getSymbol().getName() +"; add some type specifications");
				
				IAstNode recursionCheck = instance;
				while (recursionCheck != null) {
					if (recursionCheck == instance)
						break;
					recursionCheck = recursionCheck.getParent();
				}
				if (recursionCheck == null)
					ensureTypes(instance);
				return;
			}
		}
		if (node instanceof IAstTypedNode) {
			IAstTypedNode typed = (IAstTypedNode) node;
			if (typed.getType() == null || !typed.getType().isComplete()) {
				throw new ASTException(node, "incomplete type information; add some specifications");
			}
			ll.emitTypes(typed.getType());
		}
		for (IAstNode kid : node.getChildren()) {
			ensureTypes(kid);
		}
		
	}

	public void generate(IAstModule module) {
		for (Map.Entry<String, String> nfEnt : module.getNonFileText().entrySet())
			fileText.put(nfEnt.getKey(), nfEnt.getValue().split("\n"));
		
		this.ll = new LLModule(module.getOwnerScope());

		currentTarget = null;
		
		ll.addModuleDirective(new LLTargetDataTypeDirective(typeEngine));
		ll.addModuleDirective(new LLTargetTripleDirective(target));
		
		for (IAstStmt stmt : module.stmts().list()) {
			// TODO: rules for module scopes, exports, visibility... right now we export everything
			try {
				if (stmt instanceof IAstAllocStmt)
					generateGlobalAlloc((IAstAllocStmt)stmt);
				else if (stmt instanceof IAstDefineStmt)
					generateGlobalDefine((IAstDefineStmt)stmt);
					/* ignore */
				else
					unhandled(stmt);
			} catch (ASTException e) {
				recordError(e); 
			}
		}
		
/*
		for (LLType type : typeEngine.getTypes()) {
			if (type.getLLVMName() != null && type.isComplete() && !type.isGeneric()) {
				type = AstTypedNode.getConcreteType(typeEngine, null, type);
				ll.addExternType(type);
			}
		}*/
	}

	public void recordError(ASTException e) {
		messages.add(new Message(e.getNode().getSourceRef(), e.getMessage()));
	}

	public void unhandled(IAstNode node) throws ASTException {
		throw new ASTException(node, "unhandled generating: " + node.toString());
	}
	
	/**
	 * {@link http://www.llvm.org/docs/LangRef.html#globalvars}
	 * @param stmt
	 * @throws ASTException
	 */
	private void generateGlobalAlloc(IAstAllocStmt stmt) throws ASTException {
		ensureTypes(stmt);

		// TODO: simultaneous assignment?
		for (int i = 0; i < stmt.getSymbolExprs().nodeCount(); i++) {
			IAstSymbolExpr symbol = stmt.getSymbolExprs().list().get(i);
			IAstTypedExpr value = stmt.getExprs().list().get(stmt.getExprs().nodeCount() == 1 ? 0 : i);
			if (stmt.getType() instanceof LLCodeType)
				generateGlobalCode(symbol.getSymbol(), (IAstCodeExpr) value);
			else
				ll.add(new LLGlobalDirective(symbol.getSymbol(), LLVisibility.DEFAULT, LLLinkage.INTERNAL, stmt.getType()));
		}
	}


	/**
	 * {@link http://www.llvm.org/docs/LangRef.html#functionstructure}
	 * @param stmt
	 * @throws ASTException
	 */
	private void generateGlobalDefine(IAstDefineStmt stmt) throws ASTException {
	
		// only generate concrete instances
		for (IAstTypedExpr expr : stmt.bodyList()) {
			if (expr.getType() == null || expr.getType().isGeneric())
				continue;
		
			generateGlobalExpr(stmt, expr);
		}
		for (List<IAstTypedExpr> instanceList : stmt.bodyToInstanceMap().values()) {
			for (IAstTypedExpr instance : instanceList)
				generateGlobalExpr(stmt, instance);
		}
	}

	private void generateGlobalExpr(IAstDefineStmt stmt, IAstTypedExpr expr)
			throws ASTException {
		if (expr instanceof IAstCodeExpr) {
			generateGlobalCode(stmt.getSymbol(), (IAstCodeExpr) expr);
		} else if (expr instanceof IAstLitExpr) {
			generateGlobalConstant(stmt.getSymbol(), (IAstLitExpr) expr);
		} else if (expr instanceof IAstDataType) {
			generateGlobalData(stmt.getSymbol(), (IAstDataType) expr);
		} else {
			unhandled(stmt);
		}
	}

	/**
	 * @param symbol
	 * @param expr
	 * @throws ASTException 
	 */
	private void generateGlobalData(ISymbol symbol, IAstDataType expr) throws ASTException {
		// ignore for now, even though it may have initializers		
		ensureTypes(expr);
		
		ISymbol modSymbol = ll.getModuleSymbol(symbol, expr.getType());
		//ll.add(new LLConstantDirective(modSymbol, true, expr.getType(), new LLConstant(expr.getLiteral())));
	}

	/**
	 * @param symbol
	 * @param expr
	 * @throws ASTException 
	 */
	private void generateGlobalConstant(ISymbol symbol, IAstLitExpr expr) throws ASTException {
		ensureTypes(expr);
		
		ISymbol modSymbol = ll.getModuleSymbol(symbol, expr.getType());
		ll.add(new LLConstantDirective(modSymbol, true, expr.getType(), new LLConstant(expr.getLiteral())));
		
	}


	private LLFuncAttrs getFuncAttrType(IAstCodeExpr expr) {
		return new LLFuncAttrs();
	}

	private LLArgAttrType[] getArgAttrTypes(IAstArgDef[] argumentTypes) {
		LLArgAttrType[] attrTypes = new LLArgAttrType[argumentTypes.length];
		for (int i = 0; i < attrTypes.length; i++) {
			LLType argType = argumentTypes[i].getType();
			if (argumentTypes[i].isVar() || !isArgumentPassedByValue(argumentTypes[i].getType()))
				argType = typeEngine.getPointerType(argType);
			LLAttrs attrs = null; //new LLAttrs("noalias");
			// /*ISymbol typeSymbol =*/ ll.addExternType(argumentTypes[i].getType());
			attrTypes[i] = new LLArgAttrType(argumentTypes[i].getName(),  attrs, argType);
		}
		return attrTypes;
	}

	private LLAttrType getRetAttrType(IAstType returnType) {
		// /*ISymbol typeSymbol =*/ ll.addExternType(returnType.getType());
		return new LLAttrType(null, returnType.getType());
	}
	/**
	 * @param symbol
	 * @param expr
	 * @throws ASTException 
	 */
	private void generateGlobalCode(ISymbol symbol, IAstCodeExpr expr) throws ASTException {
		if (expr.isMacro())
			return;
		
		ensureTypes(expr);
		
		ISymbol modSymbol = ll.getModuleSymbol(symbol, expr.getType());
		
		LLDefineDirective define = new LLDefineDirective(this, target, ll, 
				expr.getScope(),
				modSymbol,
				null /*linkage*/, 
				LLVisibility.DEFAULT,
				null,
				getRetAttrType(expr.getPrototype().returnType()), //target.getLLCallingConvention(),
				getArgAttrTypes(expr.getPrototype().argumentTypes()),
				getFuncAttrType(expr),
				null /*section*/,
				0 /*align*/,
				null /*gc*/);
		ll.add(define);
		
		generateCode(define, symbol, expr);
	}

	/**
	 * @param argVal 
	 * @param ret
	 */
	private LLVariableOp makeLocalStorage(ISymbol symbol, IAstArgDef argDef, LLOperand argVal) {
		ILLVariable var = null;
		if (argDef != null) {
			if (argDef.isVar() || !isArgumentPassedByValue(symbol.getType()))
				var = new LLVarArgument(symbol, typeEngine);
		}
		if (var == null) {
			if (symbol.getType().getBasicType() == BasicType.REF) {
				var = new LLRefLocalVariable(symbol, typeEngine);
			} else {
				if (symbol.getType() instanceof LLArrayType)
					var = new LLLocalArrayVariable(symbol, typeEngine);
				else
					var = new LLLocalVariable(symbol, typeEngine);
			}
		}
		varStorage.registerVariable(symbol, var);
		
		var.allocate(currentTarget, argVal);
		return new LLVariableOp(var);
	}

	/**
	 * @param blocks
	 * @param stmts
	 * @throws ASTException 
	 */
	private void generateCode(ILLCodeTarget define, ISymbol symbol, IAstCodeExpr code) throws ASTException {
		ILLCodeTarget oldDefine = currentTarget;
		
		//IAstCodeExpr code = codeOrig.copy(null);
		
		try {
			currentTarget = define;
			
			IScope scope = code.getScope();
			define.addBlock(scope.addTemporary("entry"));
			
			// get return value
			LLType returnType = code.getPrototype().returnType().getType();
			
			// get address of each incoming argument, assuming it 
			// will be accessed only on the frame in the best case
			for (IAstArgDef argDef : code.getPrototype().argumentTypes()) {
				
				ISymbol argSymbol = argDef.getSymbolExpr().getSymbol();
				LLOperand argVal = generateSymbolExpr(argDef.getSymbolExpr());
				/*LLVariableOp argAddrOp =*/ makeLocalStorage(argSymbol, argDef, argVal);
			}
			
			LLOperand ret = generateStmtList(code.stmts());
			
			// deallocate variables
			for (ILLVariable var : varStorage.getVariablesForScope(scope)) {
				var.deallocate(currentTarget);
			}
			
			if (returnType.getBasicType() != BasicType.VOID) {
				LLOperand retVal = currentTarget.load(returnType, ret);
				currentTarget.emit(new LLRetInst(returnType, retVal));
			} else {
				currentTarget.emit(new LLRetInst(returnType));
			}
		} finally {
			currentTarget = oldDefine;
		}
		
	}

	/**
	 * @param stmts
	 * @throws ASTException 
	 */
	private LLOperand generateStmtList(IAstNodeList<IAstStmt> stmts) throws ASTException {
		LLOperand result = null;
		for (IAstStmt stmt : stmts.list()) {
			// ensure we have a block
			if (false && stmt instanceof IAstLabelStmt) {
				currentTarget.addBlock(((IAstLabelStmt) stmt).getLabel().getSymbol());
				continue;
			} else if (currentTarget.getCurrentBlock() == null) {
				currentTarget.addBlock(stmts.getOwnerScope().addTemporary("block"));
			}
			
			result = generateStmt(stmt);
			
			
			// end of block instr
			if (false && stmt instanceof IAstGotoStmt) {
				currentTarget.setCurrentBlock(null);
			}
		}	
		return result;
	}

	private LLOperand generateStmt( IAstStmt stmt) throws ASTException {
		
		LLOperand result = null;
		if (stmt instanceof IAstExprStmt)
			result = generateExprStmt((IAstExprStmt) stmt);
		else if (stmt instanceof IAstAllocStmt)
			result = generateLocalAllocStmt((IAstAllocStmt) stmt);
		else if (stmt instanceof IAstAllocTupleStmt)
			result = generateLocalAllocTupleStmt((IAstAllocTupleStmt) stmt);
		else if (stmt instanceof IAstAssignStmt)
			result = generateAssignStmt((IAstAssignStmt) stmt);
		else if (stmt instanceof IAstAssignTupleStmt)
			result = generateAssignTupleStmt((IAstAssignTupleStmt) stmt);
		else if (stmt instanceof IAstBlockStmt)
			result = generateStmtList(((IAstBlockStmt) stmt).stmts());
		else if (stmt instanceof IAstLoopStmt)
			result = generateLoopStmt((IAstLoopStmt) stmt);
		else if (stmt instanceof IAstBreakStmt)
			result = generateBreakStmt((IAstBreakStmt) stmt);
		else if (stmt instanceof IAstDefineStmt) 
			; // ignore
		else if (stmt instanceof IAstLabelStmt)
			// no val
			generateLabelStmt((IAstLabelStmt) stmt);
		else if (stmt instanceof IAstGotoStmt)
			// no val
			generateGotoStmt((IAstGotoStmt) stmt);
		else
			unhandled(stmt);
		return result;
	}

	/**
	 * @param stmt
	 * @return
	 * @throws ASTException 
	 */
	private LLOperand generateBreakStmt(IAstBreakStmt stmt) throws ASTException {
		if (loopStack.isEmpty())
			throw new ASTException(stmt, "'break' is not inside a loop");
		LoopContext context = loopStack.peek();
		
		LLOperand expr = generateTypedExpr(stmt.getExpr());
		currentTarget.store(context.value.getVariable().getSymbol().getType(), expr, context.value);
		
		currentTarget.emit(new LLUncondBranchInstr(new LLSymbolOp(context.exitLabel)));
		currentTarget.setCurrentBlock(null);
		
		return null;
	}

	static class LoopContext {
		private final ISymbol exitLabel;
		private ISymbol bodyLabel;
		private final ISymbol enterLabel;
		private final LLVariableOp value;
		private final IScope scope;

		private LLVariableOp inductor;
		
		LoopContext(IScope scope, ISymbol bodyLabel, ISymbol enterLabel, ISymbol exitLabel, LLVariableOp loopVal) {
			this.scope = scope;
			this.bodyLabel = bodyLabel;
			this.enterLabel = enterLabel;
			this.exitLabel = exitLabel;
			this.value = loopVal;
		}
	}
	
	private Stack<LoopContext> loopStack = new Stack<LoopContext>();
	private File optimizedFile;
	private File intermediateFile;
	private String optimizedText;
	
	/**
	 * Generate a loop.  This has an implicit return value which can be set by a 'break' statement  
	 * @param stmt
	 * @return
	 * @throws ASTException 
	 */
	private LLOperand generateLoopStmt(IAstLoopStmt stmt) throws ASTException {
		
		IScope scope = stmt.getOwnerScope();
		
		ISymbol loopValSym = scope.addTemporary("loopValue");
		loopValSym.setType(stmt.getType());
		
		LLVariableOp loopVal = makeLocalStorage(loopValSym, null, generateNil(stmt));
		
		ISymbol loopEnter = scope.addTemporary("loopEnter");
		loopEnter.setType(typeEngine.LABEL);
		
		ISymbol loopBody = scope.addTemporary("loopBody");
		loopBody.setType(typeEngine.LABEL);
		
		ISymbol loopExit = scope.addTemporary("loopExit");
		loopExit.setType(typeEngine.LABEL);
		
		LoopContext context = new LoopContext(scope, loopBody, loopEnter, loopExit, loopVal);
		loopStack.push(context);

		generateLoopHeader(context, stmt);

		LLOperand loopTemp = generateTypedExpr(stmt.getBody());
		
		currentTarget.store(stmt.getType(), loopTemp, context.value);
		
		generateLoopFooter(context, stmt);
		
		loopStack.pop();
		
		return context.value;
	}

	/**
	 * Get the value of 'nil' for a type
	 * @param type
	 * @return
	 * @throws ASTException 
	 */
	private LLOperand generateNil(IAstTypedExpr expr) throws ASTException {
		LLType type = expr.getType();
		if (type.getBasicType() == BasicType.BOOL || type.getBasicType() == BasicType.INTEGRAL || type.getBasicType() == BasicType.FLOATING)
			return new LLConstOp(expr.getType(), 0);
		else
			throw new ASTException(expr, "unhandled generating nil for: " + type);
	}

	/**
	 * @param context 
	 * @param stmt
	 * @throws ASTException 
	 */
	private void generateLoopHeader(LoopContext context, IAstLoopStmt stmt) throws ASTException {
		if (stmt instanceof IAstRepeatExpr) {
			// get the count
			IAstRepeatExpr repeatExpr = (IAstRepeatExpr)stmt;
			LLOperand counterVal = generateTypedExpr(repeatExpr.getExpr());
			
			// make a var to hold it
			ISymbol counterSym = context.scope.addTemporary("counter");
			counterSym.setType(typeEngine.INT);
			
			context.inductor = makeLocalStorage(counterSym, null, counterVal);
			
			// now do the test before the body
			currentTarget.emit(new LLUncondBranchInstr(new LLSymbolOp(context.enterLabel)));
			currentTarget.addBlock(context.enterLabel);
			
			LLType indVarType = context.inductor.getVariable().getSymbol().getType();
			LLOperand current = currentTarget.load(indVarType, context.inductor);
			
			LLOperand ret = currentTarget.newTemp(typeEngine.BOOL);
			currentTarget.emit(new LLBinaryInstr("icmp eq", ret, indVarType, current, new LLConstOp(indVarType, 0)));
			currentTarget.emit(new LLBranchInstr(typeEngine.BOOL, ret, new LLSymbolOp(context.exitLabel), new LLSymbolOp(context.bodyLabel)));
			
			currentTarget.addBlock(context.bodyLabel);
			
		} else if (stmt instanceof IAstWhileExpr) {
			IAstWhileExpr whileExpr = (IAstWhileExpr)stmt;
			
			// now do the test before the body
			currentTarget.emit(new LLUncondBranchInstr(new LLSymbolOp(context.enterLabel)));
			currentTarget.addBlock(context.enterLabel);
			
			LLOperand test = generateTypedExpr(whileExpr.getExpr());
			currentTarget.emit(new LLBranchInstr(typeEngine.BOOL, test, new LLSymbolOp(context.bodyLabel), new LLSymbolOp(context.exitLabel)));
			
			currentTarget.addBlock(context.bodyLabel);
		} else if (stmt instanceof IAstDoWhileExpr) {

			// jump right in
			currentTarget.emit(new LLUncondBranchInstr(new LLSymbolOp(context.enterLabel)));
			currentTarget.addBlock(context.enterLabel);
			
			context.bodyLabel = context.enterLabel;
			
		} else {
			unhandled(stmt);
		}
	}

	/**
	 * @param context 
	 * @param stmt
	 */
	private void generateLoopFooter(LoopContext context, IAstLoopStmt stmt) throws ASTException {
		if (stmt instanceof IAstRepeatExpr) {
			// at the end of the loop, decrement the counter
			
			LLType indVarType = context.inductor.getVariable().getSymbol().getType();
			LLOperand current = currentTarget.load(indVarType, context.inductor);
			LLOperand minusOne = currentTarget.newTemp(indVarType);
			currentTarget.emit(new LLBinaryInstr(IOperation.SUB.getLLVMName(), minusOne, indVarType, current, 
					new LLConstOp(indVarType, 1)));
			currentTarget.store(indVarType, minusOne, context.inductor);

			// and jump back
			
			currentTarget.emit(new LLUncondBranchInstr(new LLSymbolOp(context.enterLabel)));
			
			currentTarget.addBlock(context.exitLabel);
		} else if (stmt instanceof IAstWhileExpr) {
			currentTarget.emit(new LLUncondBranchInstr(new LLSymbolOp(context.enterLabel)));
			
			currentTarget.addBlock(context.exitLabel);
		} else if (stmt instanceof IAstDoWhileExpr) {
			// at end of loop, test condition and jump back if true

			LLOperand test = generateTypedExpr(((IAstDoWhileExpr) stmt).getExpr());
			currentTarget.emit(new LLBranchInstr(typeEngine.BOOL, test, new LLSymbolOp(context.bodyLabel), new LLSymbolOp(context.exitLabel)));
			
			currentTarget.addBlock(context.exitLabel);
		} else {
			unhandled(stmt);
		}
		
	}

	private void generateLabelStmt(IAstLabelStmt stmt) {
		if (currentTarget.getCurrentBlock() != null) {
			currentTarget.emit(new LLUncondBranchInstr(new LLSymbolOp(stmt.getLabel().getSymbol())));
		}
		currentTarget.addBlock(stmt.getLabel().getSymbol());
	}
	private void generateGotoStmt(IAstGotoStmt stmt) throws ASTException {
		ISymbol falseBlock = null;
		if (stmt.getExpr() != null) {
			LLOperand test = generateTypedExpr(stmt.getExpr());
			falseBlock = stmt.getOwnerScope().addTemporary("gt");
			currentTarget.emit(new LLBranchInstr(stmt.getExpr().getType(), test, 
					new LLSymbolOp(stmt.getLabel().getSymbol()),
					new LLSymbolOp(falseBlock)
			));
		} else {
			currentTarget.emit(new LLUncondBranchInstr(new LLSymbolOp(stmt.getLabel().getSymbol())));
		}
		currentTarget.setCurrentBlock(null);
		if (falseBlock != null) {
			currentTarget.addBlock(falseBlock);
		}
	}

	private LLOperand generateAssignStmt(
			IAstAssignStmt stmt) throws ASTException {
		

		LLOperand[] vals = new LLOperand[stmt.getSymbolExprs().nodeCount()];
		for (int i = 0; i < stmt.getSymbolExprs().nodeCount(); i++) {
			IAstTypedExpr exprValue = stmt.getExprs().list().get(stmt.getExprs().nodeCount() == 1 ? 0 : i);
			
			LLOperand value = stmt.getExpand() || stmt.getExprs().nodeCount() > 1 || i == 0 ? generateTypedExpr(exprValue) : vals[0];
			vals[i] = value;
		}
		
		LLOperand first = null;
		for (int i = 0; i < stmt.getSymbolExprs().nodeCount(); i++) {
			IAstTypedExpr symbol = stmt.getSymbolExprs().list().get(i);
			
			LLOperand var = generateTypedExprCore(symbol);
			currentTarget.store(vals[i].getType(), vals[i], var);
			
			if (i == 0)
				first = var;
		}
		
		return first;
	}
	

	private LLOperand generateLocalAllocStmt(
			IAstAllocStmt stmt) throws ASTException {
		
		LLOperand first = null;
		
		LLOperand val = null;
		
		for (int i = 0; i < stmt.getSymbolExprs().nodeCount(); i++) {
			IAstSymbolExpr symbol = stmt.getSymbolExprs().list().get(i);
			IAstTypedExpr exprValue = stmt.getExprs() != null ? stmt.getExprs().list().get(stmt.getExprs().nodeCount() == 1 ? 0 : i) : null;

			LLVariableOp ret = makeLocalStorage(symbol.getSymbol(), null, null);
			
			if (exprValue != null) {
				LLOperand value = stmt.getExpand() || stmt.getExprs().nodeCount() > 1 || val == null ? generateTypedExpr(exprValue) : val;
				currentTarget.store(exprValue.getType(), value, ret);
				val = value;
			}
			
			if (i == 0)
				first = ret;
		}
		
		
		return first;
	}

	private LLOperand generateLocalAllocTupleStmt(
			IAstAllocTupleStmt stmt) throws ASTException {

		LLOperand value = generateTypedExpr(stmt.getExpr());
		
		IAstNodeList<IAstTypedExpr> syms = stmt.getSymbols().elements();
		
		for (int idx = 0; idx < syms.nodeCount(); idx++) {
			IAstTypedExpr sym = syms.list().get(idx);
			if (!(sym instanceof IAstSymbolExpr))
				throw new ASTException(sym, "can only tuple-allocate a symbol");
			
			LLOperand val = currentTarget.newTemp(sym.getType());
			currentTarget.emit(new LLExtractValueInstr(val, stmt.getType(), value, new LLConstOp(idx)));
			
			// add a cast if needed
			val = generateCast(sym, sym.getType(), val.getType(), val);
			
			makeLocalStorage(((IAstSymbolExpr) sym).getSymbol(), null, val);
		}
		return value;
	}
	

	private LLOperand generateSymbolExpr(
			IAstSymbolExpr symbolExpr) {
		ISymbol symbol = symbolExpr.getSymbol();
		LLType type = symbolExpr.getType();
		return generateSymbolAddr(symbol, type);
	}

	private LLOperand generateSymbolAddr(ISymbol symbol, LLType type) {
		// TODO: out-of-scope variables
		if (!(symbol.getScope() instanceof LocalScope))
			symbol = ll.getModuleSymbol(symbol, type);
		ILLVariable var = varStorage.lookupVariable(symbol);
		if (var != null)
			return new LLVariableOp(var);
		return new LLSymbolOp(symbol);
	}

	private LLOperand generateStmtListExpr(
			IAstStmtListExpr expr) throws ASTException {
		
		
		LLOperand result = null;
		for (IAstStmt stmt : expr.getStmtList().list()) {
			result = generateStmt(stmt);
		}
		return result;
	}
	
	private LLOperand generateExprStmt( IAstExprStmt expr) throws ASTException {
		return generateTypedExpr(expr.getExpr());
	}

	public LLOperand generateTypedExpr( IAstTypedExpr expr) throws ASTException {
		//currentTarget.emit(new LLCommentInstr(getSource(expr.getSourceRef())));
		LLOperand temp = generateTypedExprCore(expr);
		if (temp == null)
			return null;
		temp = currentTarget.load(expr.getType(), temp);
		return temp;
	}

	private LLOperand generateTypedExprAddr(IAstTypedExpr expr)
			throws ASTException {
		LLOperand op = generateTypedExprCore(expr);
		if (op instanceof LLVariableOp) {
			op = ((LLVariableOp)op).getVariable().address(currentTarget);
		} else {
			//unhandled(expr);
		}
		return op;
	}

	private LLOperand generateTypedExprCore(IAstTypedExpr expr)
			throws ASTException {
		LLOperand temp = null;
		if (expr instanceof IAstExprStmt) 
			temp = generateExprStmt((IAstExprStmt) expr);
		else if (expr instanceof IAstStmtListExpr)
			temp = generateStmtListExpr((IAstStmtListExpr) expr);
		else if (expr instanceof IAstLitExpr)
			temp = generateLitExpr((IAstLitExpr) expr);
		else if (expr instanceof IAstDerefExpr)
			temp = generateDerefExpr((IAstDerefExpr) expr);
		else if (expr instanceof IAstAddrOfExpr)
			temp = generateAddrOfExpr((IAstAddrOfExpr) expr);
		else if (expr instanceof IAstAddrRefExpr)
			temp = generateAddrRefExpr((IAstAddrRefExpr) expr);
		else if (expr instanceof IAstFuncCallExpr)
			temp = generateFuncCallExpr((IAstFuncCallExpr) expr);
		else if (expr instanceof IAstSymbolExpr)
			temp = generateSymbolExpr((IAstSymbolExpr) expr);
		else if (expr instanceof IAstUnaryExpr)
			temp = generateUnaryExpr((IAstUnaryExpr) expr);
		else if (expr instanceof IAstBinExpr)
			temp = generateBinExpr((IAstBinExpr) expr);
		else if (expr instanceof IAstIndexExpr)
			temp = generateIndexExpr((IAstIndexExpr) expr);		
		else if (expr instanceof IAstFieldExpr)
			temp = generateFieldExpr((IAstFieldExpr) expr);		
		else if (expr instanceof IAstCondList)
			temp = generateCondList((IAstCondList) expr);
		else if (expr instanceof IAstTupleExpr)
			temp = generateTupleExpr((IAstTupleExpr) expr);
		else if (expr instanceof IAstAssignStmt)
			temp = generateAssignStmt((IAstAssignStmt) expr);
		else if (expr instanceof IAstInitListExpr)
			temp = generateInitListExpr((IAstInitListExpr) expr);
		else if (expr instanceof IAstBlockStmt)
			temp = generateStmtList(((IAstBlockStmt) expr).stmts());		
		else if (expr instanceof IAstBreakStmt)
			temp = generateBreakStmt((IAstBreakStmt) expr);		
		else if (expr instanceof IAstGotoStmt)
			generateGotoStmt((IAstGotoStmt) expr);
		else {
			unhandled(expr);
			return null;
		}
		return temp;
	}

	/**
	 * @param expr
	 * @return
	 * @throws ASTException 
	 */
	private LLOperand generateAddrOfExpr(IAstAddrOfExpr expr) throws ASTException {
		return generateTypedExprAddr(expr.getExpr());
	}
	private LLOperand generateAddrRefExpr(IAstAddrRefExpr expr) throws ASTException {
		return generateTypedExprAddr(expr.getExpr());
	}

	/**
	 * Only point to the address holding the desired value, so load and store can
	 * work with addresses.
	 * @param expr
	 * @return
	 * @throws ASTException 
	 */
	private LLOperand generateDerefExpr(IAstDerefExpr expr) throws ASTException {
		LLOperand source = generateTypedExprCore(expr.getExpr());
		if (source == null)
			return null;
		
		LLType valueType = AstTypedNode.getConcreteType(typeEngine, expr, source.getType());
		if (valueType.equals(expr.getType()))
			return source;
		
		if (expr.getType().getBasicType() == BasicType.VOID)
			return source;
		//LLPointerType addrType = typeEngine.getPointerType(expr.getType());
		
		while (valueType != null && !expr.getType().isCompatibleWith(valueType.getSubType())) {
			if (source.getType().getBasicType() == BasicType.REF) {
				// dereference to get the data ptr
				LLOperand addrTemp = currentTarget.newTemp(source.getType());
				currentTarget.emit(new LLGetElementPtrInstr(addrTemp, source.getType(), source,
						new LLConstOp(0), new LLConstOp(0)));
				
				// now read data ptr
				LLType valPtrType = getTypeEngine().getPointerType(source.getType().getSubType());
				LLOperand addr = currentTarget.newTemp(valPtrType);
				currentTarget.emit(new LLLoadInstr(addr, valPtrType, addrTemp));
				
				// now read value
				LLOperand value = currentTarget.newTemp(source.getType().getSubType());
				currentTarget.emit(new LLLoadInstr(value, value.getType(), addr));
				source = addr;	
			} else if (source.getType().getBasicType() == BasicType.POINTER) {
				LLOperand ret = currentTarget.newTemp(source.getType().getSubType());
				currentTarget.emit(new LLLoadInstr(ret, ret.getType(), source));
				source = ret;
			} else {
				throw new IllegalStateException();
			}
			valueType = AstTypedNode.getConcreteType(typeEngine, expr, source.getType());
		}
		
		return source;
	}

	/**
	 * Initialize data in an array or struct and return the result.

		Note LLVM favors using "physical" types that are specialized for initialization, which explicitly
		spell out where gaps between elements exist -- which are filled with zeroinitializer operands,
		and must be accounted for in the type.  The #load() code will bitcast this to the actual
		logical type.
		 
struct Silly {
int a;
char b[103];
short c;
};

struct Silly example = { .a = 0, .c = 3 }, other;

struct Silly *sillyptr() { return example.a ? &example : &other; }
int main(int argc, char **argv) {
  example.a += example.b[94];
  return sillyptr();
}

========
%0 = type { i32, [104 x i8], i16 }
%struct.Silly = type { i32, [103 x i8], i16 }

@example = internal global %0 { i32 0, [104 x i8] zeroinitializer, i16 3 }, align 32 ; <%0*> [#uses=2]
@other = internal global %struct.Silly zeroinitializer, align 32 ; <%struct.Silly*> [#uses=1]

define i32 @main(i32 %argc, i8** nocapture %argv) nounwind {
entry:
  %0 = load i32* getelementptr (%struct.Silly* bitcast (%0* @example to %struct.Silly*), i64 0, i32 0), align 32 ; <i32> [#uses=1]
  %1 = load i8* getelementptr (%struct.Silly* bitcast (%0* @example to %struct.Silly*), i64 0, i32 1, i64 94), align 2 ; <i8> [#uses=1]
  %2 = sext i8 %1 to i32                          ; <i32> [#uses=1]
  %3 = add nsw i32 %2, %0                         ; <i32> [#uses=2]
  store i32 %3, i32* getelementptr (%struct.Silly* bitcast (%0* @example to %struct.Silly*), i64 0, i32 0), align 32
  %4 = icmp eq i32 %3, 0                          ; <i1> [#uses=1]
  %5 = select i1 %4, i32 ptrtoint (%struct.Silly* @other to i32), i32 ptrtoint (%0* @example to i32) ; <i32> [#uses=1]
  ret i32 %5
}
 
	 * @param expr
	 * @return
	 */
	private LLOperand generateInitListExpr(final IAstInitListExpr expr) throws ASTException {
		
		
		boolean notAgg = !(expr.getType() instanceof LLAggregateType) && !(expr.getType() instanceof LLArrayType);
		
		if (notAgg)
			return generateTypedExpr(expr.getInitExprs().getFirst().getExpr());

		// constant init ops stored here, with zeroinits for nonconstant ones
		List<LLOperand> constOps = new ArrayList<LLOperand>();
		// non-const ops evaluated and stored here by position in constOps
		Map<Integer, LLOperand> nonConstOps = new LinkedHashMap<Integer,LLOperand>();

		ArrayList<IAstInitNodeExpr> sortedFields = new ArrayList<IAstInitNodeExpr>(expr.getInitExprs().list());
		Collections.sort(sortedFields, new Comparator<IAstInitNodeExpr>() {

			@Override
			public int compare(IAstInitNodeExpr o1, IAstInitNodeExpr o2) {
				Pair<Integer, LLType> info1;
				Pair<Integer, LLType> info2;
				try {
					info1 = o1.getInitFieldInfo(expr.getType());
					info2 = o2.getInitFieldInfo(expr.getType());
					return info1.first - info2.first;
				} catch (TypeException e) {
					// ignore here
					return 0;
				}
			}
			
		});
		
		int curOffs = 0;
		int initIdx = 0;
		
		boolean isArray = expr.getType() instanceof LLArrayType;
		boolean needAlignment = true;
		
		int fieldCount;
		if (expr.getType() instanceof LLAggregateType) {
			fieldCount = ((LLAggregateType) expr.getType()).getCount();
		} else {
			if (((LLArrayType) expr.getType()).getArrayCount() != 0)
				fieldCount = ((LLArrayType) expr.getType()).getArrayCount();
			else
				fieldCount = sortedFields.size();
		}
		
		// track the init-view types, which include explicit zeroinitializer slots
		List<LLType> initFieldTypes = new ArrayList<LLType>();
		if (isArray) {
			TypeEngine.Alignment align = typeEngine.new Alignment(TypeEngine.Target.STRUCT);
			LLType elType = expr.getType().getSubType();
			align.alignAndAdd(elType);
			if (align.sizeof() == elType.getBits())
				initFieldTypes.add(elType);
			else {
				elType = typeEngine.getArrayType(typeEngine.BYTE, align.sizeof() / 8, null);
				initFieldTypes.add(elType);
			}
			ll.emitTypes(elType);
		}
		
		Pair<Integer, LLType> initInfo = null;
		IAstInitNodeExpr initNode = null;
		int fieldIdx;

		TypeEngine.Alignment align = typeEngine.new Alignment(TypeEngine.Target.STRUCT);

		for (fieldIdx = 0; fieldIdx < fieldCount && initIdx < sortedFields.size(); fieldIdx++) {
		
			// add zero init if no init here
			if (initInfo == null) {
				initNode = sortedFields.get(initIdx);
				try {
					initInfo = initNode.getInitFieldInfo(expr.getType());
				} catch (TypeException e) {
					throw new ASTException(initNode, e.getMessage());
				}
			}
			
			if (initInfo.first == fieldIdx) {

				IAstTypedExpr initExpr = initNode.getExpr();
				LLOperand op;
				
				if (initExpr == null && initNode instanceof IAstInitListExpr) {
					op = generateInitListExpr((IAstInitListExpr) initNode);
				} else {
					op = generateTypedExpr(initExpr);
					
				}
				if (needAlignment) {
					// add zero init if we skipped anything
					int gap = align.alignmentGap(op.getType()) + (align.sizeof() - curOffs);
					addZeroInitGap(gap, constOps, initFieldTypes, isArray, align);
					curOffs = align.sizeof();
				}
				
				
				if (op.isConstant()) {
					constOps.add(op);
				} else{
					if (op.getType() instanceof LLAggregateType || op.getType() instanceof LLArrayType)
						throw new ASTException(initNode, "cannot initialize with variable aggregates");
					int idx = constOps.size();
					constOps.add(new LLZeroInit(op.getType()));
					nonConstOps.put(idx, op);
				}
				
				curOffs += op.getType().getBits();
				align.addAtOffset(op.getType());
				if (!isArray) initFieldTypes.add(initInfo.second);
				
				initInfo = null;
				initIdx++;
			} else {
				// no init for this field
				
				LLType fieldType = expr.getType() instanceof LLAggregateType 
					? ((LLAggregateType) expr.getType()).getType(fieldIdx) 
						: expr.getType().getSubType();
				
				align.alignAndAdd(fieldType);
			}
		}
		
		// add zeroinits at end
		
		for (; fieldIdx < fieldCount; fieldIdx++) {
			
			LLType fieldType = expr.getType() instanceof LLAggregateType 
				? ((LLAggregateType) expr.getType()).getType(fieldIdx) 
					: expr.getType().getSubType();

			align.alignAndAdd(fieldType);
		}
		
		if (needAlignment) {
			// fill final gap
			int gap = align.sizeof() - curOffs;
			addZeroInitGap(gap, constOps, initFieldTypes, isArray, align);
		}
		
		LLOperand initOp;
		LLType initType;
		if (isArray) {
			int size = ((LLArrayType) expr.getType()).getArrayCount();
			if (size == 0)
				size = constOps.size();
			initType = typeEngine.getArrayType(initFieldTypes.get(0), size, null);
			initOp = new LLArrayOp((LLArrayType) initType, constOps.toArray(new LLOperand[constOps.size()]));
		} else {
			ISymbol dataSym = ((LLDataType) expr.getType()).getSymbol();
			ISymbol initSym = dataSym.getScope().add(dataSym.getUniqueName() + "$init", true);
			
			initType = typeEngine.getDataType(initSym, initFieldTypes);
			initOp = new LLStructOp((LLAggregateType) initType, constOps.toArray(new LLOperand[constOps.size()]));
		}
		
		ll.emitTypes(initType);
		
		// inject non-consts
		for (Map.Entry<Integer, LLOperand> entry : nonConstOps.entrySet()) {
			LLOperand temp = currentTarget.newTemp(initType);
			currentTarget.emit(new LLInsertValueInstr(temp, initType, initOp, 
					entry.getValue().getType(), entry.getValue(), entry.getKey()));
			initOp = temp;
		}
		
		return initOp;
		
	}

	private void addZeroInitGap(int gap, List<LLOperand> initOps,
			List<LLType> initFieldTypes, boolean isArray, Alignment align) {
		if (gap > 0) {
			assert gap % 8 == 0;
			LLType fillType;
			if (isArray)
				fillType = initFieldTypes.get(0);
			else
				fillType = typeEngine.getArrayType(typeEngine.BYTE, gap / 8, 
						null);
			
			if (align != null)
				align.add(gap);

			while (gap > 0) {
				initOps.add(new LLZeroInit(fillType));
				if (!isArray) initFieldTypes.add(fillType);
				gap -= fillType.getBits();
			}
		}
	}

	private LLOperand generateIndexExpr(IAstIndexExpr expr) throws ASTException {
		LLOperand index = generateTypedExpr(expr.getIndex());
		LLOperand array = generateTypedExprAddr(expr.getExpr());
		
		// point to the array 
		LLType arrayPointerType = typeEngine.getPointerType(expr.getExpr().getType());
		// point to the element
		LLType elementType = typeEngine.getPointerType(expr.getType());
		
		LLTempOp elPtr = currentTarget.newTemp(elementType);
		currentTarget.emit(new LLGetElementPtrInstr(elPtr, 
				arrayPointerType, 
				array, 
				new LLConstOp(0),
				index));
		
		// and load value
		//LLOperand ret = currentTarget.newTemp(expr.getType());
		//currentTarget.emit(new LLLoadInstr(ret, expr.getType(), elPtr));
		return elPtr;
	}

	private LLOperand generateFieldExpr(IAstFieldExpr expr) throws ASTException {
		
		LLDataType dataType = (LLDataType) expr.getDataType();
		BaseLLField field = dataType.getField(expr.getField().getName());
		if (field == null)
			throw new ASTException(expr.getField(), "unknown field '" + expr.getField().getName() + "' in '" + dataType.getName());
		
		// point to the element 
		LLType fieldPointerType = typeEngine.getPointerType(field.getType());

		if (field instanceof LLInstanceField) {
			// dereferenced from the address of the expr
			
			LLOperand structAddr = generateTypedExprAddr(expr.getExpr());
			
			LLTempOp elPtr = currentTarget.newTemp(fieldPointerType);
			
			currentTarget.emit(new LLGetElementPtrInstr(elPtr, 
					typeEngine.getPointerType(expr.getExpr().getType()), 
					structAddr, 
					new LLConstOp(0),
					new LLConstOp(dataType.getFieldIndex(field))));
			
			// and load value
			//LLOperand ret = currentTarget.newTemp(expr.getType());
			//currentTarget.emit(new LLLoadInstr(ret, expr.getType(), elPtr));
			//return ret;
			return elPtr;
		}
		else if (field instanceof LLStaticField) {
			// find the symbol and use it directly
			ISymbol fieldSym = ((LLStaticField) field).getSymbol();
			if (fieldSym == null)
				throw new ASTException(expr.getField(), "cannot find symbol for '" + expr.getField().getName() + "' in '" + dataType.getName());
			
			LLOperand ret = generateSymbolAddr(fieldSym, fieldPointerType);
			return ret;
		} 
		else {
			unhandled(expr.getField());
			return null;
		}
	}

	/**
	 * A tuple is an unnamed type.  We just fill in all the pieces.
	 * @param tuple
	 * @return
	 * @throws ASTException
	 */
	private LLOperand generateTupleExpr(IAstTupleExpr tuple) throws ASTException {
		
		//ISymbol tupleSym = currentTarget.newTempSymbol();
		//tupleSym.setType(tuple.getType());
		//LLVariableOp ret = makeLocalStorage(tupleSym, false, null);
		
		LLOperand ret = new LLUndefOp(typeEngine.VOID);
		for (int idx = 0; idx < tuple.elements().nodeCount(); idx++) {
			IAstTypedExpr expr = tuple.elements().list().get(idx);
			LLOperand el = generateTypedExpr(expr);
			
			LLOperand tmp = currentTarget.newTemp(tuple.getType()); 
			currentTarget.emit(new LLInsertValueInstr(tmp, tuple.getType(), ret,
					expr.getType(), el, idx));
			ret = tmp;
		}
		
		return ret;
	}

	private LLOperand generateAssignTupleStmt(
			IAstAssignTupleStmt stmt) throws ASTException {

		LLOperand value = generateTypedExpr(stmt.getExpr());
		
		IAstNodeList<IAstTypedExpr> syms = stmt.getSymbols().elements();
		
		LLTupleType tupleType = (LLTupleType) stmt.getType();
		
		for (int idx = 0; idx < syms.nodeCount(); idx++) {
			IAstTypedExpr sym = syms.list().get(idx);
			
			LLOperand val = currentTarget.newTemp(tupleType.getType(idx));
			currentTarget.emit(new LLExtractValueInstr(val, stmt.getType(), value, 
					new LLConstOp(idx)));
			
			// add a cast if needed
			val = generateCast(sym, sym.getType(), val.getType(), val);
			
			LLOperand var = generateTypedExprCore(sym);
			currentTarget.store(sym.getType(), val, var);
		}
		return value;
	}
	
	private LLOperand generateCondList(IAstCondList condList) throws ASTException {
		IScope scope = condList.getOwnerScope();
		ISymbol retvalSym = scope.addTemporary("cond");
		LLOperand retval = new LLSymbolOp(retvalSym);
		currentTarget.emit(new LLAllocaInstr(retval, condList.getType()));
		
		// generate a series of tests
		LLBlock[] conds = new LLBlock[condList.getCondExprs().nodeCount()];

		ISymbol nextTest = null;
		int idx = 0;
		for (IAstCondExpr expr : condList.getCondExprs().list()) {
			ISymbol resultLabel;
			
			if (nextTest != null) {
				currentTarget.addBlock(nextTest);
			}
			if (idx + 1 < condList.getCondExprs().nodeCount()) {
				LLOperand test = generateTypedExpr(expr.getTest());
				resultLabel = scope.addTemporary("cb");
				nextTest = scope.addTemporary("ct");
				currentTarget.emit(new LLBranchInstr(
						//expr.getTest().getType(),
						typeEngine.LLBOOL,
						test, new LLSymbolOp(resultLabel), new LLSymbolOp(nextTest)));
			} else {
				// last test is always true
				resultLabel = nextTest;
			}
			
			currentTarget.addBlock(resultLabel);
			
			LLOperand result = generateTypedExpr(expr.getExpr());
			
			if (result != null)
				currentTarget.emit(new LLStoreInstr(condList.getType(), result, retval));
			conds[idx++] = currentTarget.getPreviousBlock();
		}
		
		ISymbol condSetSym = scope.addTemporary("cs");
		currentTarget.addBlock(condSetSym);
		
		for (LLBlock cond : conds) {
			// null if block branched
			if (cond != null && !cond.endsWithUncondBranch())
				cond.instrs().add(new LLUncondBranchInstr(new LLSymbolOp(condSetSym)));
		}
		
		LLOperand retTemp = currentTarget.newTemp(condList.getType());
		currentTarget.emit(new LLLoadInstr(retTemp, condList.getType(), retval));
		
		return retTemp;
	}
	
	private LLOperand generateUnaryExpr(IAstUnaryExpr expr) throws ASTException {
		LLOperand ret;
		if (expr.getOp().getLLVMName() != null) {
			LLOperand op = generateTypedExpr(expr.getExpr());
			ret = currentTarget.newTemp(expr.getType());
			currentTarget.emit(new LLUnaryInstr(expr.getOp(), ret, expr.getType(), op));
		} else {
			if (expr.getOp() == IOperation.NEG) {
				// result = sub 0, val
				LLOperand op = generateTypedExpr(expr.getExpr());
				ret = currentTarget.newTemp(expr.getType());
				currentTarget.emit(new LLBinaryInstr("sub", ret, expr.getType(), new LLConstOp(expr.getType(), 0), op));
			} else if (expr.getOp() == IOperation.PREINC || expr.getOp() == IOperation.POSTINC) {
				// get addr...
				LLOperand opAddr = generateTypedExprAddr(expr.getExpr());
				// read value
				LLOperand op = currentTarget.load(expr.getType(), opAddr);
				// increment
				LLOperand incd = currentTarget.newTemp(expr.getType()); 
				currentTarget.emit(new LLBinaryInstr("add", incd, expr.getType(), op, new LLConstOp(expr.getType(), 1)));
				// write back
				currentTarget.store(expr.getType(), incd, opAddr);
				// and yield
				ret = (expr.getOp() == IOperation.POSTINC) ? op : incd;
			} else if (expr.getOp() == IOperation.PREDEC || expr.getOp() == IOperation.POSTDEC) {
				// get addr...
				LLOperand opAddr = generateTypedExprAddr(expr.getExpr());
				// read value
				LLOperand op = currentTarget.load(expr.getType(), opAddr);
				// decrement
				LLOperand decd = currentTarget.newTemp(expr.getType()); 
				currentTarget.emit(new LLBinaryInstr("sub", decd, expr.getType(), op, new LLConstOp(expr.getType(), 1)));
				// write back
				currentTarget.store(expr.getType(), decd, opAddr);
				// and yield
				ret = expr.getOp() == IOperation.POSTDEC ? op : decd;
			} else if (expr.getOp() == IOperation.CAST) {
				LLOperand op = generateTypedExpr(expr.getExpr());
				ret = generateCast(expr, expr.getType(), expr.getExpr().getType(), op);
			} else {
				unhandled(expr);
				ret = null;
			}
		}
		return ret;
	}

	/**
	 * Cast one value (value, w/origType) to another (type).
	 * Loads and stores automatically handle memory dereferencing, so we can ignore
	 * those casts, unless they are illegal:
	 * <p>
	 * <li>casting from value to reference (should be explicit new)
	 * <li>casting from pointer (var) to reference (another explicit new)
	 * <li>casting from reference to reference (types change, should be explicit new)
	 * <li>casting from value to pointer (should not happen)
	 * <li>casting from pointer to pointer (types chane, should not happen)
	 * <p>
	 * We handle casting from reference, pointer, etc. to value by dereferencing implicitly.  
	 */
	public LLOperand generateCast(IAstNode node, LLType type, LLType origType, LLOperand value) throws ASTException {
		
		if (type.getBasicType() == BasicType.VOID)
			return null;
		
		if (origType.equals(type)) {
			// good
		} else {
			ECast cast = null;
			if ((origType.getBasicType() == BasicType.INTEGRAL || origType.getBasicType() == BasicType.BOOL) 
					&& type.getBasicType() == BasicType.INTEGRAL || type.getBasicType() == BasicType.BOOL) {
				if (origType.getBits() > type.getBits()) {
					cast = ECast.TRUNC;
				}
				else if (origType.getBits() < type.getBits()) {
					// TODO: signedness
					cast = ECast.SEXT;
				} 
				else {
					cast = ECast.BITCAST;
				}
			} 
			else if (origType.getBasicType() == BasicType.FLOATING && type.getBasicType() == BasicType.FLOATING) {
				if (origType.getBits() > type.getBits()) {
					cast = ECast.FPTRUNC;
				}
				else if (origType.getBits() < type.getBits()) {
					cast = ECast.FPEXT;
				} 
				else {
					cast = ECast.BITCAST;
				}
			}
			else if ((origType.getBasicType() == BasicType.INTEGRAL || origType.getBasicType() == BasicType.BOOL)
					&& type.getBasicType() == BasicType.FLOATING) {
				// TODO: signedness
				cast = ECast.SITOFP;
			}
			else if (origType.getBasicType() == BasicType.FLOATING
					&& (type.getBasicType() == BasicType.INTEGRAL || type.getBasicType() == BasicType.BOOL)) {
				// TODO: signedness
				cast = ECast.FPTOSI;
			}
			else if (origType.getBasicType() == BasicType.VOID) {
				// not really a cast
				type = origType;
				return value;
			} else if (origType.getBasicType() == BasicType.POINTER && type.getBasicType() == BasicType.INTEGRAL) {
				cast = ECast.PTRTOINT;
			} else if (origType.getBasicType() == BasicType.INTEGRAL && type.getBasicType() == BasicType.POINTER) {
				cast = ECast.INTTOPTR;
			} else if (origType.getBasicType() == BasicType.POINTER && type.getBasicType() == BasicType.POINTER) {
				cast = ECast.BITCAST;
			} else if (origType.getBasicType() == BasicType.CODE && type.getBasicType() == BasicType.POINTER) {
				// not really a cast:  take the address
				if (value instanceof LLSymbolOp) {
					origType = typeEngine.getPointerType(origType);
				}
				cast = ECast.BITCAST;
			/*} else if (origType.getBasicType() == BasicType.DATA && type.getBasicType() == BasicType.DATA) {
				// may be innocuous
				LLDataType origData = (LLDataType) origType;
				LLDataType data = (LLDataType) type;
				if (origData.isCompatibleWith(data)) {
					
				}*/
			} else {
				throw new ASTException(node, "cannot cast from " + origType + " to " + type);
			}
			
			LLOperand temp = currentTarget.newTemp(type);
			currentTarget.emit(new LLCastInstr(temp, cast, origType, value, type));
			
			value = temp;
		}
		
		return value;
	}

	private LLOperand generateBinExpr(IAstBinExpr expr) throws ASTException {
		IBinaryOperation oper = expr.getOp();

		return oper.generate(this, currentTarget, expr);

	}


	/**
	 * @param define
	 * @param expr
	 * @return
	 */
	private LLOperand generateFuncCallExpr(
			IAstFuncCallExpr expr) throws ASTException {
		LLOperand ret = null;
		
		//LLCodeType funcType = (LLCodeType) expr.getFunction().getType();
		
		LLType realFuncType = expr.getFunction().getType();
		LLCodeType funcType;
		
		if (realFuncType instanceof LLPointerType)
			funcType = (LLCodeType) realFuncType.getSubType();
		else
			funcType = (LLCodeType) realFuncType;
		
		LLType realRetType = funcType.getRetType();
		LLType[] realArgTypes = new LLType[funcType.getArgTypes().length];
		
		LLOperand[] ops = new LLOperand[funcType.getArgTypes().length];
		
		int idx = 0;
		for (IAstTypedExpr arg : expr.arguments().list()) {
			realArgTypes[idx] = funcType.getArgTypes()[idx];
			LLOperand argAddr = generateTypedExprAddr(arg);
			
			if (isArgumentPassedByValue(arg.getType())) {
				argAddr = currentTarget.load(arg.getType(), argAddr);
			} else {
				// point to the element 
				LLType argPointerType = typeEngine.getPointerType(funcType.getArgTypes()[idx]);
				
				/*
				LLTempOp argPtr = currentTarget.newTemp(argPointerType);
				currentTarget.emit(new LLGetElementPtrInstr(argPtr, 
						argPointerType, 
						argAddr, 
						new LLTypeIdxOp(typeEngine.getIntType(32), 0)));
				argAddr = argPtr;
				*/
				realArgTypes[idx] = argPointerType;
			}
			ops[idx++] = argAddr;
		}

		LLOperand func = generateTypedExpr(expr.getFunction());

		if (!(funcType.getRetType() instanceof LLVoidType)) {
			ret = currentTarget.newTemp(funcType.getRetType());
		}

		currentTarget.emit(new LLCallInstr(ret, expr.getType(), func, 
				typeEngine.getCodeType(realRetType, realArgTypes), ops));
		return ret;
	}

	/**
	 * @param type
	 * @return
	 */
	private boolean isArgumentPassedByValue(LLType type) {
		return (type.getBasicType().getClassMask() & LLType.TYPECLASS_MEMORY) == 0 || type.getBasicType() == BasicType.REF
			|| type.getBasicType() == BasicType.POINTER;
	}

	private LLOperand generateLitExpr( IAstLitExpr expr) throws ASTException {
		Object object = expr.getObject();
		if (object instanceof Boolean)
			return new LLConstOp(expr.getType(), Boolean.TRUE.equals(object) ? 1 : 0);
		else if (object != null)
			return new LLConstOp(expr.getType(), (Number) object);
		else
			return new LLConstOp(expr.getType(), 0);
			
	}

	/**
	 * @return
	 */
	public LLModule getModule() {
		return ll;
	}

	/**
	 * @return
	 */
	public TypeEngine getTypeEngine() {
		return typeEngine;
	}

	/**
	 * @param llfile
	 */
	public void setIntermediateFile(File llfile) {
		this.intermediateFile = llfile;
	}

	/**
	 * @return the intermediateFile
	 */
	public File getIntermediateFile() {
		return intermediateFile;
	}
	
	/**
	 * @param llOptFile
	 */
	public void setOptimizedFile(File llOptFile) {
		this.optimizedFile = llOptFile;		
	}

	/**
	 * @return the optimizedFile
	 */
	public File getOptimizedFile() {
		return optimizedFile;
	}

	/**
	 * @param optimized
	 */
	public void setOptimizedText(String optimized) {
		this.optimizedText = optimized;
	}
	/**
	 * @return the optimizedText
	 */
	public String getOptimizedText() {
		return optimizedText;
	}
}
