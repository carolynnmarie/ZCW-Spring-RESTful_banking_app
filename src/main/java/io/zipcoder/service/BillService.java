package io.zipcoder.service;

import io.zipcoder.domain.Bill;
import io.zipcoder.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public BillService() {}

    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public ResponseEntity<Iterable<Bill>> getAllBillsForSpecificAccount(Account account) {
        Iterable<Bill> allBillsforSpecificAccount = billRepository.findAll();
        return new ResponseEntity<>(allBillsforSpecificAccount, HttpStatus.OK);
    }

}
