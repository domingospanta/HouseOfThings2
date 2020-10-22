package pt.feup.ads.HouseOfThings.connection;

import pt.feup.ads.HouseOfThings.devices.Device;
import pt.feup.ads.HouseOfThings.plugins.ConnectionPlugin;

import java.util.ArrayList;
import java.util.List;

public class ConnectionManager {
    private final List<ConnectionPlugin> connectionPluginList;
    private final List<Device> deviceList;

    private static final ConnectionManager instance = new ConnectionManager();

    public ConnectionManager(){
        connectionPluginList = new ArrayList<ConnectionPlugin>();
        deviceList = new ArrayList<Device>();
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

    public List<Device> getDeviceList(){
        return deviceList;
    }

    public List<Device> scanDevices(){

        for(ConnectionPlugin connectionPlugin: connectionPluginList){
            List<Device> discoveredDevices = connectionPlugin.scanDevices();
            deviceList.addAll(discoveredDevices);
        }
        return deviceList;
    }
}
