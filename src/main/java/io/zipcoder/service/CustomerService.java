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
public class CustomerService {

    private CustomerRepository customerRepository;
    private AccountRepository accountRepository;

    public CustomerService(){}

    @Autowired
    public CustomerService(CustomerRepository customerRepository, AccountRepository accountRepository){
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    public ResponseEntity<Iterable<Customer>> getAllCustomers(){
        Iterable<Customer> accounts = customerRepository.findAll();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    public ResponseEntity<Customer> getCustomerById(Long id){
        Customer customer = customerRepository.findOne(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    public ResponseEntity<Customer> getCustomerOfAccount(Long accountId){
        Account account = accountRepository.findOne(accountId);
        Customer customer = account.getCustomer();
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    public ResponseEntity<?> createCustomer(Customer customer){
        Customer customer1 = customerRepository.save(customer);
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.getId())
                .toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(newAccountUri);
        return new ResponseEntity<>(customer1, responseHeaders, HttpStatus.CREATED);
    }

    public ResponseEntity<?> updateCustomer(Customer customer, Long customerId){
        customer.setId(customerId);
        Customer customer1 = customerRepository.save(customer);
        return new ResponseEntity<>(customer1, HttpStatus.OK);
    }

}
