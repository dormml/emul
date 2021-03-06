/*
  CompileInfo.java

  (c) 2005-2015 Edward Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package v9t9.engine.compiler;

import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionHandle;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.TABLESWITCH;

import v9t9.common.client.ISettingsHandler;
import v9t9.common.compiler.ICompiler;
import v9t9.common.memory.IMemoryDomain;


public class CompileInfo {
	public boolean optimize;
	public boolean optimizeRegAccess;
	
	public InstructionFactory ifact;
	public ISettingsHandler settings;
	
    public CompileInfo(ISettingsHandler settings, ConstantPoolGen pgen, InstructionFactory ifact) {
    	this.settings = settings;
    	this.optimize = settings.get(ICompiler.settingOptimize).getBoolean();
    	this.optimizeRegAccess = optimize && 
    		settings.get(ICompiler.settingOptimizeRegAccess).getBoolean();
    	
        this.pgen = pgen;
        this.ifact = ifact;
    }
    
    // compile-time info
    public InstructionList ilist;
	public InstructionList breakList;
	public TABLESWITCH sw;
	public InstructionHandle doneInst, breakInst, switchInst;
	public ConstantPoolGen pgen;
	public int cycles;
    
    // indexes of useful variables in generated class
    public int memoryIndex, cpuIndex, cpuStateIndex, nInstructionsIndex, nCyclesIndex;
    public int cruIndex;
    public int vdpIndex, gplIndex;
    public int executionTokenIndex;
    
    // indexes of our locals in generated method
    /** MemoryDomain */
    public int localMemory;
    public int localPc, localWp, localStatus;
    public int localEa1, localEa2;
    public int localVal1, localVal2, localVal3;
    public int localInsts, localCycles;

    // only set if Compiler.settingOptimizeRegAccess is on
    public int localWpWordMemory;
    public int localWpOffset;
    public int localTemp; // 16-bit
    
    //v9t9.memory.Memory memory;
    public IMemoryDomain memory;
}