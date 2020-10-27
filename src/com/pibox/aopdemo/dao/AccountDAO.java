package com.pibox.aopdemo.dao;

import com.pibox.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return false;
    }

    public List<Account> findAccounts() {

        List<Account> accountList = new ArrayList<>();

        Account account1 = new Account("John", "Silver");
        Account account2 = new Account("Madhu", "Platinum");
        Account account3 = new Account("Lucas", "Gold");

        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);

        return accountList;
    }
}
