package pt.feup.ads.HouseOfThings.plugins;

import pt.feup.ads.HouseOfThings.devices.Device;

import java.util.List;

public interface ConnectionPlugin {
    public List<Device> scanDevices();
}
