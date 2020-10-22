package pt.feup.ads.HouseOfThings.devices;

import pt.feup.ads.HouseOfThings.devices.adapters.InputDeviceAdapter;
import pt.feup.ads.HouseOfThings.managers.DeviceManager;

public class BulbDevice extends InputDeviceAdapter {

    public BulbDevice(){
        super();
    }

    public BulbDevice(String deviceName){
        super(deviceName);
    }

    public BulbDevice(String deviceName, DeviceManager deviceManager){
        super(deviceName, deviceManager);
    }

    @Override
    public void execute(Integer value) {
        super.execute(value);

        if(value == 1){
            turnOn();
        }else{
            turnOff();
        }

    }

    private void turnOn(){
        System.out.println("Turning on the lights.");
    }

    private void turnOff(){
        System.out.println("Turning off the lights.");
    }
}
