package io.zipcoder.serviceTest;

import io.zipcoder.domain.Customer;
import io.zipcoder.domain.Deposit;
import io.zipcoder.repository.AccountRepository;
import io.zipcoder.repository.CustomerRepository;
import io.zipcoder.service.AccountService;
import io.zipcoder.domain.Account;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceTest {

    private Account account;
    private Customer customer;

    @Mock
    private AccountRepository mockAccountRepo;
    private CustomerRepository mockCustomerRepo;

    @InjectMocks
    private AccountService mockService;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllAccounts(){
        this.account = new Account();
        ArrayList<Account> list = new ArrayList<>(Arrays.asList(account));
        Iterator<Account> iterator = list.iterator();
        ResponseEntity<Iterator<Account>> entity = new ResponseEntity<>(iterator, HttpStatus.OK);
        doReturn(account,HttpStatus.OK).when(mockAccountRepo.findAll());
        Assert.assertEquals(entity,mockService.getAllAccounts());
    }

    @Test
    public void testGetAccountById(){
        this.account = new Account();
        ResponseEntity<Account> entity = new ResponseEntity<>(account, HttpStatus.OK);
        doReturn(account,HttpStatus.OK).when(mockAccountRepo.findOne((long)1));
        Assert.assertEquals(entity,mockService.getAllAccounts());
    }

    @Test
    public void testGetAccountsOfCustomer(){

    }

    @Test
    public void testCreateAccount(){

    }

    @Test
    public void testUpdateAccount(){

    }

    @Test
    public void testDeleteAccount(){

    }
}
