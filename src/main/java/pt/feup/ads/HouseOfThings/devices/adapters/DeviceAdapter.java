package pt.feup.ads.HouseOfThings.devices.adapters;

import pt.feup.ads.HouseOfThings.devices.interfaces.DeviceI;
import pt.feup.ads.HouseOfThings.managers.DeviceManager;

public abstract class DeviceAdapter implements DeviceI {
    private String deviceStatus = DEFAULT_STATUS;
    private String deviceName = DEFAULT_NAME;

    private DeviceManager deviceManager;

    public DeviceManager getDeviceManager() {
        return deviceManager;
    }

    public void setDeviceManager(DeviceManager deviceManager) {
        this.deviceManager = deviceManager;
    }

    public DeviceAdapter(){
    }

    public DeviceAdapter(String deviceName){
        this.deviceName = deviceName;
    }

    public DeviceAdapter(String deviceName, DeviceManager deviceManager){
        this.deviceName = deviceName;
        this.deviceManager = deviceManager;
    }

    @Override
    public String getStatus() {
        return deviceStatus;
    }

    @Override
    public void run() {
        deviceStatus = STATUS_RUNNING;
    }

    @Override
    public void standby() {
        deviceStatus = STATUS_STANDBY;
    }

    @Override
    public void stop() {
        deviceStatus = STATUS_STOPPED;
    }

    @Override
    public String getDeviceName() {
        return deviceName;
    }

    @Override
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public abstract boolean isInputDevice();

    @Override
    public abstract boolean isOutputDevice();
}
