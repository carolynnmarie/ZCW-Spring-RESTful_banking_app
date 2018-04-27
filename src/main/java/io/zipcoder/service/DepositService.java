package io.zipcoder.service;

import io.zipcoder.domain.Deposit;
import io.zipcoder.repository.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class DepositService {

    private DepositRepository depositRepository;

    @Autowired
    public DepositService(DepositRepository depositRepository) {
        this.depositRepository = depositRepository;

    }

    public ResponseEntity<Iterable<Deposit>> getDepositsByAccount(Long accountId) {
        Iterable<Deposit> allDepositsForAccount = depositRepository.findAllByPayee_Id(accountId);
        return new ResponseEntity<>(allDepositsForAccount, HttpStatus.OK);
    }

    public ResponseEntity<Deposit> getDeposit(Long depositId) {
        Deposit deposit = depositRepository.findOne(depositId);
        return new ResponseEntity<>(deposit, HttpStatus.OK);
    }

    public ResponseEntity<?> createDeposit(Deposit deposit, Long accountId) {
        deposit.setPayer_id(accountId);
        Deposit deposit1 = depositRepository.save(deposit);
        return new ResponseEntity<>(deposit1, HttpStatus.CREATED);
    }

    public ResponseEntity<?> updateDeposit(Deposit deposit, Long depositId) {
        deposit.setId(depositId);
        Deposit deposit1 = depositRepository.save(deposit);
        return new ResponseEntity<>(deposit1, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteDeposit(Long depositId) {
        depositRepository.delete(depositId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}