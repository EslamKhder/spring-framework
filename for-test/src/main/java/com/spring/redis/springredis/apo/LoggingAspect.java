package com.spring.redis.springredis.apo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Before any service method
    @Before("execution(* com.spring.redis.springredis.services.impl.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("📌 Entering: " + joinPoint.getSignature());
    }

    // After returning from service
    @AfterReturning(pointcut = "execution(* com.spring.redis.springredis.services.impl.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("✅ Returned from: " + joinPoint.getSignature() + " with result = " + result);
    }

    // If method throws an exception
    @AfterThrowing(pointcut = "execution(* com.spring.redis.springredis.services.impl.*.*(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        System.out.println("❌ Exception in: " + joinPoint.getSignature() + " with message = " + ex.getMessage());
    }

    // Around: Measure execution time
    @Around("execution(* com.spring.redis.springredis.services.impl.*.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed(); // Execute method
        long duration = System.currentTimeMillis() - start;
        System.out.println("⏱️ " + joinPoint.getSignature() + " executed in " + duration + " ms");
        return result;
    }
}