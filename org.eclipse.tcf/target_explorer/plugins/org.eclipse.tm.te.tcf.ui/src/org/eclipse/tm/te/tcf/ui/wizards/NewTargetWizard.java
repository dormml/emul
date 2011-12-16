/*******************************************************************************
 * Copyright (c) 2011 Wind River Systems, Inc. and others. All rights reserved.
 * This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Wind River Systems - initial API and implementation
 *******************************************************************************/
package org.eclipse.tm.te.tcf.ui.wizards;

import java.io.IOException;
import java.util.Map;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.tm.tcf.protocol.IPeer;
import org.eclipse.tm.tcf.protocol.Protocol;
import org.eclipse.tm.te.runtime.persistence.interfaces.IPersistenceService;
import org.eclipse.tm.te.runtime.services.ServiceManager;
import org.eclipse.tm.te.tcf.locator.interfaces.nodes.ILocatorModel;
import org.eclipse.tm.te.tcf.locator.interfaces.nodes.IPeerModel;
import org.eclipse.tm.te.tcf.locator.interfaces.services.ILocatorModelLookupService;
import org.eclipse.tm.te.tcf.locator.interfaces.services.ILocatorModelRefreshService;
import org.eclipse.tm.te.tcf.ui.model.Model;
import org.eclipse.tm.te.tcf.ui.nls.Messages;
import org.eclipse.tm.te.tcf.ui.wizards.pages.NewTargetWizardPage;
import org.eclipse.tm.te.ui.views.ViewsUtil;
import org.eclipse.tm.te.ui.views.interfaces.IUIConstants;
import org.eclipse.tm.te.ui.wizards.AbstractWizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

/**
 * New TCF target wizard implementation.
 */
public class NewTargetWizard extends AbstractWizard implements INewWizard {

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// Set the window title
		setWindowTitle(Messages.NewTargetWizard_windowTitle);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		// Create and add the wizard pages
		addPage(new NewTargetWizardPage());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		IWizardPage page = getPage(NewTargetWizardPage.class.getName());
		if (page instanceof NewTargetWizardPage) {
			// Trigger the saving of the widget history
			((NewTargetWizardPage)page).saveWidgetValues();
			// Get the peer attributes map from the page
			final Map<String, String> peerAttributes = ((NewTargetWizardPage)page).getPeerAttributes();
			if (peerAttributes != null) {
				try {
					// Save the new peer
					IPersistenceService persistenceService = ServiceManager.getInstance().getService(IPersistenceService.class);
					if (persistenceService == null) throw new IOException("Persistence service instance unavailable."); //$NON-NLS-1$
					persistenceService.write(peerAttributes);

					// Get the locator model
					final ILocatorModel model = Model.getModel();
					if (model != null) {
						// Trigger a refresh of the model to read in the newly created static peer
						final ILocatorModelRefreshService service = model.getService(ILocatorModelRefreshService.class);
						if (service != null) {
							Protocol.invokeLater(new Runnable() {
								@Override
								public void run() {
									// Refresh the model now (must be executed within the TCF dispatch thread)
									service.refresh();

									// Get the peer model node from the model and select it in the tree
									final IPeerModel peerNode = model.getService(ILocatorModelLookupService.class).lkupPeerModelById(peerAttributes.get(IPeer.ATTR_ID));
									if (peerNode != null) {
										ViewsUtil.setSelection(IUIConstants.ID_EXPLORER, new StructuredSelection(peerNode));
									}
								}
							});
						}
					}
				} catch (IOException e) {
					((NewTargetWizardPage)page).setMessage(NLS.bind(Messages.NewTargetWizard_error_savePeer, e.getLocalizedMessage()), IMessageProvider.ERROR);
					getContainer().updateMessage();
					return false;
				}
			}
		}

		return true;
	}

}
