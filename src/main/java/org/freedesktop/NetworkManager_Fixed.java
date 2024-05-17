package org.freedesktop;

import org.freedesktop.dbus.DBusPath;
import org.freedesktop.dbus.TypeRef;
import org.freedesktop.dbus.annotations.DBusBoundProperty;
import org.freedesktop.dbus.annotations.DBusInterfaceName;
import org.freedesktop.dbus.exceptions.DBusException;
import org.freedesktop.dbus.interfaces.DBusInterface;
import org.freedesktop.dbus.messages.DBusSignal;
import org.freedesktop.dbus.types.UInt32;
import org.freedesktop.dbus.types.Variant;

import java.util.List;
import java.util.Map;

/**
 * Edited @DBusBoundProperty of fields using TypeRef.
 */
@DBusInterfaceName("org.freedesktop.NetworkManager")
public interface NetworkManager_Fixed extends DBusInterface {


    public void Reload(UInt32 flags);

    public List<DBusPath> GetDevices();

    public List<DBusPath> GetAllDevices();

    public DBusPath GetDeviceByIpIface(String iface);

    public DBusPath ActivateConnection(DBusPath connection, DBusPath device, DBusPath specificObject);

    public AddAndActivateConnectionTuple AddAndActivateConnection(Map<String, Map<String, Variant<?>>> connection, DBusPath device, DBusPath specificObject);

    public AddAndActivateConnection2Tuple AddAndActivateConnection2(Map<String, Map<String, Variant<?>>> connection, DBusPath device, DBusPath specificObject, Map<String, Variant<?>> options);

    public void DeactivateConnection(DBusPath activeConnection);

    public void Sleep(boolean sleep);

    public void Enable(boolean enable);

    public Map<String, String> GetPermissions();

    public void SetLogging(String level, String domains);

    public GetLoggingTuple GetLogging();

    public UInt32 CheckConnectivity();

    public UInt32 state();

    public DBusPath CheckpointCreate(List<DBusPath> devices, UInt32 rollbackTimeout, UInt32 flags);

    public void CheckpointDestroy(DBusPath checkpoint);

    public Map<String, UInt32> CheckpointRollback(DBusPath checkpoint);

    public void CheckpointAdjustRollbackTimeout(DBusPath checkpoint, UInt32 addTimeout);

    @DBusBoundProperty(type = PropertyDevicesType.class)
    public List<DBusPath> getDevices();

    @DBusBoundProperty(type = PropertyAllDevicesType.class)
    public List<DBusPath> getAllDevices();

    @DBusBoundProperty(type = PropertyCheckpointsType.class)
    public List<DBusPath> getCheckpoints();

    @DBusBoundProperty
    public boolean isNetworkingEnabled();

    @DBusBoundProperty
    public boolean isWirelessEnabled();

    @DBusBoundProperty
    public void setWirelessEnabled(boolean wirelessEnabled);

    @DBusBoundProperty
    public boolean isWirelessHardwareEnabled();

    @DBusBoundProperty
    public boolean isWwanEnabled();

    @DBusBoundProperty
    public void setWwanEnabled(boolean wwanEnabled);

    @DBusBoundProperty
    public boolean isWwanHardwareEnabled();

    @DBusBoundProperty
    public boolean isWimaxEnabled();

    @DBusBoundProperty
    public void setWimaxEnabled(boolean wimaxEnabled);

    @DBusBoundProperty
    public boolean isWimaxHardwareEnabled();

    @DBusBoundProperty
    public UInt32 getRadioFlags();

    @DBusBoundProperty(type = PropertyActiveConnectionsType.class)
    public List<DBusPath> getActiveConnections();

    @DBusBoundProperty
    public DBusPath getPrimaryConnection();

    @DBusBoundProperty
    public String getPrimaryConnectionType();

    @DBusBoundProperty
    public UInt32 getMetered();

    @DBusBoundProperty
    public DBusPath getActivatingConnection();

    @DBusBoundProperty
    public boolean isStartup();

    @DBusBoundProperty
    public String getVersion();

    @DBusBoundProperty(type = PropertyCapabilitiesType.class)
    public List<UInt32> getCapabilities();

    @DBusBoundProperty
    public UInt32 getState();

    @DBusBoundProperty
    public UInt32 getConnectivity();

    @DBusBoundProperty
    public boolean isConnectivityCheckAvailable();

    @DBusBoundProperty
    public boolean isConnectivityCheckEnabled();

    @DBusBoundProperty
    public void setConnectivityCheckEnabled(boolean connectivityCheckEnabled);

    @DBusBoundProperty
    public String getConnectivityCheckUri();

    @DBusBoundProperty(type = PropertyGlobalDnsConfigurationType.class)
    public Map<String, Variant> getGlobalDnsConfiguration();

    @DBusBoundProperty(type = PropertyGlobalDnsConfigurationType.class)
    public void setGlobalDnsConfiguration(Map<String, Variant> globalDnsConfiguration);


    public static class StateChanged extends DBusSignal {

        private final UInt32 state;

        public StateChanged(String _path, UInt32 _state) throws DBusException {
            super(_path, _state);
            this.state = _state;
        }


        public UInt32 getState() {
            return state;
        }


    }

    public static class DeviceAdded extends DBusSignal {

        private final DBusPath devicePath;

        public DeviceAdded(String _path, DBusPath _devicePath) throws DBusException {
            super(_path, _devicePath);
            this.devicePath = _devicePath;
        }


        public DBusPath getDevicePath() {
            return devicePath;
        }


    }

    public static class DeviceRemoved extends DBusSignal {

        private final DBusPath devicePath;

        public DeviceRemoved(String _path, DBusPath _devicePath) throws DBusException {
            super(_path, _devicePath);
            this.devicePath = _devicePath;
        }


        public DBusPath getDevicePath() {
            return devicePath;
        }


    }

    public static interface PropertyDevicesType extends TypeRef<List<DBusPath>> {


    }

    public static interface PropertyAllDevicesType extends TypeRef<List<DBusPath>> {


    }

    public static interface PropertyCheckpointsType extends TypeRef<List<DBusPath>> {


    }

    public static interface PropertyActiveConnectionsType extends TypeRef<List<DBusPath>> {


    }

    public static interface PropertyCapabilitiesType extends TypeRef<List<UInt32>> {


    }

    public static interface PropertyGlobalDnsConfigurationType extends TypeRef<Map<String, Variant>> {


    }
}
