package pt.feup.ads.HouseOfThings.connectors;

import pt.feup.ads.HouseOfThings.connectors.adapters.ConnectionAdapter;
import pt.feup.ads.HouseOfThings.devices.adapters.DeviceAdapter;
import pt.feup.ads.HouseOfThings.factory.DeviceFactory;

import java.util.ArrayList;
import java.util.List;

public class WifiConnection extends ConnectionAdapter {

    public WifiConnection(String name){
        super(name);
    }

    @Override
    public List<DeviceAdapter> scanDevices() {
        System.out.println(getName() + " is scanning Devices...");
        List<DeviceAdapter> deviceList = new ArrayList<DeviceAdapter>();

        deviceList.add(DeviceFactory.getInstance().createDevice("BulbDevice", "Light Bulb Device"));
        deviceList.add(DeviceFactory.getInstance().createDevice("LightDetectionDevice", "Light Detection Device"));

        return deviceList;
    }
}
