package pt.feup.ads.HouseOfThings.managers;

import pt.feup.ads.HouseOfThings.rules.Rule;

import java.util.ArrayList;
import java.util.List;

public class RulesManager {
    private static final RulesManager instance = new RulesManager();
    private static final List<Rule> rulesList = new ArrayList<Rule>();

    public RulesManager(){

    }

    public static RulesManager getInstance(){
        return instance;
    }


}
