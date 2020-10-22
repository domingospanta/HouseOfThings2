package pt.feup.ads.HouseOfThings;

import pt.feup.ads.HouseOfThings.managers.ConnectionManager;
import pt.feup.ads.HouseOfThings.managers.DeviceManager;
import pt.feup.ads.HouseOfThings.plugins.WifiConnection;

public class HouseOfThingsApplication {
    public static void main(String[] args) {
        System.out.println("ConnectionManager Initial Number of Devices: " + DeviceManager.getInstance().getDeviceList().size());
        WifiConnection wifiConn = new WifiConnection();
        ConnectionManager.getInstance().installPlugin(wifiConn);
        ConnectionManager.getInstance().scanDevices();
        System.out.println("ConnectionManager Initial Number of Devices: " + DeviceManager.getInstance().getDeviceList().size());
    }
}
