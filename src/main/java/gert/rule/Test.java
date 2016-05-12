package gert.rule;

import org.easyrules.api.RulesEngine;

import static org.easyrules.core.RulesEngineBuilder.aNewRulesEngine;

/**
 * Created by Gert on 5/12/2016.
 */
public class Test {

    public static void main(String args[]){
        Transaction transaction1 = new Transaction("2016-01-01", "12134545 vending", "successfull", "400");
        Transaction transaction2 = new Transaction("2016-01-01", "1213545 vending", "fail", "400");
        Transaction transaction3 = new Transaction("2016-01-01", "121 vending", "fail", "400");
        Transaction transaction4 = new Transaction("2016-01-01", "1213454544 vending", "maybe", "400");
        Transaction transaction5 = new Transaction("2016-01-01", "12134545", "successfull", "400");

        //create a rules engine
        RulesEngine rulesEngine = aNewRulesEngine()
                .named("transaction rules engine")
                .build();

        //register rules
        rulesEngine.registerRule(new StudentNumberRule(transaction1));
        rulesEngine.registerRule(new StudentNumberRule(transaction2));
        rulesEngine.registerRule(new StudentNumberRule(transaction3));
        rulesEngine.registerRule(new StudentNumberRule(transaction4));
        rulesEngine.registerRule(new StudentNumberRule(transaction5));


        //fire rules
        rulesEngine.fireRules();

//        //create a rules engine
//        RulesEngine rulesEngine2 = aNewRulesEngine()
//                .named("transaction rules engine with listener")
//                .withRuleListener(new StudentNrRuleListener())
//                .build();
//
//        //register rules
//        rulesEngine2.registerRule(new StudentNumberRule(transaction1));
//        rulesEngine2.registerRule(new StudentNumberRule(transaction2));
//        rulesEngine2.registerRule(new StudentNumberRule(transaction3));
//        rulesEngine2.registerRule(new StudentNumberRule(transaction4));
//        rulesEngine2.registerRule(new StudentNumberRule(transaction5));
//
//
//        //fire rules
//        rulesEngine2.fireRules();
    }
}
