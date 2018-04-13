package io.zipcoder.controller;

import io.zipcoder.domain.Withdrawal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WithdrawalController {

    @Autowired
    private WithdrawalController withdrawalController;

    @RequestMapping(value="/withdrawals/{withdrawalId}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public Withdrawal getWithdrawal(Long id) {
        return withdrawalController.getWithdrawal(id);
    }

    @RequestMapping(value="/accounts/{accountId}/withdrawals", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public Withdrawal postWithdrawal(Long id) {
        return withdrawalController.postWithdrawal(id);
    }

    @RequestMapping(value="/withdrawals/{withdrawalsId}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public Withdrawal updateWithdrawal(Long id) {
        return withdrawalController.updateWithdrawal(id);
    }

    @RequestMapping(value="/withdrawals/{withdrawalsId}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public Withdrawal deleteWithdrawal(Long id) {
        return withdrawalController.deleteWithdrawal(id);
    }
}
