package pt.feup.ads.HouseOfThings.factory;

import pt.feup.ads.HouseOfThings.devices.Device;
import pt.feup.ads.HouseOfThings.devices.TempSensorDevice;
import pt.feup.ads.HouseOfThings.plugins.ConnectionPlugin;

import java.util.ArrayList;
import java.util.List;

public class DeviceFactory {
    private static final DeviceFactory instance = new DeviceFactory();

    public DeviceFactory(){

    }

    public static DeviceFactory getInstance(){
        return instance;
    }

    public TempSensorDevice createDevice(){
        return new TempSensorDevice();
    }
}
