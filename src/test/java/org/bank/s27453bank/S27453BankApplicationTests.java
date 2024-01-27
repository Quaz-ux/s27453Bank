package org.bank.s27453bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class S27453BankApplicationTests {



    @Test
    void contextLoads() {
    }

    private BankService bankService;

    @BeforeEach
    void setUp() {
        bankService = new BankService();
    }

    @Test
    void testRegisterCustomer() {
        Customer customer = bankService.registerCustomer("123", 1000);
        assertNotNull(customer);
        assertEquals(1000, customer.getBalance());
    }

    @Test
    void testMakeTransfer() {
        bankService.registerCustomer("123", 1000);
        TransactionResult result = bankService.makeTransfer("123", 100);
        assertEquals(TransactionStatus.ACCEPTED, result.getStatus());
        assertEquals(900, result.getNewBalance());
    }

}
