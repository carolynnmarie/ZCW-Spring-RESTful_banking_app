package io.zipcoder.controller;

import io.zipcoder.domain.Bill;
import io.zipcoder.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BillController {

    private BillService billService;

    public BillController() {}

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @RequestMapping(value="/accounts/{accountId}/bills", method= RequestMethod.GET)
    public ResponseEntity<?> getAllBillsForAccount(@PathVariable("accountId") Long accountId) {
        return billService.getAllBillsForAccount(accountId);
    }

    @RequestMapping(value="/bills/{billId}", method= RequestMethod.GET)
    public ResponseEntity<?> getBillById(@PathVariable("billId") Long billId) {
        return billService.getBillById(billId);
    }

    @RequestMapping(value="/customers/{customerId}/bills", method= RequestMethod.GET)
    public ResponseEntity<?> getAllBillsForCustomer(@PathVariable Long customerId) {
        return billService.getAllBillsForCustomer();
    }

    @RequestMapping(value="/accounts/{accountId}/bills", method = RequestMethod.POST)
    public ResponseEntity<?> createBill(@PathVariable ("accountId") Long accountId, @RequestBody Bill bill) {
        return billService.createBill(accountId, bill);
    }

    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateBill(@PathVariable("billId") Long billId, @RequestBody Bill bill) {
        return billService.updateBill(bill);
    }

    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBill(@PathVariable Long billId) {
        return billService.deleteBill(billId);
    }



}
