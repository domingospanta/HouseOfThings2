package pt.feup.ads.HouseOfThings.connectors.adapters;

import org.junit.jupiter.api.Test;
import pt.feup.ads.HouseOfThings.connectors.WifiConnection;
import pt.feup.ads.HouseOfThings.devices.adapters.DeviceAdapter;
import pt.feup.ads.HouseOfThings.factory.DeviceFactory;
import pt.feup.ads.HouseOfThings.managers.ConnectionManager;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionAdapterTest {

    @Test
    void scanDevicesTest() {
        ConnectionAdapter wifiAdapter = ConnectionManager.getInstance()
                .installPlugin("WifiConnection", "Wifi Connector");

        assertEquals("Wifi Connector", wifiAdapter.getName());
        assertEquals(0, wifiAdapter.deviceCount());

        DeviceAdapter bulbDevice = DeviceFactory.getInstance()
                .createDevice("BulbDevice", "Light Bulb Device");

        ConnectionManager.getInstance().connectAndInstallDevice(bulbDevice, wifiAdapter);

        assertEquals(1, wifiAdapter.deviceCount());
    }
}