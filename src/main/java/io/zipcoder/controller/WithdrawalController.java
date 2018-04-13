package io.zipcoder.controller;

import io.zipcoder.domain.Withdrawal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WithdrawalController {

    @Autowired
    private WithdrawalController withdrawalController;

    @RequestMapping(value="accounts/{acountId}/withdrawals", method = RequestMethod.GET)
    @ResponseBody
    public List<Withdrawal> getWithdrawalsByAccount(Long id) {
        return withdrawalController.getWithdrawalsByAccount(id);
    }

    @RequestMapping(value="/withdrawals/{withdrawalId}", method = RequestMethod.GET)
    @ResponseBody
    public Withdrawal getWithdrawal(Long id) {
        return withdrawalController.getWithdrawal(id);
    }

    @RequestMapping(value="/accounts/{accountId}/withdrawals", method = RequestMethod.POST)
    @ResponseBody
    public Withdrawal postWithdrawal(Long id) {
        return withdrawalController.postWithdrawal(id);
    }

    @RequestMapping(value="/withdrawals/{withdrawalsId}" , method = RequestMethod.PATCH)
    @ResponseBody
    public Withdrawal updateWithdrawal(Long id) {
        return withdrawalController.updateWithdrawal(id);
    }

    @RequestMapping(value="/withdrawals/{withdrawalsId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Withdrawal deleteWithdrawal(Long id) {
        return withdrawalController.deleteWithdrawal(id);
    }
}
