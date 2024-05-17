package dev.tutetaki.dbus;

import org.freedesktop.dbus.DBusPath;
import org.freedesktop.dbus.TypeRef;
import org.freedesktop.dbus.annotations.DBusBoundProperty;
import org.freedesktop.dbus.annotations.DBusInterfaceName;
import org.freedesktop.dbus.interfaces.DBusInterface;

import java.util.List;

@DBusInterfaceName("dev.tutetaki.FruitManager")
public interface FruitManager extends DBusInterface {

    List<DBusPath> ListFruits();


    @DBusBoundProperty(type = PropertyFruitType.class)
    List<DBusPath> getFruits();


    public static interface PropertyFruitType extends TypeRef<List<DBusPath>> {

    }
}