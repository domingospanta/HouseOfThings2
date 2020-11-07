package pt.feup.ads.HouseOfThings.devices.interfaces;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.feup.ads.HouseOfThings.devices.BulbDevice;
import pt.feup.ads.HouseOfThings.devices.adapters.InputDeviceAdapter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class InputDeviceITest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void turningOffTheLights() {
        InputDeviceI bulbDevice = new BulbDevice("Bulb");

        bulbDevice.execute(0);

        String actual = outputStreamCaptor.toString().trim().replace("\n", "").replace("\r", "");

        StringBuilder stringExpected = new StringBuilder();
        stringExpected.append("Bulb has been tripped.").append("Turning off the lights.");

        assertEquals(stringExpected.toString().trim(), actual);
    }

    @Test
    void turningOnTheLights() {
        InputDeviceI bulbDevice = new BulbDevice("Bulb");

        bulbDevice.execute(1);

        String actual = outputStreamCaptor.toString().trim().replace("\n", "").replace("\r", "");

        StringBuilder stringExpected = new StringBuilder();
        stringExpected.append("Bulb has been tripped.").append("Turning on the lights.");

        assertEquals(stringExpected.toString().trim(), actual);
    }
}