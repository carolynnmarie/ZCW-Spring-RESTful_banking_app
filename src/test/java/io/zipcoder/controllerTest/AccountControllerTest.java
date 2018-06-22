package io.zipcoder.controllerTest;


import io.zipcoder.controller.AccountController;
import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import io.zipcoder.service.AccountService;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static java.util.Collections.singletonList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
public class AccountControllerTest {

    @Mock
    private AccountService mockAccountService;

    @InjectMocks
    private AccountController mockAccountController;

    private Account account;
    private Customer customer;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        customer = new Customer("Carolynn", "Vansant");
        customer.setId(2L);
        account = new Account();
        account.setCustomer(customer);
        account.setId(1L);
    }

    @Test
    public void testGetAllAccounts() throws Exception {
        Iterable<Account> accounts = singletonList(account);
        ResponseEntity<Iterable<Account>> response = new ResponseEntity<>(accounts, HttpStatus.OK);

        given(mockAccountService.getAllAccounts()).willReturn(response);
        ResponseEntity<Iterable<Account>> actual = mockAccountController.getAllAccounts();

        verify(mockAccountService).getAllAccounts();
        Assert.assertEquals(response, actual);
    }

    @Test
    public void testGetAccountById(){
        given(mockAccountService.getAccountById(account.getId())).willReturn(new ResponseEntity<Account>(account, HttpStatus.OK));
        ResponseEntity<Account> expected = new ResponseEntity<>(account, HttpStatus.OK);
        ResponseEntity<Account> actual = mockAccountController.getAccountById(account.getId());

        verify(mockAccountService).getAccountById(anyLong());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAccountsForCustomer(){
        Iterable<Account> iterable = singletonList(account);
        ResponseEntity<Iterable<Account>> expected = new ResponseEntity<>(iterable, HttpStatus.OK);
        given(mockAccountService.getAccountsOfCustomer(account.getCustomer().getId())).willReturn(expected);
        ResponseEntity<Iterable<Account>> actual = mockAccountController.getAccountsForCustomer(account.getCustomer().getId());

        verify(mockAccountService).getAccountsOfCustomer(anyLong());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCreateAccount(){
        ResponseEntity<Account> expected = new ResponseEntity<>(account, HttpStatus.CREATED);
        given(mockAccountService.createAccount(account.getCustomer().getId(), account)).willReturn(expected);
        ResponseEntity<Account> actual = mockAccountController.createAccount(account.getCustomer().getId(), account);

        verify(mockAccountService).createAccount(anyLong(), any(Account.class));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUpdateAccount(){
        ResponseEntity<Account> expected = new ResponseEntity<>(account, HttpStatus.OK);
        given(mockAccountService.updateAccount(1L, account)).willReturn(expected);
        ResponseEntity<Account> actual = mockAccountController.updateAccount(1L, account);
        verify(mockAccountService).updateAccount(anyLong(), any(Account.class));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDeleteAccount(){
        ResponseEntity expected = new ResponseEntity<>(HttpStatus.OK);
        given(mockAccountService.deleteAccount(1L)).willReturn(expected);
        ResponseEntity actual = mockAccountController.deleteAccount(1L);
        verify(mockAccountService).deleteAccount(anyLong());
        Assert.assertEquals(expected, actual);
    }
}

