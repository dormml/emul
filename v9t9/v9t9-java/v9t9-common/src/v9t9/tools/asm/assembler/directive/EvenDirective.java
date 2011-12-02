/**
 * 
 */
package v9t9.tools.asm.assembler.directive;

import java.util.List;

import v9t9.engine.cpu.IInstruction;
import v9t9.engine.cpu.Operand;
import v9t9.tools.asm.assembler.IAssembler;
import v9t9.tools.asm.assembler.ResolveException;

/**
 * @author Ed
 *
 */
public class EvenDirective extends Directive {

	/**
	 * @param ops  
	 */
	public EvenDirective(List<Operand> ops) {
	}
	
	@Override
	public String toString() {
		return "EVEN";
	}

	public IInstruction[] resolve(IAssembler assembler, IInstruction previous, boolean finalPass) throws ResolveException {
		// this does not affect nearby labels
		
		assembler.setPc((assembler.getPc() + 1) & 0xfffe);
		setPc(assembler.getPc());

		return new IInstruction[] { this };
	}

}
