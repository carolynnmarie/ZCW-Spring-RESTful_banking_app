package io.zipcoder.serviceTest;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Bill;
import io.zipcoder.domain.Customer;
import io.zipcoder.repository.AccountRepository;
import io.zipcoder.repository.BillRepository;
import io.zipcoder.repository.CustomerRepository;
import io.zipcoder.service.BillService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static java.util.Collections.singletonList;


@RunWith(SpringRunner.class)
public class BillServiceTest {

    @InjectMocks
    private BillService billService;

    @Mock
    private BillRepository billRepository;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private CustomerRepository customerRepository;

    private Bill bill;
    private Account account;
    private Customer customer;

    @Before
    public void setUp(){
        bill = new Bill();
        bill.setId(1L);
        account = new Account();
        account.setId(2L);
        customer = new Customer();
        customer.setId(3L);
    }

    @Test
    public void testGetBillsForAccount(){
        Iterable<Bill> bills = singletonList(bill);
        ResponseEntity<Iterable<Bill>> expected = new ResponseEntity<>(bills, HttpStatus.OK);
        given(billRepository.findAllByAccount_Id(2L)).willReturn(bills);
        ResponseEntity<Iterable<Bill>> actual = billService.getAllBillsForAccount(2L);

        verify(billRepository).findAllByAccount_Id(anyLong());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetBillById(){
        given(billRepository.findOne(1L)).willReturn(bill);
        ResponseEntity<Bill> expected = new ResponseEntity<>(bill, HttpStatus.OK);
        ResponseEntity<Bill> actual = billService.getBillById(1L);

        verify(billRepository).findOne(anyLong());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetBillsForCustomer(){
        Iterable<Bill> bills = singletonList(bill);
        ResponseEntity<Iterable<Bill>> expected = new ResponseEntity<>(bills, HttpStatus.OK);
        given(billRepository.findAllByCustomer_Id(3L, 2L)).willReturn(bills);
        ResponseEntity<Iterable<Bill>> actual = billService.getAllBillsForCustomer(3L, 2L);

        verify(billRepository).findAllByCustomer_Id(anyLong(), anyLong());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCreateBill(){
        given(accountRepository.findOne(anyLong())).willReturn(bill.getAccount());
        given(billRepository.save(any(Bill.class))).willReturn(bill);
        ResponseEntity<Bill> expected = new ResponseEntity<>(bill, HttpStatus.CREATED);
        ResponseEntity<Bill> actual = billService.createBill(2L, bill);

        verify(billRepository).save(any(Bill.class));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUpdateBill(){
        given(billRepository.save(any(Bill.class))).willReturn(bill);

        ResponseEntity<Bill> expected = new ResponseEntity<>(bill, HttpStatus.OK);
        ResponseEntity<Bill> actual = billService.updateBill(1L,bill);

        verify(billRepository).save(any(Bill.class));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDeleteBill(){
        ResponseEntity expected = new ResponseEntity(HttpStatus.OK);
        ResponseEntity actual = billService.deleteBill(1L);

        verify(billRepository).delete(anyLong());
        Assert.assertEquals(expected, actual);
    }

}
