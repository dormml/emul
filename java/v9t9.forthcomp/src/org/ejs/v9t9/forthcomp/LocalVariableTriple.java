/**
 * 
 */
package org.ejs.v9t9.forthcomp;

import org.ejs.v9t9.forthcomp.words.LocalVariable;
import org.ejs.v9t9.forthcomp.words.LocalVariableAddr;
import org.ejs.v9t9.forthcomp.words.StoreLocalVariable;

/**
 * @author ejs
 *
 */
public class LocalVariableTriple {
	public LocalVariableTriple(LocalVariable local,
			StoreLocalVariable storeLocal, LocalVariableAddr localAddr) {
		var = local;
		storeWord = storeLocal;
		addrWord = localAddr;
	}
	public LocalVariable var;
	public StoreLocalVariable storeWord;
	public LocalVariableAddr addrWord;
}
