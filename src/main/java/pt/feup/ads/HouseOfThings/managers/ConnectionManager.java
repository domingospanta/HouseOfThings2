package pt.feup.ads.HouseOfThings.managers;

import pt.feup.ads.HouseOfThings.connectors.adapters.ConnectionAdapter;
import pt.feup.ads.HouseOfThings.devices.adapters.DeviceAdapter;
import pt.feup.ads.HouseOfThings.connectors.interfaces.ConnectionPlugin;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConnectionManager {
    private Set<ConnectionPlugin> connectionPluginList;

    private static final ConnectionManager instance = new ConnectionManager();

    public ConnectionManager(){
        connectionPluginList = new HashSet<>();
    }

    public static ConnectionManager getInstance(){
        return instance;
    }

    public ConnectionAdapter installPlugin(String className,String deviceName){

        String classUrl = "pt.feup.ads.HouseOfThings.connectors." + className;
        ConnectionAdapter connector = null;
        try{
            Class<?> cl = Class.forName(classUrl);
            Constructor<?> cons = cl.getConstructor(String.class);
            connector = (ConnectionAdapter) cons.newInstance(deviceName);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        connectionPluginList.add(connector);
        return connector;
    }

    public Set<ConnectionPlugin> getConnectionPluginList(){
        return connectionPluginList;
    }

    public void scanAndInstallDevices(){
        for(ConnectionPlugin connectionPlugin: connectionPluginList){
            List<DeviceAdapter> discoveredDevices = connectionPlugin.scanDevices();
            for(DeviceAdapter device:discoveredDevices){
                DeviceManager.getInstance().installDevice(device);
            }
        }
    }

    public void connectAndInstallDevice(DeviceAdapter device, ConnectionAdapter connectionAdapter){
        device.setConnector(connectionAdapter);
        DeviceManager.getInstance().installDevice(device);
        connectionAdapter.scanDevices();
    }

    public void connectAndInstallDevice(DeviceAdapter device){
        DeviceManager.getInstance().installDevice(device);
    }

    public void connectAndInstallDevices(List<DeviceAdapter> deviceList){
        for(DeviceAdapter device: deviceList){
            DeviceManager.getInstance().installDevice(device);
        }
    }

    public void uninstallAll(){
        connectionPluginList = new HashSet<>();
    }

    public int connectionCount(){
        return connectionPluginList.size();
    }
}
