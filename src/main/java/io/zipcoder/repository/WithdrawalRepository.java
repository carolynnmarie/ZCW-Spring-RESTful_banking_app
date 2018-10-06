package io.zipcoder.repository;

import io.zipcoder.domain.Withdrawal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WithdrawalRepository extends CrudRepository<Withdrawal, Long> {

    Iterable<Withdrawal>findAllByAccount_Id(Long payerId);

}
