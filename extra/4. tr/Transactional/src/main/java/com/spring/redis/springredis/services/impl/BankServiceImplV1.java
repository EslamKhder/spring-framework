package com.spring.redis.springredis.services.impl;

import com.spring.redis.springredis.models.BankAccount;
import com.spring.redis.springredis.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankServiceImplV1 {

    @Autowired
    private BankAccountRepository repo;

    @Transactional
    public void transferWithRuntimeException(Long fromId, Long toId, double amount) {
        BankAccount from = repo.findById(fromId).orElseThrow();
        BankAccount to = repo.findById(toId).orElseThrow();

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        repo.save(from);//commit
        repo.save(to);//commit

        // Unchecked exception => causes rollback
        throw new RuntimeException("Something went wrong after saving!");
    }


    @Transactional(
            rollbackFor = Exception.class
    )
    public void transferWithCheckedException(Long fromId, Long toId, double amount) throws Exception {
        BankAccount from = repo.findById(fromId).orElseThrow();
        BankAccount to = repo.findById(toId).orElseThrow();

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        repo.save(from);
        repo.save(to);

        // Checked exception => does NOT rollback by default
        throw new Exception("Checked exception thrown after saving!");
    }
}