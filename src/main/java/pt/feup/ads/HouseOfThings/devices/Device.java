package pt.feup.ads.HouseOfThings.devices;

public interface Device {
    public static final String STATUS_OK = null;

    public String getStatus();
    public Object getTelemetry();
}
