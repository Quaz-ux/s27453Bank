package org.bank.s27453bank;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BankService {
    private final Map<String, Customer> customers = new HashMap<>();

    public Customer registerCustomer(String id, double initialBalance) {
        Customer customer = new Customer(id, initialBalance);
        customers.put(id, customer);
        return customer;
    }

    public TransactionResult makeTransfer(String customerId, double amount) {
        Customer customer = customers.get(customerId);
        if (customer == null || customer.getBalance() < amount) {
            return new TransactionResult(TransactionStatus.DECLINED, 0);
        }
        customer.setBalance(customer.getBalance() - amount);
        return new TransactionResult(TransactionStatus.ACCEPTED, customer.getBalance());

    }

    public TransactionResult depositFunds(String customerId, double amount) {
        Customer customer = customers.get(customerId);
        if (customer == null) {
            return new TransactionResult(TransactionStatus.DECLINED, 0);
        }
        double newBalance = customer.getBalance() + amount;
        if (newBalance < 0) {
            return new TransactionResult(TransactionStatus.DECLINED, customer.getBalance());
        }
        customer.setBalance(newBalance);
        return new TransactionResult(TransactionStatus.ACCEPTED, newBalance);
    }

    public Customer getCustomerDetails(String customerId) {
        return customers.get(customerId);
    }


}