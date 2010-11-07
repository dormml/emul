package v9t9.emulator.hardware;

import org.ejs.coffee.core.settings.ISettingSection;

import v9t9.emulator.common.Machine;
import v9t9.emulator.runtime.cpu.CpuF99b;
import v9t9.engine.CruHandler;
import v9t9.engine.memory.MemoryDomain;
import v9t9.engine.memory.TIMemoryModel;

public class F99bMachine extends Machine {

	private CruManager cruManager;

	public F99bMachine(MachineModel machineModel) {
		super(machineModel);
		keyboardState.setPasteKeyDelay(1);
	}

	@Override
	protected void init(MachineModel machineModel) {
		settingModuleList.setString("");
		
		super.init(machineModel);

		cruManager = new CruManager();
	}
	
	/* (non-Javadoc)
	 * @see v9t9.emulator.common.Machine#getMemoryModel()
	 */
	@Override
	public TIMemoryModel getMemoryModel() {
		return (TIMemoryModel) super.getMemoryModel();
	}
	/* (non-Javadoc)
	 * @see v9t9.emulator.common.Machine#doLoadState(org.ejs.coffee.core.settings.ISettingSection)
	 */
	@Override
	protected void doLoadState(ISettingSection section) {
		super.doLoadState(section);
		getMemoryModel().getGplMmio().loadState(section.getSection("GPL"));
	}
	/* (non-Javadoc)
	 * @see v9t9.emulator.common.Machine#doSaveState(org.ejs.coffee.core.settings.ISettingSection)
	 */
	@Override
	protected void doSaveState(ISettingSection settings) {
		super.doSaveState(settings);
		getMemoryModel().getGplMmio().saveState(settings.addSection("GPL"));
	}

	/* (non-Javadoc)
	 * @see v9t9.emulator.hardware.TI99Machine#getGplMemoryDomain()
	 */
	public MemoryDomain getGplMemoryDomain() {
		return memory.getDomain("GRAPHICS");
	}

	/* (non-Javadoc)
	 * @see v9t9.emulator.hardware.TI99Machine#getSpeechMemoryDomain()
	 */
	public MemoryDomain getSpeechMemoryDomain() {
		return memory.getDomain("SPEECH");
	}

	/* (non-Javadoc)
	 * @see v9t9.emulator.hardware.TI99Machine#getVdpMemoryDomain()
	 */
	public MemoryDomain getVdpMemoryDomain() {
		return memory.getDomain("VIDEO");
	}

	public CruManager getCruManager() {
		return cruManager;
	}


	public CruHandler getCru() {
		return cruManager;
	}
	
	/* (non-Javadoc)
	 * @see v9t9.emulator.common.Machine#keyStateChanged()
	 */
	@Override
	public void keyStateChanged() {
		super.keyStateChanged();
		if (keyboardState.anyKeyPressed()) {
			CruAccess cru = getCpu().getCruAccess();
			if (cru instanceof BaseCruAccess) {
				cru.triggerInterrupt(CpuF99b.INT_KBD);
			}
		}
	}

}