package gert.rule;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.core.BasicRule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Gert on 5/12/2016.
 */
public class StudentNumberRule extends BasicRule {

    private Transaction transaction;
    private static String studentNrRegex = "[0-9]{8}";

    public StudentNumberRule(Transaction trans) {
        super("StudentNumberRule", "Extracts student number from Transaction Descrioption", 1);

        this.transaction = trans;
    }

    @Condition
    public boolean evaluate() {
        Pattern pattern = Pattern.compile(studentNrRegex);
        Matcher matcher = pattern.matcher(transaction.getReference());

        return matcher.find();
    }

    @Action
    public void execute() {
        System.out.println("transaction for " + transaction.getReference() + " was successful");
    }

    public void success(){
        System.out.println("transaction for " + transaction.getReference() + " was successful");

    }

    public void fail(){
        System.out.println("transaction for " + transaction.getReference() + " was failed");
    }
}
