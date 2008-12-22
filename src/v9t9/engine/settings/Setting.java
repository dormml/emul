/*
 * (c) Ed Swartz, 2005
 * 
 * Created on Dec 17, 2004
 *
 */
package v9t9.engine.settings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.dialogs.IDialogSettings;

/** A single configurable setting.
 * @author ejs
 */
public class Setting {
    private Object storage;
    private String name;
    private List<ISettingListener> listeners;
    
    @SuppressWarnings("unchecked")
	public Setting(String name, Object storage) {
        this.name = name;
        this.storage = storage;
        this.listeners = (List<ISettingListener>)Collections.EMPTY_LIST;
    }
    public String getName() {
        return name;
    }
    
    public void addListener(ISettingListener listener) {
        if (listeners == Collections.EMPTY_LIST) {
            listeners = new ArrayList<ISettingListener>();
        }
        listeners.add(listener);
    }
    public void removeListener(ISettingListener listener) {
        listeners.remove(listener);
    }
    private void notifyListeners(Object oldValue) {
        for (Iterator<ISettingListener> iter = listeners.iterator(); iter.hasNext();) {
            ISettingListener listener = iter.next();
            listener.changed(this, oldValue);
        }
    }
        
    public Object getValue() {
        return storage;
    }
    public int getInt() {
        return ((Integer)storage).intValue();
    }
    public boolean getBoolean() {
        return ((Boolean)storage).booleanValue();
    }
    public String getString() {
        return (String)storage;
    }
    public void setValue(Object val) {
        Object old = storage;
        storage = val;
        notifyListeners(old);
    }
    public void setInt(int val) {
        Object old = storage;
        storage = new Integer(val);
        notifyListeners(old);
    }
    public void setBoolean(boolean val) {
        Object old = storage;
        storage = new Boolean(val);
        notifyListeners(old);
    }
    public void setString(String val) {
        Object old = storage;
        storage = val;
        notifyListeners(old);
    }
	public void saveState(IDialogSettings section) {
		if (storage instanceof Integer)
			section.put(name, Integer.toString(getInt()));
		else
			section.put(name, getValue().toString());
	}
	public void loadState(IDialogSettings section) {
		String value = section.get(name);
		if (value != null) {
			if (storage instanceof Boolean)
				setValue(Boolean.parseBoolean(value));
			else if (storage instanceof Integer)
				setValue(Integer.parseInt(value));
			else
				setValue(value);
		}
	}
}
