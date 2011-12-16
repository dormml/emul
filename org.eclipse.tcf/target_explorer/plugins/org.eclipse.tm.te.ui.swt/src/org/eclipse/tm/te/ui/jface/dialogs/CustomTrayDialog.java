/*******************************************************************************
 * Copyright (c) 2011 Wind River Systems, Inc. and others. All rights reserved.
 * This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Wind River Systems - initial API and implementation
 *******************************************************************************/
package org.eclipse.tm.te.ui.jface.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.tm.te.ui.swt.activator.UIPlugin;
import org.eclipse.ui.PlatformUI;


/**
 * Custom tray dialog implementation.
 */
public class CustomTrayDialog extends TrayDialog {
	protected static final int comboHistoryLength = 10;
	private String contextHelpId = null;

	// the dialog storage
	private IDialogSettings dialogSettings;

	/**
	 * Constructor.
	 *
	 * @param shell The parent shell or <code>null</code>.
	 */
	public CustomTrayDialog(Shell shell) {
		this(shell, null);
	}

	/**
	 * Constructor.
	 *
	 * @param shell The parent shell or <code>null</code>.
	 * @param contextHelpId The dialog context help id or <code>null</code>.
	 */
	public CustomTrayDialog(Shell shell, String contextHelpId) {
		super(shell);
		initializeDialogSettings();
		setContextHelpId(contextHelpId);
	}

	/**
	 * Configure the dialogs context help id.
	 *
	 * @param contextHelpId The context help id or <code>null</code>.
	 */
	protected void setContextHelpId(String contextHelpId) {
		this.contextHelpId = contextHelpId;
		setHelpAvailable(contextHelpId != null);
	}

	/**
	 * Initialize the dialog settings storage.
	 */
	protected void initializeDialogSettings() {
		IDialogSettings settings = doGetDialogSettingsToInitialize();
		Assert.isNotNull(settings);
		IDialogSettings section = settings.getSection(getDialogSettingsSectionName());
		if (section == null) {
			section = settings.addNewSection(getDialogSettingsSectionName());
		}
		setDialogSettings(section);
	}

	/**
	 * Returns the dialog settings container to use and to initialize. This
	 * method is called from <code>initializeDialogSettings</code> and allows
	 * overriding the dialog settings container without changing the dialog
	 * settings structure.
	 *
	 * @return The dialog settings container to use. Must not be <code>null</code>.
	 */
	protected IDialogSettings doGetDialogSettingsToInitialize() {
		return UIPlugin.getDefault().getDialogSettings();
	}

	/**
	 * Returns the section name to use for separating different persistent
	 * dialog settings from different dialogs.
	 *
	 * @return The section name used to store the persistent dialog settings within the plugins persistent
	 *         dialog settings store.
	 */
	public String getDialogSettingsSectionName() {
		return "CustomTrayDialog"; //$NON-NLS-1$
	}

	/**
	 * Returns the associated dialog settings storage.
	 *
	 * @return The dialog settings storage.
	 */
	public IDialogSettings getDialogSettings() {
		// The dialog settings may not been initialized here. Initialize first in this case
		// to be sure that we do have always the correct dialog settings.
		if (dialogSettings == null) {
			initializeDialogSettings();
		}
		return dialogSettings;
	}

	/**
	 * Sets the associated dialog settings storage.
	 *
	 * @return The dialog settings storage.
	 */
	public void setDialogSettings(IDialogSettings dialogSettings) {
		this.dialogSettings = dialogSettings;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		if (contextHelpId != null) {
			PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, contextHelpId);
		}

		// Let the super implementation create the dialog area control
		Control control = super.createDialogArea(parent);
		// But fix the layout data for the top control
		if (control instanceof Composite) {
			configureDialogAreaControl((Composite)control);
		}

		return control;
	}

	/**
	 * Configure the dialog top control.
	 *
	 * @param composite The dialog top control. Must not be <code>null</code>.
	 */
	protected void configureDialogAreaControl(Composite composite) {
		Assert.isNotNull(composite);
		Layout layout = composite.getLayout();
		if (layout == null || layout instanceof GridLayout) {
			composite.setLayout(new GridLayout());
		}
	}

	/**
	 * Adds the given string to the given string array.
	 *
	 * @param history String array to add the given entry to it.
	 * @param newEntry The new entry to add.
	 * @return The updated string array containing the old array content plus the new entry.
	 */
	protected String[] addToHistory(String[] history, String newEntry) {
		List<String> l = new ArrayList<String>(Arrays.asList(history));
		addToHistory(l, newEntry);
		String[] r = new String[l.size()];
		l.toArray(r);
		return r;
	}

	/**
	 * Adds the given string to the given list.
	 *
	 * @param history List to add the given entry to it.
	 * @param newEntry The new entry to add. Must not be <code>null</code>
	 *
	 * @return The updated list containing the old list content plus the new entry.
	 */
	protected void addToHistory(List<String> history, String newEntry) {
		Assert.isNotNull(newEntry);

		history.remove(newEntry);
		history.add(0, newEntry);
		// since only one new item was added, we can be over the limit
		// by at most one item
		if (history.size() > comboHistoryLength) {
			history.remove(comboHistoryLength);
		}
	}

	/**
	 * Save current dialog widgets values.
	 * Called by <code>okPressed</code>.
	 */
	protected void saveWidgetValues() {
		return;
	}

	/**
	 * Restore previous dialog widgets values.
	 * Note: This method is not called automatically! You have
	 *       to call this method at the appropriate time and place.
	 */
	protected void restoreWidgetValues() {
		return;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	@Override
	protected void okPressed() {
		saveWidgetValues();
		super.okPressed();
	}

	/**
	 * Cleanup when dialog is closed.
	 */
	protected void dispose() {
		dialogSettings = null;
	}

	/**
	 * Cleanup the Dialog and close it.
	 */
	@Override
	public boolean close() {
		dispose();
		return super.close();
	}

	/**
	 * Sets the title for this dialog.
	 *
	 * @param title The title.
	 */
	public void setDialogTitle(String title) {
		if (getShell() != null && !getShell().isDisposed()) {
			getShell().setText(title);
		}
	}
}
