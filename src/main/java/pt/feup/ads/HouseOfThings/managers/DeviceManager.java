package pt.feup.ads.HouseOfThings.managers;

import pt.feup.ads.HouseOfThings.devices.adapters.DeviceAdapter;
import pt.feup.ads.HouseOfThings.devices.interfaces.DeviceI;
import pt.feup.ads.HouseOfThings.managers.observers.ConnectionChangeObserverI;
import pt.feup.ads.HouseOfThings.managers.observers.TelemetryChangeObserverI;

import java.util.*;

public class DeviceManager{
    private final List<DeviceAdapter> deviceList;
    private final List<ConnectionChangeObserverI> connectionObservers;
    private final List<TelemetryChangeObserverI> telemetryObservers;

    private static final DeviceManager instance = new DeviceManager();

    public static DeviceManager getInstance(){
        return instance;
    }

    public DeviceManager(){
        deviceList = new ArrayList<DeviceAdapter>();
        connectionObservers = new ArrayList<ConnectionChangeObserverI>();
        telemetryObservers = new ArrayList<TelemetryChangeObserverI>();
    }

    public void installDevice(DeviceAdapter device){
        deviceList.add(device);
        System.out.println(device.getDeviceName());
        device.standby();
        device.run();

        device.setDeviceManager(this);

        for(ConnectionChangeObserverI dObserver: connectionObservers){
            dObserver.notifyObserver(device);
        }
    }

    public List<DeviceAdapter> getDeviceList(){
        return deviceList;
    }

    public void addConnectionObserver(ConnectionChangeObserverI observer){
        connectionObservers.add(observer);
    }

    public void addTelemetryObserver(TelemetryChangeObserverI observer){
        telemetryObservers.add(observer);
    }

    public void removeConnectionObserver(ConnectionChangeObserverI observer){
        connectionObservers.remove(observer);
    }

    public void notifyTelemetryChange(DeviceAdapter device, Integer value) {
        for(TelemetryChangeObserverI observer: telemetryObservers){
            observer.notifyObserver(device, value);
        }
    }
}
