/*
  IPrinterImageListener.java

  (c) 2014 Ed Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package v9t9.common.dsr;


/**
 * @author ejs
 *
 */
public interface IPrinterImageListener {
	/** new page being written; will be updated via #bytesProcessed and #updated */
	void newPage(PrinterPage page);

	/** bytes processed to cause next #updated */
	void bytesProcessed(byte[] bytes);

	/** changes on this page */
	void updated(PrinterPage page);
}
