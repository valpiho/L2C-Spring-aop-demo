package com.pibox.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

    @Before("com.pibox.aopdemo.aspect.AopExpressions.forDaoPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("=======>>>> Executing @Before advice on addAccount()");
    }
}
