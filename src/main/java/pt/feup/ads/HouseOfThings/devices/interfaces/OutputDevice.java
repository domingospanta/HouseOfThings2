package pt.feup.ads.HouseOfThings.devices.interfaces;

import pt.feup.ads.HouseOfThings.managers.observers.TelemetryChangeObserverI;

public interface OutputDevice extends Device{
    Integer getTelemetry();
    void addTelemetryObserver(TelemetryChangeObserverI observer);
}
