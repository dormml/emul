/**
 * 
 */
package v9t9.common.cpu;


/**
 * This interface receives details about an instruction's effects
 * @author ejs
 *
 */
public interface IInstructionListener {
	boolean preExecute(InstructionWorkBlock before);
	void executed(InstructionWorkBlock before, InstructionWorkBlock after);
}
