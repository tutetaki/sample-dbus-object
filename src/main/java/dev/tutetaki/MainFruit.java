package dev.tutetaki;

import dev.tutetaki.dbus.FruitManager;
import dev.tutetaki.dbus.FruitManagerImpl;
import org.apache.log4j.BasicConfigurator;
import org.freedesktop.dbus.DBusPath;
import org.freedesktop.dbus.connections.impl.DBusConnection;
import org.freedesktop.dbus.connections.impl.DBusConnectionBuilder;
import org.freedesktop.dbus.exceptions.DBusException;
import org.freedesktop.dbus.interfaces.Properties;

import java.util.List;

public class MainFruit {

    public static void main(String[] args) throws DBusException {
        BasicConfigurator.configure();

        DBusConnection dbus = DBusConnectionBuilder.forSessionBus().build();
        FruitManager fruitManager = new FruitManagerImpl();
        dbus.exportObject(fruitManager.getObjectPath(), fruitManager);

        dbus.requestBusName("dev.tutetaki.FruitManager");

        //--

        FruitManager remoteObj = dbus.getRemoteObject(
                "dev.tutetaki.FruitManager",
                "/dev/tutetaki/FruitManager",
                FruitManager.class);

        // outputs a result OK
        // >>> [/dev/tutetaki/FruitManager/1, /dev/tutetaki/FruitManager/2, /dev/tutetaki/FruitManager/3]
        List<DBusPath> pathsFromMethod = remoteObj.ListFruits();
        System.out.println(pathsFromMethod);

        // outputs a result OK
        // >>> [/dev/tutetaki/FruitManager/1, /dev/tutetaki/FruitManager/2, /dev/tutetaki/FruitManager/3]
        List<DBusPath> pathsFromProperty = remoteObj.getFruits();
        System.out.println(pathsFromProperty);

        //--

        Properties remotePropObj = dbus.getRemoteObject(
                "dev.tutetaki.FruitManager",
                "/dev/tutetaki/FruitManager",
                Properties.class);

        // outputs a result OK
        // >>> [/dev/tutetaki/FruitManager/1, /dev/tutetaki/FruitManager/2, /dev/tutetaki/FruitManager/3]
        Object getResult = remotePropObj.Get("dev.tutetaki.FruitManager", "Fruits");
        System.out.println(getResult);

        // Error
        // Exception in thread "main" org.freedesktop.dbus.exceptions.DBusExecutionException: Error Executing Method org.freedesktop.DBus.Properties.GetAll: Exporting non-exportable type: class java.util.ImmutableCollections$ListN
        //	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
        //	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:77)
        //	at java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
        //	at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:499)
        //	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:480)
        //	at org.freedesktop.dbus.messages.Error.getException(Error.java:111)
        //	at org.freedesktop.dbus.messages.Error.throwException(Error.java:138)
        //	at org.freedesktop.dbus.RemoteInvocationHandler.executeRemoteMethod(RemoteInvocationHandler.java:237)
        //	at org.freedesktop.dbus.RemoteInvocationHandler.executeRemoteMethod(RemoteInvocationHandler.java:250)
        //	at org.freedesktop.dbus.RemoteInvocationHandler.executeRemoteMethod(RemoteInvocationHandler.java:153)
        //	at org.freedesktop.dbus.RemoteInvocationHandler.invoke(RemoteInvocationHandler.java:97)
        //	at jdk.proxy2/jdk.proxy2.$Proxy8.GetAll(Unknown Source)
        //	at dev.tutetaki.MainFruit.main(MainFruit.java:54)
        Object getAllResult = remotePropObj.GetAll("dev.tutetaki.FruitManager");
        System.out.println(getAllResult);
    }
}