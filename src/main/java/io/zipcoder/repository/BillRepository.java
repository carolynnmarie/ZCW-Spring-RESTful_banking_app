package io.zipcoder.repository;

import io.zipcoder.domain.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long>{

    Iterable<Bill> findAllByAccount_Id(Long accountId);

    Iterable<Bill> findAllByAccount_Customer_Id(Long customerId);

    Iterable<Bill> findById(Long billId);
}
