package dev.tutetaki;

import org.apache.log4j.BasicConfigurator;
import org.freedesktop.NetworkManager;
import org.freedesktop.dbus.connections.impl.DBusConnection;
import org.freedesktop.dbus.connections.impl.DBusConnectionBuilder;
import org.freedesktop.networkmanager.Device;
import org.freedesktop.networkmanager.PropertyStateReasonStruct;

public class MainNOK {

    public static void main(String[] args) {
        BasicConfigurator.configure();

        try (DBusConnection dbus = DBusConnectionBuilder.forSystemBus().build()) {
            // Uses generated class
            NetworkManager networkManager = dbus.getRemoteObject(
                    "org.freedesktop.NetworkManager",
                    "/org/freedesktop/NetworkManager",
                    NetworkManager.class);

            // Outputs
            // Exception in thread "main" java.lang.ClassCastException: class java.util.ArrayList cannot be cast to class org.freedesktop.NetworkManager$PropertyDevicesType (java.util.ArrayList is in module java.base of loader 'bootstrap'; org.freedesktop.NetworkManager$PropertyDevicesType is in unnamed module of loader 'app')
            System.out.println(networkManager.getDevices());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (DBusConnection dbus = DBusConnectionBuilder.forSystemBus().build()) {
            // Uses generated class
            Device device1 = dbus.getRemoteObject(
                    "org.freedesktop.NetworkManager",
                    "/org/freedesktop/NetworkManager/Devices/1",
                    Device.class);

            // Outputs
            // Exception in thread "main" java.lang.ClassCastException: class [Ljava.lang.Object; cannot be cast to class org.freedesktop.networkmanager.PropertyStateReasonStruct ([Ljava.lang.Object; is in module java.base of loader 'bootstrap'; org.freedesktop.networkmanager.PropertyStateReasonStruct is in unnamed module of loader 'app')
            PropertyStateReasonStruct stateReason = device1.getStateReason();
            System.out.println(stateReason.getMember0() + ", " + stateReason.getMember1());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}