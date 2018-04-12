package io.zipcoder.repository;

import io.zipcoder.domain.Deposit;
import org.springframework.data.repository.CrudRepository;

public interface DepositRepository extends CrudRepository<Deposit, Long> { }
