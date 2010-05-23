/**
 * 
 */
package org.ejs.eulang.test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.ejs.eulang.llvm.LLArgAttrType;
import org.ejs.eulang.llvm.LLAttrType;
import org.ejs.eulang.llvm.LLAttrs;
import org.ejs.eulang.llvm.LLFuncAttrs;
import org.ejs.eulang.llvm.LLModule;
import org.ejs.eulang.llvm.LLVMGenerator;
import org.ejs.eulang.llvm.LLVisibility;
import org.ejs.eulang.llvm.directives.LLBaseDirective;
import org.ejs.eulang.llvm.directives.LLDefineDirective;
import org.ejs.eulang.llvm.tms9900.AsmInstruction;
import org.ejs.eulang.llvm.tms9900.Block;
import org.ejs.eulang.llvm.tms9900.InstrSelection;
import org.ejs.eulang.llvm.tms9900.LLRenumberAndStatisticsVisitor;
import org.ejs.eulang.llvm.tms9900.Locals;
import org.ejs.eulang.llvm.tms9900.Routine;
import org.ejs.eulang.llvm.tms9900.asm.AddrOffsOperand;
import org.ejs.eulang.llvm.tms9900.asm.AsmOperand;
import org.ejs.eulang.llvm.tms9900.asm.ISymbolOperand;
import org.ejs.eulang.llvm.tms9900.asm.RegTempOperand;
import org.ejs.eulang.symbols.ISymbol;
import org.ejs.eulang.symbols.LocalScope;
import org.ejs.eulang.types.BasicType;
import org.ejs.eulang.types.LLCodeType;
import org.ejs.eulang.types.LLType;

import v9t9.engine.cpu.InstructionTable;
import v9t9.tools.asm.assembler.operand.hl.AddrOperand;
import v9t9.tools.asm.assembler.operand.hl.AssemblerOperand;
import v9t9.tools.asm.assembler.operand.hl.ConstPoolRefOperand;
import v9t9.tools.asm.assembler.operand.hl.IRegisterOperand;
import v9t9.tools.asm.assembler.operand.hl.NumberOperand;
import v9t9.tools.asm.assembler.operand.hl.RegOffsOperand;

/**
 * @author ejs
 *
 */
public class BaseInstrTest extends BaseTest {

	protected boolean dumpIsel;
	
	protected Locals locals;
	protected ArrayList<AsmInstruction> instrs;
	protected ArrayList<Block> blocks;
	protected Block currentBlock;
	protected Routine routine;

	protected Routine doIsel(String text) throws Exception {
		LLModule mod = getModule(text);
		for (LLBaseDirective dir : mod.getDirectives()) {
			if (dir instanceof LLDefineDirective) {
				LLDefineDirective def = (LLDefineDirective) dir;
				
				return doIsel(mod, def);
			}
		}
		fail("no code generated:\n" + mod);
		return null;
	}

	protected Routine doIsel(LLModule mod, LLDefineDirective def) {
		def.accept(new LLRenumberAndStatisticsVisitor());

		instrs = new ArrayList<AsmInstruction>();
		blocks = new ArrayList<Block>();
		currentBlock = null; 
		routine = null;
		
		InstrSelection isel = new InstrSelection(mod) {
			
			{
				if (dumpIsel)
					DUMP = true;
				
			}
			/* (non-Javadoc)
			 * @see org.ejs.eulang.llvm.tms9900.InstrSelection#newRoutine(org.ejs.eulang.llvm.tms9900.Routine)
			 */
			@Override
			protected void newRoutine(Routine routine) {
				instrs.clear();
				blocks.clear();
				currentBlock = null;
				BaseInstrTest.this.routine = routine;
				BaseInstrTest.this.locals = routine.getLocals();
				if (dumpIsel) {
					locals.DUMP = true;
				}
			}
			
			@Override
			protected void emit(AsmInstruction instr) {
				if (dumpIsel) {
					System.out.println();
					System.out.println("\t"+ instr);
				}
				instrs.add(instr);
				currentBlock.addInst(instr);
			}
			
			/* (non-Javadoc)
			 * @see org.ejs.eulang.llvm.tms9900.InstrSelection#newBlock(org.ejs.eulang.llvm.tms9900.Block)
			 */
			@Override
			protected void newBlock(Block block) {
				if (dumpIsel)
					System.out.println(block.getLabel() + ":");
				currentBlock = block;
				blocks.add(block);
			}
		};
		
		def.accept(isel);
		
		for (AsmInstruction instr : instrs) {
			validateInstr(instr);
		}
		
		return routine; 
	}
	
	/**
	 * @param instr
	 */
	private void validateInstr(AsmInstruction instr) {
		assertNotNull(instr);
		for (AssemblerOperand op : instr.getOps()) {
			assertNotNull(op);
			if (op instanceof AsmOperand)
				assertNotNull(instr+":"+op+"", ((AsmOperand) op).getType() != null);
		}
		for (ISymbol sym : instr.getSources()) {
			assertNotNull(sym);
			assertNotNull(instr+":"+sym, sym.getType());
			if (sym.getScope() instanceof LocalScope)
				assertTrue(sym+"", locals.getRegLocals().containsKey(sym) || locals.getStackLocals().containsKey(sym)
						|| sym.getType().getBasicType() == BasicType.LABEL);
		}
		for (ISymbol sym : instr.getTargets()) {
			assertNotNull(sym);
			assertNotNull(instr+":"+sym, sym.getType());
			if (sym.getScope() instanceof LocalScope)
				assertTrue(sym+"", locals.getRegLocals().containsKey(sym) || locals.getStackLocals().containsKey(sym)
						|| sym.getType().getBasicType() == BasicType.LABEL);
		}
	}

	@SuppressWarnings("unchecked")
	protected void matchInstr(AsmInstruction instr, String name, Object... stuff) {
		assertEquals(instr+"", name.toLowerCase(), InstructionTable.getInstName(instr.getInst()).toLowerCase());
		int opidx = 1;
		for( int i = 0; i < stuff.length; ) {
			AssemblerOperand op = instr.getOp(opidx++);
			if (stuff[i] instanceof Class) {
				assertTrue(instr+":"+i, ((Class)stuff[i]).isInstance(op));
				i++;
				if (i >= stuff.length)
					break;
				if (stuff[i] instanceof String) {
					String string = (String) stuff[i];
					AssemblerOperand testOp = op;
					i++;
					if (op instanceof AddrOperand)
						testOp = ((AddrOperand) op).getAddr();
					if (op instanceof IRegisterOperand && op.isMemory())
						testOp = ((IRegisterOperand) op).getReg();
					
					boolean eq = true;
					if (string.startsWith("~")) {
						string = string.substring(1);
						eq = false;
					}
					
					ISymbol sym = getOperandSymbol(testOp);
					if (sym != null) {
						if (eq)
							assertSameSymbol(instr, sym, string);
						else
							assertNotSameSymbol(instr, sym, string);
					} else {
						if (eq)
							assertEquals(instr+":"+op, string, op.toString());
						else
							if (string.equals(testOp.toString()))
								fail(instr+":"+testOp);
					}
						
				}
				else if (stuff[i] instanceof Integer) {
					Integer num = (Integer) stuff[i];
					i++;
					if (op instanceof IRegisterOperand) {
						assertTrue(instr+":"+op+" #", ((IRegisterOperand) op).isReg(num));
					}
					else if (op instanceof RegTempOperand)
						assertEquals(instr+":"+op, num, (Integer)((RegTempOperand) op).getLocal().getVr());
					else if (op instanceof NumberOperand)
						assertEquals(instr+":"+op, num, (Integer)((NumberOperand) op).getValue());
					else if (op instanceof ConstPoolRefOperand)
						assertEquals(instr+":"+op, num, (Integer)((ConstPoolRefOperand) op).getValue());
					else 
						assertEquals(instr+":"+op, num, op);
				}
				else if (stuff[i] instanceof Boolean) {
					if (op instanceof RegTempOperand)
						assertEquals(instr+":"+op, stuff[i], ((RegTempOperand) op).isHighReg());
					else
						fail("expected register temp");
					i++;
				}
				else if (stuff[i] instanceof AssemblerOperand) {
					AssemblerOperand testOp = null;
					if (op instanceof AddrOperand)
						testOp = ((AddrOperand) op).getAddr();
					else if (op instanceof AddrOffsOperand)
						testOp = ((AddrOffsOperand) op).getAddr();
					else if (op instanceof IRegisterOperand && op.isMemory())
						testOp = ((IRegisterOperand) op).getReg();
					
					if (testOp != null) {
						assertEquals(instr+":"+op+" subop", stuff[i], testOp);
						i++;
					}
				}
				if (i < stuff.length && stuff[i] instanceof Integer) {
					int num = (Integer) stuff[i++];
					if (op instanceof RegOffsOperand) {
						AssemblerOperand offs = ((RegOffsOperand) op).getAddr();
						assertTrue(instr+":"+op+" offset", offs instanceof NumberOperand && ((NumberOperand) offs).getValue() == num);
					}
					if (op instanceof AddrOffsOperand) {
						AssemblerOperand offs = ((AddrOffsOperand) op).getOffset();
						assertTrue(instr+":"+op+" offset", offs instanceof NumberOperand && ((NumberOperand) offs).getValue() == num);
					}
				}
			}
			else if (stuff[i] instanceof AssemblerOperand) {
				assertEquals(instr+":"+op, stuff[i], op);
				i++;
			}
			else
				fail("unknown handling " + stuff[i]);
		}
	}

	protected ISymbol getOperandSymbol(AssemblerOperand op) {
		if (op instanceof AddrOperand)
			op = ((AddrOperand) op).getAddr();
		if (op instanceof IRegisterOperand && op.isMemory())
			op = ((IRegisterOperand) op).getReg();
		
		if (op instanceof ISymbolOperand)
			return ((ISymbolOperand) op).getSymbol();
		return null;
	}

	protected void assertSameSymbol(AsmInstruction instr,
			ISymbol sym, String string) {
		assertTrue(instr+":"+sym, symbolMatches(sym, string)
				 );
	}

	protected void assertNotSameSymbol(AsmInstruction instr,
			ISymbol sym, String string) {
		assertFalse(instr+":"+sym, symbolMatches(sym, string)
		);
	}

	protected boolean symbolMatches(ISymbol sym, String string) {
		return sym.getUniqueName().equals(string)
				 || sym.getName().equals(string)
				 || sym.getUniqueName().startsWith("%" + string)
				 || sym.getUniqueName().startsWith("@" + string)
				 || sym.getUniqueName().startsWith(string + ".")
				 || sym.getUniqueName().contains("." + string + ".");
	}

	protected int findInstrWithSymbol(List<AsmInstruction> instrs, String string, int idx) {
		for (int i = idx + 1; i < instrs.size(); i++) {
			AsmInstruction instr = instrs.get(i);	
			for (AssemblerOperand op : instr.getOps()) {
				ISymbol sym = getOperandSymbol(op);
				if (sym != null && symbolMatches(sym, string))
					return i;
			}
		}
		return -1;
	}

	protected int findInstrWithSymbol(List<AsmInstruction> instrs, String string) {
		return findInstrWithSymbol(instrs, string, -1);
	}

	protected int findInstrWithInst(List<AsmInstruction> instrs, String string) {
		return findInstrWithInst(instrs, string, -1);
	}

	protected int findInstrWithInst(List<AsmInstruction> instrs, String string, int from) {
		for (int i = from + 1; i < instrs.size(); i++) {
			AsmInstruction instr = instrs.get(i);
			if (InstructionTable.getInstName(instr.getInst()).equalsIgnoreCase(string))
				return i;
		}
		return -1;
	}

	protected int findInstrWithLabel(String string) {
		for (Block block : blocks) 
			if (block.getLabel().getName().startsWith(string))
				return instrs.indexOf(block.getFirst());
		return -1;
	}


	/**
	 * Create a stock define directive
	 * @return
	 */
	protected LLDefineDirective createDefine(LLModule mod, String funcName,
			LLType ret, LLType[] argTypes) {

		LLCodeType codeType = typeEngine.getCodeType(ret, argTypes);
		ISymbol symbol = mod.getModuleScope().add(funcName, false);
		ISymbol modSymbol = mod.getModuleSymbol(symbol, codeType);
		
		LLVMGenerator gen = new LLVMGenerator(v9t9Target);
		LLArgAttrType[] argAttrTypes = new LLArgAttrType[argTypes.length];
		for (int i = 0; i < argAttrTypes.length; i++) {
			LLType argType = typeEngine.getRealType(argTypes[i]);
			LLAttrs attrs = null;
			argAttrTypes[i] = new LLArgAttrType("arg" + i,  attrs, argType);
		}
		LLDefineDirective define = new LLDefineDirective(gen, 
				v9t9Target, mod, 
				symbol.getScope(),
				modSymbol,
				null /*linkage*/, 
				LLVisibility.DEFAULT,
				null,
				new LLAttrType(null, ret),
				argAttrTypes,
				new LLFuncAttrs(),
				null /*section*/,
				0 /*align*/,
				null /*gc*/);
		mod.add(define);
		
		return define;
	}

}
