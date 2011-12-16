/*******************************************************************************
 * Copyright (c) 2011 Wind River Systems, Inc. and others. All rights reserved.
 * This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Wind River Systems - initial API and implementation
 *******************************************************************************/
package org.eclipse.tm.te.ui.views.extensions;

import org.eclipse.core.expressions.Expression;
import org.eclipse.core.expressions.ExpressionConverter;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.tm.te.runtime.extensions.ExecutableExtension;

/**
 * Details editor page binding implementation.
 */
public class EditorPageBinding extends ExecutableExtension {
	// The mandatory page identifier
	private String pageId;
	// The insertBefore element
	private String insertBefore;
	// The insertAfter element
	private String insertAfter;
	// The converted expression
	private Expression expression;

	/* (non-Javadoc)
	 * @see org.eclipse.tm.te.runtime.extensions.ExecutableExtension#doSetInitializationData(org.eclipse.core.runtime.IConfigurationElement, java.lang.String, java.lang.Object)
	 */
	@Override
	public void doSetInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException {
	    super.doSetInitializationData(config, propertyName, data);

		// Initialize the page id field by reading the <pageId> extension attribute.
		// Throws an exception if the id is empty or null.
		pageId = config != null ? config.getAttribute("pageId") : null; //$NON-NLS-1$
		if (pageId == null || (pageId != null && "".equals(pageId.trim()))) { //$NON-NLS-1$
			throw createMissingMandatoryAttributeException("pageId", config.getContributor().getName()); //$NON-NLS-1$
		}

		// Read the sub elements of the extension
		IConfigurationElement[] children = config != null ? config.getChildren() : null;
		// The "enablement" element is the only expected one
		if (children != null && children.length > 0) {
			expression = ExpressionConverter.getDefault().perform(children[0]);
		}

		// Read the "insertBefore" attribute
		insertBefore = config != null ? config.getAttribute("insertBefore") : null; //$NON-NLS-1$
		// Read the "insertAfter" attribute
		insertAfter = config != null ? config.getAttribute("insertAfter") : null; //$NON-NLS-1$
	}

	/**
	 * Returns the editor page id which is associated with this binding.
	 *
	 * @return The editor page id.
	 */
	public String getPageId() {
		return pageId;
	}

	/**
	 * Returns the enablement expression which is associated with this binding.
	 *
	 * @return The enablement expression or <code>null</code>.
	 */
	public Expression getEnablement() {
		return expression;
	}

	/**
	 * Returns the &quot;insertBefore&quot; property for this binding.
	 *
	 * @return The &quot;insertBefore&quot; property or an empty string.
	 */
	public String getInsertBefore() {
		return insertBefore != null ? insertBefore.trim() : ""; //$NON-NLS-1$
	}

	/**
	 * Returns the &quot;insertAfter&quot; property for this binding.
	 *
	 * @return The &quot;insertAfter&quot; property or an empty string.
	 */
	public String getInsertAfter() {
		return insertAfter != null ? insertAfter.trim() : ""; //$NON-NLS-1$
	}
}
