/*
  IOperandChangeElement.java

  (c) 2015 Edward Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package v9t9.common.cpu;

import v9t9.common.asm.IOperand;

/**
 * @author ejs
 *
 */
public interface IOperandChangeElement extends IChangeElement {

	String format(IOperand op, boolean preExecute);
}
