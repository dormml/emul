package v9t9.tools.asm.assembler.operand.ll;

import v9t9.common.asm.IMachineOperand;
import v9t9.common.asm.ResolveException;

public interface IAsmMachineOperandFactory {
	//MachineOperand createMachineOperand(LLOperand op) throws ResolveException;
	IMachineOperand createRegisterOperand(LLRegisterOperand op) throws ResolveException;
	IMachineOperand createAddressOperand(LLAddrOperand op) throws ResolveException;
	IMachineOperand createCountOperand(LLCountOperand op) throws ResolveException;
	IMachineOperand createImmedOperand(LLImmedOperand op) throws ResolveException;
	IMachineOperand createPCRelativeOperand(LLPCRelativeOperand op) throws ResolveException;
	IMachineOperand createOffsetOperand(LLOffsetOperand op) throws ResolveException;
	IMachineOperand createRegIncOperand(LLRegIncOperand op) throws ResolveException;
	IMachineOperand createRegIndOperand(LLRegIndOperand op) throws ResolveException;
	IMachineOperand createRegOffsOperand(LLRegOffsOperand op) throws ResolveException;
	IMachineOperand createEmptyOperand();
	IMachineOperand createRegDecOperand(LLRegDecOperand op) throws ResolveException;
	IMachineOperand createScaledRegOffsOperand(LLScaledRegOffsOperand op) throws ResolveException;
		
}