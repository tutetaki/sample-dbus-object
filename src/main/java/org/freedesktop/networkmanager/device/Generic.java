package org.freedesktop.networkmanager.device;

import org.freedesktop.dbus.annotations.DBusBoundProperty;
import org.freedesktop.dbus.annotations.DBusInterfaceName;
import org.freedesktop.dbus.annotations.DBusProperty.Access;
import org.freedesktop.dbus.interfaces.DBusInterface;

/**
 * Auto-generated class.
 */
@DBusInterfaceName("org.freedesktop.NetworkManager.Device.Generic")
public interface Generic extends DBusInterface {


    @DBusBoundProperty
    public String getHwAddress();
    @DBusBoundProperty
    public String getTypeDescription();

}
