package io.zipcoder.controller;

import io.zipcoder.domain.Bill;
import io.zipcoder.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

@RestController
public class BillController {

    private BillRepository billRepository;

    @Autowired
    public BillController(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @RequestMapping(value="/accounts/{accountId}/bills", method= RequestMethod.GET)
    public ResponseEntity<Iterable<Bill>> getAllBillsForSpecificAccount(Account account) {
        Iterable<Bill> allBillsforSpecificAccount = billRepository.findAll();
        return new ResponseEntity<>(allBillsforSpecificAccount, HttpStatus.OK);
    }

}
