package io.zipcoder.repository;

import io.zipcoder.domain.Withdrawal;
import java.util.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WithdrawalRepository extends CrudRepository<Withdrawal, Long> {

    List<Withdrawal> findAllByAccount_Id(Long payerId);

}
