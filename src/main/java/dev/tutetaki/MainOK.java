package dev.tutetaki;

import org.apache.log4j.BasicConfigurator;
import org.freedesktop.NetworkManager_Fixed;
import org.freedesktop.dbus.DBusPath;
import org.freedesktop.dbus.connections.impl.DBusConnection;
import org.freedesktop.dbus.connections.impl.DBusConnectionBuilder;
import org.freedesktop.dbus.exceptions.DBusException;
import org.freedesktop.dbus.types.UInt32;
import org.freedesktop.networkmanager.Device_Fixed;

import java.io.IOException;
import java.util.List;

public class MainOK {

    public static void main(String[] args) {
        BasicConfigurator.configure();

        try (DBusConnection dbus = DBusConnectionBuilder.forSystemBus().build()) {
            // Uses edited class
            NetworkManager_Fixed networkManager = dbus.getRemoteObject(
                    "org.freedesktop.NetworkManager",
                    "/org/freedesktop/NetworkManager",
                    NetworkManager_Fixed.class);

            // outputs a result
            // ex: [/org/freedesktop/NetworkManager/Devices/1, /org/freedesktop/NetworkManager/Devices/2, /org/freedesktop/NetworkManager/Devices/3, /org/freedesktop/NetworkManager/Devices/4, /org/freedesktop/NetworkManager/Devices/5, /org/freedesktop/NetworkManager/Devices/6]
            List<DBusPath> devices = networkManager.getDevices();
            System.out.println(devices);

            // outputs a result
            // ex: [1]
            List<UInt32> capabilities = networkManager.getCapabilities();
            System.out.println(capabilities);

            // Uses edited class
            Device_Fixed device1 = dbus.getRemoteObject(
                    "org.freedesktop.NetworkManager",
                    "/org/freedesktop/NetworkManager/Devices/1",
                    Device_Fixed.class);

            // outputs a result
            // ex: 14
            UInt32 deviceType = device1.getDeviceType();
            System.out.println(deviceType);

            // outputs a result
            // ex: 10, 0
            Object[] stateReason = device1.getStateReason();
            System.out.println(stateReason[0] + ", " + stateReason[1]);
        } catch (DBusException e) {
            System.out.println("Could get reference to a remote object");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not close dbus connection properly");
            e.printStackTrace();
        }
    }
}