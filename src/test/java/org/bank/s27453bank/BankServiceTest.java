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
        assertEquals("Transfer successful", result.getMessage());

        result = bankService.makeTransfer("123", 2000);
        assertEquals(TransactionStatus.DECLINED, result.getStatus());
        assertEquals("Insufficient funds for the transfer", result.getMessage());
    }

    @Test
    void depositFunds() {
        bankService.registerCustomer("123", 500);
        TransactionResult result = bankService.depositFunds("123", 500);
        assertEquals(TransactionStatus.ACCEPTED, result.getStatus());
        assertEquals(1000, result.getNewBalance());
        assertEquals("Deposit successful", result.getMessage());

        TransactionResult result3 = bankService.depositFunds("123", -600); //Tak deposit xd
        assertEquals(TransactionStatus.ACCEPTED, result3.getStatus());
        assertEquals(400, result3.getNewBalance());
        assertEquals("Deposit successful", result3.getMessage());

        result = bankService.depositFunds("999", 100);
        assertEquals(TransactionStatus.DECLINED, result.getStatus());
        assertEquals("Customer not found", result.getMessage());
    }

    @Test
    void getCustomerDetails() {
        bankService.registerCustomer("123", 1000);
        Customer customer = bankService.getCustomerDetails("123");
        assertNotNull(customer);
        assertEquals(1000, customer.getBalance());
    }
}
