package pt.feup.ads.HouseOfThings.managers.observers;

import pt.feup.ads.HouseOfThings.devices.interfaces.Device;

public interface DeviceManagerObserverI {
    void notifyObserver(Device device);
}
