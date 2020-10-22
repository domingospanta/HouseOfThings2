package pt.feup.ads.HouseOfThings.factory;

import pt.feup.ads.HouseOfThings.devices.adapters.DeviceAdapter;
import pt.feup.ads.HouseOfThings.devices.interfaces.DeviceI;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DeviceFactory {
    private static final DeviceFactory instance = new DeviceFactory();

    public DeviceFactory(){

    }

    public static DeviceFactory getInstance(){
        return instance;
    }

    public DeviceAdapter createDevice(String className,String deviceName){
        String classUrl = "pt.feup.ads.HouseOfThings.devices." + className;
        DeviceAdapter device = null;
        try{
            Class<?> cl = Class.forName(classUrl);
            Constructor<?> cons = cl.getConstructor(String.class);
            device = (DeviceAdapter) cons.newInstance(deviceName);
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

        return device;
    }
}
