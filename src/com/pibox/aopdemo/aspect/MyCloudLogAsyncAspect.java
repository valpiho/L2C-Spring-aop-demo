package com.pibox.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyCloudLogAsyncAspect {

    @Before("com.pibox.aopdemo.aspect.AopExpressions.forDaoPackage()")
    public void logToCloudAsync() {
        System.out.println("=======>>>> Logging to Cloud in async fashion");
    }
}
