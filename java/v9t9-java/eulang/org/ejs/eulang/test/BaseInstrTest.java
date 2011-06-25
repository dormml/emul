/**
 * 
 */
package org.ejs.eulang.test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import org.ejs.eulang.llvm.LLLinkage;
import org.ejs.eulang.llvm.LLModule;
import org.ejs.eulang.llvm.LLVMGenerator;
import org.ejs.eulang.llvm.directives.LLBaseDirective;
import org.ejs.eulang.llvm.directives.LLConstantDirective;
import org.ejs.eulang.llvm.directives.LLDefineDirective;
import org.ejs.eulang.llvm.directives.LLGlobalDirective;
import org.ejs.eulang.llvm.tms9900.AsmInstruction;
import org.ejs.eulang.llvm.tms9900.Block;
import org.ejs.eulang.llvm.tms9900.BuildOutput;
import org.ejs.eulang.llvm.tms9900.DataBlock;
import org.ejs.eulang.llvm.tms9900.ICodeVisitor;
import org.ejs.eulang.llvm.tms9900.ILocal;
import org.ejs.eulang.llvm.tms9900.InductionVariables;
import org.ejs.eulang.llvm.tms9900.InstrSelection;
import org.ejs.eulang.llvm.tms9900.LLRenumberAndStatisticsVisitor;
import org.ejs.eulang.llvm.tms9900.PeepholeAndLocalCoalesce;
import org.ejs.eulang.llvm.tms9900.StackFrame;
import org.ejs.eulang.llvm.tms9900.LowerPseudoInstructions;
import org.ejs.eulang.llvm.tms9900.PeepholeAndLocalCoalesce9900;
import org.ejs.eulang.llvm.tms9900.RegisterLocal;
import org.ejs.eulang.llvm.tms9900.Routine;
import org.ejs.eulang.llvm.tms9900.RoutineDumper;
import org.ejs.eulang.llvm.tms9900.asm.CompositePieceOperand;
import org.ejs.eulang.llvm.tms9900.asm.AsmOperand;
import org.ejs.eulang.llvm.tms9900.asm.ISymbolOperand;
import org.ejs.eulang.llvm.tms9900.asm.RegTempOperand;
import org.ejs.eulang.llvm.tms9900.asm.TupleTempOperand;
import org.ejs.eulang.symbols.ISymbol;
import org.ejs.eulang.symbols.LocalScope;
import org.ejs.eulang.types.BasicType;
import org.ejs.eulang.types.LLArrayType;
import org.ejs.eulang.types.LLCodeType;
import org.ejs.eulang.types.LLType;
import org.junit.Before;

import v9t9.engine.cpu.InstTable9900;
import v9t9.tools.asm.assembler.IInstructionFactory;
import v9t9.tools.asm.assembler.InstructionFactory9900;
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
	
	protected StackFrame stackFrame;
	protected ArrayList<AsmInstruction> instrs;
	protected ArrayList<Block> blocks;
	protected Block currentBlock;
	protected Routine routine;

	protected IInstructionFactory instrFactory = new InstructionFactory9900();
	
	protected BuildOutput buildOutput;

	@Before
	public void setup() {
		buildOutput = new BuildOutput();
	}
	protected Routine doIsel(String text) throws Exception {
		String name = new Exception().getStackTrace()[1].getMethodName();
		LLModule mod = getModule(text);
		
		if (doOptimize) {
			File file = getTempFile("");
			String llvmText = mod.toString();
			String optText = doOptimize(llvmText, file);
			if (dumpLLVMGen)  {
				System.out.println(optText);
			}
			mod = doLLVMParse(optText);
		}
		
		LLDefineDirective def = null;
		for (LLBaseDirective dir : mod.getDirectives()) {
			if (dir instanceof LLDefineDirective) {
				def = (LLDefineDirective) dir;
				if (name != null && ((LLDefineDirective) dir).getName().getName().contains(name))
					break;
			}
		}
		if (def != null)
			return doIsel(mod, def);

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
				System.out.println("\n#### Generating " + routine.getName()+"\n");
				buildOutput.register(routine);
				
				instrs.clear();
				blocks.clear();
				currentBlock = null;
				BaseInstrTest.this.routine = routine;
				BaseInstrTest.this.stackFrame = routine.getStackFrame();
				if (dumpIsel) {
					stackFrame.DUMP = true;
				}
			}
			
			@Override
			protected void emit(AsmInstruction instr) {
				if (dumpIsel) {
					System.out.println();
					System.out.println("\t"+ instr.getAnnotatedString());
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
	protected void validateInstr(AsmInstruction instr) {
		assertNotNull(instr);
		for (AssemblerOperand op : instr.getOps()) {
			assertNotNull(op);
			if (op instanceof AsmOperand) {
				AsmOperand asmOp = (AsmOperand) op;
				//assertNotNull(instr+":"+op+"", asmOp.getType() != null);
				if (asmOp instanceof RegTempOperand) {
					RegTempOperand reg = (RegTempOperand) asmOp;
					RegisterLocal local = stackFrame.getRegLocals().get(reg.getSymbol());
					assertNotNull(reg+"", local);
					assertEquals(reg+"", reg.isRegPair(), local.isRegPair());
				}
			}
		}
		for (ISymbol sym : instr.getSources()) {
			assertNotNull(sym);
			assertNotNull(instr+":"+sym, sym.getType());
			if (sym.getScope() instanceof LocalScope)
				assertTrue(sym+"", stackFrame.getRegLocals().containsKey(sym) || stackFrame.getStackLocals().containsKey(sym)
						|| sym.getType().getBasicType() == BasicType.LABEL);
		}
		for (ISymbol sym : instr.getTargets()) {
			assertNotNull(sym);
			assertNotNull(instr+":"+sym, sym.getType());
			if (sym.getScope() instanceof LocalScope)
				assertTrue(sym+"", stackFrame.getRegLocals().containsKey(sym) || stackFrame.getStackLocals().containsKey(sym)
						|| sym.getType().getBasicType() == BasicType.LABEL);
		}
		
		// make sure operands are valid
		validateOperand(instr, 1, instr.getOp1());
		validateOperand(instr, 2, instr.getOp2());
	}

	/**
	 * @param instr
	 * @param op1
	 * @param op12
	 */
	protected void validateOperand(AsmInstruction instr, int i, AssemblerOperand op) {
		if (op == null)
			return;
		String prefix = instr+":"+op;
		assertTrue(prefix, instrFactory.supportsOp(instr.getInst(), i, op));
	}

	@SuppressWarnings("unchecked")
	protected void matchInstr(AsmInstruction instr, String name, Object... stuff) {
		assertEquals(instr+"", name.toLowerCase(), InstTable9900.getInstName(instr.getInst()).toLowerCase());
		int opidx = 1;
		for( int i = 0; i < stuff.length; ) {
			AssemblerOperand op = instr.getOp(opidx++);
			if (stuff[i] instanceof Class) {
				assertTrue("type mismatch: " + instr+":"+i+":" + stuff[i], ((Class)stuff[i]).isInstance(op));
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
							assertEquals("mismatched operand: " + instr+":"+op, string, op.toString());
						else
							if (string.equals(testOp.toString()))
								fail("expected mismatch: " + instr+":"+testOp);
					}
						
				}
				else if (stuff[i] instanceof Integer) {
					Integer num = (Integer) stuff[i];
					i++;
					if (op instanceof IRegisterOperand) {
						assertTrue("mismatched int: " + instr+":"+op+" #", ((IRegisterOperand) op).isReg(num));
					}
					else if (op instanceof RegTempOperand)
						assertEquals("mismatched vr: " + instr+":"+op, num, (Integer)((RegTempOperand) op).getLocal().getVr());
					else if (op instanceof NumberOperand)
						assertEquals("mismatched number: " + instr+":"+op, num, (Integer)((NumberOperand) op).getValue());
					else if (op instanceof ConstPoolRefOperand)
						assertEquals("mismatched const pool ref: " + instr+":"+op, num, (Integer)((ConstPoolRefOperand) op).getValue());
					else if (op instanceof CompositePieceOperand)
						assertEquals("mismatched local offset: " + instr+":"+op, num, (Integer)((NumberOperand)((CompositePieceOperand) op).getOffset()).getValue());
					else 
						assertEquals("mismatched operand: " + instr+":"+op, num, op);
				}
				else if (stuff[i] instanceof Boolean) {
					if (op instanceof RegTempOperand)
						assertEquals("mismatched low/hi flag: " + instr+":"+op, stuff[i], ((RegTempOperand) op).isHighReg());
					else
						fail("expected register temp");
					i++;
				}
				else if (stuff[i] instanceof AssemblerOperand) {
					AssemblerOperand testOp = null;
					if (op instanceof AddrOperand)
						testOp = ((AddrOperand) op).getAddr();
					else if (op instanceof CompositePieceOperand)
						testOp = ((CompositePieceOperand) op).getAddr();
					else if (op instanceof IRegisterOperand && op.isMemory())
						testOp = ((IRegisterOperand) op).getReg();
					
					if (testOp != null) {
						assertEquals("mismatched operand: " + instr+":"+op+" subop", stuff[i], testOp);
						i++;
					}
				}
				if (i < stuff.length && stuff[i] instanceof Integer) {
					int num = (Integer) stuff[i++];
					if (op instanceof RegOffsOperand) {
						AssemblerOperand offs = ((RegOffsOperand) op).getAddr();
						assertTrue("mismatched offset: " + instr+":"+op, offs instanceof NumberOperand && ((NumberOperand) offs).getValue() == num);
					}
					if (op instanceof CompositePieceOperand) {
						AssemblerOperand offs = ((CompositePieceOperand) op).getOffset();
						assertTrue("mismatched offset: " + instr+":"+op, offs instanceof NumberOperand && ((NumberOperand) offs).getValue() == num);
					}
				}
			}
			else if (stuff[i] instanceof AssemblerOperand) {
				assertEquals("mismatched operand: " + instr+":"+op, stuff[i], op);
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

	protected void assertSameSymbol(ISymbol sym, String string) {
		assertTrue(sym+"", symbolMatches(sym, string)
				 );
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
			if (InstTable9900.getInstName(instr.getInst()).equalsIgnoreCase(string))
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

		LLDefineDirective define = LLDefineDirective.create(gen, v9t9Target, mod, symbol.getScope(), modSymbol,
				typeEngine.getCodeType(ret, argTypes), null);


		mod.add(define);
		
		return define;
	}
	

	protected DataBlock doData(String text) throws Exception {
		LLModule mod = getModule(text);
		for (LLBaseDirective dir : mod.getDirectives()) {
			if (dir instanceof LLGlobalDirective) {
				LLGlobalDirective global = (LLGlobalDirective) dir;
				
				return doData(mod, global);
			}
		}
		fail("no data generated:\n" + mod);
		return null;
	}

	/**
	 * @param mod
	 * @param global
	 * @return
	 */
	protected DataBlock doData(LLModule mod, LLConstantDirective cons) {
		
		InstrSelection isel = new InstrSelection(mod) {
			
			{
				if (dumpIsel)
					DUMP = true;
				
			}
			@Override
			protected void newRoutine(Routine routine) {
			}
			@Override
			protected void emit(AsmInstruction instr) {
				
			}
			@Override
			protected void newBlock(Block block) {
				
			}
			
		};
		
		AssemblerOperand asmOp = isel.generateOperand(cons.getConstant());
		return makeDataForOperand(cons.getSymbol(), null, asmOp);
	}
	protected DataBlock doData(LLModule mod, LLGlobalDirective global) {

		InstrSelection isel = new InstrSelection(mod) {
			
			{
				if (dumpIsel)
					DUMP = true;
				
			}
			@Override
			protected void newRoutine(Routine routine) {
			}
			@Override
			protected void emit(AsmInstruction instr) {
				
			}
			@Override
			protected void newBlock(Block block) {
				
			}
			
		};
		
		AssemblerOperand asmOp = isel.generateOperand(global.getInit());
		return makeDataForOperand(global.getSymbol(), global.getLinkage(), asmOp);
	}
	private DataBlock makeDataForOperand(ISymbol symbol, LLLinkage linkage,
			AssemblerOperand asmOp) {
		assert asmOp instanceof AsmOperand;
		
		DataBlock block = null;
		
		if (linkage == LLLinkage.APPENDING) {
			// when appending, each init op adds some elements to a large array
			assert symbol.getType() instanceof LLArrayType;
			block = buildOutput.getDataBlock(symbol);
			AssemblerOperand[] current;
			if (block == null) {
				current = new AssemblerOperand[0];
				block = new DataBlock(symbol, (AsmOperand) asmOp);
				buildOutput.register(block);
				buildOutput.registerStaticInit(symbol);
			} else {
				current = ((TupleTempOperand) block.getValue()).getComponents();
			}
			AssemblerOperand[] added = ((TupleTempOperand) asmOp).getComponents();
			AssemblerOperand[] combined = new AssemblerOperand[current.length + added.length];
			System.arraycopy(current, 0, combined, 0, current.length);
			System.arraycopy(added, 0, combined, current.length, added.length);
			
			asmOp = new TupleTempOperand(typeEngine.getArrayType(symbol.getType().getSubType(), combined.length, null),
					combined);
			
		} else {
			block = new DataBlock(symbol, (AsmOperand) asmOp);
			buildOutput.register(block);
		}
		
		return block;
	}



	/**
	 * @param routine
	 * @param string
	 * @return
	 */
	protected Block getBlock(Routine routine, String string) {
		for (Block block : routine.getBlocks()) {
			if (block.getLabel().getName().equals(string))
				return block;
		}
		string += ".";
		for (Block block : routine.getBlocks()) {
			if (block.getLabel().getName().startsWith(string))
				return block;
		}
		return null;
	}
	/**
	 * @param string
	 * @return
	 */
	protected ILocal getLocal(String name) {
		for (ILocal local : stackFrame.getAllLocals()) {
			if (local.getName().getName().equals(name))
				return local;
		}
		name = "." + name + ".";
		for (ILocal local : stackFrame.getAllLocals()) {
			if (local.getName().getUniqueName().contains(name))
				return local;
		}
		return null;
	}

	/**
	 * @param stackFrame
	 */
	protected void assertNoUndefinedStackFrame(StackFrame stackFrame) {
		for (ILocal local : stackFrame.getAllLocals()) {
			if (local.getDefs().isEmpty() && local.getUses().isEmpty()) {
				fail(local+" still present");
			}
		}
		
	}
	

	protected boolean runPeepholePhase(Routine routine) {
		System.out.println("\n*** Before peepholing:\n");
		routine.accept(new RoutineDumper());
		
		PeepholeAndLocalCoalesce peepholeAndLocalCoalesce = new PeepholeAndLocalCoalesce9900(instrFactory);
		boolean anyChanges = false;
		do {
			routine.accept(peepholeAndLocalCoalesce);
			if (peepholeAndLocalCoalesce.isChanged()) {
				System.out.println("\n*** After peepholing pass:\n");
				routine.accept(new RoutineDumper());
				anyChanges = true;
				routine.setupForOptimization();
			}
		} while (peepholeAndLocalCoalesce.isChanged());
		
		if (!anyChanges)
			System.out.println("\n*** No changes");
		else {
			System.out.println("\n*** Done peepholing:\n");
			routine.accept(new RoutineDumper());
		}
		
		validateInstrsAndResync(routine);
		
		return anyChanges;
	}

	protected boolean runInductionPhase(Routine routine) {
		System.out.println("\n*** Before induction:\n");
		routine.accept(new RoutineDumper());
		
		InductionVariables inductionVariables = new InductionVariables();
		boolean anyChanges = false;
		do {
			routine.accept(inductionVariables);
			if (inductionVariables.isChanged()) {
				System.out.println("\n*** After induction pass:\n");
				routine.accept(new RoutineDumper());
				anyChanges = true;
				routine.setupForOptimization();
			}
		} while (inductionVariables.isChanged());
		
		if (!anyChanges)
			System.out.println("\n*** No changes");
		else {
			System.out.println("\n*** Done with induction:\n");
			routine.accept(new RoutineDumper());
		}
		
		validateInstrsAndResync(routine);
		
		return anyChanges;
	}

	protected void validateInstrsAndResync(Routine routine) {

		assertNoUndefinedStackFrame(routine.getStackFrame());
		
		instrs.clear();
		for (Block block : routine.getBlocks())
			instrs.addAll(block.getInstrs());
		
		for (AsmInstruction instr : instrs) {
			validateInstr(instr);
		}
		
	}
	

	/**
	 * @param local
	 */
	protected void assertLocalIsNeverKilled(ILocal local) {
    	BitSet inter = (BitSet) local.getDefs().clone();
    	inter.andNot(local.getUses());
    	assertTrue(inter.isEmpty());
	}
	
	protected boolean runLowerPseudoPhase(Routine routine) {
		System.out.println("\n*** Before lowering:\n");
		routine.accept(new RoutineDumper());
		
		LowerPseudoInstructions lower = new LowerPseudoInstructions(buildOutput);
		boolean anyChanges = false;
		do {
			try {
				routine.accept(lower);
			} catch (ICodeVisitor.Terminate e) {
				
			}
			if (lower.isChanged()) {
				System.out.println("\n*** After lowering pass:\n");
				routine.accept(new RoutineDumper());
				anyChanges = true;
				
				routine.setupForOptimization();
			}
		} while (lower.isChanged());
		

		if (!anyChanges)
			System.out.println("\n*** No changes");
		else {
			System.out.println("\n*** Done lowering:\n");
			routine.accept(new RoutineDumper());
		}
		
		validateInstrsAndResync(routine);
		return anyChanges;
		
	}
	
}
