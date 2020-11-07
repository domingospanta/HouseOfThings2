package pt.feup.ads.HouseOfThings.devices.interfaces;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import pt.feup.ads.HouseOfThings.devices.TemperatureDevice;

import static org.junit.jupiter.api.Assertions.*;

class OutputDeviceITest {

    @Test
    void getDefaultTelemetry() {
        OutputDeviceI outputDeviceI = new TemperatureDevice();

        int telemetry = outputDeviceI.getTelemetry();

        assertEquals(-1, telemetry);
    }

    @Test
    @Timeout(10)
    void getGeneratedTelemetry() throws InterruptedException {
        OutputDeviceI outputDeviceI = new TemperatureDevice();
        outputDeviceI.run();

        Thread.sleep(1000); // custom poll interval

        int telemetry = outputDeviceI.getTelemetry();

        assertTrue(telemetry >= 0 && telemetry < 3);
    }
}