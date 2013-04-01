package v9t9.tools.asm.directive;

import java.util.List;

import v9t9.common.asm.IInstruction;
import v9t9.common.asm.ResolveException;
import v9t9.tools.asm.IAsmInstructionFactory;
import v9t9.tools.asm.IAssembler;
import v9t9.tools.asm.operand.hl.AssemblerOperand;

/**
 * @author Ed
 *
 */
public class IgnoreDirective extends Directive {

	public IgnoreDirective(List<AssemblerOperand> ops) {
	}
	
	@Override
	public String toString() {
		return "";
	}

	public IInstruction[] resolve(IAssembler assembler, IInstruction previous, boolean finalPass) throws ResolveException {
		return new IInstruction[] { this };
	}
	
	public byte[] getBytes(IAsmInstructionFactory factory) throws ResolveException {
		return new byte[0];
	}
	

}