package io.zipcoder.repository;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

    @Query(value ="SELECT * WHERE customer = ?", nativeQuery = true)
    public Iterable<Account> findAccountsForCustomer(Customer customer);
}
