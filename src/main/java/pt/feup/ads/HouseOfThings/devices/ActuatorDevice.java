package pt.feup.ads.HouseOfThings.devices;

import pt.feup.ads.HouseOfThings.devices.adapters.InputDeviceAdapter;
import pt.feup.ads.HouseOfThings.managers.DeviceManager;


public class ActuatorDevice extends InputDeviceAdapter {

    public ActuatorDevice(){
        super();
    }

    public ActuatorDevice(String deviceName){
        super(deviceName);
    }

    public ActuatorDevice(String deviceName, DeviceManager deviceManager){
        super(deviceName, deviceManager);
    }

    @Override
    public void execute(Integer value) {
        super.execute(value);

        if(value == 0){
            closeWindows();
        }else{
            openWindows();
        }

    }

    private void closeWindows(){
        System.out.println("Closing Windows");
    }

    private void openWindows(){
        System.out.println("Opening Windows");
    }
}
