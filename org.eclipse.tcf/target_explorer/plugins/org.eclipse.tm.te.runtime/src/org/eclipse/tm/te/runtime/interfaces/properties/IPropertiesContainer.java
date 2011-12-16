/*******************************************************************************
 * Copyright (c) 2011 Wind River Systems, Inc. and others. All rights reserved.
 * This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Wind River Systems - initial API and implementation
 *******************************************************************************/
package org.eclipse.tm.te.runtime.interfaces.properties;

import java.util.Map;
import java.util.UUID;

import org.eclipse.core.runtime.IAdaptable;

/**
 * A generic properties container.
 */
public interface IPropertiesContainer extends IAdaptable {

	/**
	 * Returns the unique identified of the properties container.
	 *
	 * @return The unique identifier.
	 */
	public UUID getUUID();

	/**
	 * Set if or if not firing change events is enabled.
	 *
	 * @param param enabled <code>True</code> to enable the change events, <code>false</code> to disable the change events.
	 * @return <code>True</code> if the enablement has changed, <code>false</code> if not.
	 */
	public boolean setChangeEventsEnabled(boolean enabled);

	/**
	 * Returns if or if not firing change events is enabled.
	 *
	 * @return <code>True</code> if change events are enabled, <code>false</code> if disabled.
	 */
	public boolean changeEventsEnabled();

	/**
	 * Set the properties from the given map. Calling this method
	 * will overwrite all previous set properties.
	 *
	 * @param properties The map of properties to set. Must not be <code>null</code>.
	 */
	public void setProperties(Map<String, Object> properties);

	/**
	 * Stores the property under the given property key using the given property value.
	 * If the current property value is equal to the given property value, no store
	 * operation will be executed. If the property value is not <code>null</code> and
	 * is different from the current property value, the new value will be written to
	 * the property store and a property change event is fired. If the property value
	 * is <code>null</code>, the property key and the currently stored value are removed
	 * from the property store.
	 *
	 *
	 * @param key The property key. Must not be <code>null</code>!
	 * @param value The property value.
	 * @return <code>true</code> if the property value had been applied to the property store, <code>false</code> otherwise.
	 */
	public boolean setProperty(String key, Object value);

	/**
	 * Stores the property under the given property key using the given long
	 * property value. The given long value is transformed to an <code>Long</code>
	 * object and stored to the properties store via <code>setProperty(java.lang.String, java.lang.Object)</code>.
	 *
	 * @param key The property key. Must not be <code>null</code>!
	 * @param value The property value.
	 * @return <code>true</code> if the property value had been applied to the property store, <code>false</code> otherwise.
	 *
	 * @see <code>setProperty(java.lang.String, java.lang.Object)</code>
	 */
	public boolean setProperty(String key, long value);

	/**
	 * Stores the property under the given property key using the given integer
	 * property value. The given integer value is transformed to an <code>Integer</code>
	 * object and stored to the properties store via <code>setProperty(java.lang.String, java.lang.Object)</code>.
	 *
	 * @param key The property key. Must not be <code>null</code>!
	 * @param value The property value.
	 * @return <code>true</code> if the property value had been applied to the property store, <code>false</code> otherwise.
	 *
	 * @see <code>setProperty(java.lang.String, java.lang.Object)</code>
	 */
	public boolean setProperty(String key, int value);

	/**
	 * Stores the property under the given property key using the given boolean
	 * property value. The given boolean value is transformed to an <code>Boolean</code>
	 * object and stored to the properties store via <code>setProperty(java.lang.String, java.lang.Object)</code>.
	 *
	 * @param key The property key. Must not be <code>null</code>!
	 * @param value The property value.
	 * @return <code>true</code> if the property value had been applied to the property store, <code>false</code> otherwise.
	 *
	 * @see <code>setProperty(java.lang.String, java.lang.Object)</code>
	 */
	public boolean setProperty(String key, boolean value);

	/**
	 * Stores the property under the given property key using the given float
	 * property value. The given float value is transformed to an <code>Float</code>
	 * object and stored to the properties store via <code>setProperty(java.lang.String, java.lang.Object)</code>.
	 *
	 * @param key The property key. Must not be <code>null</code>!
	 * @param value The property value.
	 * @return <code>true</code> if the property value had been applied to the property store, <code>false</code> otherwise.
	 *
	 * @see <code>setProperty(java.lang.String, java.lang.Object)</code>
	 */
	public boolean setProperty(String key, float value);

	/**
	 * Stores the property under the given property key using the given double
	 * property value. The given double value is transformed to an <code>Double</code>
	 * object and stored to the properties store via <code>setProperty(java.lang.String, java.lang.Object)</code>.
	 *
	 * @param key The property key. Must not be <code>null</code>!
	 * @param value The property value.
	 * @return <code>true</code> if the property value had been applied to the property store, <code>false</code> otherwise.
	 *
	 * @see <code>setProperty(java.lang.String, java.lang.Object)</code>
	 */
	public boolean setProperty(String key, double value);

	/**
	 * Return all properties. The result map is read-only.
	 *
	 * @return A map containing all properties.
	 */
	public Map<String, Object> getProperties();

	/**
	 * Queries the property value stored under the given property key. If the property
	 * does not exist, <code>null</code> is returned.
	 *
	 * @param key The property key. Must not be <code>null</code>!
	 * @return The stored property value or <code>null</code>.
	 */
	public Object getProperty(String key);

	/**
	 * Queries the property value stored under the given property key. If the property
	 * exist and is of type <code>java.lang.String</code>, the property value casted to
	 * <code>java.lang.String</code> is returned. In all other cases, <code>null</code>
	 * is returned.
	 *
	 * @param key The property key. Must not be <code>null</code>!
	 * @return The stored property value casted <code>java.lang.String</code> or <code>null</code>.
	 */
	public String getStringProperty(String key);

	/**
	 * Queries the property value stored under the given property key. If the property
	 * exist and is of type <code>java.lang.Long</code>, the property value converted
	 * to an long value is returned. In all other cases, <code>-1</code> is returned.
	 *
	 * @param key The property key. Must not be <code>null</code>!
	 * @return The stored property value converted to a long value or <code>-1</code>.
	 */
	public long getLongProperty(String key);

	/**
	 * Queries the property value stored under the given property key. If the property
	 * exist and is of type <code>java.lang.Integer</code>, the property value converted
	 * to an integer value is returned. In all other cases, <code>-1</code> is returned.
	 *
	 * @param key The property key. Must not be <code>null</code>!
	 * @return The stored property value converted to an integer value or <code>-1</code>.
	 */
	public int getIntProperty(String key);

	/**
	 * Queries the property value stored under the given property key. If the property
	 * exist and is of type <code>java.lang.Boolean</code>, the property value converted
	 * to an boolean value is returned. In all other cases, <code>false</code> is returned.
	 *
	 * @param key The property key. Must not be <code>null</code>!
	 * @return The stored property value converted to an boolean value or <code>false</code>.
	 */
	public boolean getBooleanProperty(String key);

	/**
	 * Queries the property value stored under the given property key. If the property
	 * exist and is of type <code>java.lang.Float</code>, the property value converted
	 * to an float value is returned. In all other cases, <code>Float.NaN</code> is returned.
	 *
	 * @param key The property key. Must not be <code>null</code>!
	 * @return The stored property value converted to a float value or <code>Float.NaN</code>.
	 */
	public float getFloatProperty(String key);

	/**
	 * Queries the property value stored under the given property key. If the property
	 * exist and is of type <code>java.lang.Double</code>, the property value converted
	 * to an double value is returned. In all other cases, <code>Double.NaN</code> is returned.
	 *
	 * @param key The property key. Must not be <code>null</code>!
	 * @return The stored property value converted to a double value or <code>Double.NaN</code>.
	 */
	public double getDoubleProperty(String key);

	/**
	 * Remove all properties from the properties store. The method does not fire any
	 * properties changed event.
	 */
	public void clearProperties();

	/**
	 * Test if the property value stored under the given property is equal ignoring the case to the given
	 * expected string value.
	 *
	 * @param key The property key. Must not be <code>null</code>.
	 * @param value The expected property string value.
	 * @return <code>true</code> if the expected string value is equal ignoring the case to the stored property value, <code>false</code> otherwise.
	 */
	public boolean isPropertyIgnoreCase(String key, String value);

	/**
	 * Test if the property value stored under the given property is equal to the given
	 * expected value.
	 *
	 * @param key The property key. Must not be <code>null</code>.
	 * @param value The expected property value.
	 * @return <code>true</code> if the expected value is equal to the stored property value, <code>false</code> otherwise.
	 */
	public boolean isProperty(String key, Object value);

	/**
	 * Test if the property value stored under the given property is equal to the given
	 * expected value.
	 *
	 * @param key The property key. Must not be <code>null</code>.
	 * @param value The expected property value.
	 * @return <code>true</code> if the expected value is equal to the stored property value, <code>false</code> otherwise.
	 */
	public boolean isProperty(String key, long value);

	/**
	 * Test if the property value stored under the given property is equal to the given
	 * expected value.
	 *
	 * @param key The property key. Must not be <code>null</code>.
	 * @param value The expected property value.
	 * @return <code>true</code> if the expected value is equal to the stored property value, <code>false</code> otherwise.
	 */
	public boolean isProperty(String key, int value);

	/**
	 * Test if the property value stored under the given property is equal to the given
	 * expected value.
	 *
	 * @param key The property key. Must not be <code>null</code>.
	 * @param value The expected property value.
	 * @return <code>true</code> if the expected value is equal to the stored property value, <code>false</code> otherwise.
	 */
	public boolean isProperty(String key, boolean value);

	/**
	 * Test if the property value stored under the given property is equal to the given
	 * expected value.
	 *
	 * @param key The property key. Must not be <code>null</code>.
	 * @param value The expected property value.
	 * @return <code>true</code> if the expected value is equal to the stored property value, <code>false</code> otherwise.
	 */
	public boolean isProperty(String key, float value);

	/**
	 * Test if the property value stored under the given property is equal to the given
	 * expected value.
	 *
	 * @param key The property key. Must not be <code>null</code>.
	 * @param value The expected property value.
	 * @return <code>true</code> if the expected value is equal to the stored property value, <code>false</code> otherwise.
	 */
	public boolean isProperty(String key, double value);
}
