package pt.feup.ads.HouseOfThings.devices;

import pt.feup.ads.HouseOfThings.devices.adapters.OutputDeviceAdapter;
import pt.feup.ads.HouseOfThings.managers.DeviceManager;

public class LightDetectionDevice extends OutputDeviceAdapter {

    public LightDetectionDevice(){
        super();
    }

    public LightDetectionDevice(String deviceName){
        super(deviceName);
    }

    public LightDetectionDevice(String deviceName, DeviceManager deviceManager){
        super(deviceName, deviceManager);
    }
}
