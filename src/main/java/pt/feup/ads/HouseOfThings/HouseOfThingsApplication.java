package pt.feup.ads.HouseOfThings;

import pt.feup.ads.HouseOfThings.devices.ActuatorDevice;
import pt.feup.ads.HouseOfThings.devices.BulbDevice;
import pt.feup.ads.HouseOfThings.devices.LightDetectionDevice;
import pt.feup.ads.HouseOfThings.devices.TemperatureDevice;
import pt.feup.ads.HouseOfThings.devices.adapters.DeviceAdapter;
import pt.feup.ads.HouseOfThings.devices.interfaces.OutputDeviceI;
import pt.feup.ads.HouseOfThings.devices.interfaces.InputDeviceI;
import pt.feup.ads.HouseOfThings.managers.ConnectionManager;
import pt.feup.ads.HouseOfThings.managers.DeviceManager;
import pt.feup.ads.HouseOfThings.managers.RulesManager;
import pt.feup.ads.HouseOfThings.connectors.WifiConnection;
import pt.feup.ads.HouseOfThings.rules.Rule;

import java.util.ArrayList;
import java.util.List;

public class HouseOfThingsApplication {
    public static void main(String[] args) {
        ConnectionManager.getInstance().installPlugin("WifiConnection", "Wifi Connector");
        ConnectionManager.getInstance().installPlugin("ZigBeeConnection", "ZigBee Connector");

        BulbDevice bd = new BulbDevice("Bulb Device");
        ActuatorDevice ad = new ActuatorDevice("Actuator Device");
        LightDetectionDevice ldd = new LightDetectionDevice("Light Detection Device");
        TemperatureDevice td = new TemperatureDevice("Temperature Device");

        ConnectionManager.getInstance().connectAndInstallDevice(bd);
        ConnectionManager.getInstance().connectAndInstallDevice(ad);
        ConnectionManager.getInstance().connectAndInstallDevice(ldd);
        ConnectionManager.getInstance().connectAndInstallDevice(td);

        Rule rule1 = new Rule(td, ad, " > 2");
        Rule rule2 = new Rule(ldd, bd, " < 2");

        RulesManager.getInstance().addRule(rule1);
        RulesManager.getInstance().addRule(rule2);
    }
}
