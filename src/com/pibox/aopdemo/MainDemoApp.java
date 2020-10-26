package com.pibox.aopdemo;

import com.pibox.aopdemo.dao.AccountDAO;
import com.pibox.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        Account account = new Account();
        theAccountDAO.addAccount(account, true);
        theAccountDAO.doWork();

        theMembershipDAO.addAccount();
        theMembershipDAO.goToSleep();

        context.close();
    }
}
