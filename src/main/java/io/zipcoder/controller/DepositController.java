package io.zipcoder.controller;


import io.zipcoder.domain.Deposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepositController {

    @Autowired
    DepositController depositController;

//    @RequestMapping(value="/accounts/{accountId}/deposits", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
//    @ResponseBody
//    public List<Deposit> getDeposit(Long accountId) {
//        return depositController.getDeposit(accountId);
//    }

    @RequestMapping(value="/deposits/{depositId", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public Deposit getDeposit(Long id) {
        return depositController.getDeposit(id);
    }

    @RequestMapping(value="/accounts/{accountId}/deposits", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public Deposit postDeposit(Long id) {
        return depositController.postDeposit(id);
    }

    @RequestMapping(value="/deposits/{depositId}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public Deposit updateDeposit(Long id) {
        return depositController.updateDeposit(id);
    }

    @RequestMapping(value="/deposits/{depositId}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public Deposit deleteDeposit(Long id) {
        return depositController.deleteDeposit(id);
    }

}
