package io.zipcoder.repository;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
Iterable<Account>findAllByCustomer_Id(Long customerId);
}
