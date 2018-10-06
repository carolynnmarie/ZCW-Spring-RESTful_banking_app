package io.zipcoder.repository;

import io.zipcoder.domain.Deposit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepository extends CrudRepository<Deposit, Long> {

    Iterable<Deposit>findAllByAccount_Id(Long payeeId);


}
