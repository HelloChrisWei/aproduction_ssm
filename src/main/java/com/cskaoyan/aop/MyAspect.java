package com.cskaoyan.aop;

import com.cskaoyan.annotation.ProceedTime;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    private Logger logger = Logger.getLogger(this.getClass());

    @Pointcut("execution(* com..service..*(..))")
    public void pointCut() {
    }

    @Around("@annotation(proceedTime)")
    public Object around(ProceedingJoinPoint joinPoint, ProceedTime proceedTime) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long end = System.currentTimeMillis();

        String name = joinPoint.getSignature().getName();
        System.out.println("method:" + name);

        logger.info("method:" + name);
        System.out.println("execute time:" + (end - start));

        logger.info("execute time:" + (end - start));
        return proceed;
    }
}
