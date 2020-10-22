package pt.feup.ads.HouseOfThings.devices.interfaces;

import pt.feup.ads.HouseOfThings.managers.observers.TelemetryChangeObserverI;

public interface Device {
    String STATUS_RUNNING = "RUNNING";
    String STATUS_STANDBY = "STANDBY";
    String STATUS_STOPPED = "STOPPED";

    String getStatus();
    void run();
    void standby();
    void stop();
    String getDeviceName();
}
