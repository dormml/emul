/*
  NullCompilerStrategy.java

  (c) 2010-2013 Edward Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package v9t9.engine.compiler;

import v9t9.common.compiler.ICompiledCode;
import v9t9.common.compiler.ICompiler;
import v9t9.common.compiler.ICompilerStrategy;
import v9t9.common.cpu.IExecutor;

public class NullCompilerStrategy implements ICompilerStrategy {

	/* (non-Javadoc)
	 * @see v9t9.emulator.runtime.compiler.ICompilerStrategy#canCompile()
	 */
	@Override
	public boolean canCompile() {
		return false;
	}
	
	@Override
	public ICompiledCode getCompiledCode() {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see v9t9.emulator.runtime.compiler.ICompilerStrategy#setup(v9t9.emulator.runtime.cpu.Executor, v9t9.emulator.runtime.compiler.Compiler)
	 */
	@Override
	public void setup(IExecutor exec, ICompiler compiler) {
		
	}
	
	/* (non-Javadoc)
	 * @see v9t9.engine.compiler.ICompilerStrategy#reset()
	 */
	@Override
	public void reset() {
		
	}
}
