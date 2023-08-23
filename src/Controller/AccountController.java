package Controller;

import Model.BankAccount;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountController {
    private BankAccount account;

    public AccountController (BankAccount account) {
        this.account = account;
    }

    public boolean validateInput(String amount) {
        try {
            Double.parseDouble(amount);
            if(Pattern.compile("^[0-9]*.[0-9]{0,2}$").matcher(amount).find()) {
                return true;
            }
        } catch (NullPointerException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public String carryOutInstruction(String amount) {
        if (validateInput(amount)) {
            return account.depositMoney(Double.parseDouble(amount));
        }
        return "You need to input a valid number!";
    }

    public double updateAcc() {
        return account.getBalance();
    }
}
