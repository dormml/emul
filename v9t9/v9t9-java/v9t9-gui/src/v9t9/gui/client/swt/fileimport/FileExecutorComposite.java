/*
  FileExecutorComposite.java

  (c) 2013 Ed Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package v9t9.gui.client.swt.fileimport;

import java.util.Collections;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import v9t9.common.files.Catalog;
import v9t9.common.files.IFileExecutionHandler;
import v9t9.common.files.IFileExecutor;
import v9t9.common.machine.IMachine;

/**
 * Allow selecting a {@link IFileExecutor}
 * @author ejs
 *
 */
public class FileExecutorComposite extends Composite {
	
	private static String lastExecLabel;

	private IFileExecutor[] execs;
	private IFileExecutionHandler execHandler;
	protected IFileExecutor selectedExec;
	private ComboViewer execComboViewer;
	private IMachine machine;
	private Text descrText;

	public FileExecutorComposite(Composite parent,  
			IMachine machine) {
		super(parent, SWT.NONE);
		this.machine = machine;
		this.execHandler = machine.getEmulatedFileHandler().getFileExecutionHandler();
		
		Composite composite = this;
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(composite);
		//GridDataFactory.fillDefaults().grab(true, true).applyTo(composite);
		
		Label label;
		label = new Label(composite, SWT.WRAP);
		label.setText("Action:");
		GridDataFactory.fillDefaults().align(SWT.LEFT, SWT.CENTER).grab(false, false).applyTo(label);
		
		execComboViewer = new ComboViewer(composite, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(execComboViewer.getControl());
		execComboViewer.setLabelProvider(new LabelProvider() {
			/* (non-Javadoc)
			 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
			 */
			@Override
			public String getText(Object element) {
				if (element instanceof IFileExecutor) {
					IFileExecutor exec = (IFileExecutor) element;
					return exec.getLabel();
				}
				return element.toString();
			}
		}) ;
		execComboViewer.setContentProvider(new ArrayContentProvider());

		label = new Label(composite, SWT.WRAP);
		GridDataFactory.fillDefaults().grab(false, false).span(2, 1).applyTo(label);
		label.setText("Description:");
		
		descrText = new Text(composite, SWT.READ_ONLY | SWT.BORDER | SWT.MULTI | SWT.WRAP | SWT.V_SCROLL) ;
		GridDataFactory.fillDefaults().grab(false, true).span(2, 1).indent(6, 0).minSize(-1, 96).applyTo(descrText);

		descrText.setBackground(composite.getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
		
		execComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				Object firstElement = ((IStructuredSelection) event.getSelection()).getFirstElement();
				if (firstElement instanceof IFileExecutor) {
					IFileExecutor exec = (IFileExecutor) 
							firstElement;
					selectedExec = exec;
					descrText.setText(exec.getDescription());
					descrText.setEnabled(true);
					lastExecLabel = exec.getLabel();
				} else {
					descrText.setText("");
					descrText.setEnabled(false);
				}
			}
		});


		execComboViewer.setInput(Collections.emptyList());
	}
	
	/**
	 * 
	 */
	public void updateExecs(int drive, Catalog catalog, boolean doNothing) {
		boolean any = false;
		if (catalog != null) {
			execs = execHandler.analyze(machine, drive, catalog);
			
			if (doNothing) {
				IFileExecutor[] allExecs = new IFileExecutor[execs.length + 1];
				allExecs[0] = new DoNothingFileExecutor(catalog.getDisk(), "Do nothing (just load disk)");
				System.arraycopy(execs, 0, allExecs, 1, execs.length);
				execs = allExecs;
			}
			
			if (selectedExec != null) {
				boolean found = false;
				for (IFileExecutor e : execs) {
					if (e.getLabel().equals(selectedExec.getLabel())) {
						selectedExec = e;
						found = true;
						break;
					}
				}
				if (!found) {
					selectedExec = null;
				}
			}
			execComboViewer.setInput(execs);
			
			if (selectedExec == null) {
				if (lastExecLabel != null) {
					for (IFileExecutor exec : execs) {
						if (exec.getLabel().equals(lastExecLabel)) {
							selectedExec = exec;
							break;
						}
					}
				}
				if (selectedExec == null) {
					if (doNothing)
						selectedExec = execs.length < 2 ? execs[0] : execs[1];
					else
						selectedExec = execs.length > 0 ? execs[0] : null;
				}
			}
			if (selectedExec != null) {
				any = true;
				execComboViewer.setSelection(new StructuredSelection(selectedExec));
				descrText.setText(selectedExec.getDescription());
				descrText.setEnabled(true);
			}
			else {
				any = false;
			}
		} else {
			execs = null;
			any = false;
		}
		if (!any) {
			selectedExec = null;
			String nothing = "Nothing to do";
			execComboViewer.setInput(Collections.singletonList(nothing));
			execComboViewer.setSelection(new StructuredSelection(nothing));
			descrText.setText("No actions available");
			descrText.setEnabled(false);
		}				
		
		execComboViewer.getControl().setEnabled(execs != null && execs.length > 1);
		
	}

	public IFileExecutor getFileExecutor() {
		return selectedExec;
	}
	
}