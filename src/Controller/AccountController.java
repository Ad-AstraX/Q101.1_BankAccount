package Controller;

import Model.BankAccount;

public class AccountController {
    private BankAccount account;

    public AccountController (BankAccount account) {
        this.account = account;
    }

    public boolean validateInput(String amount) {
        try {
            Double.parseDouble(amount);
            return true;
        } catch (NullPointerException e) {

        }
        return false;
    }

    public void carryOutInstruction(String amount) {

    }

    public void updateAcc() {

    }
}
