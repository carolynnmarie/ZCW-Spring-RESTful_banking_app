package io.zipcoder.service;

import io.zipcoder.domain.Withdrawal;
import io.zipcoder.repository.WithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class WithdrawalService {

    @Autowired
    private WithdrawalRepository withdrawalRepository;

    public WithdrawalService() {}

    public WithdrawalService(WithdrawalRepository withdrawalRepository) {
        this.withdrawalRepository = withdrawalRepository;
    }

    public ResponseEntity<Iterable<Withdrawal>> getWithdrawalsByAccount(Long accountId) {
        Iterable<Withdrawal> allWithdrawalsForAccount = withdrawalRepository.findAll();
        return new ResponseEntity<>(allWithdrawalsForAccount, HttpStatus.OK);
    }

    public ResponseEntity<Withdrawal> getWithdrawal(Long withdrawalId) {
        Withdrawal withdrawal = withdrawalRepository.findOne(withdrawalId);
        return new ResponseEntity<>(withdrawal, HttpStatus.OK);
    }

    public ResponseEntity<?> createWithdrawal(Withdrawal withdrawal) {
        withdrawal = withdrawalRepository.save(withdrawal);
        URI newWithdrawalUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(withdrawal.getId())
                .toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(newWithdrawalUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    public ResponseEntity<?> updateWithdrawal(Withdrawal withdrawal) {
        Withdrawal withdrawal1 = withdrawalRepository.save(withdrawal);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> deleteWithdrawal(Long withdrawalId) {
        withdrawalRepository.delete(withdrawalId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}