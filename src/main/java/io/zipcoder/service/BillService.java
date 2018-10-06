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
import java.util.ArrayList;
import java.util.List;

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

    public ResponseEntity<List<Bill>> getAllBillsForAccount(Long accountId) {
        List<Bill> allBillsForAccount = billRepository.findAllByAccount_Id(accountId);
        return new ResponseEntity<>(allBillsForAccount, HttpStatus.OK);
    }

    public ResponseEntity<Bill> getBillById(Long billId) {
        Bill bill = billRepository.findOne(billId);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    public ResponseEntity<List<Bill>> getAllBillsForCustomer(Long customerId) {
        List<Account> accounts = accountRepository.findAllByCustomer_Id(customerId);
        List<Bill> allBillsForCustomer = new ArrayList<>();
        for(Account account:accounts){
            allBillsForCustomer.addAll(billRepository.findAllByAccount_Id(account.getId()));
        }
//        Iterable<Bill> allBillsForCustomer = billRepository.findAllByAccount_Id(accountId);
        return new ResponseEntity<>(allBillsForCustomer, HttpStatus.OK);
    }

    public ResponseEntity<Bill> createBill(Long accountId, Bill bill) {
        Account account = accountRepository.findOne(accountId);
        bill.setAccount(account);
        Bill bill1 = billRepository.save(bill);
        return new ResponseEntity<>(bill1,HttpStatus.CREATED);
    }

    public ResponseEntity<Bill> updateBill(Long billId, Bill bill) {
        bill.setId(billId);
        Bill bill1 = billRepository.save(bill);
        return new ResponseEntity<>(bill1, HttpStatus.OK);
    }

    public ResponseEntity deleteBill(Long billId) {
        billRepository.delete(billId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
