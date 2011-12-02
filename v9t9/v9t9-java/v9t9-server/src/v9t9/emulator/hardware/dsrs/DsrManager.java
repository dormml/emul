package v9t9.emulator.hardware.dsrs;

import java.util.ArrayList;
import java.util.List;

import org.ejs.coffee.core.settings.ISettingSection;

import v9t9.emulator.common.IMachine;

public abstract class DsrManager implements IDsrManager {

	protected final IMachine machine;
	protected List<DsrHandler> dsrs;
	protected DsrHandler activeDsr;

	public DsrManager(IMachine machine) {
		super();
		this.machine = machine;
		dsrs = new ArrayList<DsrHandler>();

	}

	public void dispose() {
		for (DsrHandler dsr : dsrs) {
			dsr.dispose();
		}
	}

	public void saveState(ISettingSection section) {
		for (DsrHandler handler : dsrs) {
			handler.saveState(section.addSection(handler.getName()));
		}
	}

	public void loadState(ISettingSection section) {
		if (section == null) return;
		for (DsrHandler handler : dsrs) {
			handler.loadState(section.getSection(handler.getName()));
		}
	}

	public List<DsrHandler> getDsrs() {
		return dsrs;
	}

	public void registerDsr(DsrHandler dsr) {
		this.dsrs.add(dsr);
	}
}