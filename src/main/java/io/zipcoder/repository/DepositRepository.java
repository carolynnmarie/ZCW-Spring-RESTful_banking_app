package io.zipcoder.repository;

import io.zipcoder.domain.Deposit;
import org.springframework.data.repository.CrudRepository;

public interface DepositRepository extends CrudRepository<Deposit, Long> {

    Iterable<Deposit>findAllByPayee_Id(Long payeeId);

//    Deposit getDepositById(Long id);

}
