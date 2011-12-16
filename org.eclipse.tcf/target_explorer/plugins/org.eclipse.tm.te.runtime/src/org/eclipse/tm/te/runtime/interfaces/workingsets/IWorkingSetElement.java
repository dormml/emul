/*******************************************************************************
 * Copyright (c) 2011 Wind River Systems, Inc. and others. All rights reserved.
 * This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Wind River Systems - initial API and implementation
 *******************************************************************************/
package org.eclipse.tm.te.runtime.interfaces.workingsets;

import org.eclipse.core.runtime.IAdaptable;

/**
 * Interface to be implemented by root elements contributed to the
 * Target Explorer tree view which can be added to a working set as
 * root element.
 */
public interface IWorkingSetElement extends IAdaptable {

	/**
	 * Returns the working set element id.
	 * <p>
	 * The working set element id must be unique and persisted through out multiple session. This id
	 * is used to identify the working set element at restarting the Target Explorer after a session
	 * shutdown.
	 *
	 * @return The working set element id.
	 */
	public String getElementId();
}
