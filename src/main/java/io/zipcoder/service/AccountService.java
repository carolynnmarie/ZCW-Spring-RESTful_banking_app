package io.zipcoder.service;


import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import io.zipcoder.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public AccountService(){}

    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public ResponseEntity<?> getAllAccounts(){
        Iterable<Account> accounts = accountRepository.findAll();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    public ResponseEntity<?> getAccountById(Long id){
        Account account = accountRepository.findOne(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    public ResponseEntity<?> getAccountsOfCustomer(Customer customer){
        Iterable<Account> accounts = accountRepository.findAccountsForCustomer(customer);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    public ResponseEntity<?> createAccount(Account account){
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account.getId())
                .toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(newAccountUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    public ResponseEntity<?> updateAccount(Account account){
        Account account1 = accountRepository.save(account);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> deleteAccount(Long accountId){
        accountRepository.delete(accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
