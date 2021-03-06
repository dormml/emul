/*
  IFifoLpcDataFetcher.java

  (c) 2012-2013 Edward Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package v9t9.engine.speech;

/**
 * @author ejs
 *
 */
public interface IFifoLpcDataFetcher extends ILPCDataFetcher {

	public interface IFifoStatusListener {
		void fetchedEmpty();
		void lengthChanged(int length);
	}

	void setListener(IFifoStatusListener listener);
	void write(byte val);
	void purge();
	
	boolean isFull();
}
