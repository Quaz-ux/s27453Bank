package org.bank.s27453bank;


public class TransactionResult {
    private final TransactionStatus status;
    private final double newBalance;
    private final String message;

    public TransactionResult(TransactionStatus status, double newBalance, String message) {
        this.status = status;
        this.newBalance = newBalance;
        this.message = message;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public double getNewBalance() {
        return newBalance;
    }

    public String getMessage() {
        return message;
    }
}