package io.zipcoder.service;


import io.zipcoder.domain.Deposit;
import io.zipcoder.repository.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class DepositService {

    @Autowired
    DepositRepository depositRepository;
    public DepositService(DepositRepository depositRepository) {
        this.depositRepository = depositRepository;
    }

    public ResponseEntity<Iterable<Deposit>> getDepositsByAccount(Long accountId) {
        Iterable<Deposit> allDepositsForAccount = depositRepository.findAll();
        return new ResponseEntity<>(allDepositsForAccount, HttpStatus.OK);
    }

    public ResponseEntity<Deposit> getDeposit(Long depositId) {
        Deposit deposit = depositRepository.findOne(depositId);
        return new ResponseEntity<>(deposit, HttpStatus.OK);
    }

    public ResponseEntity<?> createDeposit(Deposit deposit) {
        deposit = depositRepository.save(deposit);
        URI newDepositUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(deposit.getId())
                .toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(newDepositUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    public ResponseEntity<?> updateDeposit(Deposit deposit) {
        Deposit deposit1 = depositRepository.save(deposit);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> deleteDeposit(Long depositId) {
        depositRepository.delete(depositId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}