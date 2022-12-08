package com.jad.jad.biz.retry.myretry.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RetryAspect {

    @Pointcut("@within(com.jad.jad.biz.retry.myretry.annotation.MyRetry)")
    public void retryMethod() {}

    @Around(value = "retryMethod()")
    public Object retry(ProceedingJoinPoint pjp) {
        Object res = null;
        int retryTimes = 3;
        for (int i = 0; i < retryTimes; i++) {
            try {
                res = pjp.proceed();
            } catch (Throwable e) {

            }

        }


        return res;
    }

}
