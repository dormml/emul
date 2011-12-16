/*******************************************************************************
 * Copyright (c) 2011 Wind River Systems, Inc. and others. All rights reserved.
 * This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Wind River Systems - initial API and implementation
 *******************************************************************************/
package org.eclipse.tm.te.tcf.ui.tables;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.tm.te.tcf.ui.nls.Messages;
import org.eclipse.tm.te.ui.tables.TableViewerComparator;


/**
 * TCF node properties table viewer comparator implementation.
 */
public class NodePropertiesViewerComparator extends TableViewerComparator {

	/**
	 * Constructor.
	 *
	 * @param viewer The parent viewer. Must not be <code>null</code>.
	 * @param labelProvider The table label provider. Must not be <code>null</code>.
	 */
	public NodePropertiesViewerComparator(Viewer viewer, ITableLabelProvider labelProvider) {
		super(viewer, labelProvider);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.tm.te.tcf.vtl.ui.tables.TableViewerComparator#doCompare(java.lang.Object, java.lang.Object, java.lang.String, int, int)
	 */
	@Override
	protected int doCompare(Object node1, Object node2, String sortColumn, int index, int inverter) {
		if (node1 != null && node2 != null) {
			String t1 = doGetText(node1, index);
			String t2 = doGetText(node2, index);

			// Name column sorting
			if (index == 0) {
				// Special handling for empty text and last error text
				if ("".equals(t1) || "".equals(t2) //$NON-NLS-1$ //$NON-NLS-2$
						|| Messages.NodePropertiesLabelProvider_lastScannerError.equals(t1)
						|| Messages.NodePropertiesLabelProvider_lastScannerError.equals(t2)) {
					if (("".equals(t1) || Messages.NodePropertiesLabelProvider_lastScannerError.equals(t1)) //$NON-NLS-1$
							&& !("".equals(t2) || Messages.NodePropertiesLabelProvider_lastScannerError.equals(t2))) { //$NON-NLS-1$
						return 1;
					}
					if (!("".equals(t1) || Messages.NodePropertiesLabelProvider_lastScannerError.equals(t1)) //$NON-NLS-1$
							&& ("".equals(t2) || Messages.NodePropertiesLabelProvider_lastScannerError.equals(t2))) { //$NON-NLS-1$
						return -1;
					}
					if ("".equals(t1) && Messages.NodePropertiesLabelProvider_lastScannerError.equals(t2)) { //$NON-NLS-1$
						return -1;
					}
					if ("".equals(t2) && Messages.NodePropertiesLabelProvider_lastScannerError.equals(t1)) { //$NON-NLS-1$
						return 1;
					}
				}
				// Special handling for "\t"
				else if ("\t".equals(t1) || "\t".equals(t2)) { //$NON-NLS-1$ //$NON-NLS-2$
					return 0;
				}
			}
			// Value column sorting
			else if (index == 1) {
				String t11 = doGetText(node1, 0);
				String t21 = doGetText(node2, 0);
				// Special handling for "\t"
				if ("\t".equals(t11) || "\t".equals(t21)) { //$NON-NLS-1$ //$NON-NLS-2$
					return 0;
				}
			}
		}

		return super.doCompare(node1, node2, sortColumn, index, inverter);
	}
}
