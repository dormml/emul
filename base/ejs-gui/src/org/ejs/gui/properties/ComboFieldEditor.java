/*
  ComboFieldEditor.java

  (c) 2010-2012 Edward Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package org.ejs.gui.properties;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import ejs.base.properties.FieldProperty;


/**
 * @author ejs
 *
 */
public class ComboFieldEditor extends FieldPropertyEditor {

	private final String[] strings;
	private Combo combo;

	/**
	 * @param strings
	 */
	public ComboFieldEditor(FieldProperty property, String[] strings) {
		super(property);
		this.strings = strings;
		
	}
	/* (non-Javadoc)
	 * 
	 */
	public IPropertyEditorControl createEditor(Composite parent) {
		combo = new Combo(parent, SWT.BORDER);
		combo.setItems(strings);
		try {
			combo.setText(""+strings[(Integer)getValue()]);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		final SelectionAdapter selectionListener = new SelectionAdapter() {
			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				change();
			}
			
			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				change();
			}
		};
		combo.addSelectionListener(selectionListener);
		
		final ModifyListener modifyListener = new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				change();
			}
			
		};
		combo.addModifyListener(modifyListener);
		
		return new IPropertyEditorControl() {

			@Override
			public Control getControl() {
				return combo;
			}

			@Override
			public void reset() {
				combo.removeSelectionListener(selectionListener);
				combo.removeModifyListener(modifyListener);
				
				combo.select(property.getInt());

				combo.addSelectionListener(selectionListener);
				combo.addModifyListener(modifyListener);
			}
			
		};
		
	}
	private void change() {
		int index = combo.getSelectionIndex();
		if (index >= 0) {
			try {
				setValue(index);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}				
	}
}
