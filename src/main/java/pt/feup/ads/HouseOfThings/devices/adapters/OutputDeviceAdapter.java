package pt.feup.ads.HouseOfThings.devices.adapters;

import pt.feup.ads.HouseOfThings.devices.interfaces.OutputDeviceI;
import pt.feup.ads.HouseOfThings.managers.DeviceManager;

import java.util.*;

public class OutputDeviceAdapter extends DeviceAdapter implements OutputDeviceI {
    private final List<Integer> telemetryLog;
    private final Timer timer;

    public OutputDeviceAdapter(){
        super();
        telemetryLog = new ArrayList<Integer>();
        timer = new Timer();
    }

    public OutputDeviceAdapter(String deviceName){
        super(deviceName);
        telemetryLog = new ArrayList<Integer>();
        timer = new Timer();
    }

    public OutputDeviceAdapter(String deviceName, DeviceManager deviceManager){
        super(deviceName, deviceManager);
        telemetryLog = new ArrayList<Integer>();
        timer = new Timer();
    }

    @Override
    public Integer getTelemetry() {
        if(telemetryLog.size() != 0){
            return telemetryLog.get(telemetryLog.size() - 1);
        }else{
            return -1;
        }
    }

    @Override
    public void run() {
        super.run();
        final DeviceAdapter thisDevice = this;
        timer.schedule(new TimerTask() {
           @Override
           public void run() {
                Random rand = new Random();
                Integer randomNumber = rand.nextInt(3);

                if(telemetryLog.size() == 0 || !telemetryLog.get(telemetryLog.size() - 1).equals(randomNumber)){
                    getDeviceManager().ifPresent(deviceManager -> {
                        deviceManager.notifyTelemetryChange(thisDevice, randomNumber);
                    });
                }

                System.out.println(getDeviceName() + " value: " + randomNumber);
                telemetryLog.add(randomNumber);
            }
        }, 0, 5000);
    }

    @Override
    public boolean isInputDevice() {
        return false;
    }

    @Override
    public boolean isOutputDevice() {
        return true;
    }
}
