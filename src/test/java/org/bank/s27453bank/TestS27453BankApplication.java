package org.bank.s27453bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestS27453BankApplication {

    public static void main(String[] args) {
        SpringApplication.from(S27453BankApplication::main).with(TestS27453BankApplication.class).run(args);
    }
}
