package org.javaacademy.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @Pointcut("within(org.javaacademy..*)")
    public void executeMethods() {
    }

    @Pointcut("this(org.javaacademy.nuclearplant.department.ReactorDepartment)")
    public void excludeMethods() {
    }

    @Before("executeMethods() && !excludeMethods()")
    public void logging(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();
        log.info("Method {}, args {}", name, args);
    }

}
