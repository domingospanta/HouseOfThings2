package pt.feup.ads.HouseOfThings.devices.interfaces;

import org.junit.jupiter.api.Test;
import pt.feup.ads.HouseOfThings.devices.ActuatorDevice;
import pt.feup.ads.HouseOfThings.devices.TemperatureDevice;

import static org.junit.jupiter.api.Assertions.*;

class DeviceITest {

    @Test
    void defaultConstructorTest() {
        DeviceI deviceI = new ActuatorDevice();

        String deviceName = deviceI.getDeviceName();
        String defaultStatus = deviceI.getStatus();

        assertEquals(DeviceI.DEFAULT_NAME, deviceName);
        assertEquals(DeviceI.DEFAULT_STATUS, defaultStatus);
    }

    @Test
    void argumentConstructorTest() {
        String deviceName = "MyActuator";
        DeviceI deviceI = new ActuatorDevice(deviceName);

        String actualName = deviceI.getDeviceName();

        assertEquals(deviceName, actualName);
    }

    @Test
    void changeStatusTest(){
        DeviceI deviceI = new TemperatureDevice();

        assertEquals(DeviceI.STATUS_STOPPED, deviceI.getStatus());

        deviceI.run();
        assertEquals(DeviceI.STATUS_RUNNING, deviceI.getStatus());

        deviceI.standby();
        assertEquals(DeviceI.STATUS_STANDBY, deviceI.getStatus());

        deviceI.stop();
        assertEquals(DeviceI.STATUS_STOPPED, deviceI.getStatus());
    }

    @Test
    void isInputDeviceTest() {
        DeviceI deviceI = new TemperatureDevice();
        assertTrue(deviceI.isOutputDevice());
        assertFalse(deviceI.isInputDevice());
    }

    @Test
    void isOutputDeviceTest() {
        DeviceI deviceI = new ActuatorDevice();
        assertTrue(deviceI.isInputDevice());
        assertFalse(deviceI.isOutputDevice());
    }
}