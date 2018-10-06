package io.zipcoder.serviceTest;


import io.zipcoder.domain.Customer;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static java.util.Collections.singletonList;


@RunWith(SpringRunner.class)
public class AccountServiceTest {

    @InjectMocks
    private AccountService mockService;

    @Mock
    private AccountRepository mockAccountRepo;

    @Mock
    private CustomerRepository mockCustomerRepo;

    private Account account;
    private Customer customer;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        customer = new Customer("Carolynn", "Vansant");
        account = new Account();
        account.setCustomer(customer);
        account.setId(1L);
        customer.setId(2L);
    }

    @Test
    public void testGetAllAccounts(){
       List<Account> accounts = new ArrayList<>(Arrays.asList(account));
       given(mockAccountRepo.findAll()).willReturn(accounts);

       ResponseEntity<List<Account>> expected = new ResponseEntity<>(accounts, HttpStatus.OK);
       ResponseEntity<List<Account>> actual = mockService.getAllAccounts();

       verify(mockAccountRepo).findAll();
       Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAccountById(){
        given(mockAccountRepo.findOne(1L)).willReturn(account);

        ResponseEntity<Account> expected = new ResponseEntity<>(account, HttpStatus.OK);
        ResponseEntity<Account> actual = mockService.getAccountById(1L);

        verify(mockAccountRepo).findOne(anyLong());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAccountsOfCustomer(){
        List<Account> accounts = singletonList(account);
        given(mockAccountRepo.findAllByCustomer_Id(2L)).willReturn(accounts);

        ResponseEntity<List<Account>> expected = new ResponseEntity<>(accounts, HttpStatus.OK);
        ResponseEntity<List<Account>> actual = mockService.getAccountsOfCustomer(2L);

        verify(mockAccountRepo).findAllByCustomer_Id(anyLong());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCreateAccount(){
        given(mockCustomerRepo.findOne(anyLong())).willReturn(account.getCustomer());
        given(mockAccountRepo.save(any(Account.class))).willReturn(account);

        ResponseEntity<Account> expected = new ResponseEntity(account, HttpStatus.CREATED);
        ResponseEntity<Account> actual = mockService.createAccount(account.getCustomer().getId(), account);

        verify(mockAccountRepo).save(any(Account.class));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUpdateAccount(){
        given(mockAccountRepo.save(any(Account.class))).willReturn(account);

        ResponseEntity<Account> expected = new ResponseEntity<>(account, HttpStatus.OK);
        ResponseEntity<Account> actual = mockService.updateAccount(1L, account);

        verify(mockAccountRepo).save(any(Account.class));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDeleteAccount(){
        ResponseEntity<Account> expected = new ResponseEntity<>(HttpStatus.OK);
        ResponseEntity<Account> actual = mockService.deleteAccount(1L);

        verify(mockAccountRepo).delete(anyLong());
        Assert.assertEquals(expected, actual);
    }
}
