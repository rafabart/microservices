package com.hrpayroll.utils;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@ConditionalOnExpression("${aspect.enabled:true}")
public class ExecutionTimeAdvice {

    @Around("@annotation(com.hrpayroll.utils.LogExecutionTime)")
    public Object executionTime(ProceedingJoinPoint point) throws Throwable {

        long startTime = System.currentTimeMillis();
        Object object = point.proceed();
        long endtime = System.currentTimeMillis();
        log.info("\nClass Name: " + point.getSignature().getDeclaringTypeName() + ". \nMethod Name: " + point.getSignature().getName() + ". \nTime taken for Execution is : " + (endtime - startTime) + "ms");
        return object;
    }
}