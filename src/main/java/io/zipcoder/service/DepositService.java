package io.zipcoder.service;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Deposit;
import io.zipcoder.repository.AccountRepository;
import io.zipcoder.repository.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class DepositService {

    private DepositRepository depositRepository;
    private AccountRepository accountRepository;


    @Autowired
    public DepositService(DepositRepository depositRepository, AccountRepository accountRepository) {
        this.depositRepository = depositRepository;
        this.accountRepository = accountRepository;

    }

    public ResponseEntity<Iterable<Deposit>> getDepositsByAccount(Long accountId) {
        Iterable<Deposit> allDepositsForAccount = depositRepository.findAllByAccount_Id(accountId);
        return new ResponseEntity<>(allDepositsForAccount, HttpStatus.OK);
    }

    public ResponseEntity<Deposit> getDeposit(Long depositId) {
        Deposit deposit = depositRepository.findOne(depositId);
        return new ResponseEntity<>(deposit, HttpStatus.OK);
    }

    public ResponseEntity<Deposit> createDeposit(Long accountId, Deposit deposit) {
        Account account = accountRepository.findOne(accountId);
        deposit.setAccount(account);
        Deposit deposit1 = depositRepository.save(deposit);
        return new ResponseEntity<>(deposit1, HttpStatus.CREATED);
    }

    public ResponseEntity<Deposit> updateDeposit(Long depositId, Deposit deposit) {
        deposit.setId(depositId);
        Deposit deposit1 = depositRepository.save(deposit);
        return new ResponseEntity<>(deposit1, HttpStatus.OK);
    }

    public ResponseEntity deleteDeposit(Long depositId) {
        depositRepository.delete(depositId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}