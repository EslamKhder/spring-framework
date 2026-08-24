package com.spring.redis.springredis.services.impl.bank;

import com.spring.redis.springredis.models.BankAccount;
import com.spring.redis.springredis.repositories.BankAccountRepository;
import com.spring.redis.springredis.services.impl.audit.AuditServiceImplV4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankServiceImplV4 {

    @Autowired
    private BankAccountRepository repo;

    @Autowired
    private AuditServiceImplV4 audit;

    public void transferWithoutTx(Long fromId, Long toId, double amount) {
        // no @Transactional
        BankAccount from = repo.findById(fromId).orElseThrow();
        BankAccount to = repo.findById(toId).orElseThrow();

        from.setBalance(from.getBalance() - amount);
        repo.save(from); // committed 700

        to.setBalance(to.getBalance() + amount);
        repo.save(to);// committed

//        audit.logTransfer("No transaction context");

    }


    //@Transactional
    public void transferWithTx(Long fromId, Long toId, double amount) throws Exception {
        BankAccount from = repo.findById(fromId).orElseThrow();
        BankAccount to = repo.findById(toId).orElseThrow();

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        repo.save(from);
        repo.save(to);

        audit.logTransfer("Runs inside existing transaction");

//        throw new RuntimeException("Oops!");
    }

}