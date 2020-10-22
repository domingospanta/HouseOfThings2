package pt.feup.ads.HouseOfThings.connectors.interfaces;

import pt.feup.ads.HouseOfThings.devices.adapters.DeviceAdapter;

import java.util.List;

public interface ConnectionPlugin {
    List<DeviceAdapter> scanDevices();
}
