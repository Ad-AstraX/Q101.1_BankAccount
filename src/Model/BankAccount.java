package Model;

public class BankAccount {
    private double balance;

    public BankAccount (double balance) {
        this.balance = balance;
    }

    /**
     * Deposits or withdraws money from the bank account
     * @param amount the money to be deposited or withdrawn
     * @return A message depending on whether the operation was successful
     */
    public String depositMoney(double amount) {
        if ((balance + amount) < 0) {
            return "You cannot withdraw more money than you own!";
        }
        balance += amount;
        return "";
    }

    /**
     * Returns the balance of this Account
     * @return The current balance
     */
    public double getBalance() {
        return balance;
    }
}
