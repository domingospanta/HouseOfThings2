package pt.feup.ads.HouseOfThings.devices;

public class TempSensorDevice implements Device{
    public static final String STATUS_OK = "OK";

    public TempSensorDevice(){

    }

    public String getStatus() {
        return STATUS_OK;
    }

    public Integer getTelemetry() {
        return 20;
    }

    public void execute() {

    }
}
