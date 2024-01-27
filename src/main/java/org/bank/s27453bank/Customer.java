package org.bank.s27453bank;

public class Customer {
    private final String id;
    private double balance;


    public Customer(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }
    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
