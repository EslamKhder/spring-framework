package com.spring.redis.springredis.services.impl;

import com.spring.redis.springredis.models.BankAccount;
import com.spring.redis.springredis.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankServiceImplV6 {

    @Autowired
    private BankAccountRepository repo;

    @Autowired
    private AuditServiceImplV6 audit;

    public void transferWithoutTx(Long fromId, Long toId, double amount) {
        // no @Transactional
        BankAccount from = repo.findById(fromId).orElseThrow();
        BankAccount to = repo.findById(toId).orElseThrow();

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        repo.save(from);
        repo.save(to);
        audit.logTransfer("No transaction context");
        throw new RuntimeException("Oops!");
    }


    @Transactional
    public void transferWithTx(Long fromId, Long toId, double amount) {
        BankAccount from = repo.findById(fromId).orElseThrow();
        BankAccount to = repo.findById(toId).orElseThrow();

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        repo.save(from);
        repo.save(to);
        audit.logTransfer("Runs inside existing transaction");

    }

}