package pt.feup.ads.HouseOfThings.rules;

import pt.feup.ads.HouseOfThings.devices.interfaces.OutputDeviceI;
import pt.feup.ads.HouseOfThings.devices.interfaces.InputDeviceI;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Rule {
    private final OutputDeviceI sourceDevice;
    private final InputDeviceI targetDevice;
    private final String triggerCondition;

    public Rule(OutputDeviceI sourceDevice, InputDeviceI targetDevice, String condition){
        this.sourceDevice = sourceDevice;
        this.targetDevice = targetDevice;
        this.triggerCondition = condition.trim();
    }

    public void verify(Integer value){
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String condition = value + triggerCondition;
        try {
            Boolean result = (Boolean) engine.eval(condition);
            if(result){
                targetDevice.execute(value);
            }
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    public OutputDeviceI getSourceDevice(){
        return sourceDevice;
    }
}
