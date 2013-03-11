/**
 * 
 */
package v9t9.machine.ti99.machine.fileExecutors;

import v9t9.common.client.IKeyboardHandler;
import v9t9.common.events.NotifyException;
import v9t9.common.files.IFileExecutor;
import v9t9.common.machine.IMachine;
import v9t9.common.modules.IModule;

/**
 * @author ejs
 *
 */
public class EditAssmLoadAndRunProgramFileExecutor implements IFileExecutor {

	private IModule module;
	private String devicePath;

	public EditAssmLoadAndRunProgramFileExecutor(IModule module, String devicePath) {
		this.module = module;
		this.devicePath = devicePath;
	}
	
	/* (non-Javadoc)
	 * @see v9t9.common.files.IFileExecutor#getLabel()
	 */
	@Override
	public String getLabel() {
		return "Load program file " + devicePath + " with " + module.getName();
	}
	
	/* (non-Javadoc)
	 * @see v9t9.common.files.IFileExecutor#getDescription()
	 */
	@Override
	public String getDescription() {
		return "Load module " + module.getName() + ", and run the program file " + devicePath + " using 'Option 5'.";
				
	}
	
	/* (non-Javadoc)
	 * @see v9t9.common.files.IFileExecutor#run(v9t9.common.machine.IMachine)
	 */
	@Override
	public void run(IMachine machine) throws NotifyException {
		machine.getModuleManager().switchModule(module);
		machine.reset();
		machine.getKeyboardHandler().pasteText(" 2"+	// space for title, 2 for extended basic
				IKeyboardHandler.WAIT_FOR_FLUSH + IKeyboardHandler.WAIT_VIDEO + 
				"5" + devicePath + "\n");
	}

}
