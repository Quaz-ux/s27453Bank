package org.bank.s27453bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerStorageTest {

    private CustomerStorage customerStorage;

    @BeforeEach
    void setUp() {
        customerStorage = new CustomerStorage();
    }

    @Test
    void testAddAndGetCustomer() {
        Customer customer = new Customer("123", 1000);
        customerStorage.addCustomer(customer);

        Customer retrievedCustomer = customerStorage.getCustomer("123");
        assertNotNull(retrievedCustomer, "Customer should not be null");
        assertEquals("123", retrievedCustomer.getId(), "Customer ID should match");
        assertEquals(1000, retrievedCustomer.getBalance(), "Balance should match");
    }

    @Test
    void getNonExistentCustomer() {
        Customer customer = customerStorage.getCustomer("nonexistent");
        assertNull(customer, "Getting a non-existent customer should return null");
    }
}