package pt.feup.ads.HouseOfThings.rules;

import pt.feup.ads.HouseOfThings.devices.interfaces.OutputDevice;
import pt.feup.ads.HouseOfThings.devices.interfaces.InputDevice;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Rule {
    private final OutputDevice sourceDevice;
    private final InputDevice targetDevice;
    private final String triggerCondition;

    public Rule(OutputDevice sourceDevice, InputDevice targetDevice, String condition){
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
                System.out.println("RULE CONDITION TRIPPED BY " + sourceDevice.getDeviceName() + ".");
            }
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    public OutputDevice getSourceDevice(){
        return sourceDevice;
    }
}
