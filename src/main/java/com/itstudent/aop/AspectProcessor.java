package com.itstudent.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectProcessor {

    @Around("@annotation(LogTime)")
    public Object logTime(ProceedingJoinPoint  joinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - startTime;
        System.out.println(joinPoint.getSignature()+" executed in "+executionTime);
        return proceed;
    }

    @After("@annotation(LogAfter)")
    public void autoTryCatch(JoinPoint joinPoint) throws Throwable{
        System.out.println("end function");
    }
}
