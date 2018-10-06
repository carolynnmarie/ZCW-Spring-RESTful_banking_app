package io.zipcoder.repository;

import io.zipcoder.domain.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long>{

    List<Bill> findAllByAccount_Id(Long accountId);

}
