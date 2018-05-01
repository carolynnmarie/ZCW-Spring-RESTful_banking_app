package io.zipcoder.service;

import io.zipcoder.domain.Withdrawal;
import io.zipcoder.repository.WithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WithdrawalService {

    private WithdrawalRepository withdrawalRepository;

    @Autowired
    public WithdrawalService(WithdrawalRepository withdrawalRepository) {
        this.withdrawalRepository = withdrawalRepository;
    }

    public ResponseEntity<Iterable<Withdrawal>> getWithdrawalsByAccount(Long accountId) {
        Iterable<Withdrawal> allWithdrawalsForAccount = withdrawalRepository.findAllByAccount_Id(accountId);
        return new ResponseEntity<>(allWithdrawalsForAccount, HttpStatus.OK);
    }

    public ResponseEntity<Withdrawal> getWithdrawal(Long withdrawalId) {
        Withdrawal withdrawal = withdrawalRepository.findOne(withdrawalId);
        return new ResponseEntity<>(withdrawal, HttpStatus.OK);
    }

    public ResponseEntity<?> createWithdrawal(Withdrawal withdrawal, Long accountId) {
        withdrawal.setPayer_id(accountId);
        Withdrawal withdrawal1 = withdrawalRepository.save(withdrawal);
        return new ResponseEntity<>(withdrawal1, HttpStatus.CREATED);
    }

    public ResponseEntity<?> updateWithdrawal(Withdrawal withdrawal, Long withdrawalId) {
        withdrawal.setId(withdrawalId);
        Withdrawal withdrawal1 = withdrawalRepository.save(withdrawal);
        return new ResponseEntity<>(withdrawal1,HttpStatus.OK);
    }

    public ResponseEntity<?> deleteWithdrawal(Long withdrawalId) {
        withdrawalRepository.delete(withdrawalId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}