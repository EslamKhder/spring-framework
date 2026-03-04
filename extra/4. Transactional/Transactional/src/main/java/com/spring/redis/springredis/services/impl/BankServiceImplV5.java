package com.spring.redis.springredis.services.impl;

import com.spring.redis.springredis.models.BankAccount;
import com.spring.redis.springredis.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankServiceImplV5 {

    @Autowired
    private BankAccountRepository repo;

    @Autowired
    private AuditServiceImplV5 audit;

    public void transferWithoutTx(Long fromId, Long toId, double amount) {
        // no @Transactional
        BankAccount from = repo.findById(fromId).orElseThrow();
        BankAccount to = repo.findById(toId).orElseThrow();

        from.setBalance(from.getBalance() - amount);
        repo.save(from);

        try {
            audit.logTransfer("No transaction context");
        } catch (Exception exception) {
            System.out.println("--> ex");
        }

        to.setBalance(to.getBalance() + amount);
        repo.save(to);

    }


    @Transactional
    public void transferWithTx(Long fromId, Long toId, double amount) {
        BankAccount from = repo.findById(fromId).orElseThrow();
        BankAccount to = repo.findById(toId).orElseThrow();

        from.setBalance(from.getBalance() - amount);
        repo.save(from);// tx with save

        to.setBalance(to.getBalance() + amount);
        repo.save(to);

        audit.logTransfer("Runs inside existing transaction");
//        try {
//            audit.logTransfer("Runs inside existing transaction");
//        } catch (Exception exception) {
//            System.out.println("--------> NOT_SUPPORTED");
//        }

        // catch tx
//        throw new RuntimeException("Oops 2!");
    }

}