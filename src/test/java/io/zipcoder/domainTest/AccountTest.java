package io.zipcoder.domainTest;

import io.zipcoder.domain.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class AccountTest {

    private Account account = new Account();

    @Test
    public void getIdTest(){
        account.setId((long)50);
        Long expected = (long)50;
        Long actual = account.getId();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTypeTest(){
        account.setType(AccountType.CHECKING);
        String expected = "checking";
        String actual = account.getType();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNicknameTest(){
        account.setNickname("Carolynn checking account");
        String expected = "Carolynn checking account";
        String actual = account.getNickname();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getRewardsTest(){
        account.setRewards(50);
        Integer expected = 50;
        Integer actual = account.getRewards();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getBalanceTest(){
        account.setBalance(20000.57);
        Double expected = 20000.57;
        Double actual = account.getBalance();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCustomerTest(){
        Customer customer = new Customer();
        customer.setFirst_name("Carolynn");
        account.setCustomer(customer);
        String expected = "Carolynn";
        String actual = account.getCustomer().getFirst_name();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNewBalanceTest(){
        Deposit deposit1 = new Deposit(100.40);
        Deposit deposit2 = new Deposit(2000.61);
        Withdrawal withdrawal = new Withdrawal(200.58);
        account.setDeposits(new LinkedHashSet<>(Arrays.asList(deposit1, deposit2)));
        account.setWithdrawals(new LinkedHashSet<>(Arrays.asList(withdrawal)));
        account.setBalance(20000.57);

        Double expected = 21901.00;
        Double actual = account.getNewBalance();

        Assert.assertEquals(expected, actual);
    }



}
