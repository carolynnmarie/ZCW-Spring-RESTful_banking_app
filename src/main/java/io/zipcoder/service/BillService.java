package io.zipcoder.service;

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

    @Autowired
    private BillRepository billRepository;
    private AccountRepository accountRepository;

    public BillService() {}

    public BillService(BillRepository billRepository, AccountRepository accountRepository) {
        this.billRepository = billRepository;
        this.accountRepository = accountRepository;
    }

    public ResponseEntity<Iterable<Bill>> getAllBillsForAccount(Long accountId) {
        Iterable<Bill> allBillsForAccount = billRepository.findAllByAccount_Id(accountId);
        return new ResponseEntity<>(allBillsForAccount, HttpStatus.OK);
    }

    public ResponseEntity<Bill> getBillById(Long billId) {
        /*
        Account account = accountRepo.findById(accountId).orElse(new Account());
        return new ResponseEntity<>(account, OK);
         */
        // need to rework this.
//        Bill bill = billRepository.findById(billId);
//        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    public ResponseEntity<Iterable<Bill>> getAllBillsForCustomer() {
        Iterable<Bill> allBillsForCustomer = billRepository.findAll();
        return new ResponseEntity<>(allBillsForCustomer, HttpStatus.OK);
    }

    public ResponseEntity<?> createBill(Bill bill) {
        bill = billRepository.save(bill);
        URI newBillUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(bill.getId())
                .toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(newBillUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    public ResponseEntity<?> updateBill(Bill bill) {
        Bill bill1 = billRepository.save(bill);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> deleteBill(Long billId) {
        billRepository.delete(billId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
