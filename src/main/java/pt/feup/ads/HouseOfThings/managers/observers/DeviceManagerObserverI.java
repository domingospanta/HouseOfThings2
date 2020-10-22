package pt.feup.ads.HouseOfThings.managers.observers;

import pt.feup.ads.HouseOfThings.devices.Device;

public interface DeviceManagerObserverI {
    void notifyObserver(Device device);
}
