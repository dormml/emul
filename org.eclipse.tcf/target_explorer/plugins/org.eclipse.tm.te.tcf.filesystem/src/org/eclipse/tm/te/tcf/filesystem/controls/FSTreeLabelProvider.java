/*******************************************************************************
 * Copyright (c) 2011 Wind River Systems, Inc. and others. All rights reserved.
 * This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Wind River Systems - initial API and implementation
 *******************************************************************************/
package org.eclipse.tm.te.tcf.filesystem.controls;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.tm.te.tcf.filesystem.activator.UIPlugin;
import org.eclipse.tm.te.tcf.filesystem.internal.ImageConsts;
import org.eclipse.tm.te.tcf.filesystem.model.FSTreeNode;
import org.eclipse.tm.te.ui.views.interfaces.IUIConstants;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonNavigator;


/**
 * File system tree control label provider implementation.
 */
public class FSTreeLabelProvider extends LabelProvider implements ITableLabelProvider {
	private IEditorRegistry editorRegistry = null;

	private static final SimpleDateFormat DATE_MODIFIED_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm"); //$NON-NLS-1$
	private static final DecimalFormat SIZE_FORMAT = new DecimalFormat();

	// Reference to the parent tree viewer
	private TreeViewer parentViewer;

	/**
	 * Constructor.
	 */
	public FSTreeLabelProvider() {
		this(null);
	}

	/**
	 * Constructor.
	 *
	 * @param viewer The tree viewer or <code>null</code>.
	 */
	public FSTreeLabelProvider(TreeViewer viewer) {
		super();
		parentViewer = viewer;
	}

	/**
	 * Returns the parent tree viewer instance.
	 *
	 * @return The parent tree viewer or <code>null</code>.
	 */
	public final TreeViewer getParentViewer() {
		if (parentViewer == null) {
			if (PlatformUI.getWorkbench() != null && PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null
					&& PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage() != null) {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				IViewPart part = page.findView(IUIConstants.ID_EXPLORER);
				if (part instanceof CommonNavigator) {
					parentViewer = ((CommonNavigator)part).getCommonViewer();
				}
			}
		}
		return parentViewer;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof FSTreeNode) {
			return ((FSTreeNode)element).name;
		}
		return super.getText(element);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {
		if (element != null) {
			boolean isExpanded = getParentViewer().getExpandedState(element);

			if (element instanceof FSTreeNode) {
				FSTreeNode node = (FSTreeNode)element;
				if ("FSRootDirNode".equals(node.type)) {//$NON-NLS-1$
					return isExpanded ? UIPlugin.getImage(ImageConsts.ROOT_DRIVE_OPEN) : UIPlugin.getImage(ImageConsts.ROOT_DRIVE);
				} else if ("FSDirNode".equals(node.type)) { //$NON-NLS-1$
					return isExpanded ? PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER) : UIPlugin.getImage(ImageConsts.FOLDER);
				} else if ("FSFileNode".equals(node.type)) { //$NON-NLS-1$
					String key = node.name;
					Image image = UIPlugin.getImage(key);
					if (image == null) {

						ImageDescriptor descriptor = getEditorRegistry().getImageDescriptor(key);
						if (descriptor == null) descriptor = getEditorRegistry().getSystemExternalEditorImageDescriptor(key);
						if (descriptor != null) UIPlugin.getDefault().getImageRegistry().put(key, descriptor);
						image = UIPlugin.getImage(key);
					}
					return image;
				}
			}
		}

		return super.getImage(element);
	}

	/**
	 * Returns the workbench's editor registry.
	 */
	private IEditorRegistry getEditorRegistry() {
		if (editorRegistry == null) {
			IWorkbench workbench = PlatformUI.getWorkbench();
			if (workbench != null) editorRegistry = workbench.getEditorRegistry();
		}
		return editorRegistry;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
	 */
	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		if (columnIndex == 0) return getImage(element);
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
	 */
	@Override
	public String getColumnText(Object element, int columnIndex) {
		if (columnIndex == 0) return getText(element);

		if (element instanceof FSTreeNode) {
			FSTreeNode node = (FSTreeNode)element;
			if (node.type != null && node.type.startsWith("FS")) { //$NON-NLS-1$
				// Pending nodes does not have column texts at all
				if (node.type.endsWith("PendingNode")) return ""; //$NON-NLS-1$ //$NON-NLS-2$

				boolean isDirNode = node.type.endsWith("DirNode"); //$NON-NLS-1$
				switch (columnIndex) {
				case 1:
					// Directory nodes does not have a size
					if (!isDirNode) {
						if (node.attr != null) {
							return SIZE_FORMAT.format(node.attr.size / 1024) + " KB"; //$NON-NLS-1$
						}
					}
					break;
				case 2:
					if (node.attr != null) {
						return DATE_MODIFIED_FORMAT.format(new Date(node.attr.mtime));
					}
					break;
				}

			}
		}

		return ""; //$NON-NLS-1$
	}

}
