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
        account.setName("Madhu");
        account.setLevel("Platinum");
        theAccountDAO.addAccount(account, true);
        System.out.println();
        theAccountDAO.doWork();
        System.out.println();

        theMembershipDAO.addAccount();
        System.out.println();
        theMembershipDAO.goToSleep();

        context.close();
    }
}
