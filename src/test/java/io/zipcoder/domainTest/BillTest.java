package io.zipcoder.domainTest;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Bill;
import org.junit.Assert;
import org.junit.Test;

public class BillTest {

    private Bill bill = new Bill();
    private Bill bill2 = new Bill(101.10);


    @Test
    public void getIdTest(){
        bill.setId(1L);
        Long expected = 1L;
        Long actual = bill.getId();
    }

    @Test
    public void getStatusTest(){
        bill.setStatus("pending");
        String expected = "pending";
        String actual = bill.getStatus();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getPayeeTest(){
        bill.setPayee("Comcast");
        String expected = "Comcast";
        String actual = bill.getPayee();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getNicknameTest(){
        bill.setNickname("cable bill");
        String expected = "cable bill";
        String actual = bill.getNickname();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getCreationDateTest(){
        bill.setCreation_date("10/22/2017");
        String expected = "10/22/2017";
        String actual = bill.getCreation_date();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getPaymentDateTest(){
        bill.setPayment_date("10/22/2018");
        String expected = "10/22/2018";
        String actual = bill.getPayment_date();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getReoccurringDateTest(){
        bill.setRecurring_date("10/22/2018");
        String expected = "10/22/2018";
        String actual = bill.getRecurring_date();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getUpcomingPaymentDateTest(){
        bill.setUpcoming_payment_date("10/22/2018");
        String expected = "10/22/2018";
        String actual = bill.getUpcoming_payment_date();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getPaymentAmountTest(){
        Double expected = 101.10;
        Double actual = bill2.getPayment_amount();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getAccountTest(){
        Account account = new Account();
        account.setId(3L);
        bill.setAccount(account);
        long expected = 3L;
        long actual = bill.getAccount().getId();
        Assert.assertEquals(expected,actual);
    }
}
