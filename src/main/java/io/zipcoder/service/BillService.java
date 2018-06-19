package io.zipcoder.service;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Bill;
import io.zipcoder.repository.AccountRepository;
import io.zipcoder.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class BillService {

    private BillRepository billRepository;
    private AccountRepository accountRepository;

    public BillService() {}

    @Autowired
    public BillService(BillRepository billRepository, AccountRepository accountRepository) {
        this.billRepository = billRepository;
        this.accountRepository = accountRepository;
    }

    public ResponseEntity<Iterable<Bill>> getAllBillsForAccount(Long accountId) {
        Iterable<Bill> allBillsForAccount = billRepository.findAllByAccount_Id(accountId);
        return new ResponseEntity<>(allBillsForAccount, HttpStatus.OK);
    }

    public ResponseEntity<Bill> getBillById(Long billId) {
        Bill bill = billRepository.findOne(billId);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    public ResponseEntity<Iterable<Bill>> getAllBillsForCustomer(Long customerId, Long accountId) {
        Iterable<Bill> allBillsForCustomer = billRepository.findAllByCustomer_Id(customerId, accountId);
        return new ResponseEntity<>(allBillsForCustomer, HttpStatus.OK);
    }

    public ResponseEntity<Bill> createBill(Long accountId, Bill bill) {
        Account account = accountRepository.findOne(accountId);
        bill.setAccount(account);
        Bill bill1 = billRepository.save(bill);
        return new ResponseEntity<>(bill1,HttpStatus.CREATED);
    }

    public ResponseEntity<Bill> updateBill(Bill bill) {
        Bill bill1 = billRepository.save(bill);
        return new ResponseEntity<>(bill1, HttpStatus.OK);
    }

    public ResponseEntity deleteBill(Long billId) {
        billRepository.delete(billId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
