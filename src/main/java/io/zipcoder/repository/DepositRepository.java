package io.zipcoder.repository;

import io.zipcoder.domain.Deposit;
import java.util.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepository extends CrudRepository<Deposit, Long> {

    List<Deposit> findAllByAccount_Id(Long payeeId);


}
