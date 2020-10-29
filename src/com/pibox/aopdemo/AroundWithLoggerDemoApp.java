package com.pibox.aopdemo;

import com.pibox.aopdemo.config.DemoConfig;
import com.pibox.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLoggerDemoApp {

    private static final Logger logger =
            Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService trafficFortuneService =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);

        String data = trafficFortuneService.getFortune();

        logger.info("My fortune is: " + data);

        context.close();
    }
}
