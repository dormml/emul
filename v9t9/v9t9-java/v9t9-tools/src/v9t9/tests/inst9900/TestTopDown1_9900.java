/*
  TestTopDown1_9900.java

  (c) 2008-2013 Edward Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package v9t9.tests.inst9900;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import ejs.base.settings.SettingProperty;

import v9t9.common.asm.BaseMachineOperand;
import v9t9.common.asm.Block;
import v9t9.common.asm.IHighLevelInstruction;
import v9t9.common.asm.IMachineOperand;
import v9t9.common.asm.InstTableCommon;
import v9t9.common.asm.LabelListOperand;
import v9t9.common.asm.Routine;
import v9t9.common.asm.RoutineOperand;
import v9t9.engine.memory.MemoryEntryInfoBuilder;
import v9t9.machine.ti99.asm.ContextSwitchRoutine;
import v9t9.machine.ti99.asm.HighLevelInstruction;
import v9t9.machine.ti99.asm.LinkedRoutine;
import v9t9.machine.ti99.cpu.Inst9900;
import v9t9.machine.ti99.cpu.MachineOperand9900;
import v9t9.tools.asm.ParseException;


public class TestTopDown1_9900 extends BaseTopDownTest9900
{
   /**
	 * 
	 */
	private static final String ROM_PATH = "994arom.bin";
	
	/* (non-Javadoc)
		 * @see v9t9.tests.inst9900.BaseTopDownTest9900#setUp()
		 */
		@Override
		protected void setUp() throws Exception {
			super.setUp();
			
			List<String> arr = new ArrayList<String>();
			arr.add("../../build/roms");
			arr.add("/usr/local/src/v9t9-data/roms");
			fileLocator.addReadOnlyPathProperty(new SettingProperty("foo", arr));
		}

	public void testDanglingBlock() throws Exception {
        // no return
        Routine routine = parseRoutine(0x100, "ENTRY", new LinkedRoutine(), new String[] {
           "li r1,100"     
        });
        
        phase.run();
        phase.dumpBlocks(System.out);
        
        
        assertTrue(routine.getSpannedBlocks().size() == 1);
        Block block = getSingleEntry(routine);
        assertNotNull(block);
        assertTrue(block.getPred().length == 0);
        assertTrue(block.getSucc().length == 0);
        assertTrue((block.getLast().getFlags() & HighLevelInstruction.fIsReturn) == 0);
        validateBlocks(routine.getSpannedBlocks());
    }

    public void testOneBlock() throws Exception {
        Routine routine = parseRoutine(0x100, "ENTRY", new LinkedRoutine(),
                new String[] {
           "li r1,100",
           "rt"
        });
        
        phase.run();
        assertTrue(routine.getSpannedBlocks().size() == 1);
        assertTrue((routine.flags & Routine.fUnknownExit) == 0);
        Block block = getSingleEntry(routine);
        assertNotNull(block);
        assertTrue(block.getPred().length == 0);
        assertTrue(block.getSucc().length == 0);
        assertTrue(block.getFirst() != block.getLast());
        assertTrue(!block.getFirst().isReturn());
        assertTrue(block.getLast().isReturn());
        validateBlocks(routine.getSpannedBlocks());
    }

    public void testThreeBlock() throws Exception {
        Routine routine = parseRoutine(0x100, "ENTRY", new LinkedRoutine(),
                new String[] {
           "li r1,100", // 100
           "jne >10A",  //104
           ///
           "li r1, 10",//106
           //
           "rt"//10A
        });
        
        phase.run();
        assertEquals(3, routine.getSpannedBlocks().size());
        assertTrue((routine.flags & Routine.fUnknownExit) == 0);
        
        Block block1 = getSingleEntry(routine);
        Block block2 = block1.getSucc()[1];
        Block block3 = block1.getSucc()[0];

        checkList(block1.getPred(), new Block[] { });
        checkList(block1.getSucc(), new Block[] { block2, block3 });

        assertTrue(block1.getFirst() != block1.getLast());
        assertTrue(!block1.getLast().isReturn());


        checkList(block2.getPred(), new Block[] { block1 });
        checkList(block2.getSucc(), new Block[] { block3 });

        assertTrue(block2.getFirst() == block2.getLast());
        assertTrue(!block2.getFirst().isReturn());
        assertTrue(!block2.getLast().isBranch());

        checkList(block3.getPred(), new Block[] { block1, block2 });
        checkList(block3.getSucc(), new Block[] {} );

        assertTrue(block3.getFirst() == block3.getLast());
        assertTrue((block3.getLast().getFlags() & HighLevelInstruction.fIsReturn + HighLevelInstruction.fIsBranch) != 0);
        validateBlocks(routine.getSpannedBlocks());

    }

    public void testOuterCall() throws Exception {
        Routine routine = parseRoutine(0x100, "ENTRY", new LinkedRoutine(),
                new String[] {
           "li r1,100", // 100
           "blwp @>2300",  
           "rt"
        });
        
        phase.run();
        phase.dumpBlocks(System.out);
        assertTrue((routine.flags & Routine.fUnknownExit) == 0);
        assertTrue(routine.getSpannedBlocks().size() == 2);
        Block block1 = getSingleEntry(routine);
        assertTrue(block1.getFirst().getInst().getInst() == Inst9900.Ili);
        assertTrue(block1.getLast().getInst().getInst() == Inst9900.Iblwp);
        Block block2 = block1.succ.get(0);
        assertTrue(block2.getFirst().getInst().getInst() == Inst9900.Ib);
        assertTrue(block2.getLast().getInst().getInst() == Inst9900.Ib);
        validateBlocks(routine.getSpannedBlocks());
    }

    public void testInnerCall() throws Exception {
    	// this forms another routine
        Routine routine = parseRoutine(0x100, "ENTRY", new ContextSwitchRoutine(0x8300),
                new String[] {
           "li r1,100", // 100
           "bl @>110", // 104
           //
           "rtwp", // 108
           //
           "nop", // 10A
           //
           "nop", // 10C
           //
           "nop", // 10E
           //
           "mov r5, 11", // 110
           "rt", // 114
           
        });
        
        phase.run();
        phase.dumpBlocks(System.out);
        
        assertTrue(routine.getSpannedBlocks().size() == 2);
        assertTrue((routine.flags & Routine.fUnknownExit) == 0);
        Block block1 = getSingleEntry(routine);
        assertTrue(block1.getFirst().getInst().getInst() == Inst9900.Ili);
        assertTrue(block1.getLast().getInst().getInst() == Inst9900.Ibl);
        Block block2 = block1.succ.get(0);
        assertTrue(block2.getFirst().getInst().getInst() == Inst9900.Irtwp);
        assertTrue(block2.getLast().getInst().getInst() == Inst9900.Irtwp);
        
        IHighLevelInstruction inst2 = block1.getFirst().getLogicalNext();
		assertTrue(inst2.getInst().getOp1() instanceof RoutineOperand);
        Routine routine2 = ((RoutineOperand) inst2.getInst().getOp1()).routine;  
        assertNotSame(routine, routine2);
        assertTrue(routine2.getSpannedBlocks().size() == 1);
        
        // the NOPs are jumps so they produce a new routine
        assertEquals(3, phase.getRoutines().size());
        Block r2block = getSingleEntry(routine2);
        assertEquals(1, r2block.getPred().length);
        checkList(r2block.getSucc(), new Block[] {});
        validateBlocks(routine.getSpannedBlocks());
    }

    public void testInnerCall2() throws Exception {
    	// this forms another routine
        Routine routine = parseRoutine(0x100, "ENTRY", new ContextSwitchRoutine(0x8300),
                new String[] {
           "li r1,100", // 100
           "bl @>110", // 104
           //
           "bl @>110", // 108
           //
           "rtwp", // 10C
           //
           "nop", // 10E
           "li r5, 11", // 110
           "rt", // 114
           
        });
        
        phase.run();
        assertTrue(routine.getSpannedBlocks().size() == 3);
        assertTrue((routine.flags & Routine.fUnknownExit) == 0);
        Block block1 = getSingleEntry(routine);
        assertTrue(block1.getFirst().getInst().getInst() == Inst9900.Ili);
        IHighLevelInstruction inst2 = block1.getFirst().getLogicalNext();
		assertTrue(inst2.getInst().getOp1() instanceof RoutineOperand);
        IHighLevelInstruction inst3 = inst2.getLogicalNext();
		assertTrue(inst3.getInst().getOp1() instanceof RoutineOperand);
        assertTrue(block1.getLast().getInst().getInst() == Inst9900.Ibl);
        
        Routine routine2 = ((RoutineOperand) inst2.getInst().getOp1()).routine;  
        Routine routine2p = ((RoutineOperand) inst3.getInst().getOp1()).routine;
        // don't duplicate
        assertTrue(routine2 == routine2p);
        validateBlocks(routine.getSpannedBlocks());
        
    }

    public void testSavedBL() throws Exception {
        Routine routine = parseRoutine(0x100, "ENTRY", new LinkedRoutine(),
                new String[] {
           "mov r11,r6", // 100
           "bl @>0110", // 102
           //
           "movb r2,@>fffe(r15)", // 106
           "b *r6", // 10A
           //
           "nop", // 10C
           "nop", // 10E
           "rt", //110
        });
        
        phase.run();
        assertTrue(routine.getSpannedBlocks().size() == 2);
        assertTrue((routine.flags & Routine.fUnknownExit) == 0);
        Block block1 = getSingleEntry(routine);
        assertTrue(block1.getFirst().getInst().getInst() == Inst9900.Imov);
        assertTrue(block1.getFirst().getLogicalNext().getInst().getOp1() instanceof RoutineOperand);
        assertTrue(block1.getLast().getInst().getInst() == Inst9900.Ibl);
        Block block2 = block1.succ.get(0);
        assertTrue(block2.getFirst().getInst().getInst() == Inst9900.Imovb);
        assertTrue(block2.getLast().isReturn());
        
        validateBlocks(routine.getSpannedBlocks());
    }

    /** THIS WILL FAIL until we properly implement a compiler (or pass opcodes some other way) */
    /*
    public void testJumpTable1() throws Exception {
        // jumping directly to code (unlikely)
        Routine routine = parseRoutine(0x100, "ENTRY", new LinkedRoutine(),
                new String[] {
           "li r1,4", // 100
           "b @>110(r1)", // 104    
           "nop", // 108
           "nop", // 10A
           "nop", // 10C
           "rt", // 10E
           "li r2,10", //110
           "ai r2, 5", //114
           "jmp >10E", //118
           "data >4444"
        });
        
        phase.run();
        assertTrue(routine.blocks.size() == 5);
        
        LabelListOperand op = (LabelListOperand) routine.blocks.get(0).last.op1;
        assertTrue(op.operands.size() == 3);
        assertTrue(op.operands.get(0).label.addr == 0x118);
        assertTrue(op.operands.get(1).label.addr == 0x11C);
        assertTrue(op.operands.get(2).label.addr == 0x120);
    }*/

    /** If we know the WP, we can optimize this */
    public void testJumpReg1() throws Exception {
        // Jump to register.  This runs in the workspace.
        Routine routine = parseRoutine(0x100, 0x83E0, "ENTRY", new LinkedRoutine(),
                new String[] {
           "li r1,>0300", // 100
           "li r2,>0002", // 104
           "li r3,>0300", // 108
           "li r4,>0000", // 10C
           "li r5,>045b", // 110
           "bl r1", // 114
           "rt" // 116
        });
        
        phase.run();
        assertEquals(2, routine.getSpannedBlocks().size());
        
        Block block = getSingleEntry(routine);
        BaseMachineOperand op = (BaseMachineOperand) block.getLast().getInst().getOp1();
        assertEquals(MachineOperand9900.OP_ADDR, op.type);
        assertEquals(op.val, 0);
        assertEquals(op.immed, (short) 0x83E2);
        validateBlocks(routine.getSpannedBlocks());
    }
    
    /** If we know the WP, we can optimize this */
    public void testJumpReg2() throws Exception {
        // Jump to register.  We don't know the WP.
        Routine routine = parseRoutine(0x100, 0, "ENTRY", new LinkedRoutine(),
                new String[] {
           "bl r1",
           //
           "rt"
        });
        
        phase.run();
        assertTrue(routine.getSpannedBlocks().size() == 2);
        
        Block block = getSingleEntry(routine);
        BaseMachineOperand op = (BaseMachineOperand) block.getLast().getInst().getOp1();
        assertTrue(op.type == MachineOperand9900.OP_REG);
        assertEquals(op.val, 1);
        assertEquals(op.immed, 0);
        validateBlocks(routine.getSpannedBlocks());
    }

    public void testJumpTable0() throws Exception {
        // Not a jump table!
        Routine routine = parseRoutine(0x100, "ENTRY", new ContextSwitchRoutine(0x83e0),
                new String[] {
        	"mov @>83d8,R11", //100
           "b *R11", // 104
        });

        highLevel.getLLInstructions().put(0xfe, createHLInstruction(0xfe, 0, "B *R10"));

        phase.run();
        assertEquals(1, routine.getSpannedBlocks().size());
        
        assertTrue(getSingleEntry(routine).getLast().getInst().getOp1() instanceof IMachineOperand);
        validateBlocks(routine.getSpannedBlocks());
    }
    public void testJumpTable0b() throws Exception {
        // Single-entry
        Routine routine = parseRoutine(0x4c0, "ENTRY", new ContextSwitchRoutine(0x83e0),
                new String[] {
        	"mov @>4c6,R11", //4c0
           "b *R11", // 4c4
           "data >4c8", //4c6
           "clr r10", // 4ca == 4c8 but not a jump
           "clr r12", //4ca
        });

        highLevel.getLLInstructions().put(0xfe, createHLInstruction(0xfe, 0, "B *R10"));

        phase.run();
        assertEquals(2, routine.getSpannedBlocks().size());
        
        LabelListOperand op = (LabelListOperand) getSingleEntry(routine).getLast().getInst().getOp1();
        assertEquals(1, op.operands.size());
        assertEquals(0x4c8, op.operands.get(0).label.getAddr());
        
        
        validateBlocks(routine.getSpannedBlocks());
    }

	private Block getSingleEntry(Routine routine) {
		assertEquals(1, routine.getEntries().size());
		return routine.getMainLabel().getBlock();
	}
    public void testJumpTable1() throws Exception {
        // indirect jump to code.  This requires two instructions -- one to read an address
    	// and another to jump through that register
        Routine routine = parseRoutine(0x100, "ENTRY", new LinkedRoutine(),
                new String[] {
           "mov r1,r1", // 100
           "inct r1", // 102
           "mov @>110(r1), r2", // 104
           "b *r2", // 108
           "nop", // 10A
           "nop", // 10C
           "rt", // 10E
           "data >118", //110
           "data >11C", //112
           "data >11C", //114
           "data >120", //116
           "li r2,10", //118
           "ai r2, 5", //11C
           "jmp >10E", //120
           "data >4444"
        });

        highLevel.getLLInstructions().put(0xfe, createHLInstruction(0xfe, 0, "RT"));

        phase.run();
        assertEquals(5, routine.getSpannedBlocks().size());
        
        LabelListOperand op = (LabelListOperand) getSingleEntry(routine).getLast().getInst().getOp1();
        assertEquals(4, op.operands.size());
        assertEquals(0x118, op.operands.get(0).label.getAddr());
        assertEquals(0x11c, op.operands.get(1).label.getAddr());
        assertEquals(0x11C, op.operands.get(2).label.getAddr());
        assertEquals(0x120, op.operands.get(3).label.getAddr());
        validateBlocks(routine.getSpannedBlocks());
    }

    public void testJumpTable2() throws Exception {
        // indirect jump to code.  This requires two instructions -- one to read an address
    	// and another to jump through that register.  This one restricts the range of the index.
        Routine routine = parseRoutine(0x100, "ENTRY", new LinkedRoutine(),
                new String[] {
           "andi r1,6", // 100
           "mov @>110(r1), r2", // 104
           "b *r2", // 108
           ///
           "nop", // 10A
           ///
           "nop", // 10C
           ///
           "rt", // 10E
           ///
           "data >118", //110
           "data >11C", //112
           "data >11C", //114
           "data >120", //116	// not a target
           ///
           "li r2,10", //118
           ///
           "ai r2, 5", //11C
           "jmp >10E", //120
           "data >4444"
        });
        
        highLevel.getLLInstructions().put(0xfe, createHLInstruction(0xfe, 0, "RT"));
        
        phase.run();
        assertEquals(4, routine.getSpannedBlocks().size());
        
        LabelListOperand op = (LabelListOperand) getSingleEntry(routine).getLast().getInst().getOp1();
        assertEquals(3, op.operands.size());
        assertEquals(0x118, op.operands.get(0).label.getAddr());
        assertEquals(0x11c, op.operands.get(1).label.getAddr());
        assertEquals(0x11C, op.operands.get(2).label.getAddr());
        validateBlocks(routine.getSpannedBlocks());
    }

    public void testJumpTable3() throws Exception {
        // indirect jump to code.  This requires two instructions -- one to read an address
    	// and another to jump through that register.  This one restricts the range of the index.
        Routine routine = parseRoutine(0x100, "ENTRY", new LinkedRoutine(),
                new String[] {
           "mov r1,r1", // 100
           "srl r1,>f", // 102
           "mov @>110(r1), r2", // 104
           "b *r2", // 108
           "nop", // 10A
           "nop", // 10C
           "rt", // 10E
           "data >118", //110
           "data >11C", //112	// not
           "data >11C", //114	// not
           "data >120", //116	// not a target
           "li r2,10", //118
           "ai r2, 5", //11C
           "jmp >10E", //120
           "data >4444"
        });

        highLevel.getLLInstructions().put(0xfe, createHLInstruction(0xfe, 0, "RT"));

        phase.run();
        assertEquals(3, routine.getSpannedBlocks().size());
        
        LabelListOperand op = (LabelListOperand) getSingleEntry(routine).getLast().getInst().getOp1();
        assertEquals(1, op.operands.size());
        assertEquals(0x118, op.operands.get(0).label.getAddr());
        validateBlocks(routine.getSpannedBlocks());
    }

    public void testOneBlockBLWP() throws Exception {
        Routine routine = parseRoutine(0x100, "ENTRY", new ContextSwitchRoutine(0x8300),
                new String[] {
           "li r1,100",
           "rtwp"
        });
        
        phase.run();
        assertTrue(routine.getSpannedBlocks().size() == 1);
        Block block = getSingleEntry(routine);
        assertNotNull(block);
        assertTrue(block.getPred().length == 0);
        assertTrue(block.getSucc().length == 0);
        assertTrue(block.getFirst() != block.getLast());
        assertTrue((block.getFirst().getFlags() & HighLevelInstruction.fIsReturn + HighLevelInstruction.fIsBranch) == 0);
        assertTrue((block.getLast().getFlags() & HighLevelInstruction.fIsReturn) != 0);
        validateBlocks(routine.getSpannedBlocks());
    }

    public void testCrossRoutineJumps() throws ParseException {
    	Routine routine1 = parseRoutine(0x200, "ENTRY", new LinkedRoutine(),
                new String[] {
    		"CLR R5", //200
    		"RT", //202
    	});
    	Routine routine2 = parseRoutine(0x104, "ENTRY2", new LinkedRoutine(),
                new String[] {
    		"SETO R5", //104
    		"MOV @>10E(R4),R4",//106
    		"B *R4", //10A
    		"RT", //10C
    		"DATA >10C",
    		"DATA >200"
    	});
    	
        phase.run();
        validateBlocks(routine1.getSpannedBlocks());
        Collection<Block> r2blocks = routine2.getSpannedBlocks();
		validateBlocks(r2blocks);
        validateRoutines(phase.getRoutines());
        assertEquals(1, routine1.getSpannedBlocks().size());
        
        assertEquals(3, r2blocks.size());
        assertEquals(2, routine2.getEntries().size());
        assertTrue((routine1.flags & Routine.fSubroutine) != 0);
        assertTrue((routine2.flags & Routine.fSubroutine) == 0);
        assertTrue(routine2.getEntries().contains(routine1.getMainLabel().getBlock()));
        
    }
    /** Make sure blocks do not contain the same instruction twice 
     * @throws ParseException */
    public void testBlockGeneration() throws ParseException {
        Routine routine = parseRoutine(0x100, "ENTRY", new LinkedRoutine(),
                new String[] {
    		"LI R1,1", //100
    		"LI R2,1", //104
    		"LI R3,1", //108
    		"LI R4,1", //10c
    		"JNE >138", //110
    		"JGT >134", //112
    		"CLR R5", //114
    		"JH >100", //116
    		"LI R6,1", //118
    		"LI R7,1", //11c
    		"NEG R8", //120
    		"JGT >12C",//122
    		"LI R9,1", //124
    		"LI R10,1", //128
    		"LI R11,1", //12c
    		"LI R12,1", //130
    		"MOV @>13A(R13),R13", //134
    		"B *R13", //138
    		"data >100",//13A
    		"data >104",
    		"data >108",
    		"data >10c",
    		"data >110",
    		"data >114",
    		"data >118",
    		"data >11c",
    		"data >120",
    		"data >124",
    		"data >128",
    		"data >12c",
    		"data >130",
    	});
        phase.run();
        phase.dumpBlocks(System.out);
        assertEquals(16, routine.getSpannedBlocks().size());
        
        validateBlocks(routine.getSpannedBlocks());
        
    }
    
    public void testJumpTable4() throws ParseException {
    	// don't get confusing flowgraph when jumps inside instructions
        Routine routine = parseRoutine(0x100, "ENTRY", new LinkedRoutine(),
                new String[] {
    		"LI R1,>4c1", //100
    		"MOV @>10C(R2),R2", //104
    		"B *R2", //108
    		"rt", //10A
    		"data >10A",//10C
    		"data >102",//10E  could be a jump
    		"data >ffff",
    	});
        highLevel.getLLInstructions().put(0x102, createHLInstruction(0x102, 0, "CLR R1"));	// this is the decoded constant in the LI R1,>4c1
        
        phase.run();
        Collection<Block> spannedBlocks = routine.getSpannedBlocks();
		assertEquals(3, spannedBlocks.size());

        LabelListOperand op = (LabelListOperand) getSingleEntry(routine).getFirst().getLogicalNext().getLogicalNext().getInst().getOp1();
        assertEquals(2, op.operands.size());
        assertEquals(0x10A, op.operands.get(0).label.getAddr());
        assertEquals(0x102, op.operands.get(1).label.getAddr());
        validateBlocks(spannedBlocks);
        
    }

    public void testDataWords1() throws ParseException {
    	Routine routine = parseRoutine(0x100, "ENTRY", new LinkedRoutine(),
                new String[] {
    		"MOV *R11+,R1", //100
    		"CLR R2", //100
    		"MOVB *R11+,R2", //100
    		"SWPB R2",
    		"MOVB *R11+,R2", //100
    		"SWPB R2",
    		"rt", //10A
    	});
        
        phase.run();
        assertEquals(1, routine.getSpannedBlocks().size());
        assertEquals(2, routine.getDataWords());
    }
    public void testDataWords2() throws ParseException {
    	Routine routine = parseRoutine(0x100, "ENTRY", new LinkedRoutine(),
                new String[] {
    		"MOV *R11+,R1", //100
    		"MOV R11,R10",
    		"CLR R2", //100
    		"MOVB *R10+,R2", //100
    		"SWPB R2",
    		"MOVB *R10+,R2", //100
    		"SWPB R2",
    		"B *R10", //10A
    	});
        
        phase.run();
        assertEquals(1, routine.getSpannedBlocks().size());
        assertEquals(2, routine.getDataWords());
    }
    
    public void testDataWords3() throws ParseException {
    	Routine routine = parseRoutine(0x100, "ENTRY", new ContextSwitchRoutine(0x83e0),
                new String[] {
    		"MOV *R14+,R1", //100
    		"CLR R2", //100
    		"MOVB *R14+,R2", //100
    		"SWPB R2",
    		"MOVB *R14+,R2", //100
    		"SWPB R2",
    		"rtwp", //10A
    	});
        
        phase.run();
        assertEquals(1, routine.getSpannedBlocks().size());
        assertEquals(2, routine.getDataWords());
    }
    public void testDataWords4() throws ParseException {
    	Routine routine = parseRoutine(0x100, "ENTRY", new ContextSwitchRoutine(0x8300),
                new String[] {
    		"MOV *R14+,R1", //100
    		// don't follow moves here, because it's more likely we'll return via R14
    		"MOV R14,R11",
    		"CLR R2", //100
    		"MOVB *R11+,R2", //100
    		"SWPB R2",
    		"MOVB *R11+,R2", //100
    		"SWPB R2",
    		"RTWP", //10A
    	});
        
        phase.run();
        assertEquals(1, routine.getSpannedBlocks().size());
        assertEquals(1, routine.getDataWords());
    }
    
    /**
     * A routine may consume words which appear to be jumps or something
     * else which will mess up the flowgraph.  Be sure the routine's data word
     * detection forces a re-scan to fix up such things.
     * @throws ParseException 
     */
    public void testFixupDataWordConfusion() throws ParseException {
    	Routine routine1 = parseRoutine(0x100, "CALLER", new LinkedRoutine(),
                new String[] {
    		"MOV R11,R10",//100
    		"BL @>400", //102
    		//
    		"JMP $+>40",// 106  <-- looks like jumping to >146, but doesn't.
    		"B *R10", //108
    	});
    	Routine routine2 = parseRoutine(0x140, "RANDOM", new LinkedRoutine(),
                new String[] {
    		"CLR R1", // 140
    		"CLR R2", // 142
    		"CLR R3", // 144
    		"CLR R4", // 146
    		"RT",     // 148
    	});
    	Routine routine3 = parseRoutine(0x400, "ROUTINE", new LinkedRoutine(),
                new String[] {
    		"MOV R11,R10",
    		"MOV *R10+, R1",
    		"B *R10",
    	});
        
        phase.run();
        phase.dumpRoutines(System.out);
        
        validateRoutines(getRoutines());
        assertEquals(0, routine1.flags & Routine.fSubroutine);
        assertEquals(0, routine2.flags & Routine.fSubroutine);
        assertEquals(0, routine3.flags & Routine.fSubroutine);
        
        assertEquals(2, routine1.getSpannedBlocks().size());
        assertEquals(0, routine1.getDataWords());

        assertEquals(1, routine2.getSpannedBlocks().size());
        assertEquals(0, routine2.getDataWords());

        assertEquals(1, routine3.getSpannedBlocks().size());
        assertEquals(1, routine3.getDataWords());
    }
    
    
    public void testBlockBreaks() throws ParseException {
		Routine routine1 = parseRoutine(0x100, "ENTRY", new LinkedRoutine(),
	            new String[] {
			"JMP $+>2", //100
			"JNE $+>2",	//102
			"LIMI >2",	//104
			"B @>10C",	//108
			"NOP"		//10C
		});
	    
	    phase.run();
	    phase.dumpRoutines(System.out);
	    
	    validateRoutines(getRoutines());
	    
	    assertEquals(5, routine1.getSpannedBlocks().size());
	}

	public void test994ARom_0() throws Exception {
    	String path = ROM_PATH;
    	this.memory.addAndMap(memoryEntryFactory.newMemoryEntry(
    			MemoryEntryInfoBuilder.standardConsoleRom(path).create("CPU ROM")));
    	phase.disassemble();
    	phase.run();
    	phase.dumpBlocks(System.out);
    	validateBlocks(phase.getBlocks());
    	validateRoutines(phase.getRoutines());
    	Set<Integer> spannedPcs = phase.getBlockSpannedPcs();
    	System.out.println("spanned PCs: " + spannedPcs.size());
		assertTrue(spannedPcs.size() > 0x1e00 / 2);
    	assertTrue(phase.getRoutines().size() > 50);
    }
    
    public void test994ARom_BlockCrazy() throws Exception {
    	String path = ROM_PATH;
    	this.memory.addAndMap(memoryEntryFactory.newMemoryEntry(
    			MemoryEntryInfoBuilder.standardConsoleRom(path).create("CPU ROM")));
    	phase.disassemble();
    	// add label at every instruction just to be sure it doesn't explode
    	for (IHighLevelInstruction inst : phase.decompileInfo.getLLInstructions().values()) {
    		if (inst.getInst().getInst() != InstTableCommon.Idata && inst.getBlock() == null)
    			phase.addBlock(new Block(inst));
    	}
    	phase.run();
    	phase.dumpBlocks(System.out);
    	
    	System.out.println(phase.getBlocks().size());
    	assertTrue(phase.getBlocks().size() < 4222);
    	validateBlocks(phase.getBlocks());
    	validateRoutines(phase.getRoutines());
    	Set<Integer> spannedPcs = phase.getBlockSpannedPcs();
    	System.out.println("spanned PCs: " + spannedPcs.size());
		assertTrue(spannedPcs.size() > 0x1e00 / 2);
    	assertTrue(phase.getRoutines().size() > 100);
    }
    
    public void test994ARom_1() throws Exception {
    	String path = ROM_PATH;
    	this.memory.addAndMap(memoryEntryFactory.newMemoryEntry(
    			MemoryEntryInfoBuilder.standardConsoleRom(path).create("CPU ROM")));
    	phase.decompileInfo.getMemoryRanges().clear();
    	phase.decompileInfo.getMemoryRanges().addRange(0x800, 0x800, true);
    	phase.disassemble();
    	IHighLevelInstruction inst = phase.decompileInfo.getLLInstructions().get(0x800);
    	while (inst != null) {
    		if (inst.getInst().pc >= 0x800 && inst.getInst().pc < 0x1000 && inst.getBlock() == null && inst.getInst().getInst() != InstTableCommon.Idata)
    			phase.addBlock(new Block(inst));
    		inst = inst.getPhysicalNext();
    	}
    	phase.run();
    	phase.dumpBlocks(System.out);
    	System.out.println(phase.getBlocks().size());
    	
    	assertTrue(phase.getBlocks().size() > 240);
    	validateBlocks(phase.getBlocks());
    	
    	System.out.println(phase.getRoutines().size());
    	assertTrue(phase.getRoutines().size() > 25);
    	validateRoutines(phase.getRoutines());
    	
    	Set<Integer> spannedPcs = phase.getBlockSpannedPcs();
    	System.out.println("spanned PCs: " + spannedPcs.size());
		assertTrue(spannedPcs.size() > 0x700 / 2);
    }

}
