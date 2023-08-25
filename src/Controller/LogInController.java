package Controller;

import Model.BankAccount;
import Model.ClientManager;

public class LogInController {
    private ClientManager clientManager;

    public LogInController (ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    public String logIn (String name, String password) {
        if (clientManager.validateInput(name, password) && clientManager.sameAccount(name, Integer.parseInt(password))) {
            return "";
        }
        return "There is no such user. Please recheck your input.";
    }
    public String addBankAccount (String name, String password) {
        if (!clientManager.addElement(name, password)) {
            return "You might have inputted wrong information or the user already exists.";
        }
        return "User added successfully!";
    }
    public String deleteBankAccount (BankAccount account) {
        if (!clientManager.deleteElement(account)) {
            return "This account does not exist.";
        }
        return "User deleted successfully!";
    }
}
