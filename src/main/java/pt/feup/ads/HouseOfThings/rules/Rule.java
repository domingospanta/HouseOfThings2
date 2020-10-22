package pt.feup.ads.HouseOfThings.rules;

import pt.feup.ads.HouseOfThings.devices.Device;

public class Rule {
    private Device sourceDevice;
    private Device targetDevice;
    private Integer triggerCondition;

    public Rule(Device sourceDevice,Device targetDevice, int condition){
        this.sourceDevice = sourceDevice;
        this.targetDevice = targetDevice;
        this.triggerCondition = condition;
    }

    public void verify(){
        if(sourceDevice.getTelemetry() > triggerCondition){
            targetDevice.execute();
        }
    }
}
