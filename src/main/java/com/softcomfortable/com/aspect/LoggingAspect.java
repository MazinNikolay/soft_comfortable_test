package com.softcomfortable.com.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Before("@annotation(com.softcomfortable.com.aspect.annotation.CustomLogging)")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Log info before executing method " + joinPoint.getSignature().getName());
    }
}
