import Controller.AccountController;
import Model.BankAccount;
import View.AccountWindow;

public class Main {
    public static void main(String[] args) {
        new AccountWindow(new AccountController(new BankAccount(0)));
    }
}
