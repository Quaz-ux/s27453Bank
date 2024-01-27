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
        assertTrue(customerStorage.addCustomer(customer), "Should successfully add customer");
        Customer retrievedCustomer = customerStorage.getCustomer("123");
        assertNotNull(retrievedCustomer, "Customer should not be null");
        assertEquals("123", retrievedCustomer.getId(), "Customer ID should match");
        assertEquals(1000, retrievedCustomer.getBalance(), "Balance should match");
    }

    @Test
    void testAddCustomerThatAlreadyExists() {
        Customer customer1 = new Customer("123", 1000);
        assertTrue(customerStorage.addCustomer(customer1), "First addition should be successful");
        Customer customer2 = new Customer("123", 2000);
        assertFalse(customerStorage.addCustomer(customer2), "Should not add customer with duplicate ID");
    }

    @Test
    void testAddNullCustomer() {
        assertFalse(customerStorage.addCustomer(null), "Should not add null customer");
    }

    @Test
    void getNonExistentCustomer() {
        assertNull(customerStorage.getCustomer("nonexistent"), "Getting a non-existent customer should return null");
    }
}