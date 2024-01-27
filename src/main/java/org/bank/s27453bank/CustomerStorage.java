package org.bank.s27453bank;

import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private Map<String, Customer> customers = new HashMap<>();

    public boolean addCustomer(Customer customer) {
        if (customer == null || customer.getId() == null || customers.containsKey(customer.getId())) {
            return false;
        }
        customers.put(customer.getId(), customer);
        return true;
    }

    public Customer getCustomer(String id) {
        return customers.get(id);
    }

}
