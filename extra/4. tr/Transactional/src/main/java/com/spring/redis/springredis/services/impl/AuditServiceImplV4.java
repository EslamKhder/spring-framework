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


    @Transactional(propagation = Propagation.SUPPORTS)
    public void logTransfer(String message) {
        loggerRepository.save(new Logger(message));
//        throw new RuntimeException("Oops!"); // rollback both transfer and log
    }
}
