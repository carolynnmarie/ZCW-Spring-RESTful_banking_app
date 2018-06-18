package io.zipcoder.service;


import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import io.zipcoder.repository.AccountRepository;
import io.zipcoder.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class AccountService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, CustomerRepository customerRepository){
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    public ResponseEntity<Iterable<Account>> getAllAccounts(){
        Iterable<Account> accounts = accountRepository.findAll();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    public ResponseEntity<Account> getAccountById(Long id){
        Account account = accountRepository.findOne(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    public ResponseEntity<Iterable<Account>> getAccountsOfCustomer(Long customerId){
        Iterable<Account> accounts = accountRepository.findAllByCustomer_Id(customerId);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    public ResponseEntity<Account> createAccount(Long customerId, Account account){
        Customer customer = customerRepository.findOne(customerId);
        account.setCustomer(customer);
        Account account1 = accountRepository.save(account);
        return new ResponseEntity<>(account1, HttpStatus.CREATED);
    }

    public ResponseEntity<Account> updateAccount(Account account, Long accountId){
        account.setId(accountId);
        Account account1 = accountRepository.save(account);
        return new ResponseEntity<>(account1, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteAccount(Long accountId){
        accountRepository.delete(accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
