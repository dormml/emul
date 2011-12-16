/*******************************************************************************
 * Copyright (c) 2008, 2010 Wind River Systems, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Wind River Systems - initial API and implementation
 *******************************************************************************/
package org.eclipse.tm.internal.tcf.debug.ui.model;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.tm.tcf.protocol.IToken;
import org.eclipse.tm.tcf.services.IExpressions;

public class TCFChildrenLocalVariables extends TCFChildren {

    private final TCFNodeStackFrame node;

    TCFChildrenLocalVariables(TCFNodeStackFrame node) {
        super(node, 128);
        this.node = node;
    }

    void onSuspended() {
        reset();
        for (TCFNode n : getNodes()) ((TCFNodeExpression)n).onSuspended();
    }

    void onRegisterValueChanged() {
        for (TCFNode n : getNodes()) ((TCFNodeExpression)n).onRegisterValueChanged();
    }

    void onMemoryChanged() {
        for (TCFNode n : getNodes()) ((TCFNodeExpression)n).onMemoryChanged();
    }

    void onMemoryMapChanged() {
        reset();
        for (TCFNode n : getNodes()) ((TCFNodeExpression)n).onMemoryMapChanged();
    }

    @Override
    protected boolean startDataRetrieval() {
        IExpressions exps = node.model.getLaunch().getService(IExpressions.class);
        if (exps == null || node.isEmulated()) {
            set(null, null, new HashMap<String,TCFNode>());
            return true;
        }
        TCFChildrenStackTrace stack_trace_cache = ((TCFNodeExecContext)node.parent).getStackTrace();
        if (!stack_trace_cache.validate(this)) return false; // node.getFrameNo() is not valid
        if (node.getFrameNo() < 0) {
            set(null, null, new HashMap<String,TCFNode>());
            return true;
        }
        assert command == null;
        command = exps.getChildren(node.id, new IExpressions.DoneGetChildren() {
            public void doneGetChildren(IToken token, Exception error, String[] contexts) {
                Map<String,TCFNode> data = null;
                if (command == token && error == null) {
                    int cnt = 0;
                    data = new HashMap<String,TCFNode>();
                    for (String id : contexts) {
                        TCFNodeExpression n = (TCFNodeExpression)node.model.getNode(id);
                        if (n == null) n = new TCFNodeExpression(node, null, null, id, null, -1, false);
                        assert n.id.equals(id);
                        assert n.parent == node;
                        n.setSortPosition(cnt++);
                        data.put(n.id, n);
                    }
                }
                set(token, error, data);
            }
        });
        return false;
    }
}
