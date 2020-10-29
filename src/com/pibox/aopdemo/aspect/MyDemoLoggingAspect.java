package com.pibox.aopdemo.aspect;

import com.pibox.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

    @Before("com.pibox.aopdemo.aspect.AopExpressions.forDaoPackage()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("=======>>>> Executing @Before advice on addAccount()");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("method: " + methodSignature);

        // display method arguments
        Object[] args = joinPoint.getArgs();
        for (Object arg: args) {
            System.out.println(arg);

            if (arg instanceof Account) {
                Account account = (Account) arg;
                System.out.println("Account name: " + account.getName());
                System.out.println("Account name: " + account.getLevel());
            }
        }
    }

    @AfterReturning(
            pointcut = "execution(* com.pibox.aopdemo..dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n======>>> Executing @AfterReturning on method: " + method);
        System.out.println("======>>> Result is: " + result);

        convertAccountNamesToUpperCase(result);
        System.out.println("======>>> Result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account tempAccount: result) {
            String theUpperName = tempAccount.getName().toUpperCase();
            tempAccount.setName(theUpperName);
        }
    }
}
