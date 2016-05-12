package gert.rule;

import org.easyrules.api.Rule;
import org.easyrules.api.RuleListener;

/**
 * Created by Gert on 5/12/2016.
 */
public class StudentNrRuleListener implements RuleListener {

    public void beforeExecute(Rule rule) {

    }

    public void onSuccess(Rule rule) {
        System.out.println("transaction was successful");

    }

    public void onFailure(Rule rule, Exception e) {
        System.out.println("transaction failed:" + e.getMessage());

    }
}
