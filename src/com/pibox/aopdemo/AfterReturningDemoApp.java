package com.pibox.aopdemo;

import com.pibox.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accountList = theAccountDAO.findAccounts();

        System.out.println("\nMain program:");
        System.out.println(accountList);

        context.close();
    }
}
