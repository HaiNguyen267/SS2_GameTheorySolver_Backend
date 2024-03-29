package com.example.SS2_Backend.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(* com.example.SS2_Backend.service.*.*(..))")
    public void gameTheorySolver() {}

    @Around("gameTheorySolver()")
    public Object logAroundGameTheorySolver(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();

        log.info("{}.{}() is started", className, methodName);
        Object result = joinPoint.proceed();
        log.info("{}.{}() is finished", className, methodName);


        return result;
        //OBject: return and void
        //void: void
    }


}
