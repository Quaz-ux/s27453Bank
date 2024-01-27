package org.bank.s27453bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BankServiceTest {

    private BankService bankService;

    @BeforeEach
    void setUp() {
        bankService = new BankService();
    }

    @Test
    void registerCustomer() {
        Customer customer = bankService.registerCustomer("123", 1000);
        assertNotNull(customer);
        assertEquals(1000, customer.getBalance());
    }

    @Test
    void makeTransfer() {
        bankService.registerCustomer("123", 1000);
        TransactionResult result = bankService.makeTransfer("123", 100);
        assertEquals(TransactionStatus.ACCEPTED, result.getStatus());
        assertEquals(900, result.getNewBalance());
    }

    @Test
    void depositFunds() {
        bankService.registerCustomer("123", 500);
        TransactionResult result = bankService.depositFunds("123", 500);
        assertEquals(TransactionStatus.ACCEPTED, result.getStatus());
        assertEquals(1000, result.getNewBalance());

        TransactionResult result2 = bankService.depositFunds("123", 400);
        assertEquals(TransactionStatus.ACCEPTED, result2.getStatus());
        assertEquals(1400, result2.getNewBalance());

        TransactionResult result3 = bankService.depositFunds("123", -400);
        assertEquals(TransactionStatus.ACCEPTED, result3.getStatus());
        assertEquals(1000, result3.getNewBalance());
    }

    @Test
    void getCustomerDetails() {
        bankService.registerCustomer("123", 1000);
        Customer customer = bankService.getCustomerDetails("123");
        assertNotNull(customer);
        assertEquals(1000, customer.getBalance());
    }
}
