package model;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

    public static final SimpleDateFormat f = new SimpleDateFormat("hh:mm dd/MM/yyyy");
    public static final DecimalFormat f1 = new DecimalFormat("#,###,###");


    private String date;
    private String message;
    private String accountNumber;
    private double amount;

    {
        date = f.format(new Date());
    }

    public Transaction(){};

    public Transaction(String message, String accountNumber, double amount) {
        this.message = message;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return " - " + this.date + " - "+this.message+" - "+this.accountNumber+" - "+f1.format(this.amount);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
