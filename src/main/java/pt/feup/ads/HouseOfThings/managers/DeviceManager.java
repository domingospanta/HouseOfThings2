package pt.feup.ads.HouseOfThings.managers;

import pt.feup.ads.HouseOfThings.devices.Device;
import pt.feup.ads.HouseOfThings.managers.observers.DeviceManagerObserverI;

import java.util.ArrayList;
import java.util.List;

public class DeviceManager {
    private final List<Device> deviceList;
    private final List<DeviceManagerObserverI> observers;

    private static final DeviceManager instance = new DeviceManager();

    public static DeviceManager getInstance(){
        return instance;
    }

    public DeviceManager(){
        deviceList = new ArrayList<Device>();
        observers = new ArrayList<DeviceManagerObserverI>();
    }

    public void installDevice(Device device){
        deviceList.add(device);
        for(DeviceManagerObserverI dObserver: observers){
            dObserver.notifyObserver(device);
        }
    }

    public List<Device> getDeviceList(){
        return deviceList;
    }

    public void addObserver(DeviceManagerObserverI observer){
        observers.add(observer);
    }

    public void removeObserver(DeviceManagerObserverI observer){
        observers.remove(observer);
    }
}
