/*
  DemoInputEventBuffer.java

  (c) 2012-2013 Edward Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package v9t9.engine.demos.format;

import java.io.InputStream;

import v9t9.common.demos.IDemoInputEventBuffer;

/**
 * @author ejs
 *
 */
public abstract class DemoInputEventBuffer extends DemoInputBuffer implements
		IDemoInputEventBuffer {

	/**
	 * @param is
	 * @param code
	 * @param identifier
	 */
	public DemoInputEventBuffer(InputStream is, int code, String identifier) {
		super(is, code, identifier);
	}
	

}
