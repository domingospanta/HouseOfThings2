package pt.feup.ads.HouseOfThings;

import pt.feup.ads.HouseOfThings.connection.ConnectionManager;
import pt.feup.ads.HouseOfThings.plugins.WifiConnection;

public class HouseOfThingsApplication {
    public static void main(String[] args) {
        System.out.println("ConnectionManager Initial Number of Devices: " + ConnectionManager.getInstance().getDeviceList().size());
        WifiConnection wifiConn = new WifiConnection();
        ConnectionManager.getInstance().installPlugin(wifiConn);
        ConnectionManager.getInstance().scanDevices();
        System.out.println("ConnectionManager Initial Number of Devices: " + ConnectionManager.getInstance().getDeviceList().size());
    }
}
