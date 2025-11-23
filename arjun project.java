import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BankAccount implements Serializable {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private List<String> transactions;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.transactions = new ArrayList<>();
        transactions.add("Account created with balance: " + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: " + amount + " | New Balance: " + balance);
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add("Withdrawn: " + amount + " | New Balance: " + balance);
            return true;
        }
        return false;
    }

    public void addTransaction(String note) {
        transactions.add(note);
    }

    public List<String> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber +
               ", Name: " + accountHolderName +
               ", Balance: " + balance;
    }
}