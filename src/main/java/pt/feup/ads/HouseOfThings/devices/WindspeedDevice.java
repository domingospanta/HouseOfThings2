package pt.feup.ads.HouseOfThings.devices;

import pt.feup.ads.HouseOfThings.devices.interfaces.Device;
import pt.feup.ads.HouseOfThings.devices.interfaces.OutputDevice;
import pt.feup.ads.HouseOfThings.managers.observers.TelemetryChangeObserverI;

import java.util.*;

public class WindspeedDevice implements OutputDevice {
    private String deviceStatus;
    private Timer timer;
    private List<Integer> telemetryLog;
    private List<TelemetryChangeObserverI> telemetryObservers;
    private String deviceName = "Unnamed Device";

    public WindspeedDevice(){
        deviceStatus = STATUS_STOPPED;
        timer = new Timer();
        telemetryLog = new ArrayList<Integer>();
        telemetryObservers = new ArrayList<TelemetryChangeObserverI>();
        deviceName = "Windspeed Device";
    }

    public String getStatus() {
        return deviceStatus;
    }

    @Override
    public String getDeviceName() {
        return deviceName;
    }

    public void run() {
        deviceStatus = STATUS_RUNNING;
        final Device thisDevice = this;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Random rand = new Random();
                Integer randomNumber = rand.nextInt(3);

                if(telemetryLog.size() == 0 || !telemetryLog.get(telemetryLog.size() - 1).equals(randomNumber)){
                    for(TelemetryChangeObserverI telemetryObserver: telemetryObservers){
                        telemetryObserver.notifyObserver(thisDevice, randomNumber);
                    }
                }

                telemetryLog.add(randomNumber);
                System.out.println( deviceName + ": " + randomNumber);
            }
        }, 0, 5000);
    }

    public void standby() {
        deviceStatus = STATUS_STANDBY;
    }

    public void stop() {
        deviceStatus = STATUS_STOPPED;
    }

    public Integer getTelemetry() {
        return 60;
    }

    @Override
    public void addTelemetryObserver(TelemetryChangeObserverI observer) {
        telemetryObservers.add(observer);
    }
}
