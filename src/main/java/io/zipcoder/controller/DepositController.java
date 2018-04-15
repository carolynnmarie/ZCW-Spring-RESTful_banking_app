package io.zipcoder.controller;


import io.zipcoder.domain.Deposit;
import io.zipcoder.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepositController {


    private DepositService depositService;

    public DepositController() {}

    @Autowired
    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    @RequestMapping(value="/accounts/{accountId}/deposits", method = RequestMethod.GET)
    public ResponseEntity<?> getDepositsByAccount(@PathVariable Long accountId) {
        return depositService.getDepositsByAccount(accountId);
    }

    @RequestMapping(value="/deposits/{depositId}", method = RequestMethod.GET)
    public ResponseEntity<?> getDeposit(@PathVariable Long depositId) {
        return depositService.getDeposit(depositId);
    }

    @RequestMapping(value="/accounts/{accountId}/deposits", method = RequestMethod.POST)
    public ResponseEntity<?> createDeposit(@PathVariable Long accountId, @RequestBody Deposit deposit) {
        return depositService.createDeposit(deposit);
    }

    @RequestMapping(value="/deposits/{depositId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateDeposit(@PathVariable Long depositId, @RequestBody Deposit deposit) {
        return depositService.updateDeposit(deposit);
    }

    @RequestMapping(value="/deposits/{depositId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteDeposit(@PathVariable Long depositId) {
        return depositService.deleteDeposit(depositId);
    }

}