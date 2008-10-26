/**
 * 
 */
package v9t9.tools.asm.operand;

import v9t9.engine.cpu.AssemblerOperand;
import v9t9.engine.cpu.IInstruction;
import v9t9.engine.cpu.MachineOperand;
import v9t9.tools.asm.Assembler;
import v9t9.tools.asm.ResolveException;
import v9t9.utils.Utils;

/**
 * @author ejs
 *
 */
public class NumberOperand implements AssemblerOperand {

	private int i;

	public NumberOperand(int i) {
		this.i = i;
	}
	
	public void negate() {
		i = -i;
	}
	@Override
	public String toString() {
		return ">" + Utils.toHex4(i);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
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
		NumberOperand other = (NumberOperand) obj;
		if (i != other.i) {
			return false;
		}
		return true;
	}

	public MachineOperand resolve(Assembler assembler, IInstruction inst) throws ResolveException {
		return MachineOperand.createImmediate(i);
	}

	public int getValue() {
		return i;
	}
	
}
