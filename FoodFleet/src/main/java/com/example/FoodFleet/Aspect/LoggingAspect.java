package com.example.FoodFleet.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Around("execution(* com.example.FoodFleet.Service..*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            long start = System.currentTimeMillis();

            Object result = joinPoint.proceed();

            long end = System.currentTimeMillis();
            System.out.println(joinPoint.getSignature().getDeclaringType().getSimpleName()
                    + " (AOP) :-  execute in " + (end - start) + "ms");

            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
