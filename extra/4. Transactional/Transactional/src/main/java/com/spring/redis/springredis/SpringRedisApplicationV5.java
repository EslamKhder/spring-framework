package com.spring.redis.springredis;

import com.spring.redis.springredis.models.BankAccount;
import com.spring.redis.springredis.repositories.BankAccountRepository;
import com.spring.redis.springredis.services.impl.BankServiceImplV5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

//@SpringBootApplication
public class SpringRedisApplicationV5 implements CommandLineRunner {

    @Autowired
    private BankAccountRepository repo;

    @Autowired
    private BankServiceImplV5 bankService;

    public static void main(String[] args) {
        SpringApplication.run(SpringRedisApplicationV5.class, args);
    }

    @Override
    public void run(String... args) {
        BankAccount a = new BankAccount();
        a.setOwner("Alice");
        a.setBalance(1000);

        BankAccount b = new BankAccount();
        b.setOwner("Bob");
        b.setBalance(500);

        repo.saveAll(List.of(a, b));

        try {
            bankService.transferWithoutTx(a.getId(), b.getId(), 300);
            System.out.println("Transfer succeeded");
        } catch (Exception e) {
            System.out.println("Transfer failed: " + e.getMessage());
        }

        repo.findAll().forEach(acc -> {
            System.out.println(acc.getOwner() + ": " + acc.getBalance());
        });
    }
}
