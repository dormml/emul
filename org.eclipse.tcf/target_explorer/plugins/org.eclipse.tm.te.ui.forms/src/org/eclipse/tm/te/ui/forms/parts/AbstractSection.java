/*******************************************************************************
 * Copyright (c) 2011 Wind River Systems, Inc. and others. All rights reserved.
 * This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Wind River Systems - initial API and implementation
 *******************************************************************************/
package org.eclipse.tm.te.ui.forms.parts;

import java.lang.reflect.Field;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.tm.te.ui.forms.FormLayoutFactory;
import org.eclipse.tm.te.ui.swt.SWTControlUtil;
import org.eclipse.ui.forms.AbstractFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

/**
 * Abstract section implementation.
 */
public abstract class AbstractSection extends SectionPart implements IAdaptable {

	/**
	 * Constructor.
	 *
	 * @param form The parent managed form. Must not be <code>null</code>.
	 * @param parent The parent composite. Must not be <code>null</code>.
	 * @param style The section style.
	 */
	public AbstractSection(IManagedForm form, Composite parent, int style) {
		this(form, parent, style, true);
	}

	/**
	 * Constructor.
	 *
	 * @param form The parent managed form. Must not be <code>null</code>.
	 * @param parent The parent composite. Must not be <code>null</code>.
	 * @param style The section style.
	 * @param titleBar If <code>true</code>, the title bar style bit is added to <code>style</code>.
	 */
	public AbstractSection(IManagedForm form, Composite parent, int style, boolean titleBar) {
		super(parent, form.getToolkit(), titleBar ? (ExpandableComposite.TITLE_BAR | style) : style);
		initialize(form);
		getSection().clientVerticalSpacing = FormLayoutFactory.SECTION_HEADER_VERTICAL_SPACING;
		getSection().setData("part", this); //$NON-NLS-1$
	}

	/**
	 * Creates the section client.
	 *
	 * @param section The parent section. Must not be <code>null</code>.
	 * @param toolkit The form toolkit. Must not be <code>null</code>.
	 */
	protected abstract void createClient(Section section, FormToolkit toolkit);

	/**
	 * Creates the client container composite.
	 *
	 * @param parent The parent composite. Must not be <code>null</code>.
	 * @param numColumns The number of columns.
	 * @param toolkit The form toolkit or <code>null</code>.
	 *
	 * @return The client container composite.
	 */
	protected Composite createClientContainer(Composite parent, int numColumns, FormToolkit toolkit) {
		Composite container = toolkit != null ? toolkit.createComposite(parent) : new Composite(parent, SWT.NONE);
		container.setLayout(FormLayoutFactory.createSectionClientGridLayout(false, numColumns));
		return container;
	}

	/**
	 * Convenience method to create a "invisible" label for creating an
	 * empty space between controls.
	 *
	 * @param parent The parent composite. Must not be <code>null</code>.
	 * @param span The horizontal span.
	 * @param toolkit The form toolkit or <code>null</code>.
	 *
	 * @return
	 */
	protected Label createEmptySpace(Composite parent, int span, FormToolkit toolkit) {
		Assert.isNotNull(parent);

		Label emptySpace = toolkit != null ? toolkit.createLabel(parent, null) : new Label(parent, SWT.NONE);

		GridData layoutData = new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false);
		layoutData.horizontalSpan = span;
		layoutData.widthHint = 0; layoutData.heightHint = SWTControlUtil.convertHeightInCharsToPixels(emptySpace, 1) / 2;

		emptySpace.setLayoutData(layoutData);

		return emptySpace;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	@Override
	public Object getAdapter(Class adapter) {
		return Platform.getAdapterManager().getAdapter(this, adapter);
	}

	/**
	 * Marks the section dirty or reset the dirty state.
	 *
	 * @param dirty <code>True</code> to mark the section dirty, <code>false</code> otherwise.
	 */
	public final void markDirty(boolean dirty) {
		if (dirty) markDirty();
		else {
			// For now, there is no direct way to reset the dirty state,
			// and the refresh() method is setting back both flags (stale and dirty).
			// Plus, refresh() might be overwritten to refresh the widget content
			// from the data itself, what will trigger an stack overflow after all.
			try {
				Field f = AbstractFormPart.class.getDeclaredField("dirty"); //$NON-NLS-1$
				f.setAccessible(true);
				f.setBoolean(this, dirty);
				getManagedForm().dirtyStateChanged();
			} catch (Exception e) { /* ignored on purpose */ }
		}
	}
}
