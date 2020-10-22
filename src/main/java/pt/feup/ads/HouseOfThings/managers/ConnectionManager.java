package pt.feup.ads.HouseOfThings.managers;

import pt.feup.ads.HouseOfThings.devices.Device;
import pt.feup.ads.HouseOfThings.plugins.ConnectionPlugin;

import java.util.ArrayList;
import java.util.List;

public class ConnectionManager {
    private final List<ConnectionPlugin> connectionPluginList;

    private static final ConnectionManager instance = new ConnectionManager();

    public ConnectionManager(){
        connectionPluginList = new ArrayList<ConnectionPlugin>();
    }

    public static ConnectionManager getInstance(){
        return instance;
    }

    public void installPlugin(ConnectionPlugin plugin){
        connectionPluginList.add(plugin);
    }

    public List<ConnectionPlugin> getConnnectionPluginList(){
        return connectionPluginList;
    }

    public List<Device> scanDevices(){
        List<Device> deviceList = new ArrayList<Device>();

        for(ConnectionPlugin connectionPlugin: connectionPluginList){
            List<Device> discoveredDevices = connectionPlugin.scanDevices();
            deviceList.addAll(discoveredDevices);
        }
        return deviceList;
    }

    public void scanAndInstallDevices(){
        for(ConnectionPlugin connectionPlugin: connectionPluginList){
            List<Device> discoveredDevices = connectionPlugin.scanDevices();
            for(Device device:discoveredDevices){
                DeviceManager.getInstance().installDevice(device);
            }
        }
    }
}