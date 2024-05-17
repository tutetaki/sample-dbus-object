package org.freedesktop.networkmanager.device;

import org.freedesktop.dbus.annotations.DBusBoundProperty;
import org.freedesktop.dbus.annotations.DBusInterfaceName;
import org.freedesktop.dbus.annotations.DBusProperty.Access;
import org.freedesktop.dbus.interfaces.DBusInterface;
import org.freedesktop.dbus.types.UInt32;
import org.freedesktop.dbus.types.UInt64;

/**
 * Auto-generated class.
 */
@DBusInterfaceName("org.freedesktop.NetworkManager.Device.Statistics")
public interface Statistics extends DBusInterface {


    @DBusBoundProperty
    public UInt32 getRefreshRateMs();
    @DBusBoundProperty
    public void setRefreshRateMs(UInt32 refreshRateMs);
    @DBusBoundProperty
    public UInt64 getTxBytes();
    @DBusBoundProperty
    public UInt64 getRxBytes();

}
