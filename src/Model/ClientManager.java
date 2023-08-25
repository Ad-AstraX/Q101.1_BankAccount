package Model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Pattern;

public class ClientManager {
    private static ArrayList<BankAccount> accounts = new ArrayList<>();

    public boolean validateInput(String name, String password) {
        try{
            Integer.parseInt(password);
            if (!(Integer.parseInt(password) < 0) && Pattern.compile("^[A-Z]").matcher(name).find()) {
                return true;
            }
        }catch (NullPointerException | NumberFormatException e){
            System.out.println(e.getMessage());
        };
        return false;
    }

    public boolean addElement(String name, String password) {
        if (validateInput(name, password) && !accounts.contains(new BankAccount(name, Integer.parseInt(password)))) {
            accounts.add(new BankAccount(name, Integer.parseInt(password)));
            return true;
        }
        return false;
    }

    public boolean deleteElement(BankAccount bankAccount) {
        if (accounts.contains(bankAccount)) {
            accounts.remove(bankAccount);
            return true;
        }
        return false;
    }

    public static boolean sameAccount (String name, int password) {
        for (BankAccount account : accounts) {
            if (Objects.equals(account.getName(), name) && Objects.equals(account.getPassword(), password)) {
                return true;
            }
        }
        return false;
    }

    public static BankAccount returnSameAccount (String name, int password) {
        for (BankAccount account : accounts) {
            if (Objects.equals(account.getName(), name) && Objects.equals(account.getPassword(), password)) {
                return account;
            }
        }
        return null;
    }

    public ArrayList<BankAccount> getClients() {
        return accounts;
    }
}