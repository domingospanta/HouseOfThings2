package pt.feup.ads.HouseOfThings.managers;

import pt.feup.ads.HouseOfThings.devices.interfaces.DeviceI;
import pt.feup.ads.HouseOfThings.devices.interfaces.OutputDeviceI;
import pt.feup.ads.HouseOfThings.managers.observers.TelemetryChangeObserverI;
import pt.feup.ads.HouseOfThings.rules.Rule;

import java.util.ArrayList;
import java.util.List;

public class RulesManager implements TelemetryChangeObserverI {
    private static final RulesManager instance = new RulesManager();
    private static final List<Rule> rulesList = new ArrayList<Rule>();

    public RulesManager(){
        DeviceManager.getInstance().addTelemetryObserver(this);
    }

    public static RulesManager getInstance(){
        return instance;
    }

    public void addRule(Rule rule){
        rulesList.add(rule);
    }

    public void verifyRules(OutputDeviceI device, Integer value){
        for(Rule rule: rulesList){
            if(rule.getSourceDevice() == device){
                rule.verify(value);
            }
        }
    }

    @Override
    public void notifyObserver(DeviceI device, Integer value) {
        verifyRules((OutputDeviceI) device, value);
    }
}
