package pt.feup.ads.HouseOfThings.connectors.adapters;

import pt.feup.ads.HouseOfThings.connectors.interfaces.ConnectionPlugin;
import pt.feup.ads.HouseOfThings.devices.adapters.DeviceAdapter;
import pt.feup.ads.HouseOfThings.factory.DeviceFactory;

import java.util.ArrayList;
import java.util.List;

public class ConnectionAdapter implements ConnectionPlugin {

    private String name = "Unnamed Connection";

    public ConnectionAdapter(String name){
        this.name = name;
    }

    public List<DeviceAdapter> scanDevices() {
        System.out.println("Scanning Devices...");
        List<DeviceAdapter> deviceList = new ArrayList<DeviceAdapter>();

        deviceList.add(DeviceFactory.getInstance().createDevice("TemperatureDevice", "Temperature Device"));
        deviceList.add(DeviceFactory.getInstance().createDevice("ActuatorDevice", "Actuator Device"));
        deviceList.add(DeviceFactory.getInstance().createDevice("BulbDevice", "Light Bulb Device"));
        deviceList.add(DeviceFactory.getInstance().createDevice("LightDetectionDevice", "Light Detection Device"));

        return deviceList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
