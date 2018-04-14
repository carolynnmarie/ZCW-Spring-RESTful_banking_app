package io.zipcoder.controller;

import io.zipcoder.domain.Bill;
import io.zipcoder.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillController {

    @Autowired
    private BillService billService;

    public BillController() {}

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @RequestMapping(value="/accounts/{accountId}/bills", method= RequestMethod.GET)
    public ResponseEntity<Iterable<Bill>> getAllBillsForAccount(@PathVariable Long accountId) {
        return billService.getAllBillsForAccount(); // I don't need to pass accountId to billService method
    }

    @RequestMapping(value="/bills/{billId}", method= RequestMethod.GET)
    public ResponseEntity<?> getBillById(@PathVariable Long billId) {
        return billService.getBillById(billId);
    }

    @RequestMapping(value="/customers/{customerId}/bills", method= RequestMethod.GET)
    public ResponseEntity<Iterable<Bill>> getAllBillsForCustomer(@PathVariable Long customerId) {
        return billService.getAllBillsForCustomer();
    }

//    @RequestMapping(value="/accounts/{accountId}/bills", method= RequestMethod.GET)
//    public ResponseEntity<Iterable<Bill>> getAllBillsForAccount(Account account) {
//        return billService.getAllBillsForAccount(Account account);
//    }
//
//    @RequestMapping(value="/accounts/{accountId}/bills", method= RequestMethod.GET)
//    public ResponseEntity<Iterable<Bill>> getAllBillsForAccount(Account account) {
//        return billService.getAllBillsForAccount(Account account);
//    }



}
