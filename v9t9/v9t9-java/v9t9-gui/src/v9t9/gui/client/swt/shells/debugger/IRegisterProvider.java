/*
  IRegisterProvider.java

  (c) 2011 Edward Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package v9t9.gui.client.swt.shells.debugger;

/**
 * @author ejs
 *
 */
public interface IRegisterProvider {
	String getLabel();
	int getNumDigits();
	IRegister[] getRegisters(int start, int count);
	int getRegisterCount();
}