package com.spring.redis.springredis.services.impl;

import com.spring.redis.springredis.models.BankAccount;
import com.spring.redis.springredis.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankServiceImplV2 {

    @Autowired
    private BankAccountRepository repo;

    @Autowired
    private AuditServiceImplV2 audit;
    //Alice  1000
    //Bob    500
    //

//    @Transactional
    public void transfer(Long fromId, Long toId, double amount) {
        BankAccount from = repo.findById(fromId).orElseThrow();
        BankAccount to = repo.findById(toId).orElseThrow();
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);
        repo.save(from);
        repo.save(to);

        audit.logTransfer("Transfer completed");
        throw new RuntimeException("Oops!");
    }

}