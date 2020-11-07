package pt.feup.ads.HouseOfThings.connectors.adapters;

import pt.feup.ads.HouseOfThings.connectors.interfaces.ConnectionPlugin;
import pt.feup.ads.HouseOfThings.devices.adapters.DeviceAdapter;
import pt.feup.ads.HouseOfThings.factory.DeviceFactory;
import pt.feup.ads.HouseOfThings.managers.DeviceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConnectionAdapter implements ConnectionPlugin {

    private String name = "Unnamed Connection";

    List<DeviceAdapter> devices = new ArrayList<>();

    public ConnectionAdapter(String name){
        this.name = name;
    }

    public List<DeviceAdapter> scanDevices() {
        System.out.println("Scanning Devices...");

        List<DeviceAdapter> existingDevices  = DeviceManager.getInstance().getDeviceList();
        for(DeviceAdapter deviceAdapter: existingDevices){
            deviceAdapter.getDeviceConnector().ifPresent(connector -> {
                if(connector.getName().equals(this.getName())){
                    devices.add(deviceAdapter);
                    System.out.println(deviceAdapter);
                }
            });
        }

        /*List<DeviceAdapter> deviceList = new ArrayList<DeviceAdapter>();

        deviceList.add(DeviceFactory.getInstance().createDevice("TemperatureDevice", "Temperature Device"));
        deviceList.add(DeviceFactory.getInstance().createDevice("ActuatorDevice", "Actuator Device"));
        deviceList.add(DeviceFactory.getInstance().createDevice("BulbDevice", "Light Bulb Device"));
        deviceList.add(DeviceFactory.getInstance().createDevice("LightDetectionDevice", "Light Detection Device"));

        return deviceList;
         */

        return devices;
    }

    public int deviceCount() {
        return devices.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object connection) {
        if (this == connection) return true;
        if (connection == null || getClass() != connection.getClass()) return false;
        ConnectionAdapter that = (ConnectionAdapter) connection;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
