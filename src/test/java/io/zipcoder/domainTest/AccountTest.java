package io.zipcoder.domainTest;

import io.zipcoder.domain.*;
import org.junit.Assert;
import org.junit.Test;


public class AccountTest {

    private Account account = new Account();

    @Test
    public void getIdTest(){
        System.out.println(account.getId());
//        account.setId(50L);
//        Long expected = 50L;
//        Long actual = account.getId();
//        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTypeTest(){
        account.setType("checking");
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


}
