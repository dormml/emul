/**
 * 
 */
package v9t9.engine.demos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import v9t9.common.demos.IDemoActor;
import v9t9.common.demos.IDemoOutputStream;
import v9t9.common.demos.IDemoRecorder;
import v9t9.common.demos.IDemoHandler.IDemoListener;
import v9t9.common.events.IEventNotifier.Level;
import v9t9.common.events.NotifyEvent;
import v9t9.common.machine.IMachine;
import ejs.base.utils.ListenerList;
import ejs.base.utils.ListenerList.IFire;
/**
 * @author ejs
 *
 */
public class DemoRecorder implements IDemoRecorder {
	private final IDemoOutputStream os;
	private final ListenerList<IDemoListener> listeners;


	private final IMachine machine;
	
	private IDemoActor[] recordingActors;
	
	
	public DemoRecorder(IMachine machine, IDemoOutputStream os, ListenerList<IDemoListener> listeners) throws IOException {
		this.machine = machine;
		this.os = os;
		this.listeners = listeners;
		
		List<IDemoActor> actors = new ArrayList<IDemoActor>();
		for (IDemoActor actor : machine.getDemoManager().getActors()) {
			if (actor.shouldRecordFor(os.getDemoFormat())) {
				actors.add(actor);
			}
		}
		recordingActors = (IDemoActor[]) actors.toArray(new IDemoActor[actors.size()]);
		
		for (IDemoActor actor : recordingActors)
			actor.setup(machine);
		
		connect();
		
	}

	public synchronized void stop() throws IOException {
		disconnect();
		
		os.close();
	}

	public synchronized void fail(final Throwable t) {
		t.printStackTrace();
		
		listeners.fire(new IFire<IDemoListener>() {

			@Override
			public void fire(IDemoListener listener) {
				t.printStackTrace();
				listener.stopped(new NotifyEvent(System.currentTimeMillis(), null, Level.ERROR, 
						"Unexpected error writing demo: " + t.getMessage()));
			}
		});

		disconnect();
	}
	
	private synchronized void connect() throws IOException {
		
		for (IDemoActor actor : recordingActors) {
			actor.connectForRecording(this);
		}
	}

	private synchronized void disconnect() {
		for (IDemoActor actor : recordingActors) {
			actor.disconnectFromRecording(this);
		}
	}

	public synchronized void flushData() throws IOException {
		for (IDemoActor actor : recordingActors) {
			actor.flushRecording(this);
		}
		
		if (os.getOutputStream() != null)
			os.getOutputStream().flush();
	}

	@Override
	public IMachine getMachine() {
		return machine;
	}
	
	@Override
	public IDemoOutputStream getOutputStream() {
		return os;
	}
}
