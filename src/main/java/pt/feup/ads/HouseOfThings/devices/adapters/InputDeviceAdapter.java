package pt.feup.ads.HouseOfThings.devices.adapters;

import pt.feup.ads.HouseOfThings.devices.interfaces.InputDeviceI;
import pt.feup.ads.HouseOfThings.managers.DeviceManager;

public class InputDeviceAdapter extends DeviceAdapter implements InputDeviceI {


    public InputDeviceAdapter(){
        super();
    }

    public InputDeviceAdapter(String deviceName){
        super(deviceName);
    }

    public InputDeviceAdapter(String deviceName, DeviceManager deviceManager){
        super(deviceName, deviceManager);
    }

    @Override
    public void execute(Integer value) {
        System.out.println(getDeviceName() + " has been tripped.");
    }

    @Override
    public boolean isInputDevice() {
        return true;
    }

    @Override
    public boolean isOutputDevice() {
        return false;
    }
}
