package io.zipcoder.repository;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    @Query(value ="SELECT * WHERE customer = ?", nativeQuery = true)
    public Iterable<Customer> findCustomerOfAccount(Account account);
}
