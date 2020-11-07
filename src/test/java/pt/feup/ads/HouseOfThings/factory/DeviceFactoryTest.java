package pt.feup.ads.HouseOfThings.factory;

import org.junit.jupiter.api.Test;
import pt.feup.ads.HouseOfThings.devices.BulbDevice;
import pt.feup.ads.HouseOfThings.devices.adapters.DeviceAdapter;

import static org.junit.jupiter.api.Assertions.*;

class DeviceFactoryTest {

    @Test
    void createDevice() {
        DeviceAdapter bulbDevice = DeviceFactory.getInstance()
                .createDevice("BulbDevice", "Light Bulb Device");

        assertTrue(bulbDevice instanceof BulbDevice);
        assertEquals("Light Bulb Device", bulbDevice.getDeviceName());
    }
}