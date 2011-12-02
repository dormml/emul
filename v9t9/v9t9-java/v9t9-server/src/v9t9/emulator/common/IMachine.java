/**
 * 
 */
package v9t9.emulator.common;

import java.io.IOException;
import java.util.Timer;

import org.ejs.coffee.core.properties.SettingProperty;
import org.ejs.coffee.core.settings.ISettingSection;

import v9t9.emulator.clients.builtin.SoundProvider;
import v9t9.emulator.hardware.MachineModel;
import v9t9.emulator.hardware.dsrs.IDsrManager;
import v9t9.emulator.runtime.cpu.Cpu;
import v9t9.emulator.runtime.cpu.CpuMetrics;
import v9t9.emulator.runtime.cpu.Executor;
import v9t9.engine.Client;
import v9t9.engine.VdpHandler;
import v9t9.engine.cpu.IRawInstructionFactory;
import v9t9.engine.memory.Memory;
import v9t9.engine.memory.MemoryDomain;
import v9t9.engine.memory.MemoryModel;
import v9t9.keyboard.KeyboardState;

/**
 * @author ejs
 *
 */
public interface IMachine extends IBaseMachine {

	static public final SettingProperty settingPauseMachine = new SettingProperty(
			"PauseMachine", new Boolean(false));
	static public final SettingProperty settingThrottleInterrupts = new SettingProperty(
			"ThrottleVDPInterrupts", new Boolean(false));
	static public final SettingProperty settingModuleList = new SettingProperty(
			"ModuleListFile", new String("modules.xml"));


	Client getClient();

	void setClient(Client client);

	Executor getExecutor();

	void setExecutor(Executor executor);

	KeyboardState getKeyboardState();

	SoundProvider getSound();

	/**
	 * @return the moduleManager
	 */
	ModuleManager getModuleManager();

	VdpHandler getVdp();

	IDsrManager getDsrManager();

	/**
	 * @return
	 */
	MachineModel getModel();

	/** Called when keyboardState changes */
	void keyStateChanged();

}