/*******************************************************************************
 * Copyright (c) 2007 Wind River Systems, Inc. and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *  
 * Contributors:
 *     Wind River Systems - initial API and implementation
 *******************************************************************************/
package com.windriver.tcf.rse.ui;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.rse.core.model.IHost;
import org.eclipse.rse.services.clientserver.FileTypeMatcher;
import org.eclipse.rse.services.clientserver.IMatcher;
import org.eclipse.rse.services.clientserver.NamePatternMatcher;
import org.eclipse.rse.services.clientserver.messages.IndicatorException;
import org.eclipse.rse.services.clientserver.messages.SystemMessage;
import org.eclipse.rse.services.clientserver.messages.SystemMessageException;
import org.eclipse.rse.services.files.AbstractFileService;
import org.eclipse.rse.services.files.IHostFile;

import com.windriver.tcf.api.protocol.IToken;
import com.windriver.tcf.api.protocol.Protocol;
import com.windriver.tcf.api.services.IFileSystem;
import com.windriver.tcf.api.services.IFileSystem.DirEntry;
import com.windriver.tcf.api.services.IFileSystem.FileAttrs;
import com.windriver.tcf.api.services.IFileSystem.FileSystemException;
import com.windriver.tcf.api.services.IFileSystem.IFileHandle;
import com.windriver.tcf.api.util.TCFFileInputStream;
import com.windriver.tcf.api.util.TCFFileOutputStream;

public class TCFFileService extends AbstractFileService implements ITCFFileService {

    private final TCFConnectorService connector;
    
    private UserInfo user_info;
    
    private static final class UserInfo {
        final int r_uid;
        final int e_uid;
        final int r_gid;
        final int e_gid;
        final String home;
        
        final Throwable error;
        
        UserInfo(int r_uid, int e_uid, int r_gid, int e_gid, String home) {
            this.r_uid = r_uid;
            this.e_uid = e_uid;
            this.r_gid = r_gid;
            this.e_gid = e_gid;
            this.home = home;
            error = null;
        }
        
        UserInfo(Throwable error) {
            this.error = error;
            r_uid = -1;
            e_uid = -1;
            r_gid = -1;
            e_gid = -1;
            home = null;
        }
    }
    
    public TCFFileService(IHost host) {
        connector = (TCFConnectorService)TCFConnectorServiceManager
            .getInstance().getConnectorService(host, ITCFSubSystem.class);
    }

    public String getDescription() {
        return "The TCF File Service uses the Target Communication Framework to provide service" +
            "for the Files subsystem. It requires a TCF agent to be running on the remote machine.";
    }

    public SystemMessage getMessage(String id) {
        try {
            return new SystemMessage("TCF", "C", "0001",
                    SystemMessage.ERROR, id, "");
        }
        catch (IndicatorException e) {
            throw new Error(e);
        }
    }

    public SystemMessage getMessage(Throwable x) {
        try {
            return new SystemMessage("TCF", "C", "0002",
                    SystemMessage.ERROR, x.getClass().getName(), x.getMessage());
        }
        catch (IndicatorException e) {
            throw new Error(e);
        }
    }

    public String getName() {
        return "TCF File Service";
    }

    public void initService(IProgressMonitor monitor) {
    }

    public void uninitService(IProgressMonitor monitor) {
    }
    
    private String toRemotePath(String parent, String name) throws SystemMessageException {
        assert !Protocol.isDispatchThread();
        String s  = null;
        if (parent != null) parent = parent.replace('\\', '/');
        if (name != null) name = name.replace('\\', '/');
        if (parent == null || parent.length() == 0) s = name;
        else if (name == null || name.equals(".")) s = parent;
        else if (name.equals("/")) s = parent;
        else if (parent.endsWith("/")) s = parent + name;
        else s = parent + '/' + name;
        if (s.startsWith("./") || s.equals(".")) {
            UserInfo ui = getUserInfo();
            if (ui.error != null) throw new SystemMessageException(getMessage(ui.error));
            s = ui.home.replace('\\', '/') + s.substring(1);
        }
        while (s.endsWith("/.")) s = s.substring(0, s.length() - 2);
        return s;
    }
    
    public boolean copy(String srcParent,
            String srcName, String tgtParent, String tgtName, IProgressMonitor monitor)
            throws SystemMessageException {
        final String src = toRemotePath(srcParent, srcName);
        final String tgt = toRemotePath(tgtParent, tgtName);
        return new TCFRSETask<Boolean>() {
            public void run() {
                IFileSystem fs = connector.getFileSystemService();
                fs.copy(src, tgt, false, false, new IFileSystem.DoneCopy() {
                    public void doneCopy(IToken token, FileSystemException error) {
                        if (error != null) error(error);
                        else done(true);
                    }
                });
            }
        }.getS(monitor, "Copy: " + srcName);
    }

    public boolean copyBatch(String[] srcParents,
            String[] srcNames, String tgtParent, IProgressMonitor monitor) throws SystemMessageException {
        for (int i = 0; i < srcParents.length; i++) {
            if (!copy(srcParents[i], srcNames[i], tgtParent, srcNames[i], monitor)) return false;
        }
        return true;
    }

    public IHostFile createFile(String parent,
            String name, IProgressMonitor monitor) throws SystemMessageException {
        try {
            getOutputStream(parent, name, true, monitor).close();
            return getFile(parent, name, monitor);
        }
        catch (IOException e) {
            throw new SystemMessageException(getMessage(e));
        }
    }

    public IHostFile createFolder(final String parent, final String name, IProgressMonitor monitor) throws SystemMessageException {
        final String path = toRemotePath(parent, name);
        return new TCFRSETask<IHostFile>() {
            public void run() {
                final IFileSystem fs = connector.getFileSystemService();
                fs.mkdir(path, null, new IFileSystem.DoneMkDir() {
                    public void doneMkDir(IToken token, FileSystemException error) {
                        if (error != null) {
                            error(error);
                            return;
                        }
                        fs.stat(path, new IFileSystem.DoneStat() {
                            public void doneStat(IToken token,
                                    FileSystemException error, FileAttrs attrs) {
                                if (error != null) error(error);
                                else done(new TCFFileResource(TCFFileService.this,
                                        path, null, attrs, false));
                            }
                        });
                    }
                });
            }
        }.getS(monitor, "Create folder");
    }

    public boolean delete(String parent,
            String name, IProgressMonitor monitor) throws SystemMessageException {
        final String path = toRemotePath(parent, name);
        return new TCFRSETask<Boolean>() {
            public void run() {
                final IFileSystem fs = connector.getFileSystemService();
                fs.stat(path, new IFileSystem.DoneStat() {
                    public void doneStat(IToken token,
                            FileSystemException error, FileAttrs attrs) {
                        if (error != null) {
                            error(error);
                            return;
                        }
                        IFileSystem.DoneRemove done = new IFileSystem.DoneRemove() {
                            public void doneRemove(IToken token, FileSystemException error) {
                                if (error != null) {
                                    error(error);
                                    return;
                                }
                                done(true);
                            }
                        };
                        if (attrs.isDirectory()) {
                            fs.rmdir(path, done);
                        }
                        else {
                            fs.remove(path, done);
                        }
                    }
                });
            }
        }.getS(monitor, "Delete");
    }

    public boolean deleteBatch(String[] remoteParents, String[] fileNames, IProgressMonitor monitor)
            throws SystemMessageException {
        for (int i = 0; i < remoteParents.length; i++) {
            delete(remoteParents[i], fileNames[i], monitor);
        }
        return true;
    }

    public boolean download(final String parent,
            final String name, final File file, final boolean is_binary,
            final String host_encoding, IProgressMonitor monitor) throws SystemMessageException {
        monitor.beginTask("Download", 1);
        try {
            file.getParentFile().mkdirs();
            InputStream inp = getInputStream(parent, name, is_binary, new NullProgressMonitor());
            OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
            copyStream(inp, out, is_binary, "UTF8", host_encoding);
            return true;
        }
        catch (Throwable x) {
            if (x instanceof SystemMessageException) throw (SystemMessageException)x;
            throw new SystemMessageException(getMessage(x));
        }
        finally {
            monitor.done();
        }
    }

    public String getEncoding(IProgressMonitor monitor) throws SystemMessageException {
        return "UTF8";
    }

    public IHostFile getFile(final String parent,
            final String name, IProgressMonitor monitor) throws SystemMessageException {
        final String path = toRemotePath(parent, name);
        return new TCFRSETask<IHostFile>() {
            public void run() {
                IFileSystem fs = connector.getFileSystemService();
                fs.stat(path, new IFileSystem.DoneStat() {
                    public void doneStat(IToken token,
                            FileSystemException error, FileAttrs attrs) {
                        if (error != null) {
                            if (error.getStatus() == IFileSystem.STATUS_NO_SUCH_FILE) {
                                done(new TCFFileResource(TCFFileService.this, path, null, null, false));
                                return;
                            }
                            error(error);
                            return;
                        }
                        done(new TCFFileResource(TCFFileService.this, path, null, attrs, false));
                    }
                });
            }
        }.getS(monitor, "Stat");
    }

    protected IHostFile[] internalFetch(final String parent, final String filter, final int fileType, final IProgressMonitor monitor)
            throws SystemMessageException {
        final String path = toRemotePath(parent, null);
        final boolean wantFiles = (fileType==FILE_TYPE_FILES_AND_FOLDERS || (fileType&FILE_TYPE_FILES)!=0); 
        final boolean wantFolders = (fileType==FILE_TYPE_FILES_AND_FOLDERS || (fileType%FILE_TYPE_FOLDERS)!=0);
        return new TCFRSETask<IHostFile[]>() {
            private IMatcher matcher = null;
            public void run() {
                if (filter == null) {
                    matcher = null;
                }
                else if (filter.endsWith(",")) { //$NON-NLS-1$
                    String[] types = filter.split(","); //$NON-NLS-1$
                    matcher = new FileTypeMatcher(types, true);
                }
                else {
                    matcher = new NamePatternMatcher(filter, true, true);
                }
                final List<TCFFileResource> results = new ArrayList<TCFFileResource>();
                final IFileSystem fs = connector.getFileSystemService();
                fs.opendir(path, new IFileSystem.DoneOpen() {
                    public void doneOpen(IToken token, FileSystemException error, final IFileHandle handle) {
                        if (error != null) {
                            error(error);
                            return;
                        }
                        fs.readdir(handle, new IFileSystem.DoneReadDir() {
                            public void doneReadDir(IToken token,
                                    FileSystemException error, DirEntry[] entries, boolean eof) {
                                if (error != null) {
                                    error(error);
                                    return;
                                }
                                for (DirEntry e : entries) {
                                    if (e.attrs == null) {
                                        // Attrs are not available if, for example,
                                        // the entry is a broken symbolic link
                                    }
                                    else if (e.attrs.isDirectory()) {
                                        //dont filter folder names if getting both folders and files
                                        if (wantFolders && (matcher==null || fileType==FILE_TYPE_FILES_AND_FOLDERS || matcher.matches(e.filename))) {
                                            results.add(new TCFFileResource(TCFFileService.this,
                                                    path, e.filename, e.attrs, false));
                                        }
                                    }
                                    else if (e.attrs.isFile()) {
                                        if (wantFiles && (matcher == null || matcher.matches(e.filename))) {
                                            results.add(new TCFFileResource(TCFFileService.this,
                                                    path, e.filename, e.attrs, false));
                                        }
                                    }
                                }
                                if (eof) {
                                    fs.close(handle, new IFileSystem.DoneClose() {
                                        public void doneClose(IToken token, FileSystemException error) {
                                            if (error != null) {
                                                error(error);
                                                return;
                                            }
                                            done(results.toArray(new TCFFileResource[results.size()]));
                                        }
                                    });
                                }
                                else {
                                    fs.readdir(handle, this);
                                }
                            }
                        });
                    }
                });
            }
        }.getS(monitor, "Get files and folders");
    }

    public InputStream getInputStream(final String parent, final String name, boolean isBinary, IProgressMonitor monitor)
            throws SystemMessageException {
        final String path = toRemotePath(parent, name);
        final IFileHandle handle = new TCFRSETask<IFileHandle>() {
            public void run() {
                IFileSystem fs = connector.getFileSystemService();
                fs.open(path, IFileSystem.O_READ, null, new IFileSystem.DoneOpen() {
                    public void doneOpen(IToken token, FileSystemException error, IFileHandle handle) {
                        if (error != null) error(error);
                        else done(handle);
                    }
                });
            }
        }.getS(monitor, "Get input stream");
        return new TCFFileInputStream(handle);
    }

    public OutputStream getOutputStream(final String parent, final String name, boolean isBinary, IProgressMonitor monitor)
            throws SystemMessageException {
        final String path = toRemotePath(parent, name);
        final IFileHandle handle = new TCFRSETask<IFileHandle>() {
            public void run() {
                IFileSystem fs = connector.getFileSystemService();
                int flags = IFileSystem.O_WRITE | IFileSystem.O_CREAT | IFileSystem.O_TRUNC;
                fs.open(path, flags, null, new IFileSystem.DoneOpen() {
                    public void doneOpen(IToken token, FileSystemException error, IFileHandle handle) {
                        if (error != null) error(error);
                        else done(handle);
                    }
                });
            }
        }.getS(monitor, "Get output stream");
        return new TCFFileOutputStream(handle);
    }

    public IHostFile[] getRoots(IProgressMonitor monitor) throws SystemMessageException {
        return new TCFRSETask<IHostFile[]>() {
            public void run() {
                IFileSystem fs = connector.getFileSystemService();
                fs.roots(new IFileSystem.DoneRoots() {
                    public void doneRoots(IToken token, FileSystemException error, DirEntry[] entries) {
                        if (error != null) {
                            error(error);
                            return;
                        }
                        List<TCFFileResource> l = new ArrayList<TCFFileResource>();
                        for (DirEntry e : entries) {
                            if (e.attrs == null) continue;
                            l.add(new TCFFileResource(TCFFileService.this, null, e.filename, e.attrs, true));
                        }
                        done(l.toArray(new IHostFile[l.size()]));
                    }
                });
            }
        }.getS(monitor, "Get roots");
    }

    public IHostFile getUserHome() {
        UserInfo ui = getUserInfo();
        try {
            return getFile(ui.home, ".", new NullProgressMonitor());
        }
        catch (SystemMessageException e) {
            throw new Error(e);
        }
    }

    public boolean isCaseSensitive() {
        return true;
    }

    public boolean move(final String srcParent,
            final String srcName, final String tgtParent, final String tgtName, IProgressMonitor monitor)
            throws SystemMessageException {
        final String src_path = toRemotePath(srcParent, srcName);
        final String tgt_path = toRemotePath(tgtParent, tgtName);
        return new TCFRSETask<Boolean>() {
            public void run() {
                IFileSystem fs = connector.getFileSystemService();
                fs.rename(src_path, tgt_path, new IFileSystem.DoneRename() {
                    public void doneRename(IToken token, FileSystemException error) {
                        if (error != null) error(error);
                        else done(true);
                    }
                });
            }
        }.getS(monitor, "Move");
    }

    public boolean rename(String remoteParent,
            String oldName, String newName, IProgressMonitor monitor) throws SystemMessageException {
        return move(remoteParent, oldName, remoteParent, newName, monitor);
    }

    public boolean rename(String remoteParent,
            String oldName, String newName, IHostFile oldFile, IProgressMonitor monitor)
            throws SystemMessageException {
        boolean b = move(remoteParent, oldName, remoteParent, newName, monitor);
        if (b) oldFile.renameTo(toRemotePath(remoteParent, newName));
        return b;
    }

    public boolean setLastModified(final String parent,
            final String name, final long timestamp, IProgressMonitor monitor) throws SystemMessageException {
        final String path = toRemotePath(parent, name);
        return new TCFRSETask<Boolean>() {
            public void run() {
                IFileSystem fs = connector.getFileSystemService();
                FileAttrs attrs = new FileAttrs(IFileSystem.ATTR_ACMODTIME,
                        0, 0, 0, 0, timestamp, timestamp, null);
                fs.setstat(path, attrs, new IFileSystem.DoneSetStat() {
                    public void doneSetStat(IToken token, FileSystemException error) {
                        if (error != null) error(error);
                        else done(true);
                    }
                });
            }
        }.getS(monitor, "Set modification time");
    }

    public boolean setReadOnly(final String parent,
            final String name, final boolean readOnly, IProgressMonitor monitor) throws SystemMessageException {
        final String path = toRemotePath(parent, name);
        return new TCFRSETask<Boolean>() {
            public void run() {
                final IFileSystem fs = connector.getFileSystemService();
                fs.stat(path, new IFileSystem.DoneStat() {
                    public void doneStat(IToken token, FileSystemException error, FileAttrs attrs) {
                        if (error != null) {
                            error(error);
                            return;
                        }
                        int p = attrs.permissions;
                        if (readOnly) {
                            p &= ~IFileSystem.S_IWUSR;
                            p &= ~IFileSystem.S_IWGRP;
                            p &= ~IFileSystem.S_IWOTH;
                        }
                        else {
                            p |= IFileSystem.S_IWUSR;
                            p |= IFileSystem.S_IWGRP;
                            p |= IFileSystem.S_IWOTH;
                        }
                        FileAttrs new_attrs = new FileAttrs(IFileSystem.ATTR_PERMISSIONS,
                                0, 0, 0, p, 0, 0, null);
                        fs.setstat(path, new_attrs, new IFileSystem.DoneSetStat() {
                            public void doneSetStat(IToken token, FileSystemException error) {
                                if (error != null) error(error);
                                else done(true);
                            }
                        });
                    }
                });
            }
        }.getS(monitor, "Set permissions");
    }

    public boolean upload(InputStream inp,
            String parent, String name, boolean isBinary,
            String hostEncoding, IProgressMonitor monitor) throws SystemMessageException {
        monitor.beginTask("Upload", 1);
        try {
            OutputStream out = getOutputStream(parent, name, isBinary, new NullProgressMonitor());
            copyStream(inp, out, isBinary, hostEncoding, "UTF8");
            return true;
        }
        catch (Throwable x) {
            if (x instanceof SystemMessageException) throw (SystemMessageException)x;
            throw new SystemMessageException(getMessage(x));
        }
        finally {
            monitor.done();
        }
    }

    public boolean upload(File localFile,
            String parent, String name, boolean isBinary,
            String srcEncoding, String hostEncoding, IProgressMonitor monitor)
            throws SystemMessageException {
        monitor.beginTask("Upload", 1);
        try {
            OutputStream out = getOutputStream(parent, name, isBinary, new NullProgressMonitor());
            InputStream inp = new BufferedInputStream(new FileInputStream(localFile));
            copyStream(inp, out, isBinary, hostEncoding, "UTF8");
            return true;
        }
        catch (Throwable x) {
            if (x instanceof SystemMessageException) throw (SystemMessageException)x;
            throw new SystemMessageException(getMessage(x));
        }
        finally {
            monitor.done();
        }
    }
    
    private void copyStream(InputStream inp, OutputStream out, 
            boolean is_binary, String inp_encoding, String out_encoding) throws IOException {
        try {
            if (!is_binary) {
                if (inp_encoding.equals("UTF-8")) inp_encoding = "UTF8";
                if (out_encoding.equals("UTF-8")) out_encoding = "UTF8";
            }
            if (is_binary || inp_encoding.equals(out_encoding)) {
                byte[] buf = new byte[0x1000];
                for (;;) {
                    int buf_len = inp.read(buf);
                    if (buf_len < 0) break;
                    out.write(buf, 0, buf_len);
                }
            }
            else {
                Reader reader = new InputStreamReader(inp, inp_encoding);
                Writer writer = new OutputStreamWriter(out, out_encoding);
                char[] buf = new char[0x1000];
                for (;;) {
                    int buf_len = reader.read(buf);
                    if (buf_len < 0) break;
                    writer.write(buf, 0, buf_len);
                }
                writer.flush();
            }
        }
        finally {
            out.close();
            inp.close();
        }
    }
    
    private synchronized UserInfo getUserInfo() {
        if (user_info == null || user_info.error != null) {
            user_info = new TCFRSETask<UserInfo>() {
                public void run() {
                    IFileSystem fs = connector.getFileSystemService();
                    fs.user(new IFileSystem.DoneUser() {
                        public void doneUser(IToken token, FileSystemException error, int real_uid,
                                int effective_uid, int real_gid, int effective_gid, String home) {
                            if (error != null) done(new UserInfo(error));
                            else done(new UserInfo(real_uid, effective_uid, real_gid, effective_gid, home));
                        }
                    });
                }
            }.getE();
        }
        return user_info;
    }
    
    public boolean canRead(FileAttrs attrs) {
        if ((attrs.flags & IFileSystem.ATTR_PERMISSIONS) == 0) return false;
        if ((attrs.flags & IFileSystem.ATTR_UIDGID) == 0) return false;
        UserInfo ui = getUserInfo();
        if (ui.error != null) return false;
        if (ui.e_uid == attrs.uid) {
            return (attrs.permissions & IFileSystem.S_IRUSR) != 0;
        }
        if (ui.e_gid == attrs.gid) {
            return (attrs.permissions & IFileSystem.S_IRGRP) != 0;
        }
        return (attrs.permissions & IFileSystem.S_IROTH) != 0;
    }
    
    public boolean canWrite(FileAttrs attrs) {
        if ((attrs.flags & IFileSystem.ATTR_PERMISSIONS) == 0) return false;
        if ((attrs.flags & IFileSystem.ATTR_UIDGID) == 0) return false;
        UserInfo ui = getUserInfo();
        if (ui.error != null) return false;
        if (ui.e_uid == attrs.uid) {
            return (attrs.permissions & IFileSystem.S_IWUSR) != 0;
        }
        if (ui.e_gid == attrs.gid) {
            return (attrs.permissions & IFileSystem.S_IWGRP) != 0;
        }
        return (attrs.permissions & IFileSystem.S_IWOTH) != 0;
    }
    
}
