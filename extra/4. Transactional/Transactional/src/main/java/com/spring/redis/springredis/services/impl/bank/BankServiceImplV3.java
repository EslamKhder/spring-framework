package com.spring.redis.springredis.services.impl.bank;

import com.spring.redis.springredis.models.BankAccount;
import com.spring.redis.springredis.repositories.BankAccountRepository;
import com.spring.redis.springredis.services.impl.audit.AuditServiceImplV3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankServiceImplV3 {

    @Autowired
    private BankAccountRepository repo;

    @Autowired
    private AuditServiceImplV3 audit;

    @Transactional
    public void transfer(Long fromId, Long toId, double amount) {
        BankAccount from = repo.findById(fromId).orElseThrow();
        BankAccount to = repo.findById(toId).orElseThrow();

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        repo.save(from);
        repo.save(to);

        audit.logTransfer("Transfer completed");

        throw new RuntimeException("invalid");



    }

}