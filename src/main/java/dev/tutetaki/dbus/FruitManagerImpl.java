package dev.tutetaki.dbus;

import org.freedesktop.dbus.DBusPath;

import java.util.List;

public class FruitManagerImpl implements FruitManager {

    @Override
    public List<DBusPath> ListFruits() {
        return List.of(
                new DBusPath("/dev/tutetaki/FruitManager/1"),
                new DBusPath("/dev/tutetaki/FruitManager/2"),
                new DBusPath("/dev/tutetaki/FruitManager/3")
        );
    }

    @Override
    public List<DBusPath> getFruits() {
        return ListFruits();
    }

    @Override
    public String getObjectPath() {
        return "/dev/tutetaki/FruitManager";
    }
}
