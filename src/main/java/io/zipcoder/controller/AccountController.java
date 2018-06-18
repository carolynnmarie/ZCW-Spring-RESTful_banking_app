package io.zipcoder.controller;


import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import io.zipcoder.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Account>> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<Account> getAccountById(@PathVariable("accountId") Long accountId){
        return accountService.getAccountById(accountId);
    }

    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Account>> getAccountsForCustomer(@PathVariable("customerId") Long customerId){
        return accountService.getAccountsOfCustomer(customerId);
    }

    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.POST)
    public ResponseEntity<Account> createAccount(@PathVariable ("customerId") Long customerId, @RequestBody Account account){
        return accountService.createAccount(customerId, account);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.PUT)
    public ResponseEntity<Account> updateAccount(@PathVariable("accountId") Long accountId, @RequestBody Account account){
        return accountService.updateAccount(accountId, account);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAccount(@PathVariable("accountId") Long accountId){
        return accountService.deleteAccount(accountId);
    }
}
