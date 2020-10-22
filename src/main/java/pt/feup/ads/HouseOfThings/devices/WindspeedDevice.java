package pt.feup.ads.HouseOfThings.devices;

import pt.feup.ads.HouseOfThings.devices.adapters.OutputDeviceAdapter;
import pt.feup.ads.HouseOfThings.managers.DeviceManager;

public class WindspeedDevice extends OutputDeviceAdapter {

    public WindspeedDevice(){
        super();
    }

    public WindspeedDevice(String deviceName){
        super(deviceName);
    }

    public WindspeedDevice(String deviceName, DeviceManager deviceManager){
        super(deviceName, deviceManager);
    }
}
