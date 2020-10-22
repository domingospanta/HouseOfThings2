package pt.feup.ads.HouseOfThings.managers.observers;

import pt.feup.ads.HouseOfThings.devices.interfaces.DeviceI;

public interface ConnectionChangeObserverI {
    void notifyObserver(DeviceI device);
}
