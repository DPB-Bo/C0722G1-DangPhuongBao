package com.codegym.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
public class LogOrderBook {
    @Pointcut("within(com.codegym.controller.*)")
    public void callMethod() {
    }

    @Before("callMethod()")
    public void beforeOrderBook(JoinPoint joinPoint) {
        System.out.println("Đang vào method " + joinPoint.getSignature().getName() + " vào thời gian " + LocalDate.now());
    }
}
