package com.pibox.aopdemo;

import com.pibox.aopdemo.config.DemoConfig;
import com.pibox.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService trafficFortuneService =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);

        String data = trafficFortuneService.getFortune();

        System.out.println("My fortune is: " + data);

        context.close();
    }
}
