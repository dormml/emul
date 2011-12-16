/*******************************************************************************
 * Copyright (c) 2011 Wind River Systems, Inc. and others. All rights reserved.
 * This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Wind River Systems - initial API and implementation
 *******************************************************************************/
package org.eclipse.tm.te.ui.views.nls;

import org.eclipse.osgi.util.NLS;

/**
 * Target Explorer UI plugin externalized strings management.
 */
public class Messages extends NLS {

	// The plug-in resource bundle name
	private static final String BUNDLE_NAME = "org.eclipse.tm.te.ui.views.nls.Messages"; //$NON-NLS-1$

	/**
	 * Static constructor.
	 */
	static {
		// Load message values from bundle file
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	// **** Declare externalized string id's down here *****

	public static String View_toolTip;
	public static String View_toolTip2;
	public static String View_toolTip3;
	public static String View_workingSetModel;

	public static String NewActionProvider_NewMenu_label;
	public static String NewActionProvider_NewWizardCommandAction_label;
	public static String NewActionProvider_NewWizardCommandAction_tooltip;

	public static String WorkingSetActionProvider_multipleWorkingSets;

	public static String WorkingSetRootModeActionGroup_Top_Level_Element;
	public static String WorkingSetRootModeActionGroup_Target;
	public static String WorkingSetRootModeActionGroup_Working_Set;

	public static String WorkingSetContentProvider_others_name;

	public static String PropertiesCommandHandler_error_initPartFailed;

	public static String TargetWorkingSetPage_workingSet_name;
	public static String TargetWorkingSetPage_workspace_content;
	public static String TargetWorkingSetPage_add_button;
	public static String TargetWorkingSetPage_addAll_button;
	public static String TargetWorkingSetPage_remove_button;
	public static String TargetWorkingSetPage_removeAll_button;
	public static String TargetWorkingSetPage_workingSet_content;
	public static String TargetWorkingSetPage_warning_nameWhitespace;
	public static String TargetWorkingSetPage_warning_nameMustNotBeEmpty;
	public static String TargetWorkingSetPage_warning_workingSetExists;
	public static String TargetWorkingSetPage_warning_resourceMustBeChecked;
	public static String TargetWorkingSetPage_title;
	public static String TargetWorkingSetPage_workingSet_description;
}
