/*******************************************************************************
 * Copyright (c) 2007, 2010 Wind River Systems, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Wind River Systems - initial API and implementation
 *******************************************************************************/
package org.eclipse.tm.tcf.core;

import java.io.IOException;

import org.eclipse.tm.tcf.protocol.IPeer;

/**
 * Abstract implementation of IChannel interface for stream oriented transport protocols.
 *
 * StreamChannel implements communication link connecting two end points (peers).
 * The channel asynchronously transmits messages: commands, results and events.
 *
 * StreamChannel uses escape sequences to represent End-Of-Message and End-Of-Stream markers.
 *
 * Clients can subclass StreamChannel to support particular stream oriented transport (wire) protocol.
 * Also, see ChannelTCP for a concrete IChannel implementation that works on top of TCP sockets as a transport.
 */
public abstract class StreamChannel extends AbstractChannel {

    public static final int ESC = 3;

    private int bin_data_size;

    private final byte[] buf = new byte[0x1000];
    private int buf_pos;
    private int buf_len;

    public StreamChannel(IPeer remote_peer) {
        super(remote_peer);
    }

    public StreamChannel(IPeer local_peer, IPeer remote_peer) {
        super(local_peer, remote_peer);
    }

    protected abstract int get() throws IOException;
    protected abstract void put(int n) throws IOException;

    protected int get(byte[] buf) throws IOException {
        int i = 0;
        while (i < buf.length) {
            int b = get();
            if (b < 0) {
                if (i == 0) return -1;
                break;
            }
            buf[i++] = (byte)b;
            if (i >= bin_data_size) break;
        }
        return i;
    }

    protected void put(byte[] buf) throws IOException {
        for (byte b : buf) put(b & 0xff);
    }

    @Override
    protected final int read() throws IOException {
        for (;;) {
            while (buf_pos >= buf_len) {
                buf_len = get(buf);
                buf_pos = 0;
                if (buf_len < 0) return EOS;
            }
            int res = buf[buf_pos++] & 0xff;
            if (bin_data_size > 0) {
                bin_data_size--;
                return res;
            }
            if (res != ESC) return res;
            while (buf_pos >= buf_len) {
                buf_len = get(buf);
                buf_pos = 0;
                if (buf_len < 0) return EOS;
            }
            int n = buf[buf_pos++] & 0xff;
            switch (n) {
            case 0: return ESC;
            case 1: return EOM;
            case 2: return EOS;
            case 3:
                for (int i = 0;; i += 7) {
                    while (buf_pos >= buf_len) {
                        buf_len = get(buf);
                        buf_pos = 0;
                        if (buf_len < 0) return EOS;
                    }
                    int m = buf[buf_pos++] & 0xff;
                    bin_data_size |= (m & 0x7f) << i;
                    if ((m & 0x80) == 0) break;
                }
                break;
            default:
                if (n < 0) return EOS;
                assert false;
            }
        }
    }

    @Override
    protected final void write(int n) throws IOException {
        switch (n) {
        case ESC: put(ESC); put(0); break;
        case EOM: put(ESC); put(1); break;
        case EOS: put(ESC); put(2); break;
        default:
            assert n >= 0 && n <= 0xff;
            put(n);
        }
    }

    @Override
    protected void write(byte[] buf) throws IOException {
        if (buf.length > 32 && isZeroCopySupported()) {
            put(ESC); put(3);
            int n = buf.length;
            for (;;) {
                if (n <= 0x7f) {
                    put(n);
                    break;
                }
                put((n & 0x7f) | 0x80);
                n = n >> 7;
            }
            put(buf);
        }
        else {
            for (byte b : buf) {
                int n = b & 0xff;
                put(n);
                if (n == ESC) put(0);
            }
        }
    }
}
