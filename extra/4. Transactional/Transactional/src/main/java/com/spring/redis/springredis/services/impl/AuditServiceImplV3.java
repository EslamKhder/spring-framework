package com.spring.redis.springredis.services.impl;

import com.spring.redis.springredis.models.Logger;
import com.spring.redis.springredis.repositories.LoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuditServiceImplV3 {

    @Autowired
    private LoggerRepository loggerRepository;


    @Transactional(propagation = Propagation.NESTED)
    public void logTransfer(String message) {
        System.out.println("save log");
        loggerRepository.save(new Logger(message));
    }
}
