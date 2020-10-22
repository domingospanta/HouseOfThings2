package pt.feup.ads.HouseOfThings.plugins;

import pt.feup.ads.HouseOfThings.devices.Device;
import pt.feup.ads.HouseOfThings.factory.DeviceFactory;

import java.util.ArrayList;
import java.util.List;

public class WifiConnection implements ConnectionPlugin{

    public List<Device> scanDevices() {
        List<Device> deviceList = new ArrayList<Device>();

        deviceList.add(DeviceFactory.getInstance().createDevice());
        deviceList.add(DeviceFactory.getInstance().createDevice());
        deviceList.add(DeviceFactory.getInstance().createDevice());

        return deviceList;
    }
}
