import java.util.ArrayList;
import java.util.List;

public class Account {
    private String  username;
    private String password;
    private String accountNumber;
    private double balance;
    private List<Transaction> transaction;

    {
        transaction = new ArrayList<>();
        balance = 5000000;
    }

    public Account(){};

    public Account(String username, String password, String accountNumber) {
        this.username = username;
        this.password = password;
        this.accountNumber = accountNumber;

    }

    @Override
    public String toString() {
        return "--Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", transaction=" + transaction +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }
    public void deposit(double amount){
        this.balance += amount;
    }
}
