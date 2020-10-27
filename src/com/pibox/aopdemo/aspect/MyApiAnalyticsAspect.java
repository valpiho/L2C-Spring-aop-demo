package com.pibox.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyApiAnalyticsAspect {

    @Before("com.pibox.aopdemo.aspect.AopExpressions.forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("=======>>>> Performing API analytics");
    }
}
