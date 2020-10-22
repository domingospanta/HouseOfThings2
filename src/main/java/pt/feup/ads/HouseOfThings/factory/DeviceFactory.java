package pt.feup.ads.HouseOfThings.factory;

import pt.feup.ads.HouseOfThings.devices.interfaces.Device;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DeviceFactory {
    private static final DeviceFactory instance = new DeviceFactory();

    public DeviceFactory(){

    }

    public static DeviceFactory getInstance(){
        return instance;
    }

    public Device createDevice(String className){
        String classUrl = "pt.feup.ads.HouseOfThings.devices." + className;
        Device device = null;
        try{
            Class<?> cl = Class.forName(classUrl);
            Constructor<?> cons = cl.getConstructor();
            device = (Device) cons.newInstance();
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
