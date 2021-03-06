/*
  EmulatedBaseFDRFile.java

  (c) 2012-2013 Edward Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package v9t9.common.files;

import java.io.IOException;

/**
 * @author ejs
 *
 */
public abstract class EmulatedBaseFDRFile implements IEmulatedFile, IFDROwner {

	protected FDR fdr;
	private IEmulatedDisk disk;

	public EmulatedBaseFDRFile(IEmulatedDisk disk, FDR fdr) {
		this.disk = disk;
		this.fdr = fdr;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return fdr.toString();
	}

	/* (non-Javadoc)
	 * @see v9t9.common.files.IEmulatedFile#getDisk()
	 */
	@Override
	public IEmulatedDisk getDisk() {
		return disk;
	}
	
	/* (non-Javadoc)
	 * @see v9t9.common.files.EmulatedFile#getName()
	 */
	@Override
	public String getFileName() {
		return fdr.getFileName();
	}
	
	public int getFileSize() {
	    return fdr.getFileSize();
	}
	
	/* (non-Javadoc)
	 * @see v9t9.common.files.NativeFile#setFileSize(int)
	 */
	@Override
	public void setFileSize(int size) throws IOException {
		fdr.setFileSize(size);	
	}

	public FDR getFDR() {
		return fdr;
	}

	public int getFlags() {
		return fdr.getFlags();
	}

	public int getSectorsUsed() {
		return fdr.secsused;
	}

	public int getByteOffset() {
		return fdr.getByteOffset();
	}

	public int getNumberRecords() {
		return fdr.getNumberRecords();
	}

	public int getRecordLength() {
		return fdr.getRecordLength();
	}

	public int getRecordsPerSector() {
		return fdr.getRecordsPerSector();
	}
	
	/* (non-Javadoc)
	 * @see v9t9.common.files.IFDRInfo#getContentSectors()
	 */
	@Override
	public int[] getContentSectors() {
		return fdr.getContentSectors();
	}
}