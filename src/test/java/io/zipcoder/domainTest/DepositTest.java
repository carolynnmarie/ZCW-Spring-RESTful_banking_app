package io.zipcoder.domainTest;

import io.zipcoder.domain.*;
import org.junit.Assert;
import org.junit.Test;

public class DepositTest {

    private Deposit deposit = new Deposit();
    private Deposit deposit2 = new Deposit(4002.99);

    @Test
    public void getIdTest(){

    }

    @Test
    public void getTransactionTypeTest(){
        deposit.setTransactionType(TransactionType.DEPOSIT);
        TransactionType expected = TransactionType.DEPOSIT;
        TransactionType actual = deposit.getTransactionType();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTransactionDateTest(){
        deposit.setTransaction_date("10/22/2017");
        String expected = "10/22/2017";
        String actual = deposit.getTransaction_date();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTransactionStatusTest(){
        deposit.setTransactionStatus(TransactionStatus.PENDING);
        TransactionStatus expected = TransactionStatus.PENDING;
        TransactionStatus actual = deposit.getTransactionStatus();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAccountTest(){
        Account account = new Account();
        account.setId(3L);
        deposit.setAccount(account);
        Long expected = 3L;
        Long actual = deposit.getAccount().getId();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getMediumTest(){
        deposit.setMedium(Medium.BALANCE);
        Medium expected = Medium.BALANCE;
        Medium actual = deposit.getMedium();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAmountTest(){
        Double expected = 4002.99;
        Double actual = deposit2.getAmount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getDescriptionTest(){
        deposit.setDescription("Pay check");
        String expected = "Pay check";
        String actual = deposit.getDescription();
        Assert.assertEquals(expected, actual);
    }
}
