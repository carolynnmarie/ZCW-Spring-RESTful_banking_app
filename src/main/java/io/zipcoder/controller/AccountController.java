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
    @Autowired
    private AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<?> getAccountById(@PathVariable Long id){
        return accountService.getAccountById(id);
    }

    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.GET)
    public ResponseEntity<?> getAccountsForCustomer(@PathVariable Long customerId, @RequestBody Customer customer){
        return accountService.getAccountsOfCustomer(customer);
    }

    @RequestMapping(value = "/customers/{customerId}/", method = RequestMethod.POST)
    public ResponseEntity<?> createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAccount(@PathVariable Long accountId, @RequestBody Account account){
        return accountService.updateAccount(account);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAccount(@PathVariable Long accountId){
        return accountService.deleteAccount(accountId);
    }
}
