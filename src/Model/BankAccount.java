package Model;

public class BankAccount {

    private double balance;

    public BankAccount (double balance) {
        this.balance = balance;
    }

    private boolean depositMoney(double amount) {
        if ((balance + amount) < 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    public double getBalance() {
        return balance;
    }
}
