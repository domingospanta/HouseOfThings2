package pt.feup.ads.HouseOfThings.devices;

import pt.feup.ads.HouseOfThings.devices.adapters.OutputDeviceAdapter;
import pt.feup.ads.HouseOfThings.devices.interfaces.DeviceI;
import pt.feup.ads.HouseOfThings.devices.interfaces.OutputDeviceI;
import pt.feup.ads.HouseOfThings.managers.DeviceManager;
import pt.feup.ads.HouseOfThings.managers.observers.TelemetryChangeObserverI;

import java.util.*;

public class TemperatureDevice extends OutputDeviceAdapter {

    public TemperatureDevice(){
        super();
    }

    public TemperatureDevice(String deviceName){
        super(deviceName);
    }

    public TemperatureDevice(String deviceName, DeviceManager deviceManager){
        super(deviceName, deviceManager);
    }
}
