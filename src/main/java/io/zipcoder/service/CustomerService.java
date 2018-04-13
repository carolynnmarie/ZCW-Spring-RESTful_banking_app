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
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService(){}

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public ResponseEntity<Iterable<Customer>> getAllCustomers(){
        Iterable<Customer> accounts = customerRepository.findAll();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    public ResponseEntity<Customer> getCustomerById(Long id){
        Customer customer = customerRepository.findOne(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    public ResponseEntity<Iterable<Customer>> getCustomerOfAccount(Account account){
        Iterable<Customer> accounts = customerRepository.findCustomerOfAccount(account);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    public ResponseEntity<?> createCustomer(Customer customer){
        customer = customerRepository.save(customer);
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.getId())
                .toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(newAccountUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    public ResponseEntity<?> updateCustomer(Customer customer){
        Customer customer1 = customerRepository.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
