package pt.feup.ads.HouseOfThings;

import pt.feup.ads.HouseOfThings.devices.interfaces.OutputDevice;
import pt.feup.ads.HouseOfThings.devices.interfaces.InputDevice;
import pt.feup.ads.HouseOfThings.managers.ConnectionManager;
import pt.feup.ads.HouseOfThings.managers.DeviceManager;
import pt.feup.ads.HouseOfThings.managers.RulesManager;
import pt.feup.ads.HouseOfThings.plugins.WifiConnection;
import pt.feup.ads.HouseOfThings.rules.Rule;

public class HouseOfThingsApplication {
    public static void main(String[] args) {
        System.out.println("ConnectionManager Initial Number of Devices: " + DeviceManager.getInstance().getDeviceList().size());
        WifiConnection wifiConn = new WifiConnection();
        ConnectionManager.getInstance().installPlugin(wifiConn);
        ConnectionManager.getInstance().scanAndInstallDevices();

        Rule rule1 = new Rule((OutputDevice) DeviceManager.getInstance().getDeviceList().get(0), (InputDevice)DeviceManager.getInstance().getDeviceList().get(1), " < (1 + 1)");

        RulesManager.getInstance().addRule(rule1);

    }
}
