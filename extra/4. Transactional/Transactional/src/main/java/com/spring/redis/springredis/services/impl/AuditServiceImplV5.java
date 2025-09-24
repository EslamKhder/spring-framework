package com.spring.redis.springredis.services.impl;

import com.spring.redis.springredis.models.Logger;
import com.spring.redis.springredis.repositories.LoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuditServiceImplV5 {

    @Autowired
    private LoggerRepository loggerRepository;


    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void logTransfer(String message) {
        loggerRepository.save(new Logger(message));
        throw new RuntimeException("Oops 1!");
    }
}

// EXCEPTION   TRY CATCH

// RuntimeException    --->  EXCEPTION   IGNORE EX