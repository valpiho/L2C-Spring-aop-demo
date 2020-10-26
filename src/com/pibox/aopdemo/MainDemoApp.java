package com.pibox.aopdemo;

import com.pibox.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        theAccountDAO.addAccount();

        context.close();
    }
}
