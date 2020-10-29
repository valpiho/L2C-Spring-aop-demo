package com.pibox.aopdemo;

import com.pibox.aopdemo.config.DemoConfig;
import com.pibox.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        try {
            // boolean flag to simulate exception
            boolean tripWare = false;
            List<Account> accountList = theAccountDAO.findAccounts(tripWare);

            System.out.println("\nMain program:");
            System.out.println(accountList);
        } catch (Exception e) {
            System.out.println("\nMain program exception: " + e);
        }




        context.close();
    }
}
