package io.zipcoder.service;


import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import io.zipcoder.repository.AccountRepository;
import io.zipcoder.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class AccountService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, CustomerRepository customerRepository){
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    public ResponseEntity<List<Account>> getAllAccounts(){
        Iterable<Account> accounts = accountRepository.findAll();
        List<Account> accountList = new ArrayList<>();
        for (Account account:accounts) {
            accountList.add(account);
        }
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }

    public ResponseEntity<Account> getAccountById(Long id){
        Account account = accountRepository.findOne(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    public ResponseEntity<List<Account>> getAccountsOfCustomer(Long customerId){
        List<Account> accounts = accountRepository.findAllByCustomer_Id(customerId);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    public ResponseEntity<Account> createAccount(Long customerId, Account account){
        try {
            Customer customer = customerRepository.findOne(customerId);
            account.setCustomer(customer);
            Account account1 = accountRepository.save(account);
            return new ResponseEntity<>(account1, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(new Account(), BAD_REQUEST);
        }
    }

    public ResponseEntity<Account> updateAccount(Long accountId, Account account){
        account.setId(accountId);
        Account account1 = accountRepository.save(account);
        return new ResponseEntity<>(account1, HttpStatus.OK);
    }

    public ResponseEntity deleteAccount(Long accountId){
        accountRepository.delete(accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
