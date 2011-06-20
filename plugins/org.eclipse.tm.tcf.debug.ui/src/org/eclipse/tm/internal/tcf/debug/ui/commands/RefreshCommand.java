package org.eclipse.tm.internal.tcf.debug.ui.commands;

import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.debug.ui.IDebugView;
import org.eclipse.tm.internal.tcf.debug.ui.model.TCFNode;
import org.eclipse.tm.tcf.util.TCFTask;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPartSite;

public class RefreshCommand extends AbstractActionDelegate {

    @Override
    protected void selectionChanged() {
        getAction().setEnabled(getRootNode() != null);
    }

    @Override
    protected void run() {
        final TCFNode n = getRootNode();
        if (n == null) return;
        new TCFTask<Object>(n.getChannel()) {
            public void run() {
                n.refresh(getView());
                done(null);
            }
        }.getE();
    }

    private TCFNode getRootNode() {
        IViewPart view = getView();
        if (view == null) return null;
        IWorkbenchPartSite site = view.getSite();
        if (site != null && IDebugUIConstants.ID_DEBUG_VIEW.equals(site.getId())) {
            TCFNode n = getSelectedNode();
            if (n == null) return null;
            return n.getModel().getRootNode();
        }
        if (view instanceof IDebugView) {
            Object input = ((IDebugView)view).getViewer().getInput();
            if (input instanceof TCFNode) return (TCFNode)input;
        }
        return null;
    }
}
