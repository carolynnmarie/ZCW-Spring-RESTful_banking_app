package io.zipcoder.domainTest;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.TransactionStatus;
import io.zipcoder.domain.TransactionType;
import io.zipcoder.domain.Withdrawal;
import org.junit.Assert;
import org.junit.Test;

public class WithdrawalTest {

    private Withdrawal withdrawal = new Withdrawal();
    private Withdrawal withdrawal2 = new Withdrawal(200.40);
    private Account account = new Account();


    @Test
    public void testGetId(){
        withdrawal.setId(1L);
        Long expected = 1L;
        Long actual = withdrawal.getId();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetTransactionType(){
        withdrawal.setTransactionType(TransactionType.WITHDRAWAL);
        TransactionType expected = TransactionType.WITHDRAWAL;
        TransactionType actual = withdrawal.getTransactionType();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetTransactionDate(){
        withdrawal.setTransaction_date("10/22/2017");
        String expected = "10/22/2017";
        String actual = withdrawal.getTransaction_date();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetTransactionStatus(){
        withdrawal.setTransactionStatus(TransactionStatus.COMPLETED);
        TransactionStatus expected = TransactionStatus.COMPLETED;
        TransactionStatus actual = withdrawal.getTransactionStatus();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAccount(){
        withdrawal.setAccount(account);
        Account expected = account;
        Account actual = withdrawal.getAccount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetMedium(){

    }

    @Test
    public void testGetAmount(){}

    @Test
    public void testGetDescription(){}

}
