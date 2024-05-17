package org.freedesktop.networkmanager;

import org.freedesktop.dbus.DBusPath;
import org.freedesktop.dbus.TypeRef;
import org.freedesktop.dbus.annotations.DBusBoundProperty;
import org.freedesktop.dbus.annotations.DBusInterfaceName;
import org.freedesktop.dbus.exceptions.DBusException;
import org.freedesktop.dbus.interfaces.DBusInterface;
import org.freedesktop.dbus.messages.DBusSignal;
import org.freedesktop.dbus.types.UInt32;
import org.freedesktop.dbus.types.UInt64;
import org.freedesktop.dbus.types.Variant;

import java.util.List;
import java.util.Map;

/**
 * Edited @DBusBoundProperty of fields using Struct.
 */
@DBusInterfaceName("org.freedesktop.NetworkManager.Device")
public interface Device_Fixed extends DBusInterface {


    public void Reapply(Map<String, Map<String, Variant<?>>> connection, UInt64 versionId, UInt32 flags);

    public GetAppliedConnectionTuple GetAppliedConnection(UInt32 flags);

    public void Disconnect();

    public void Delete();

    @DBusBoundProperty
    public String getUdi();

    @DBusBoundProperty
    public String getPath();

    @DBusBoundProperty
    public String getInterface();

    @DBusBoundProperty
    public String getIpInterface();

    @DBusBoundProperty
    public String getDriver();

    @DBusBoundProperty
    public String getDriverVersion();

    @DBusBoundProperty
    public String getFirmwareVersion();

    @DBusBoundProperty
    public UInt32 getCapabilities();

    @DBusBoundProperty
    public UInt32 getIp4Address();

    @DBusBoundProperty
    public UInt32 getState();

    @DBusBoundProperty(type = PropertyStateReasonStruct.class)
    public Object[] getStateReason();

    @DBusBoundProperty
    public DBusPath getActiveConnection();

    @DBusBoundProperty
    public DBusPath getIp4Config();

    @DBusBoundProperty
    public DBusPath getDhcp4Config();

    @DBusBoundProperty
    public DBusPath getIp6Config();

    @DBusBoundProperty
    public DBusPath getDhcp6Config();

    @DBusBoundProperty
    public boolean isManaged();

    @DBusBoundProperty
    public void setManaged(boolean managed);

    @DBusBoundProperty
    public boolean isAutoconnect();

    @DBusBoundProperty
    public void setAutoconnect(boolean autoconnect);

    @DBusBoundProperty
    public boolean isFirmwareMissing();

    @DBusBoundProperty
    public boolean isNmPluginMissing();

    @DBusBoundProperty
    public UInt32 getDeviceType();

    @DBusBoundProperty
    public PropertyAvailableConnectionsType getAvailableConnections();

    @DBusBoundProperty
    public String getPhysicalPortId();

    @DBusBoundProperty
    public UInt32 getMtu();

    @DBusBoundProperty
    public UInt32 getMetered();

    @DBusBoundProperty
    public PropertyLldpNeighborsType getLldpNeighbors();

    @DBusBoundProperty
    public boolean isReal();

    @DBusBoundProperty
    public UInt32 getIp4Connectivity();

    @DBusBoundProperty
    public UInt32 getIp6Connectivity();

    @DBusBoundProperty
    public UInt32 getInterfaceFlags();

    @DBusBoundProperty
    public String getHwAddress();

    @DBusBoundProperty
    public PropertyPortsType getPorts();


    public static class StateChanged extends DBusSignal {

        private final UInt32 newState;
        private final UInt32 oldState;
        private final UInt32 reason;

        public StateChanged(String _path, UInt32 _newState, UInt32 _oldState, UInt32 _reason) throws DBusException {
            super(_path, _newState, _oldState, _reason);
            this.newState = _newState;
            this.oldState = _oldState;
            this.reason = _reason;
        }


        public UInt32 getNewState() {
            return newState;
        }

        public UInt32 getOldState() {
            return oldState;
        }

        public UInt32 getReason() {
            return reason;
        }


    }

    public static interface PropertyAvailableConnectionsType extends TypeRef<List<DBusPath>> {


    }

    public static interface PropertyLldpNeighborsType extends TypeRef<List<Map<String, Variant>>> {


    }

    public static interface PropertyPortsType extends TypeRef<List<DBusPath>> {


    }
}
