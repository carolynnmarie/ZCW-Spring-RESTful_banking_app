package io.zipcoder.service;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Withdrawal;
import io.zipcoder.repository.WithdrawalRepository;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WithdrawalService {

    private WithdrawalRepository withdrawalRepository;
    private Account account;

    @Autowired
    public WithdrawalService(WithdrawalRepository withdrawalRepository) {
        this.withdrawalRepository = withdrawalRepository;
        this.account = new Account();
    }

    public ResponseEntity<List<Withdrawal>> getWithdrawalsByAccount(Long accountId) {
        List<Withdrawal> allWithdrawalsForAccount = withdrawalRepository.findAllByAccount_Id(accountId);
        return new ResponseEntity<>(allWithdrawalsForAccount, HttpStatus.OK);
    }

    public ResponseEntity<Withdrawal> getWithdrawal(Long withdrawalId) {
        Withdrawal withdrawal = withdrawalRepository.findOne(withdrawalId);
        return new ResponseEntity<>(withdrawal, HttpStatus.OK);
    }

    public ResponseEntity<Withdrawal> createWithdrawal(Long accountId, Withdrawal withdrawal) {
        withdrawal.setAccount(account);
        withdrawal.getAccount().setId(accountId);
        Withdrawal withdrawal1 = withdrawalRepository.save(withdrawal);
        return new ResponseEntity<>(withdrawal1, HttpStatus.CREATED);
    }

    public ResponseEntity<Withdrawal> updateWithdrawal(Long withdrawalId, Withdrawal withdrawal) {
        withdrawal.setId(withdrawalId);
        Withdrawal withdrawal1 = withdrawalRepository.save(withdrawal);
        return new ResponseEntity<>(withdrawal1,HttpStatus.OK);
    }

    public ResponseEntity deleteWithdrawal(Long withdrawalId) {
        withdrawalRepository.delete(withdrawalId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}