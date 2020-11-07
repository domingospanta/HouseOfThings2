package pt.feup.ads.HouseOfThings.managers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.feup.ads.HouseOfThings.connectors.adapters.ConnectionAdapter;
import pt.feup.ads.HouseOfThings.devices.adapters.DeviceAdapter;
import pt.feup.ads.HouseOfThings.factory.DeviceFactory;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionManagerTest {

    @BeforeEach
    void setUp(){
        ConnectionManager.getInstance().uninstallAll();
    }

    @Test
    void countZeroInstalledPlugins() {
        ConnectionManager manager1 = ConnectionManager.getInstance();
        ConnectionManager manager2 = ConnectionManager.getInstance();

        assertTrue(manager1 == manager2);

        assertEquals(0, ConnectionManager.getInstance().connectionCount());
    }

    @Test
    void countUniqueInstalledPlugins() {
        ConnectionManager.getInstance()
                .installPlugin("WifiConnection", "Wifi Connector");

        assertEquals(1, ConnectionManager.getInstance().connectionCount());

        ConnectionManager.getInstance()
                .installPlugin("WifiConnection", "Wifi Connector");

        assertEquals(1, ConnectionManager.getInstance().connectionCount());
    }

    @Test
    void countMultipleInstalledPlugins() {
        ConnectionManager.getInstance().installPlugin("WifiConnection", "Wifi Connector");

        assertEquals(1, ConnectionManager.getInstance().connectionCount());

        ConnectionManager.getInstance().installPlugin("WifiConnection", "Wifi Connector 2");

        assertEquals(2, ConnectionManager.getInstance().connectionCount());

        ConnectionManager.getInstance().installPlugin("ZigBeeConnection", "ZigBee Connector");

        assertEquals(3, ConnectionManager.getInstance().connectionCount());
    }
}