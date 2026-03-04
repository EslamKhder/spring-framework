package com.spring.redis.springredis.services.impl;

import com.spring.redis.springredis.models.BankAccount;
import com.spring.redis.springredis.repositories.BankAccountRepository;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// CHECK EXC          Exception
// NON CHECK EXC      RUNTIME Exception
@Service
public class BankServiceImplV1 {

    //CH
    //NON CH
    @Autowired
    private BankAccountRepository repo;

    @Transactional(
            rollbackFor = RuntimeException.class
    )
    public void transferWithRuntimeException(Long fromId, Long toId, double amount) {
        BankAccount from = repo.findById(fromId).orElseThrow();//1000
        BankAccount to = repo.findById(toId).orElseThrow();// 500

        from.setBalance(from.getBalance() - amount);// 1000 - 300 = 700
        repo.save(from);//700
        if(true){
            throw new RuntimeException("Something went wrong after saving!");
        }
        to.setBalance(to.getBalance() + amount); // 500 + 300 = 800
        repo.save(to);//



        // Unchecked exception => causes rollback
//        throw new RuntimeException("Something went wrong after saving!");
    }


//    @Transactional(
//            rollbackFor = Exception.class,
//            noRollbackFor = SystemException.class
//    )
//    @Transactional(
//            rollbackFor = Throwable.class
//    )
    @Transactional(
            noRollbackFor = Exception.class
    )
    public void transferWithCheckedException(Long fromId, Long toId, double amount) throws Exception {
        BankAccount from = repo.findById(fromId).orElseThrow();// 1000
        BankAccount to = repo.findById(toId).orElseThrow(); // 500

        from.setBalance(from.getBalance() - amount);
        repo.save(from);
        if(true){
            throw new Exception("Something went wrong after saving!");
        }
        to.setBalance(to.getBalance() + amount);
        repo.save(to);

        // Checked exception => does NOT rollback by default
//        throw new Exception("Checked exception thrown after saving!");
    }


    // @T()
    void createAccount(){
        // create
        // Check    NOT CHECK
        // assign user role
    }
}