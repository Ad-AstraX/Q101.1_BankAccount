package Controller;

import Model.BankAccount;
import java.util.regex.Pattern;

public class AccountController {
    private BankAccount account;

    public AccountController (BankAccount account) {
        this.account = account;
    }

    /**
     * Checks whether the input is a valid number with to decimals max
     * @param amount The String that is to be checked
     * @return A truth value dependent on whether the input is valid
     */
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

    /**
     * Validates the input and carries out the instruction
     * @param amount The String that is used to perform the operation
     * @return A message dependent on whether the operation was carried out successfully
     */
    public String carryOutInstruction(String amount) {
        if (validateInput(amount)) {
            return account.depositMoney(Double.parseDouble(amount));
        }
        return "You need to input a valid number!";
    }

    /**
     * Returns the balance of the current Account
     * @return balance
     */
    public double updateAcc() {
        return account.getBalance();
    }
}
