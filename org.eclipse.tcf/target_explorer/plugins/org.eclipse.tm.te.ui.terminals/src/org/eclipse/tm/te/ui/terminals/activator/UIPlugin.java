/*******************************************************************************
 * Copyright (c) 2011 Wind River Systems, Inc. and others. All rights reserved.
 * This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Wind River Systems - initial API and implementation
 *******************************************************************************/
package org.eclipse.tm.te.ui.terminals.activator;

import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.tm.te.runtime.preferences.ScopedEclipsePreferences;
import org.eclipse.tm.te.runtime.tracing.TraceHandler;
import org.eclipse.tm.te.ui.terminals.interfaces.ImageConsts;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class UIPlugin extends AbstractUIPlugin {
	// The shared instance
	private static UIPlugin plugin;

	private static ScopedEclipsePreferences scopedPreferences = null;
	// The trace handler instance
	private static TraceHandler traceHandler;

	/**
	 * The constructor
	 */
	public UIPlugin() {
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static UIPlugin getDefault() {
		return plugin;
	}

	/**
	 * Convenience method which returns the unique identifier of this plugin.
	 */
	public static String getUniqueIdentifier() {
		if (getDefault() != null && getDefault().getBundle() != null) {
			return getDefault().getBundle().getSymbolicName();
		}
		return null;
	}

	/**
	 * Return the scoped preferences for this plugin.
	 */
	public static ScopedEclipsePreferences getScopedPreferences() {
		if (scopedPreferences == null) {
			scopedPreferences = new ScopedEclipsePreferences(getUniqueIdentifier());
		}
		return scopedPreferences;
	}

	/**
	 * Returns the bundles trace handler.
	 *
	 * @return The bundles trace handler.
	 */
	public static TraceHandler getTraceHandler() {
		if (traceHandler == null) {
			traceHandler = new TraceHandler(getUniqueIdentifier());
		}
		return traceHandler;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		scopedPreferences = null;
		traceHandler = null;
		super.stop(context);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#initializeImageRegistry(org.eclipse.jface.resource.ImageRegistry)
	 */
	@Override
	protected void initializeImageRegistry(ImageRegistry registry) {
		Bundle bundle = Platform.getBundle("org.eclipse.ui.console"); //$NON-NLS-1$
		if (bundle != null) {
			URL url = bundle.getEntry(ImageConsts.IMAGE_DIR_ROOT + "full/" + ImageConsts.IMAGE_DIR_EVIEW + "console_view.gif"); //$NON-NLS-1$ //$NON-NLS-2$
			registry.put(ImageConsts.VIEW_Terminals, ImageDescriptor.createFromURL(url));

			url = bundle.getEntry(ImageConsts.IMAGE_DIR_ROOT + "full/" + ImageConsts.IMAGE_DIR_CLCL + "lock_co.gif"); //$NON-NLS-1$ //$NON-NLS-2$
			registry.put(ImageConsts.ACTION_ScrollLock_Hover, ImageDescriptor.createFromURL(url));
			url = bundle.getEntry(ImageConsts.IMAGE_DIR_ROOT + "full/" + ImageConsts.IMAGE_DIR_ELCL + "lock_co.gif"); //$NON-NLS-1$ //$NON-NLS-2$
			registry.put(ImageConsts.ACTION_ScrollLock_Enabled, ImageDescriptor.createFromURL(url));
			url = bundle.getEntry(ImageConsts.IMAGE_DIR_ROOT + "full/" + ImageConsts.IMAGE_DIR_DLCL + "lock_co.gif"); //$NON-NLS-1$ //$NON-NLS-2$
			registry.put(ImageConsts.ACTION_ScrollLock_Disabled, ImageDescriptor.createFromURL(url));
		}
	}

	/**
	 * Loads the image registered under the specified key from the image
	 * registry and returns the <code>Image</code> object instance.
	 *
	 * @param key The key the image is registered with.
	 * @return The <code>Image</code> object instance or <code>null</code>.
	 */
	public static Image getImage(String key) {
		return getDefault().getImageRegistry().get(key);
	}

	/**
	 * Loads the image registered under the specified key from the image
	 * registry and returns the <code>ImageDescriptor</code> object instance.
	 *
	 * @param key The key the image is registered with.
	 * @return The <code>ImageDescriptor</code> object instance or <code>null</code>.
	 */
	public static ImageDescriptor getImageDescriptor(String key) {
		return getDefault().getImageRegistry().getDescriptor(key);
	}
}
