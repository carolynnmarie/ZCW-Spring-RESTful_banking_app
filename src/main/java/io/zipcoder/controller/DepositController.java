package io.zipcoder.controller;


import io.zipcoder.domain.Deposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepositController {

    @Autowired
    DepositController depositController;

    @RequestMapping(value="/accounts/{accountId}/deposits", method = RequestMethod.GET)
    @ResponseBody
    public List<Deposit> getDepositsByAccountId(Long id) {
        return depositController.getDepositsByAccountId(id);
    }

    @RequestMapping(value="/deposits/{depositId}", method = RequestMethod.GET)
    @ResponseBody
    public Deposit getDeposit(Long id) {
        return depositController.getDeposit(id);
    }

    @RequestMapping(value="/accounts/{accountId}/deposits", method = RequestMethod.POST)
    @ResponseBody
    public Deposit postDeposit(Long id) {
        return depositController.postDeposit(id);
    }

    @RequestMapping(value="/deposits/{depositId}", method = RequestMethod.PATCH)
    @ResponseBody
    public Deposit updateDeposit(Long id) {
        return depositController.updateDeposit(id);
    }

    @RequestMapping(value="/deposits/{depositId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Deposit deleteDeposit(Long id) {
        return depositController.deleteDeposit(id);
    }

}
