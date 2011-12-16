/*******************************************************************************
 * Copyright (c) 2008, 2011 Wind River Systems, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Wind River Systems - initial API and implementation
 *******************************************************************************/
package org.eclipse.tm.internal.tcf.debug.ui.model;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IExpressionManager;
import org.eclipse.debug.core.model.IExpression;
import org.eclipse.debug.core.model.IWatchExpression;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IChildrenCountUpdate;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IChildrenUpdate;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IElementEditor;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IHasChildrenUpdate;
import org.eclipse.debug.internal.ui.viewers.model.provisional.ILabelUpdate;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IModelDelta;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IPresentationContext;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.tm.internal.tcf.debug.model.TCFContextState;
import org.eclipse.tm.internal.tcf.debug.ui.Activator;
import org.eclipse.tm.internal.tcf.debug.ui.ImageCache;
import org.eclipse.tm.tcf.protocol.IChannel;
import org.eclipse.tm.tcf.protocol.IToken;
import org.eclipse.tm.tcf.protocol.JSON;
import org.eclipse.tm.tcf.protocol.Protocol;
import org.eclipse.tm.tcf.services.IExpressions;
import org.eclipse.tm.tcf.services.IMemory;
import org.eclipse.tm.tcf.services.IMemory.MemoryError;
import org.eclipse.tm.tcf.services.IRegisters;
import org.eclipse.tm.tcf.services.ISymbols;
import org.eclipse.tm.tcf.util.TCFDataCache;
import org.eclipse.tm.tcf.util.TCFTask;

public class TCFNodeExpression extends TCFNode implements IElementEditor, ICastToType, IWatchInExpressions, IDetailsProvider {

    // TODO: User commands: Add Global Variables, Remove Global Variables
    // TODO: enable Change Value user command

    private final String script;
    private final int index;
    private final boolean deref;
    private final String field_id;
    private final String reg_id;
    private final TCFData<IExpressions.Expression> var_expression;
    private final TCFData<String> base_text;
    private final TCFData<Expression> expression;
    private final TCFData<IExpressions.Value> value;
    private final TCFData<ISymbols.Symbol> type;
    private final TCFData<String> type_name;
    private final TCFData<String> string;
    private final TCFData<String> expression_text;
    private final TCFChildrenSubExpressions children;
    private int sort_pos;
    private boolean enabled = true;
    private IExpressions.Value prev_value;
    private IExpressions.Value next_value;

    private static final RGB
        rgb_error = new RGB(192, 0, 0),
        rgb_highlight = new RGB(255, 255, 128),
        rgb_disabled = new RGB(127, 127, 127);

    private static int expr_cnt;

    private class Expression {

        final IExpressions.Expression expression;
        boolean must_be_disposed;

        Expression(IExpressions.Expression expression) {
            assert expression != null;
            this.expression = expression;
        }

        void dispose() {
            if (!must_be_disposed) return;
            if (channel.getState() == IChannel.STATE_OPEN) {
                IExpressions exps = channel.getRemoteService(IExpressions.class);
                exps.dispose(expression.getID(), new IExpressions.DoneDispose() {
                    public void doneDispose(IToken token, Exception error) {
                        if (error == null) return;
                        if (channel.getState() != IChannel.STATE_OPEN) return;
                        Activator.log("Error disposing remote expression evaluator", error);
                    }
                });
            }
            must_be_disposed = false;
        }
    }

    TCFNodeExpression(final TCFNode parent, final String script,
            final String field_id, final String var_id, final String reg_id,
            final int index, final boolean deref) {
        super(parent, var_id != null ? var_id : "Expr" + expr_cnt++);
        assert script != null || field_id != null || var_id != null || reg_id != null || index >= 0;
        this.script = script;
        this.field_id = field_id;
        this.reg_id = reg_id;
        this.index = index;
        this.deref = deref;
        var_expression = new TCFData<IExpressions.Expression>(channel) {
            @Override
            protected boolean startDataRetrieval() {
                IExpressions exps = launch.getService(IExpressions.class);
                if (exps == null || var_id == null) {
                    set(null, null, null);
                    return true;
                }
                command = exps.getContext(var_id, new IExpressions.DoneGetContext() {
                    public void doneGetContext(IToken token, Exception error, IExpressions.Expression context) {
                        set(token, error, context);
                    }
                });
                return false;
            }
        };
        base_text = new TCFData<String>(channel) {
            @Override
            protected boolean startDataRetrieval() {
                /* Compute expression script, not including type cast */
                if (script != null) {
                    set(null, null, script);
                    return true;
                }
                if (var_id != null) {
                    if (!var_expression.validate(this)) return false;
                    Throwable err = null;
                    String exp = null;
                    if (var_expression.getData() == null) {
                        err = var_expression.getError();
                    }
                    else {
                        exp = var_expression.getData().getExpression();
                        if (exp == null) err = new Exception("Missing 'Expression' property");
                    }
                    set(null, err, exp);
                    return true;
                }
                if (reg_id != null) {
                    set(null, null, "${" + reg_id + "}");
                    return true;
                }
                TCFNode n = parent;
                while (n instanceof TCFNodeArrayPartition) n = n.parent;
                TCFDataCache<String> t = ((TCFNodeExpression)n).base_text;
                if (!t.validate(this)) return false;
                String e = t.getData();
                if (e == null) {
                    set(null, t.getError(), null);
                    return true;
                }
                String cast = model.getCastToType(n.id);
                if (cast != null) e = "(" + cast + ")(" + e + ")";
                if (field_id != null) {
                    e = "(" + e + ")" + (deref ? "->" : ".") + "${" + field_id + "}";
                }
                else if (index == 0) {
                    e = "*(" + e + ")";
                }
                else if (index > 0) {
                    e = "(" + e + ")[" + index + "]";
                }
                set(null, null, e);
                return true;
            }
        };
        expression_text = new TCFData<String>(channel) {
            @Override
            protected boolean startDataRetrieval() {
                /* Compute human readable expression script,
                 * including type cast, and using variable names instead of IDs */
                String expr_text = null;
                if (script != null) {
                    expr_text = script;
                }
                else if (var_id != null) {
                    if (!var_expression.validate(this)) return false;
                    IExpressions.Expression e = var_expression.getData();
                    if (e != null) {
                        TCFDataCache<ISymbols.Symbol> var = model.getSymbolInfoCache(e.getSymbolID());
                        if (var != null) {
                            if (!var.validate(this)) return false;
                            if (var.getData() != null) expr_text = var.getData().getName();
                        }
                    }
                }
                else if (reg_id != null) {
                    if (!model.createNode(reg_id, this)) return false;
                    if (isValid()) return true;
                    TCFNodeRegister reg_node = (TCFNodeRegister)model.getNode(reg_id);
                    for (;;) {
                        TCFDataCache<IRegisters.RegistersContext> ctx_cache = reg_node.getContext();
                        if (!ctx_cache.validate(this)) return false;
                        IRegisters.RegistersContext ctx_data = ctx_cache.getData();
                        if (ctx_data == null) {
                            set(null, ctx_cache.getError(), null);
                            return true;
                        }
                        expr_text = expr_text == null ? ctx_data.getName() : ctx_data.getName() + "." + expr_text;
                        if (!(reg_node.parent instanceof TCFNodeRegister)) break;
                        reg_node = (TCFNodeRegister)reg_node.parent;
                    }
                    expr_text = "$" + expr_text;
                }
                else {
                    TCFDataCache<?> pending = null;
                    TCFDataCache<ISymbols.Symbol> field = model.getSymbolInfoCache(field_id);
                    if (field != null && !field.validate()) pending = field;
                    if (!base_text.validate()) pending = base_text;
                    if (pending != null) {
                        pending.wait(this);
                        return false;
                    }
                    String parent_text = "";
                    TCFNode n = parent;
                    while (n instanceof TCFNodeArrayPartition) n = n.parent;
                    TCFDataCache<String> parent_text_cache = ((TCFNodeExpression)n).expression_text;
                    if (!parent_text_cache.validate(this)) return false;
                    if (parent_text_cache.getData() != null) {
                        parent_text = parent_text_cache.getData();
                        // surround with parentheses if not a simple identifier
                        if (!parent_text.matches("\\w*")) {
                            parent_text = '(' + parent_text + ')';
                        }
                    }
                    if (index >= 0) {
                        if (index == 0 && deref) {
                            expr_text = "*" + parent_text;
                        }
                        else {
                            expr_text = parent_text + "[" + index + "]";
                        }
                    }
                    if (expr_text == null && field != null && field.getData() != null) {
                        expr_text = parent_text + (deref ? "->" : ".") + field.getData().getName();
                    }
                    if (expr_text == null && base_text.getData() != null) expr_text = base_text.getData();
                }
                if (expr_text != null) {
                    String cast = model.getCastToType(id);
                    if (cast != null) expr_text = "(" + cast + ")(" + expr_text + ")";
                }
                set(null, null, expr_text);
                return true;
            }
        };
        expression = new TCFData<Expression>(channel) {
            @Override
            protected boolean startDataRetrieval() {
                IExpressions exps = launch.getService(IExpressions.class);
                if (exps == null) {
                    set(null, null, null);
                    return true;
                }
                String cast = model.getCastToType(id);
                if (var_id != null && cast == null) {
                    if (!var_expression.validate(this)) return false;
                    Expression exp = null;
                    if (var_expression.getData() != null) exp = new Expression(var_expression.getData());
                    set(null, var_expression.getError(), exp);
                    return true;
                }
                if (!base_text.validate(this)) return false;
                String e = base_text.getData();
                if (e == null) {
                    set(null, base_text.getError(), null);
                    return true;
                }
                if (cast != null) e = "(" + cast + ")(" + e + ")";
                TCFNode n = getRootExpression().parent;
                if (n instanceof TCFNodeStackFrame && ((TCFNodeStackFrame)n).isEmulated()) n = n.parent;
                command = exps.create(n.id, null, e, new IExpressions.DoneCreate() {
                    public void doneCreate(IToken token, Exception error, IExpressions.Expression context) {
                        Expression e = null;
                        if (context != null) {
                            e = new Expression(context);
                            e.must_be_disposed = true;
                        }
                        if (!isDisposed()) set(token, error, e);
                        else if (e != null) e.dispose();
                    }
                });
                return false;
            }
            @Override
            public void cancel() {
                if (isValid() && getData() != null) getData().dispose();
                super.cancel();
            }
            @Override
            public void dispose() {
                if (isValid() && getData() != null) getData().dispose();
                super.dispose();
            }
        };
        value = new TCFData<IExpressions.Value>(channel) {
            @Override
            protected boolean startDataRetrieval() {
                Boolean b = usePrevValue(this);
                if (b == null) return false;
                if (b) {
                    set(null, null, prev_value);
                    return true;
                }
                if (!expression.validate(this)) return false;
                final Expression exp = expression.getData();
                if (exp == null) {
                    set(null, expression.getError(), null);
                    return true;
                }
                IExpressions exps = launch.getService(IExpressions.class);
                command = exps.evaluate(exp.expression.getID(), new IExpressions.DoneEvaluate() {
                    public void doneEvaluate(IToken token, Exception error, IExpressions.Value value) {
                        if (error != null) {
                            Boolean b = usePrevValue(null);
                            if (b != null && b) {
                                set(token, null, prev_value);
                                return;
                            }
                        }
                        set(token, error, value);
                    }
                });
                return false;
            }
            public void reset() {
                super.reset();
            }
        };
        type = new TCFData<ISymbols.Symbol>(channel) {
            @Override
            protected boolean startDataRetrieval() {
                String type_id = null;
                if (!value.validate(this)) return false;
                IExpressions.Value val = value.getData();
                if (val != null) type_id = val.getTypeID();
                if (type_id == null) {
                    if (!expression.validate(this)) return false;
                    Expression exp = expression.getData();
                    if (exp != null) type_id = exp.expression.getTypeID();
                }
                if (type_id == null) {
                    set(null, value.getError(), null);
                    return true;
                }
                TCFDataCache<ISymbols.Symbol> type_cache = model.getSymbolInfoCache(type_id);
                if (type_cache == null) {
                    set(null, null, null);
                    return true;
                }
                if (!type_cache.validate(this)) return false;
                set(null, type_cache.getError(), type_cache.getData());
                return true;
            }
        };
        string = new TCFData<String>(channel) {
            IMemory.MemoryContext mem;
            ISymbols.Symbol base_type_data;
            BigInteger addr;
            byte[] buf;
            int size;
            int offs;
            @Override
            protected boolean startDataRetrieval() {
                if (addr != null) {
                    if (mem == null) {
                        TCFDataCache<TCFNodeExecContext> mem_node_cache = model.searchMemoryContext(parent);
                        if (mem_node_cache == null) {
                            set(null, new Exception("Context does not provide memory access"), null);
                            return true;
                        }
                        if (!mem_node_cache.validate(this)) return false;
                        if (mem_node_cache.getError() != null) {
                            set(null, mem_node_cache.getError(), null);
                            return true;
                        }
                        TCFNodeExecContext mem_node = mem_node_cache.getData();
                        if (mem_node == null) {
                            set(null, new Exception("Context does not provide memory access"), null);
                            return true;
                        }
                        TCFDataCache<IMemory.MemoryContext> mem_ctx_cache = mem_node.getMemoryContext();
                        if (!mem_ctx_cache.validate(this)) return false;
                        if (mem_ctx_cache.getError() != null) {
                            set(null, mem_ctx_cache.getError(), null);
                            return true;
                        }
                        mem = mem_ctx_cache.getData();
                        if (mem == null) {
                            set(null, new Exception("Context does not provide memory access"), null);
                            return true;
                        }
                    }
                    if (size == 0) {
                        // data is ASCII string
                        if (buf == null) buf = new byte[256];
                        if (offs >= buf.length) {
                            byte[] tmp = new byte[buf.length * 2];
                            System.arraycopy(buf, 0, tmp, 0, buf.length);
                            buf = tmp;
                        }
                        command = mem.get(addr.add(BigInteger.valueOf(offs)), 1, buf, offs, 1, 0, new IMemory.DoneMemory() {
                            public void doneMemory(IToken token, MemoryError error) {
                                if (error != null) {
                                    set(command, error, null);
                                }
                                else if (buf[offs] == 0 || offs >= 2048) {
                                    set(command, null, toASCIIString(buf, 0, offs, '"'));
                                }
                                else if (command == token) {
                                    command = null;
                                    offs++;
                                    run();
                                }
                            }
                        });
                        return false;
                    }
                    // data is a struct
                    if (offs != size) {
                        if (buf == null || buf.length < size) buf = new byte[size];
                        command = mem.get(addr, 1, buf, 0, size, 0, new IMemory.DoneMemory() {
                            public void doneMemory(IToken token, MemoryError error) {
                                if (error != null) {
                                    set(command, error, null);
                                }
                                else if (command == token) {
                                    command = null;
                                    offs = size;
                                    run();
                                }
                            }
                        });
                        return false;
                    }
                    StyledStringBuffer bf = new StyledStringBuffer();
                    bf.append('{');
                    if (!appendCompositeValueText(bf, 1, base_type_data, buf, 0, size, mem.isBigEndian(), this)) return false;
                    bf.append('}');
                    set(null, null, bf.toString());
                    return true;
                }
                if (!type.validate(this)) return false;
                ISymbols.Symbol type_data = type.getData();
                if (type_data != null) {
                    switch (type_data.getTypeClass()) {
                    case pointer:
                    case array:
                        TCFDataCache<ISymbols.Symbol> base_type_cahce = model.getSymbolInfoCache(type_data.getBaseTypeID());
                        if (base_type_cahce != null) {
                            if (!base_type_cahce.validate(this)) return false;
                            base_type_data = base_type_cahce.getData();
                            if (base_type_data != null) {
                                offs = 0;
                                size = base_type_data.getSize();
                                switch (base_type_data.getTypeClass()) {
                                case integer:
                                case cardinal:
                                    if (base_type_data.getSize() != 1) break;
                                    size = 0; // read until character = 0
                                case composite:
                                    if (base_type_data.getSize() == 0) break;
                                    if (type_data.getTypeClass() == ISymbols.TypeClass.array &&
                                            base_type_data.getTypeClass() == ISymbols.TypeClass.composite) break;
                                    if (!value.validate(this)) return false;
                                    IExpressions.Value v = value.getData();
                                    if (v != null) {
                                        byte[] data = v.getValue();
                                        if (type_data.getTypeClass() == ISymbols.TypeClass.array) {
                                            set(null, null, toASCIIString(data, 0, data.length, '"'));
                                            return true;
                                        }
                                        BigInteger a = TCFNumberFormat.toBigInteger(data, 0, data.length, v.isBigEndian(), false);
                                        if (!a.equals(BigInteger.valueOf(0))) {
                                            addr = a;
                                            Protocol.invokeLater(this);
                                            return false;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case integer:
                    case cardinal:
                        if (type_data.getSize() == 1) {
                            if (!value.validate(this)) return false;
                            IExpressions.Value v = value.getData();
                            if (v != null) {
                                byte[] data = v.getValue();
                                set(null, null, toASCIIString(data, 0, data.length, '\''));
                                return true;
                            }
                        }
                        break;
                    }
                }
                set(null, null, null);
                return true;
            }
            @Override
            public void reset() {
                super.reset();
                mem = null;
                addr = null;
            }
        };
        type_name = new TCFData<String>(channel) {
            @Override
            protected boolean startDataRetrieval() {
                if (!type.validate(this)) return false;
                if (type.getData() == null) {
                    if (!value.validate(this)) return false;
                    IExpressions.Value val = value.getData();
                    if (val != null && val.getValue() != null) {
                        String s = getTypeName(val.getTypeClass(), val.getValue().length);
                        if (s != null) {
                            set(null, null, s);
                            return true;
                        }
                    }
                }
                StringBuffer bf = new StringBuffer();
                if (!getTypeName(bf, type, this)) return false;
                set(null, null, bf.toString());
                return true;
            }
        };
        children = new TCFChildrenSubExpressions(this, 0, 0, 0);
    }

    private TCFNodeExpression getRootExpression() {
        TCFNode n = this;
        while (n.parent instanceof TCFNodeExpression || n.parent instanceof TCFNodeArrayPartition) n = n.parent;
        return (TCFNodeExpression)n;
    }

    private void postAllChangedDelta() {
        TCFNodeExpression n = getRootExpression();
        for (TCFModelProxy p : model.getModelProxies()) {
            String id = p.getPresentationContext().getId();
            if (IDebugUIConstants.ID_EXPRESSION_VIEW.equals(id) && n.script != null ||
                        TCFModel.ID_EXPRESSION_HOVER.equals(id) && n.script != null ||
                    IDebugUIConstants.ID_VARIABLE_VIEW.equals(id) && n.script == null) {
                p.addDelta(this, IModelDelta.STATE | IModelDelta.CONTENT);
            }
        }
    }

    void onSuspended() {
        prev_value = next_value;
        if (expression.isValid() && expression.getError() != null) expression.reset();
        value.reset();
        type.reset();
        type_name.reset();
        string.reset();
        children.onSuspended();
        // No need to post delta: parent posted CONTENT
    }

    void onRegisterValueChanged() {
        value.reset();
        type.reset();
        type_name.reset();
        string.reset();
        children.onRegisterValueChanged();
        postAllChangedDelta();
    }

    void onMemoryChanged() {
        value.reset();
        type.reset();
        type_name.reset();
        string.reset();
        children.onMemoryChanged();
        if (parent instanceof TCFNodeExpression) return;
        if (parent instanceof TCFNodeArrayPartition) return;
        postAllChangedDelta();
    }

    void onMemoryMapChanged() {
        value.reset();
        type.reset();
        type_name.reset();
        string.reset();
        children.onMemoryMapChanged();
        if (parent instanceof TCFNodeExpression) return;
        if (parent instanceof TCFNodeArrayPartition) return;
        postAllChangedDelta();
    }

    void onValueChanged() {
        value.reset();
        type.reset();
        type_name.reset();
        string.reset();
        children.onValueChanged();
        postAllChangedDelta();
    }

    public void onCastToTypeChanged() {
        expression.cancel();
        value.cancel();
        type.cancel();
        type_name.cancel();
        string.cancel();
        expression_text.cancel();
        children.onCastToTypeChanged();
        postAllChangedDelta();
    }

    public String getScript() {
        return script;
    }

    String getFieldID() {
        return field_id;
    }

    String getRegisterID() {
        return reg_id;
    }

    int getIndex() {
        return index;
    }

    boolean isDeref() {
        return deref;
    }

    void setSortPosition(int sort_pos) {
        this.sort_pos = sort_pos;
    }

    void setEnabled(boolean enabled) {
        if (this.enabled == enabled) return;
        this.enabled = enabled;
        postAllChangedDelta();
    }

    /**
     * Get expression properties cache.
     * The cache is empty is the expression does not represent a variable.
     * @return The expression properties cache.
     */
    public TCFDataCache<IExpressions.Expression> getVariable() {
        return var_expression;
    }

    /**
     * Get expression value cache.
     * @return The expression value cache.
     */
    public TCFDataCache<IExpressions.Value> getValue() {
        return value;
    }

    /**
     * Get expression type cache.
     * @return The expression type cache.
     */
    public TCFDataCache<ISymbols.Symbol> getType() {
        return type;
    }

    /**
     * Get human readable expression script,
     * including type cast, and using variable names instead of IDs.
     */
    public TCFDataCache<String> getExpressionText() {
        return expression_text;
    }

    private Boolean usePrevValue(Runnable done) {
        // Check if view should show old value.
        // Old value is shown if context is running or
        // stack trace does not contain expression parent frame.
        // Return null if waiting for cache update.
        if (prev_value == null) return false;
        if (parent instanceof TCFNodeStackFrame) {
            TCFNodeExecContext exe = (TCFNodeExecContext)parent.parent;
            TCFDataCache<TCFContextState> state_cache = exe.getState();
            if (!state_cache.validate(done)) return null;
            TCFContextState state = state_cache.getData();
            if (state == null || !state.is_suspended) return true;
            TCFChildrenStackTrace stack_trace_cache = exe.getStackTrace();
            if (!stack_trace_cache.validate(done)) return null;
            if (stack_trace_cache.getData().get(parent.id) == null) return true;
        }
        else if (parent instanceof TCFNodeExecContext) {
            TCFNodeExecContext exe = (TCFNodeExecContext)parent;
            TCFDataCache<TCFContextState> state_cache = exe.getState();
            if (!state_cache.validate(done)) return null;
            TCFContextState state = state_cache.getData();
            if (state == null || !state.is_suspended) return true;
        }
        return false;
    }

    private String getTypeName(ISymbols.TypeClass type_class, int size) {
        String s = null;
        switch (type_class) {
        case integer:
            if (size == 0) s = "<Void>";
            else s = "<Integer-" + (size * 8) + ">";
            break;
        case cardinal:
            if (size == 0) s = "<Void>";
            else s = "<Unsigned-" + (size * 8) + ">";
            break;
        case real:
            if (size == 0) s = "<Void>";
            else s = "<Float-" + (size * 8) + ">";
            break;
        }
        return s;
    }

    private boolean getTypeName(StringBuffer bf, TCFDataCache<ISymbols.Symbol> type_cache, Runnable done) {
        String name = null;
        for (;;) {
            String s = null;
            boolean get_base_type = false;
            if (!type_cache.validate(done)) return false;
            ISymbols.Symbol type_symbol = type_cache.getData();
            if (type_symbol != null) {
                int flags = type_symbol.getFlags();
                s = type_symbol.getName();
                if (s != null && type_symbol.getTypeClass() == ISymbols.TypeClass.composite) {
                    if ((flags & ISymbols.SYM_FLAG_UNION_TYPE) != 0) s = "union " + s;
                    else if ((flags & ISymbols.SYM_FLAG_CLASS_TYPE) != 0) s = "class " + s;
                    else if ((flags & ISymbols.SYM_FLAG_INTERFACE_TYPE) != 0) s = "interface " + s;
                    else s = "struct " + s;
                }
                if (s == null) s = getTypeName(type_symbol.getTypeClass(), type_symbol.getSize());
                if (s == null) {
                    switch (type_symbol.getTypeClass()) {
                    case pointer:
                        s = "*";
                        if ((flags & ISymbols.SYM_FLAG_REFERENCE) != 0) s = "&";
                        get_base_type = true;
                        break;
                    case array:
                        s = "[" + type_symbol.getLength() + "]";
                        get_base_type = true;
                        break;
                    case composite:
                        s = "<Structure>";
                        break;
                    case function:
                        {
                            TCFDataCache<String[]> children_cache = model.getSymbolChildrenCache(type_symbol.getID());
                            if (!children_cache.validate(done)) return false;
                            if (children_cache.getError() == null) {
                                String[] children = children_cache.getData();
                                if (children != null) {
                                    StringBuffer args = new StringBuffer();
                                    if (name != null) {
                                        args.append('(');
                                        args.append(name);
                                        args.append(')');
                                        name = null;
                                    }
                                    args.append('(');
                                    for (String id : children) {
                                        if (id != children[0]) args.append(',');
                                        if (!getTypeName(args, model.getSymbolInfoCache(id), done)) return false;
                                    }
                                    args.append(')');
                                    s = args.toString();
                                    get_base_type = true;
                                    break;
                                }
                            }
                        }
                        s = "<Function>";
                        break;
                    }
                }
                if (s != null) {
                    if ((flags & ISymbols.SYM_FLAG_VOLATILE_TYPE) != 0) s = "volatile " + s;
                    if ((flags & ISymbols.SYM_FLAG_CONST_TYPE) != 0) s = "const " + s;
                }
            }
            if (s == null) {
                name = "N/A";
                break;
            }
            if (name == null) name = s;
            else if (!get_base_type) name = s + " " + name;
            else name = s + name;

            if (!get_base_type) break;

            type_cache = model.getSymbolInfoCache(type_symbol.getBaseTypeID());
            if (type_cache == null) {
                name = "N/A";
                break;
            }
        }
        bf.append(name);
        return true;
    }

    private String toASCIIString(byte[] data, int offs, int size, char quote_char) {
        StringBuffer bf = new StringBuffer();
        bf.append(quote_char);
        for (int i = 0; i < size; i++) {
            int ch = data[offs + i] & 0xff;
            if (ch >= ' ' && ch < 0x7f) {
                bf.append((char)ch);
            }
            else {
                switch (ch) {
                case '\r': bf.append("\\r"); break;
                case '\n': bf.append("\\n"); break;
                case '\b': bf.append("\\b"); break;
                case '\t': bf.append("\\t"); break;
                case '\f': bf.append("\\f"); break;
                default:
                    bf.append('\\');
                    bf.append((char)('0' + ch / 64));
                    bf.append((char)('0' + ch / 8 % 8));
                    bf.append((char)('0' + ch % 8));
                }
            }
        }
        if (data.length <= offs + size || data[offs + size] == 0) bf.append(quote_char);
        else bf.append("...");
        return bf.toString();
    }

    private String toNumberString(int radix, ISymbols.TypeClass t, byte[] data, int offs, int size, boolean big_endian) {
        if (size <= 0 || size > 16) return "";
        if (radix != 16) {
            switch (t) {
            case array:
            case composite:
                return "";
            }
        }
        String s = null;
        if (data == null) s = "N/A";
        if (s == null && radix == 10) {
            if (t != null) {
                switch (t) {
                case integer:
                    s = TCFNumberFormat.toBigInteger(data, offs, size, big_endian, true).toString();
                    break;
                case real:
                    s = TCFNumberFormat.toFPString(data, offs, size, big_endian);
                    break;
                }
            }
        }
        if (s == null) {
            s = TCFNumberFormat.toBigInteger(data, offs, size, big_endian, false).toString(radix);
            switch (radix) {
            case 8:
                if (!s.startsWith("0")) s = "0" + s;
                break;
            case 16:
                if (s.length() < size * 2) {
                    StringBuffer bf = new StringBuffer();
                    while (bf.length() + s.length() < size * 2) bf.append('0');
                    bf.append(s);
                    s = bf.toString();
                }
                break;
            }
        }
        if (s == null) s = "N/A";
        return s;
    }

    private String toNumberString(int radix) {
        String s = null;
        IExpressions.Value val = value.getData();
        if (val != null) {
            byte[] data = val.getValue();
            if (data != null) {
                ISymbols.TypeClass t = val.getTypeClass();
                if (t == ISymbols.TypeClass.unknown && type.getData() != null) t = type.getData().getTypeClass();
                s = toNumberString(radix, t, data, 0, data.length, val.isBigEndian());
            }
        }
        if (s == null) s = "N/A";
        return s;
    }

    private void setLabel(ILabelUpdate result, String name, int col, int radix) {
        String s = toNumberString(radix);
        if (name == null) {
            result.setLabel(s, col);
        }
        else {
            result.setLabel(name + " = " + s, col);
        }
    }

    private boolean isValueChanged(IExpressions.Value x, IExpressions.Value y) {
        if (x == null || y == null) return false;
        byte[] xb = x.getValue();
        byte[] yb = y.getValue();
        if (xb == null || yb == null) return false;
        if (xb.length != yb.length) return true;
        for (int i = 0; i < xb.length; i++) {
            if (xb[i] != yb[i]) return true;
        }
        return false;
    }

    @Override
    protected boolean getData(ILabelUpdate result, Runnable done) {
        if (enabled || script == null) {
            TCFDataCache<ISymbols.Symbol> field = model.getSymbolInfoCache(field_id);
            TCFDataCache<?> pending = null;
            if (field != null && !field.validate()) pending = field;
            if (reg_id != null && !expression_text.validate(done)) pending = expression_text;
            if (!var_expression.validate()) pending = var_expression;
            if (!base_text.validate()) pending = base_text;
            if (!value.validate()) pending = value;
            if (!type.validate()) pending = type;
            if (pending != null) {
                pending.wait(done);
                return false;
            }
            String name = null;
            if (index >= 0) {
                if (index == 0 && deref) {
                    name = "*";
                }
                else {
                    name = "[" + index + "]";
                }
            }
            if (name == null && field != null && field.getData() != null) name = field.getData().getName();
            if (name == null && reg_id != null && expression_text.getData() != null) name = expression_text.getData();
            if (name == null && var_expression.getData() != null) {
                TCFDataCache<ISymbols.Symbol> var = model.getSymbolInfoCache(var_expression.getData().getSymbolID());
                if (var != null) {
                    if (!var.validate(done)) return false;
                    ISymbols.Symbol var_data = var.getData();
                    if (var_data != null) {
                        name = var_data.getName();
                        if (name == null && var_data.getFlag(ISymbols.SYM_FLAG_VARARG)) name = "<VarArg>";
                        if (name == null) name = "<" + var_data.getID() + ">";
                    }
                }
            }
            if (name == null && base_text.getData() != null) name = base_text.getData();
            if (name != null) {
                String cast = model.getCastToType(id);
                if (cast != null) name = "(" + cast + ")(" + name + ")";
            }
            Throwable error = base_text.getError();
            if (error == null) error = value.getError();
            String[] cols = result.getColumnIds();
            if (error != null) {
                if (cols == null || cols.length <= 1) {
                    result.setForeground(rgb_error, 0);
                    result.setLabel(name + ": N/A", 0);
                }
                else {
                    for (int i = 0; i < cols.length; i++) {
                        String c = cols[i];
                        if (c.equals(TCFColumnPresentationExpression.COL_NAME)) {
                            result.setLabel(name, i);
                        }
                        else if (c.equals(TCFColumnPresentationExpression.COL_TYPE)) {
                            if (!type_name.validate(done)) return false;
                            result.setLabel(type_name.getData(), i);
                        }
                        else {
                            result.setForeground(rgb_error, i);
                            result.setLabel("N/A", i);
                        }
                    }
                }
            }
            else {
                if (cols == null) {
                    setLabel(result, name, 0, 16);
                }
                else {
                    for (int i = 0; i < cols.length; i++) {
                        String c = cols[i];
                        if (c.equals(TCFColumnPresentationExpression.COL_NAME)) {
                            result.setLabel(name, i);
                        }
                        else if (c.equals(TCFColumnPresentationExpression.COL_TYPE)) {
                            if (!type_name.validate(done)) return false;
                            result.setLabel(type_name.getData(), i);
                        }
                        else if (c.equals(TCFColumnPresentationExpression.COL_HEX_VALUE)) {
                            setLabel(result, null, i, 16);
                        }
                        else if (c.equals(TCFColumnPresentationExpression.COL_DEC_VALUE)) {
                            setLabel(result, null, i, 10);
                        }
                    }
                }
            }
            next_value = value.getData();
            if (isValueChanged(prev_value, next_value)) {
                result.setBackground(rgb_highlight, 0);
                if (cols != null) {
                    for (int i = 1; i < cols.length; i++) {
                        result.setBackground(rgb_highlight, i);
                    }
                }
            }
            ISymbols.TypeClass type_class = ISymbols.TypeClass.unknown;
            ISymbols.Symbol type_symbol = type.getData();
            if (type_symbol != null) {
                type_class = type_symbol.getTypeClass();
            }
            switch (type_class) {
            case pointer:
                result.setImageDescriptor(ImageCache.getImageDescriptor(ImageCache.IMG_VARIABLE_POINTER), 0);
                break;
            case composite:
            case array:
                result.setImageDescriptor(ImageCache.getImageDescriptor(ImageCache.IMG_VARIABLE_AGGREGATE), 0);
                break;
            default:
                result.setImageDescriptor(ImageCache.getImageDescriptor(ImageCache.IMG_VARIABLE), 0);
            }
        }
        else {
            String[] cols = result.getColumnIds();
            if (cols == null || cols.length <= 1) {
                result.setForeground(rgb_disabled, 0);
                result.setLabel(script, 0);
            }
            else {
                for (int i = 0; i < cols.length; i++) {
                    String c = cols[i];
                    if (c.equals(TCFColumnPresentationExpression.COL_NAME)) {
                        result.setForeground(rgb_disabled, i);
                        result.setLabel(script, i);
                    }
                }
            }
        }
        return true;
    }

    private void appendErrorText(StringBuffer bf, Throwable error) {
        if (error == null) return;
        bf.append("Exception: ");
        bf.append(TCFModel.getErrorMessage(error, true));
    }

    private boolean appendArrayValueText(StyledStringBuffer bf, int level, ISymbols.Symbol type,
            byte[] data, int offs, int size, boolean big_endian, Runnable done) {
        assert offs + size <= data.length;
        int length = type.getLength();
        bf.append('[');
        if (length > 0) {
            int elem_size = size / length;
            for (int n = 0; n < length; n++) {
                if (n >= 100) {
                    bf.append("...");
                    break;
                }
                if (n > 0) bf.append(", ");
                if (!appendValueText(bf, level + 1, type.getBaseTypeID(),
                        data, offs + n * elem_size, elem_size, big_endian, done)) return false;
            }
        }
        bf.append(']');
        return true;
    }

    private boolean appendCompositeValueText(StyledStringBuffer bf, int level, ISymbols.Symbol type,
            byte[] data, int offs, int size, boolean big_endian, Runnable done) {
        TCFDataCache<String[]> children_cache = model.getSymbolChildrenCache(type.getID());
        if (children_cache == null) {
            bf.append("...");
            return true;
        }
        if (!children_cache.validate(done)) return false;
        String[] children_data = children_cache.getData();
        if (children_data == null) {
            bf.append("...");
            return true;
        }
        int cnt = 0;
        TCFDataCache<?> pending = null;
        for (String id : children_data) {
            TCFDataCache<ISymbols.Symbol> field_cache = model.getSymbolInfoCache(id);
            if (!field_cache.validate()) {
                pending = field_cache;
                continue;
            }
            ISymbols.Symbol field_data = field_cache.getData();
            if (field_data == null) continue;
            if (field_data.getSymbolClass() != ISymbols.SymbolClass.reference) continue;
            String name = field_data.getName();
            int f_offs = field_data.getOffset();
            int f_size = field_data.getSize();
            if (name == null) {
                // Super-class members
                if (offs + f_offs + f_size > data.length) {
                    continue;
                }
                else {
                    StyledStringBuffer bf1 = new StyledStringBuffer();
                    if (!appendCompositeValueText(bf1, level, field_data, data,
                            offs + f_offs, f_size, big_endian, done)) return false;
                    if (bf1.length() > 0) {
                        if (cnt > 0) bf.append(", ");
                        bf.append(bf1);
                        cnt++;
                    }
                }
            }
            else {
                if (cnt > 0) bf.append(", ");
                bf.append(name);
                bf.append('=');
                if (offs + f_offs + f_size > data.length) {
                    bf.append('?');
                }
                else {
                    if (!appendValueText(bf, level + 1, field_data.getTypeID(),
                            data, offs + f_offs, f_size, big_endian, done)) return false;
                }
                cnt++;
            }
        }
        if (pending == null) return true;
        pending.wait(done);
        return false;
    }

    private boolean appendValueText(StyledStringBuffer bf, int level, String type_id,
            byte[] data, int offs, int size, boolean big_endian, Runnable done) {
        if (data == null) return true;
        ISymbols.Symbol type_data = null;
        if (type_id != null) {
            TCFDataCache<ISymbols.Symbol> type_cache = model.getSymbolInfoCache(type_id);
            if (!type_cache.validate(done)) return false;
            type_data = type_cache.getData();
        }
        if (type_data == null) {
            ISymbols.TypeClass type_class = ISymbols.TypeClass.unknown;
            if (!value.validate(done)) return false;
            if (value.getData() != null) type_class = value.getData().getTypeClass();
            if (level == 0) {
                assert offs == 0;
                assert size == data.length;
                String s = getTypeName(type_class, size);
                if (s == null) s = "not available";
                bf.append("Type: ", SWT.BOLD);
                bf.append(s);
                bf.append('\n');
                bf.append("Size: ", SWT.BOLD);
                bf.append(size);
                bf.append(size == 1 ? " byte\n" : " bytes\n");
                if (size > 0) {
                    if (type_class == ISymbols.TypeClass.integer || type_class == ISymbols.TypeClass.real) {
                        bf.append("Dec: ", SWT.BOLD);
                        bf.append(toNumberString(10, type_class, data, offs, size, big_endian));
                        bf.append("\n");
                    }
                    bf.append("Hex: ", SWT.BOLD);
                    bf.append(toNumberString(16, type_class, data, offs, size, big_endian));
                    bf.append("\n");
                }
            }
            else if (type_class == ISymbols.TypeClass.integer || type_class == ISymbols.TypeClass.real) {
                bf.append(toNumberString(10, type_class, data, offs, size, big_endian));
            }
            else {
                bf.append(toNumberString(16, type_class, data, offs, size, big_endian));
            }
            return true;
        }
        if (level == 0) {
            if (!string.validate(done)) return false;
            Throwable e = string.getError();
            String s = string.getData();
            if (s != null) {
                bf.append(s);
                bf.append("\n");
            }
            else if (e != null) {
                bf.append("Cannot read pointed value: ", SWT.BOLD, null, rgb_error);
                bf.append(TCFModel.getErrorMessage(e, true), SWT.ITALIC, null, rgb_error);
            }
        }
        if (type_data.getSize() > 0) {
            ISymbols.TypeClass type_class = type_data.getTypeClass();
            switch (type_class) {
            case enumeration:
            case integer:
            case cardinal:
            case real:
                if (level == 0) {
                    bf.append("Dec: ", SWT.BOLD);
                    bf.append(toNumberString(10, type_class, data, offs, size, big_endian));
                    bf.append("\n");
                    bf.append("Oct: ", SWT.BOLD);
                    bf.append(toNumberString(8, type_class, data, offs, size, big_endian));
                    bf.append("\n");
                    bf.append("Hex: ", SWT.BOLD);
                    bf.append(toNumberString(16, type_class, data, offs, size, big_endian));
                    bf.append("\n");
                }
                else if (type_data.getTypeClass() == ISymbols.TypeClass.cardinal) {
                    bf.append("0x");
                    bf.append(toNumberString(16, type_class, data, offs, size, big_endian));
                }
                else {
                    bf.append(toNumberString(10, type_class, data, offs, size, big_endian));
                }
                break;
            case pointer:
            case function:
                if (level == 0) {
                    bf.append("Oct: ", SWT.BOLD);
                    bf.append(toNumberString(8, type_class, data, offs, size, big_endian));
                    bf.append("\n");
                    bf.append("Hex: ", SWT.BOLD);
                    bf.append(toNumberString(16, type_class, data, offs, size, big_endian));
                    bf.append("\n");
                }
                else {
                    bf.append("0x");
                    bf.append(toNumberString(16, type_class, data, offs, size, big_endian));
                }
                break;
            case array:
                if (!appendArrayValueText(bf, level, type_data, data, offs, size, big_endian, done)) return false;
                if (level == 0) bf.append("\n");
                break;
            case composite:
                bf.append('{');
                if (!appendCompositeValueText(bf, level, type_data, data, offs, size, big_endian, done)) return false;
                bf.append('}');
                if (level == 0) bf.append("\n");
                break;
            }
        }
        if (level == 0) {
            if (!type_name.validate(done)) return false;
            String nm = type_name.getData();
            if (nm != null) {
                bf.append("Type: ", SWT.BOLD);
                bf.append(nm);
                bf.append("\n");
            }
            bf.append("Size: ", SWT.BOLD);
            bf.append(type_data.getSize());
            bf.append(type_data.getSize() == 1 ? " byte\n" : " bytes\n");
        }
        return true;
    }

    private String getRegisterName(String reg_id, Runnable done) {
        String name = reg_id;
        TCFDataCache<?> pending = null;
        TCFNodeRegister reg_node = null;
        LinkedList<TCFChildren> queue = new LinkedList<TCFChildren>();
        TCFNode n = parent;
        while (n != null) {
            if (n instanceof TCFNodeStackFrame) {
                queue.add(((TCFNodeStackFrame)n).getRegisters());
            }
            if (n instanceof TCFNodeExecContext) {
                queue.add(((TCFNodeExecContext)n).getRegisters());
                break;
            }
            n = n.parent;
        }
        while (!queue.isEmpty()) {
            TCFChildren reg_list = queue.removeFirst();
            if (!reg_list.validate()) {
                pending = reg_list;
            }
            else {
                Map<String,TCFNode> reg_map = reg_list.getData();
                if (reg_map != null) {
                    reg_node = (TCFNodeRegister)reg_map.get(reg_id);
                    if (reg_node != null) break;
                    for (TCFNode node : reg_map.values()) {
                        queue.add(((TCFNodeRegister)node).getChildren());
                    }
                }
            }
        }
        if (pending != null) {
            pending.wait(done);
            return null;
        }
        if (reg_node != null) {
            TCFDataCache<IRegisters.RegistersContext> reg_ctx_cache = reg_node.getContext();
            if (!reg_ctx_cache.validate(done)) return null;
            IRegisters.RegistersContext reg_ctx_data = reg_ctx_cache.getData();
            if (reg_ctx_data != null && reg_ctx_data.getName() != null) name = reg_ctx_data.getName();
        }
        return name;
    }

    public boolean getDetailText(StyledStringBuffer bf, Runnable done) {
        if (!enabled) {
            bf.append("Disabled");
            return true;
        }
        if (!expression.validate(done)) return false;
        if (!value.validate(done)) return false;
        int pos = bf.length();
        appendErrorText(bf.getStringBuffer(), expression.getError());
        if (bf.length() == pos) appendErrorText(bf.getStringBuffer(), value.getError());
        if (bf.length() > pos) {
            bf.append(pos, 0, null, rgb_error);
        }
        else {
            IExpressions.Value v = value.getData();
            if (v != null) {
                byte[] data = v.getValue();
                if (data != null) {
                    boolean big_endian = v.isBigEndian();
                    if (!appendValueText(bf, 0, v.getTypeID(),
                            data, 0, data.length, big_endian, done)) return false;
                }
                String reg_id = v.getRegisterID();
                if (reg_id != null) {
                    String nm = getRegisterName(reg_id, done);
                    if (nm == null) return false;
                    bf.append("Register: ", SWT.BOLD);
                    bf.append(nm);
                    bf.append('\n');
                }
                Number addr = v.getAddress();
                if (addr != null) {
                    BigInteger i = JSON.toBigInteger(addr);
                    bf.append("Address: ", SWT.BOLD);
                    bf.append("0x");
                    bf.append(i.toString(16));
                    bf.append('\n');
                }
            }
        }
        return true;
    }

    public String getValueText(boolean add_error_text, Runnable done) {
        if (!expression.validate(done)) return null;
        if (!value.validate(done)) return null;
        StyledStringBuffer bf = new StyledStringBuffer();
        IExpressions.Value v = value.getData();
        if (v != null) {
            byte[] data = v.getValue();
            if (data != null) {
                boolean big_endian = v.isBigEndian();
                if (!appendValueText(bf, 1, v.getTypeID(),
                        data, 0, data.length, big_endian, done)) return null;
            }
        }
        if (add_error_text) {
            if (bf.length() == 0 && expression.getError() != null) {
                bf.append(TCFModel.getErrorMessage(expression.getError(), false));
            }
            if (bf.length() == 0 && value.getError() != null) {
                bf.append(TCFModel.getErrorMessage(value.getError(), false));
            }
        }
        return bf.toString();
    }

    @Override
    protected boolean getData(IChildrenCountUpdate result, Runnable done) {
        if (enabled) {
            if (!children.validate(done)) return false;
            result.setChildCount(children.size());
        }
        else {
            result.setChildCount(0);
        }
        return true;
    }

    @Override
    protected boolean getData(IChildrenUpdate result, Runnable done) {
        if (!enabled) return true;
        return children.getData(result, done);
    }

    @Override
    protected boolean getData(IHasChildrenUpdate result, Runnable done) {
        if (enabled) {
            if (!children.validate(done)) return false;
            result.setHasChilren(children.size() > 0);
        }
        else {
            result.setHasChilren(false);
        }
        return true;
    }

    @Override
    public int compareTo(TCFNode n) {
        TCFNodeExpression e = (TCFNodeExpression)n;
        if (sort_pos < e.sort_pos) return -1;
        if (sort_pos > e.sort_pos) return +1;
        return 0;
    }

    public CellEditor getCellEditor(IPresentationContext context, String column_id, Object element, Composite parent) {
        assert element == this;
        if (TCFColumnPresentationExpression.COL_NAME.equals(column_id) && script != null) {
            return new TextCellEditor(parent);
        }
        if (TCFColumnPresentationExpression.COL_HEX_VALUE.equals(column_id)) {
            return new TextCellEditor(parent);
        }
        if (TCFColumnPresentationExpression.COL_DEC_VALUE.equals(column_id)) {
            return new TextCellEditor(parent);
        }
        return null;
    }

    private static final ICellModifier cell_modifier = new ICellModifier() {

        public boolean canModify(Object element, final String property) {
            final TCFNodeExpression node = (TCFNodeExpression)element;
            return new TCFTask<Boolean>() {
                public void run() {
                    if (TCFColumnPresentationExpression.COL_NAME.equals(property)) {
                        done(node.script != null);
                        return;
                    }
                    if (node.enabled) {
                        if (!node.expression.validate(this)) return;
                        if (node.expression.getData() != null && node.expression.getData().expression.canAssign()) {
                            if (!node.value.validate(this)) return;
                            if (!node.type.validate(this)) return;
                            if (TCFColumnPresentationExpression.COL_HEX_VALUE.equals(property)) {
                                done(TCFNumberFormat.isValidHexNumber(node.toNumberString(16)) == null);
                                return;
                            }
                            if (TCFColumnPresentationExpression.COL_DEC_VALUE.equals(property)) {
                                done(TCFNumberFormat.isValidDecNumber(true, node.toNumberString(10)) == null);
                                return;
                            }
                        }
                    }
                    done(Boolean.FALSE);
                }
            }.getE();
        }

        public Object getValue(Object element, final String property) {
            final TCFNodeExpression node = (TCFNodeExpression)element;
            return new TCFTask<String>() {
                public void run() {
                    if (TCFColumnPresentationExpression.COL_NAME.equals(property)) {
                        done(node.script);
                        return;
                    }
                    if (!node.value.validate(this)) return;
                    if (node.value.getData() != null) {
                        if (TCFColumnPresentationExpression.COL_HEX_VALUE.equals(property)) {
                            done(node.toNumberString(16));
                            return;
                        }
                        if (TCFColumnPresentationExpression.COL_DEC_VALUE.equals(property)) {
                            done(node.toNumberString(10));
                            return;
                        }
                    }
                    done(null);
                }
            }.getE();
        }

        public void modify(Object element, final String property, final Object value) {
            if (value == null) return;
            final TCFNodeExpression node = (TCFNodeExpression)element;
            new TCFTask<Boolean>() {
                public void run() {
                    try {
                        if (TCFColumnPresentationExpression.COL_NAME.equals(property)) {
                            if (!node.script.equals(value)) {
                                IExpressionManager m = DebugPlugin.getDefault().getExpressionManager();
                                for (final IExpression e : m.getExpressions()) {
                                    if (node.script.equals(e.getExpressionText())) m.removeExpression(e);
                                }
                                IExpression e = m.newWatchExpression((String)value);
                                m.addExpression(e);
                            }
                            done(Boolean.TRUE);
                            return;
                        }
                        if (!node.expression.validate(this)) return;
                        if (node.expression.getData() != null) {
                            IExpressions.Expression exp = node.expression.getData().expression;
                            if (exp.canAssign()) {
                                byte[] bf = null;
                                int size = exp.getSize();
                                boolean is_float = false;
                                boolean big_endian = false;
                                boolean signed = false;
                                if (!node.value.validate(this)) return;
                                IExpressions.Value eval = node.value.getData();
                                if (eval != null) {
                                    switch(eval.getTypeClass()) {
                                    case real:
                                        is_float = true;
                                    case integer:
                                        signed = true;
                                        break;
                                    }
                                    big_endian = eval.isBigEndian();
                                    size = eval.getValue().length;
                                }
                                String input = (String)value;
                                String error = null;
                                if (TCFColumnPresentationExpression.COL_HEX_VALUE.equals(property)) {
                                    error = TCFNumberFormat.isValidHexNumber(input);
                                    if (error == null) bf = TCFNumberFormat.toByteArray(input, 16, false, size, signed, big_endian);
                                }
                                else if (TCFColumnPresentationExpression.COL_DEC_VALUE.equals(property)) {
                                    error = TCFNumberFormat.isValidDecNumber(is_float, input);
                                    if (error == null) bf = TCFNumberFormat.toByteArray(input, 10, is_float, size, signed, big_endian);
                                }
                                if (error != null) throw new Exception("Invalid value: " + value, new Exception(error));
                                if (bf != null) {
                                    IExpressions exps = node.launch.getService(IExpressions.class);
                                    exps.assign(exp.getID(), bf, new IExpressions.DoneAssign() {
                                        public void doneAssign(IToken token, Exception error) {
                                            node.getRootExpression().onValueChanged();
                                            if (error != null) {
                                                node.model.showMessageBox("Cannot modify element value", error);
                                                done(Boolean.FALSE);
                                            }
                                            else {
                                                done(Boolean.TRUE);
                                            }
                                        }
                                    });
                                    return;
                                }
                            }
                        }
                        done(Boolean.FALSE);
                    }
                    catch (Throwable x) {
                        node.model.showMessageBox("Cannot modify element value", x);
                        done(Boolean.FALSE);
                    }
                }
            }.getE();
        }
    };

    public ICellModifier getCellModifier(IPresentationContext context, Object element) {
        assert element == this;
        return cell_modifier;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Object getAdapter(Class adapter) {
        if (script != null) {
            if (adapter == IExpression.class) {
                IExpressionManager m = DebugPlugin.getDefault().getExpressionManager();
                for (final IExpression e : m.getExpressions()) {
                    if (script.equals(e.getExpressionText())) return e;
                }
            }
            if (adapter == IWatchExpression.class) {
                IExpressionManager m = DebugPlugin.getDefault().getExpressionManager();
                for (final IExpression e : m.getExpressions()) {
                    if (e instanceof IWatchExpression && script.equals(e.getExpressionText())) return e;
                }
            }
        }
        return super.getAdapter(adapter);
    }
}
