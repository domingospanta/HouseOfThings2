package pt.feup.ads.HouseOfThings.devices.interfaces;

import pt.feup.ads.HouseOfThings.managers.observers.TelemetryChangeObserverI;

public interface OutputDeviceI extends DeviceI {
    Integer getTelemetry();
}
