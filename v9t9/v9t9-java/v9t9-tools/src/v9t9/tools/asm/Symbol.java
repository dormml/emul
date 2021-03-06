/*
  Symbol.java

  (c) 2008-2014 Edward Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package v9t9.tools.asm;

import ejs.base.utils.HexUtils;

/**
 * @author ejs
 *
 */
public class Symbol implements Comparable<Symbol> {

	private final String name;
	private int addr;
	private boolean defined;
	private int index;
	private final SymbolTable table;

	public Symbol(SymbolTable table, String name) {
		this.table = table;
		this.name = name;
	}

	public Symbol(SymbolTable table, String name, int addr) {
		this.table = table;
		this.name = name;
		this.addr = addr;
		this.defined = true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Symbol o) {
		return addr - o.addr;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name + (isDefined() ? "{>"+HexUtils.toHex4(addr)+"}" : "");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result + ((name == null) ? 0 : name.hashCode()))
			* prime + (table == null ? 0 : table.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Symbol other = (Symbol) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (table == null) {
			if (other.table != null) {
				return false;
			}
		} else if (!table.equals(other.table)) {
			return false;
		}
		return true;
	}

	public void setAddr(int addr) {
		this.addr = addr;
		this.defined = true;
	}

	/** Is the real address known for this symbol? */
	public boolean isDefined() {
		return defined;
	}

	/** Is the real address known for this symbol? */
	public void setDefined(boolean b) {
		this.defined = b;
	}
	
	
	public int getAddr() {
		return addr & 0xffff;
	}


	public void setIndex(int i) {
		this.index = i;
	}
	
	public int getIndex() {
		return index;
	}
	
	public SymbolTable getTable() {
		return table;
	}

	
}
