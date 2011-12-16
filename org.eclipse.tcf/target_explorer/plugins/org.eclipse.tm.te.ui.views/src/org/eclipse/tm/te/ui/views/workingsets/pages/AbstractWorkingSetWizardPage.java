/*******************************************************************************
 * Copyright (c) 2000, 2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 * 		William Chen (Wind River)	[354578] Add support for working sets
 *******************************************************************************/
package org.eclipse.tm.te.ui.views.workingsets.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.tm.te.runtime.interfaces.workingsets.IWorkingSetElement;
import org.eclipse.tm.te.ui.views.nls.Messages;
import org.eclipse.tm.te.ui.views.workingsets.WorkingSetElementHolder;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.IWorkingSetManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.IWorkingSetPage;

/**
 * A tree viewer on the left is used to show the workspace content, a table viewer on the right is
 * used to show the working set content. Buttons to move content from right to left and vice versa
 * are available between the two viewers. A text field allows to set/change the working sets name.
 * <p>
 * Copied and adapted from <code>org.eclipse.jdt.internal.ui.workingsets.AbstractWorkingSetWizardPage</code>.
 */
public abstract class AbstractWorkingSetWizardPage extends WizardPage implements IWorkingSetPage {

	final class AddedElementsFilter extends ViewerFilter {

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
		 */
		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			return !selectedElements.contains(element);
		}

	}

	/* default */ Text workingSetNameControl;
	/* default */ TreeViewer tree;
	/* default */ TableViewer table;
	/* default */ ITreeContentProvider treeContentProvider;

	/* default */ boolean firstCheck;
	/* default */ final HashSet<Object> selectedElements;
	/* default */ IWorkingSet workingSet;

	/**
	 * Constructor.
	 *
	 * @param pageName
	 * @param title
	 * @param titleImage
	 */
	protected AbstractWorkingSetWizardPage(String pageName, String title, ImageDescriptor titleImage) {
		super(pageName, title, titleImage);

		selectedElements = new HashSet<Object>();
		firstCheck = true;
	}

	/**
	 * Returns the page id as specified in the extension point.
	 *
	 * @return the page id
	 */
	protected abstract String getPageId();

	/**
	 * Configure the tree viewer used on the left side of the dialog.
	 *
	 * Implementors must set:
	 * <ul>
	 * <li>The content provider</li>
	 * <li>The label provider</li>
	 * <li>The viewers input</li>
	 * </ul>
	 * They may also set:
	 * <ul>
	 * <li>The viewer comparator</li>
	 * <li>Any viewer filter</li>
	 * <li>The selection</li>
	 * </ul>
	 *
	 * @param tree
	 *            the tree to configure
	 */
	protected abstract void configureTree(TreeViewer tree);

	/**
	 * Configure the table viewer used on the right side of the dialog.
	 *
	 * Implementors must set:
	 * <ul>
	 * <li>The label provider</li>
	 * </ul>
	 * They may also set:
	 * <ul>
	 * <li>The viewer comparator</li>
	 * </ul>
	 * They must not set:
	 * <ul>
	 * <li>The viewers content provider</li>
	 * <li>The viewers input</li>
	 * <li>Any viewer filter</li>
	 * </ul>
	 *
	 * @param table
	 *            the table to configure
	 */
	protected abstract void configureTable(TableViewer table);

	/**
	 * Returns the elements which are shown in the table initially. Return an
	 * empty array if the table should be empty. The given working set is the
	 * working set which will be configured by this dialog, or <b>null</b> if it
	 * does not yet exist.
	 *
	 * @param workingSet
	 *            the working set to configure or <b>null</b> if not yet exist
	 * @return the elements to show in the table
	 */
	protected abstract Object[] getInitialWorkingSetElements(IWorkingSet workingSet);

	/*
	 * @see
	 * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	@Override
    public void createControl(Composite parent) {
		initializeDialogUnits(parent);

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		setControl(composite);

		Label label = new Label(composite, SWT.WRAP);
		label.setText(Messages.TargetWorkingSetPage_workingSet_name);
		GridData gd = new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_CENTER);
		label.setLayoutData(gd);

		workingSetNameControl = new Text(composite, SWT.SINGLE | SWT.BORDER);
		workingSetNameControl.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		workingSetNameControl.addModifyListener(new ModifyListener() {
			@Override
            public void modifyText(ModifyEvent e) {
				validateInput();
			}
		});

		Composite leftCenterRightComposite = new Composite(composite, SWT.NONE);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.heightHint = convertHeightInCharsToPixels(20);
		leftCenterRightComposite.setLayoutData(gridData);
		GridLayout gridLayout = new GridLayout(3, false);
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		leftCenterRightComposite.setLayout(gridLayout);

		Composite leftComposite = new Composite(leftCenterRightComposite, SWT.NONE);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.widthHint = convertWidthInCharsToPixels(40);
		leftComposite.setLayoutData(gridData);
		gridLayout = new GridLayout(1, false);
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		leftComposite.setLayout(gridLayout);

		Composite centerComposite = new Composite(leftCenterRightComposite, SWT.NONE);
		gridLayout = new GridLayout(1, false);
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		centerComposite.setLayout(gridLayout);
		centerComposite.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false));

		Composite rightComposite = new Composite(leftCenterRightComposite, SWT.NONE);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.widthHint = convertWidthInCharsToPixels(40);
		rightComposite.setLayoutData(gridData);
		gridLayout = new GridLayout(1, false);
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		rightComposite.setLayout(gridLayout);

		createTree(leftComposite);
		createTable(rightComposite);

		if (workingSet != null)
			workingSetNameControl.setText(workingSet.getName());

		initializeSelectedElements();
		validateInput();

		table.setInput(selectedElements);
		table.refresh(true);
		tree.refresh(true);

		createButtonBar(centerComposite);

		workingSetNameControl.setFocus();
		workingSetNameControl.setSelection(0, workingSetNameControl.getText().length());

		Dialog.applyDialogFont(composite);
	}

	private void createTree(Composite parent) {

		Label label = new Label(parent, SWT.NONE);
		label.setLayoutData(new GridData(SWT.LEAD, SWT.CENTER, false, false));
		label.setText(Messages.TargetWorkingSetPage_workspace_content);

		tree = new TreeViewer(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI);
		tree.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		tree.addFilter(new AddedElementsFilter());
		tree.setUseHashlookup(true);

		configureTree(tree);

		treeContentProvider = (ITreeContentProvider) tree.getContentProvider();
	}

	private void createButtonBar(Composite parent) {
		Label spacer = new Label(parent, SWT.NONE);
		spacer.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		final Button addButton = new Button(parent, SWT.PUSH);
		addButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		addButton.setText(Messages.TargetWorkingSetPage_add_button);
		addButton.setEnabled(!tree.getSelection().isEmpty());

		final Button addAllButton = new Button(parent, SWT.PUSH);
		addAllButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		addAllButton.setText(Messages.TargetWorkingSetPage_addAll_button);
		addAllButton.setEnabled(tree.getTree().getItems().length > 0);

		final Button removeButton = new Button(parent, SWT.PUSH);
		removeButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		removeButton.setText(Messages.TargetWorkingSetPage_remove_button);
		removeButton.setEnabled(!table.getSelection().isEmpty());

		final Button removeAllButton = new Button(parent, SWT.PUSH);
		removeAllButton.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false));
		removeAllButton.setText(Messages.TargetWorkingSetPage_removeAll_button);
		removeAllButton.setEnabled(!selectedElements.isEmpty());

		tree.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
            public void selectionChanged(SelectionChangedEvent event) {
				addButton.setEnabled(!event.getSelection().isEmpty());
			}
		});

		addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				addTreeSelection();

				removeAllButton.setEnabled(true);
				addAllButton.setEnabled(tree.getTree().getItems().length > 0);
			}
		});

		tree.addDoubleClickListener(new IDoubleClickListener() {
			@Override
            public void doubleClick(DoubleClickEvent event) {
				addTreeSelection();

				removeAllButton.setEnabled(true);
				addAllButton.setEnabled(tree.getTree().getItems().length > 0);
			}
		});

		table.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
            public void selectionChanged(SelectionChangedEvent event) {
				removeButton.setEnabled(!event.getSelection().isEmpty());
			}
		});

		removeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				removeTableSelection();

				addAllButton.setEnabled(true);
				removeAllButton.setEnabled(!selectedElements.isEmpty());
			}
		});

		table.addDoubleClickListener(new IDoubleClickListener() {
			@Override
            public void doubleClick(DoubleClickEvent event) {
				removeTableSelection();

				addAllButton.setEnabled(true);
				removeAllButton.setEnabled(!selectedElements.isEmpty());
			}
		});

		addAllButton.addSelectionListener(new SelectionAdapter() {
			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				TreeItem[] items = tree.getTree().getItems();
				for (int i = 0; i < items.length; i++) {
					selectedElements.add(items[i].getData());
				}
				table.refresh();
				tree.refresh();

				addAllButton.setEnabled(false);
				removeAllButton.setEnabled(true);
			}
		});

		removeAllButton.addSelectionListener(new SelectionAdapter() {
			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				selectedElements.clear();

				table.refresh();
				tree.refresh();

				removeAllButton.setEnabled(false);
				addAllButton.setEnabled(true);
			}
		});

	}

	/**
	 * Moves selected elements in the tree into the table
	 */
	void addTreeSelection() {
		IStructuredSelection selection = (IStructuredSelection) tree.getSelection();
		selectedElements.addAll(selection.toList());
		Object[] selectedElements = selection.toArray();
		table.add(selectedElements);
		tree.remove(selectedElements);
		table.setSelection(selection);
		table.getControl().setFocus();
		validateInput();
	}

	/**
	 * Moves the selected elements in the table into the tree
	 */
	void removeTableSelection() {
		IStructuredSelection selection = (IStructuredSelection) table.getSelection();
		selectedElements.removeAll(selection.toList());
		Object[] selectedElements = selection.toArray();
		table.remove(selectedElements);
		try {
			tree.getTree().setRedraw(false);
			for (int i = 0; i < selectedElements.length; i++) {
				tree.refresh(treeContentProvider.getParent(selectedElements[i]), true);
			}
		} finally {
			tree.getTree().setRedraw(true);
		}
		tree.setSelection(selection);
		tree.getControl().setFocus();
		validateInput();
	}

	private void createTable(Composite parent) {
		Label label = new Label(parent, SWT.WRAP);
		label.setText(Messages.TargetWorkingSetPage_workingSet_content);
		label.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		table = new TableViewer(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI);

		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		table.getControl().setLayoutData(gd);

		table.setUseHashlookup(true);

		configureTable(table);

		table.setContentProvider(new IStructuredContentProvider() {

			@Override
            public Object[] getElements(Object inputElement) {
				return selectedElements.toArray();
			}

			@Override
            public void dispose() {
			}

			@Override
            public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}

		});
	}

	/*
	 * Implements method from IWorkingSetPage
	 */
	@Override
    public IWorkingSet getSelection() {
		return workingSet;
	}

	/*
	 * Implements method from IWorkingSetPage
	 */
	@Override
    public void setSelection(IWorkingSet workingSet) {
		Assert.isNotNull(workingSet, "Working set must not be null"); //$NON-NLS-1$
		this.workingSet = workingSet;
		if (getContainer() != null && getShell() != null && workingSetNameControl != null) {
			firstCheck = false;
			workingSetNameControl.setText(workingSet.getName());
			initializeSelectedElements();
			validateInput();
		}
	}

	/*
	 * Implements method from IWorkingSetPage
	 */
	@Override
    public void finish() {
		String workingSetName = workingSetNameControl.getText();

		List<IAdaptable> elements = new ArrayList<IAdaptable>();
		for (Object candidate : selectedElements) {
			if (candidate instanceof IWorkingSetElement) {
				WorkingSetElementHolder holder = new WorkingSetElementHolder(workingSetName, ((IWorkingSetElement)candidate).getElementId());
				holder.setElement((IWorkingSetElement)candidate);
				elements.add(holder);
			}
		}

		if (workingSet == null) {
			IWorkingSetManager workingSetManager = PlatformUI.getWorkbench().getWorkingSetManager();
			workingSet = workingSetManager.createWorkingSet(workingSetName, elements.toArray(new IAdaptable[elements.size()]));
			workingSet.setId(getPageId());
		} else {
			workingSet.setName(workingSetName);
			workingSet.setElements(elements.toArray(new IAdaptable[elements.size()]));
		}
	}

	void validateInput() {
		String errorMessage = null;
		String infoMessage = null;
		String newText = workingSetNameControl.getText();

		if (newText.equals(newText.trim()) == false)
			errorMessage = Messages.TargetWorkingSetPage_warning_nameWhitespace;
		if (newText.equals("")) { //$NON-NLS-1$
			if (firstCheck) {
				setPageComplete(false);
				firstCheck = false;
				return;
			}
			errorMessage = Messages.TargetWorkingSetPage_warning_nameMustNotBeEmpty;
		}

		firstCheck = false;

		if (errorMessage == null && (workingSet == null || newText.equals(workingSet.getName()) == false)) {
			IWorkingSet[] workingSets = PlatformUI.getWorkbench().getWorkingSetManager().getAllWorkingSets();
			for (int i = 0; i < workingSets.length; i++) {
				if (newText.equals(workingSets[i].getName())) {
					errorMessage = Messages.TargetWorkingSetPage_warning_workingSetExists;
				}
			}
		}

		if (!hasSelectedElement())
			infoMessage = Messages.TargetWorkingSetPage_warning_resourceMustBeChecked;

		setMessage(infoMessage, INFORMATION);
		setErrorMessage(errorMessage);
		setPageComplete(errorMessage == null);
	}

	private boolean hasSelectedElement() {
		return !selectedElements.isEmpty();
	}

	private void initializeSelectedElements() {
		selectedElements.addAll(Arrays.asList(getInitialWorkingSetElements(workingSet)));
	}

}
