package com.spring.redis.springredis.services.impl;

import com.spring.redis.springredis.models.Logger;
import com.spring.redis.springredis.repositories.LoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuditServiceImplV4 {

    @Autowired
    private LoggerRepository loggerRepository;

    // if Tx exist join
    // if No Tx exist ex non tx
    @Transactional(propagation = Propagation.SUPPORTS)
    public void logTransfer(String message) {
        loggerRepository.save(new Logger(message));// committed
//        throw new RuntimeException("Oops!"); // rollback both transfer and log
    }
}
