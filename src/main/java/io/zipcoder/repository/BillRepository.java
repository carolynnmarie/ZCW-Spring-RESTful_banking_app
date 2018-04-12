package io.zipcoder.repository;

import io.zipcoder.domain.Bill;
import org.springframework.data.repository.CrudRepository;

public interface BillRepository extends CrudRepository<Bill, Long>{
}
