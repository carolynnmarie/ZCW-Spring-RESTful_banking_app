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
    public ResponseEntity<Iterable<Bill>> getAllBillsForAccount(@PathVariable("accountId") Long accountId) {
        return billService.getAllBillsForAccount(accountId);
    }

    @RequestMapping(value="/bills/{billId}", method= RequestMethod.GET)
    public ResponseEntity<Bill> getBillById(@PathVariable("billId") Long billId) {
        return billService.getBillById(billId);
    }

    @RequestMapping(value="/customers/{customerId}/accounts/{accountId}/bills", method= RequestMethod.GET)
    public ResponseEntity<Iterable<Bill>> getAllBillsForCustomer(@PathVariable("customerId") Long customerId, @PathVariable("accountId") Long accountId) {
        return billService.getAllBillsForCustomer(customerId, accountId);
    }

    @RequestMapping(value="/accounts/{accountId}/bills", method = RequestMethod.POST)
    public ResponseEntity<Bill> createBill(@PathVariable ("accountId") Long accountId, @RequestBody Bill bill) {
        return billService.createBill(accountId, bill);
    }

    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.PUT)
    public ResponseEntity<Bill> updateBill(@PathVariable("billId") Long billId, @RequestBody Bill bill) {
        return billService.updateBill(billId, bill);
    }

    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteBill(@PathVariable("billId") Long billId) {
        return billService.deleteBill(billId);
    }



}
