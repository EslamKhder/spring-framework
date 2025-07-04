package com.spring.redis.springredis.repositories;

import com.spring.redis.springredis.models.BankAccount;
import com.spring.redis.springredis.models.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepository extends JpaRepository<Logger, Long> {

}