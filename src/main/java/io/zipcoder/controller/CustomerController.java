package io.zipcoder.controller;


import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import io.zipcoder.repository.CustomerRepository;
import io.zipcoder.service.AccountService;
import io.zipcoder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Customer>> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @RequestMapping(value = "/accounts/{accountId}/customer", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Customer>> getCustomer(@PathVariable Long accountId){
        return customerService.getCustomerOfAccount();
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }
}
