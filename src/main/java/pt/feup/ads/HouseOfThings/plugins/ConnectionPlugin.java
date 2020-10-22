package pt.feup.ads.HouseOfThings.plugins;

import pt.feup.ads.HouseOfThings.devices.interfaces.Device;

import java.util.List;

public interface ConnectionPlugin {
    List<Device> scanDevices();
}
