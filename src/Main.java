import Controller.AccountController;
import Controller.LogInController;
import Model.BankAccount;
import Model.ClientManager;
import View.AccountWindow;
import View.LogInWindow;

public class Main {
    public static void main(String[] args) {
        new ClientManager().addElement("Haya", "1234");
        new LogInWindow(new LogInController(new ClientManager()));
    }
}
