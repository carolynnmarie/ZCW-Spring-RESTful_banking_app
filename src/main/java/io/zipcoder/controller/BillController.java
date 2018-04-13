package io.zipcoder.controller;

import io.zipcoder.domain.Bill;
import io.zipcoder.repository.BillRepository;
import io.zipcoder.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

@RestController
public class BillController {

    @Autowired
    private BillService billService;

    public BillController() {}

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @RequestMapping(value="/accounts/{accountId}/bills", method= RequestMethod.GET)
    public ResponseEntity<Iterable<Bill>> getAllBillsForSpecificAccount(Account account) {
        return billService.getAllBillsForSpecificAccount(account);
    }

    @RequestMapping(value="/bills/{billId}", method= RequestMethod.GET)
    public ResponseEntity<?> getBillById(@PathVariable Long id) {
        return billService.getBillById(id);
    }

    @RequestMapping(value="/accounts/{accountId}/bills", method= RequestMethod.GET)
    public ResponseEntity<Iterable<Bill>> getAllBillsForSpecificAccount(Account account) {
        return billService.getAllBillsForSpecificAccount(Account account);
    }

    @RequestMapping(value="/accounts/{accountId}/bills", method= RequestMethod.GET)
    public ResponseEntity<Iterable<Bill>> getAllBillsForSpecificAccount(Account account) {
        return billService.getAllBillsForSpecificAccount(Account account);
    }

    @RequestMapping(value="/accounts/{accountId}/bills", method= RequestMethod.GET)
    public ResponseEntity<Iterable<Bill>> getAllBillsForSpecificAccount(Account account) {
        return billService.getAllBillsForSpecificAccount(Account account);
    }



}
