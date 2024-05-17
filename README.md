Hello, using a 5.0.1-SNAPSHOT (master, commit 5041727ca38e31db254d60395e898e0a0c2ac5f8) to generate the `org.freedesktop.NetworkManager` interface with the _dbus-java-utils_ module and I have noted sereval issues.

Here are the commands. I set the `--propertyMethods` argument to use the new annotation `@DBusBoundProperty`. 

```
mvn exec:java \
   -Dexec.mainClass="org.freedesktop.dbus.utils.generator.InterfaceCodeGenerator" \
   -Dexec.executable="java" \
   -Dexec.args="--system --propertyMethods --outputDir /output org.freedesktop.NetworkManager /org/freedesktop/NetworkManager"

mvn exec:java \
   -Dexec.mainClass="org.freedesktop.dbus.utils.generator.InterfaceCodeGenerator" \
   -Dexec.executable="java" \
   -Dexec.args="--system --propertyMethods --outputDir /output org.freedesktop.NetworkManager /org/freedesktop/NetworkManager/Devices/1"
```


0. The generated class `AddAndActivateConnection2Tuple` uses `Variant` but does not import it.
0. The gererated interface `NetworkManager` has property fields annotated with `@DBusBoundProperty` alright.  
   However the ones using a `TypeRef` type are not generated properly. For instance, I get: 

   ```java
   @DBusBoundProperty
   public PropertyDevicesType getDevices();
   
   public static interface PropertyDevicesType extends TypeRef<List<DBusPath>> {
   }
   ```

   Whereas the expected should be:

   ```java
   @DBusBoundProperty(type = PropertyDevicesType.class)
   public List<DBusPath> getDevices();
   
   public static interface PropertyDevicesType extends TypeRef<List<DBusPath>> {
   }
   ```

   Attempting to use the first version result in a ClassCastException

   ```
   > Task :MainNOK.main()
   24/05/17 10:47:30 INFO transports.TransportBuilder: Using transport dbus-java-transport-native-unixsocket for address unix:path=/var/run/dbus/system_bus_socket
   0 [main] INFO org.freedesktop.dbus.connections.transports.TransportBuilder  - Using transport dbus-java-transport-native-unixsocket for address unix:path=/var/run/dbus/system_bus_socket
   Exception in thread "main" java.lang.ClassCastException: class java.util.ArrayList cannot be cast to class org.freedesktop.NetworkManager$PropertyDevicesType (java.util.ArrayList is in module java.base of loader 'bootstrap'; org.freedesktop.NetworkManager$PropertyDevicesType is in unnamed module of loader 'app')
       at jdk.proxy2/jdk.proxy2.$Proxy6.getDevices(Unknown Source)
       at dev.tutetaki.MainNOK.main(MainNOK.java:25)
   ```
   
0. Similarly, gererated interface `Device` has property fields annotated with `@DBusBoundProperty`.
   For the field using a `Struct` type, I get: 

   ```
   @DBusBoundProperty
   public PropertyStateReasonStruct getStateReason();
   ```

   Whereas the expected should be (I'm not sure about this one):

   ```
   @DBusBoundProperty(type = PropertyStateReasonStruct.class)
   public Object[] getStateReason();
   ```

   Attempting to use the first version result in a ClassCastException

   ```
   24/05/17 11:39:40 INFO transports.TransportBuilder: Using transport dbus-java-transport-native-unixsocket for address unix:path=/var/run/dbus/system_bus_socket
   0 [main] INFO org.freedesktop.dbus.connections.transports.TransportBuilder  - Using transport dbus-java-transport-native-unixsocket for address unix:path=/var/run/dbus/system_bus_socket
   Exception in thread "main" java.lang.ClassCastException: class [Ljava.lang.Object; cannot be cast to class org.freedesktop.networkmanager.PropertyStateReasonStruct ([Ljava.lang.Object; is in module java.base of loader 'bootstrap'; org.freedesktop.networkmanager.PropertyStateReasonStruct is in unnamed module of loader 'app')
      at jdk.proxy2/jdk.proxy2.$Proxy8.getStateReason(Unknown Source)
      at dev.tutetaki.MainOK.main(MainOK.java:42)
   ```



Here a sample project to reproduce  