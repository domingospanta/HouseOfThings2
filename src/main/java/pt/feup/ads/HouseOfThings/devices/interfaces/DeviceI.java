package pt.feup.ads.HouseOfThings.devices.interfaces;

public interface DeviceI {
    String STATUS_RUNNING = "RUNNING";
    String STATUS_STANDBY = "STANDBY";
    String STATUS_STOPPED = "STOPPED";

    String DEFAULT_NAME = "Unnamed Device";
    String DEFAULT_STATUS = STATUS_STOPPED;

    String getStatus();
    void run();
    void standby();
    void stop();
    String getDeviceName();
    void setDeviceName(String deviceName);
    boolean isInputDevice();
    boolean isOutputDevice();
}
