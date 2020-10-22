package pt.feup.ads.HouseOfThings.devices;

public interface Device {
    String STATUS_OK = null;
    String getStatus();
    Integer getTelemetry();
    void execute();
}
