package com.llye.sb.customannotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RepositoryLoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * com.llye.sb.customannotation..*Repository+.*(..))")
    public void springDataRestRepository() {
    }

    @Pointcut("@annotation(CustomQuery)")
    public void customQuery() {
    }

    @Around("springDataRestRepository()") // apply @Around with a point cut argument
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed(); // to get the response
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        logger.info(
                "Method {} executed in {} ms",
                joinPoint.getSignature().toShortString(),
                executionTime
        );

        return result;
    }

    @Before("customQuery()")
    public void log(JoinPoint joinPoint) {
        logger.info("Custom query called: {}", joinPoint.getSignature().toShortString());
    }
}
