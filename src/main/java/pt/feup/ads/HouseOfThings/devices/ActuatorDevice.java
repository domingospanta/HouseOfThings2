package pt.feup.ads.HouseOfThings.devices;

import pt.feup.ads.HouseOfThings.devices.interfaces.InputDevice;

import java.util.*;

public class ActuatorDevice implements InputDevice {
    private String deviceStatus;
    private Timer timer;
    private List<Integer> telemetryLog;
    private String deviceName = "Unnamed Device";

    public ActuatorDevice(){
        deviceStatus = STATUS_STOPPED;
        timer = new Timer();
        telemetryLog = new ArrayList<Integer>();
        deviceName = "Actuator";
    }

    @Override
    public String getDeviceName() {
        return deviceName;
    }

    public void execute() {
        System.out.println("Output Device Executed");
    }

    public String getStatus() {
        return deviceStatus;
    }

    public void run() {
        deviceStatus = STATUS_RUNNING;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Random rand = new Random();
                telemetryLog.add(rand.nextInt(3));
            }
        }, 0, 5000);
    }

    public void standby() {
        deviceStatus = STATUS_STANDBY;
    }

    public void stop() {
        deviceStatus = STATUS_STOPPED;
    }
}
