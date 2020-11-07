package pt.feup.ads.HouseOfThings.plugins;

import pt.feup.ads.HouseOfThings.devices.interfaces.Device;
import pt.feup.ads.HouseOfThings.factory.DeviceFactory;

import java.util.ArrayList;
import java.util.List;

public class WifiConnection implements ConnectionPlugin{

    public List<Device> scanDevices() {
        List<Device> deviceList = new ArrayList<Device>();

        //deviceList.add(DeviceFactory.getInstance().createDevice("TemperatureDevice"));
        //deviceList.add(DeviceFactory.getInstance().createDevice("ActuatorDevice"));
        //deviceList.add(DeviceFactory.getInstance().createDevice("WindspeedDevice"));

        return deviceList;
    }
}
