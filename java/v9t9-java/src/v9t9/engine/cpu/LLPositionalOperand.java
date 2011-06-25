/**
 * 
 */
package v9t9.engine.cpu;

import v9t9.tools.asm.assembler.ResolveException;
import v9t9.tools.asm.assembler.operand.ll.IMachineOperandFactory;
import v9t9.tools.asm.assembler.operand.ll.LLOperand;

final class LLPositionalOperand extends LLOperand {
	private final int position;
	/**
	 * @param original
	 */
	public LLPositionalOperand(int position) {
		super(null);
		this.position = position;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + position;
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		LLPositionalOperand other = (LLPositionalOperand) obj;
		if (position != other.position)
			return false;
		return true;
	}


	@Override
	public MachineOperand createMachineOperand(
			IMachineOperandFactory opFactory) throws ResolveException {
		throw new ResolveException(this, "should be replaced");
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "<positional operand " + position + ">";
	}
	

	@Override
	public int getImmediate() {
		return 0;
	}

	@Override
	public int getSize() {
		return 0;
	}
	@Override
	public boolean hasImmediate() {
		return false;
	}
	@Override
	public boolean isConst() {
		return false;
	}
	@Override
	public boolean isMemory() {
		return false;
	}
	@Override
	public boolean isRegister() {
		return false;
	}
}