package pt.feup.ads.HouseOfThings.managers;

import pt.feup.ads.HouseOfThings.devices.interfaces.Device;
import pt.feup.ads.HouseOfThings.devices.interfaces.OutputDevice;
import pt.feup.ads.HouseOfThings.managers.observers.DeviceManagerObserverI;
import pt.feup.ads.HouseOfThings.managers.observers.TelemetryChangeObserverI;

import java.util.*;

public class DeviceManager implements TelemetryChangeObserverI{
    private final List<Device> deviceList;
    private final List<DeviceManagerObserverI> connectionObservers;
    private final List<TelemetryChangeObserverI> telemetryObservers;

    private static final DeviceManager instance = new DeviceManager();

    public static DeviceManager getInstance(){
        return instance;
    }

    public DeviceManager(){
        deviceList = new ArrayList<Device>();
        connectionObservers = new ArrayList<DeviceManagerObserverI>();
        telemetryObservers = new ArrayList<TelemetryChangeObserverI>();
    }

    public void installDevice(Device device){
        deviceList.add(device);
        System.out.println(device.getDeviceName());
        device.standby();
        device.run();

        if(device instanceof OutputDevice){
            ((OutputDevice)device).addTelemetryObserver(this);
        }

        for(DeviceManagerObserverI dObserver: connectionObservers){
            dObserver.notifyObserver(device);
        }
    }

    public List<Device> getDeviceList(){
        return deviceList;
    }

    public void addConnectionObserver(DeviceManagerObserverI observer){
        connectionObservers.add(observer);
    }

    public void addTelemetryObserver(TelemetryChangeObserverI observer){
        telemetryObservers.add(observer);
    }

    public void removeConnectionObserver(DeviceManagerObserverI observer){
        connectionObservers.remove(observer);
    }

    @Override
    public void notifyObserver(Device device, Integer value) {
        for(TelemetryChangeObserverI telemetryObserver: telemetryObservers){
            telemetryObserver.notifyObserver(device, value);
        }
    }
}
