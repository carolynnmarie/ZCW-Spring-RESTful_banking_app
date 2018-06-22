package io.zipcoder.controllerTest;

import io.zipcoder.controller.BillController;
import io.zipcoder.domain.Account;
import io.zipcoder.domain.Bill;
import io.zipcoder.domain.Customer;
import io.zipcoder.service.BillService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static java.util.Collections.singletonList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
public class BillControllerTest {

    @Mock
    private BillService mockBillService;

    @InjectMocks
    private BillController mockBillController;

    private Bill bill;
    private Account account;
    private Customer customer;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        bill = new Bill();
        account = new Account();
        customer = new Customer();
        bill.setId(1L);
        bill.setAccount(account);
        account.setId(2L);
        account.setCustomer(customer);
        customer.setId(3L);
    }

    @Test
    public void testGetAllBillsForAccount(){
        Iterable<Bill> bills = singletonList(bill);
        ResponseEntity<Iterable<Bill>> expected = new ResponseEntity<>(bills, HttpStatus.OK);
        given(mockBillService.getAllBillsForAccount(2L)).willReturn(expected);

        ResponseEntity<Iterable<Bill>> actual = mockBillController.getAllBillsForAccount(bill.getAccount().getId());

        verify(mockBillService).getAllBillsForAccount(anyLong());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetBillById(){
        ResponseEntity<Bill> expected = new ResponseEntity<>(bill, HttpStatus.OK);
        given(mockBillService.getBillById(1L)).willReturn(expected);

        ResponseEntity<Bill> actual = mockBillController.getBillById(bill.getId());

        verify(mockBillService).getBillById(anyLong());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAllBillsForCustomer(){
        Iterable<Bill> bills = singletonList(bill);
        ResponseEntity<Iterable<Bill>> expected = new ResponseEntity<>(bills, HttpStatus.OK);
        given(mockBillService.getAllBillsForCustomer(3L,2L)).willReturn(expected);

        ResponseEntity<Iterable<Bill>> actual = mockBillController.getAllBillsForCustomer(bill.getAccount().getCustomer().getId(),
                bill.getAccount().getId());

        verify(mockBillService).getAllBillsForCustomer(anyLong(), anyLong());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCreateBill(){
        ResponseEntity<Bill> expected = new ResponseEntity<>(bill, HttpStatus.CREATED);
        given(mockBillService.createBill(2L, bill)).willReturn(expected);

        ResponseEntity<Bill> actual = mockBillController.createBill(bill.getAccount().getId(), bill);

        verify(mockBillService).createBill(anyLong(),any(Bill.class));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUpdateBill(){
        ResponseEntity<Bill> expected = new ResponseEntity<>(bill, HttpStatus.OK);
        given(mockBillService.updateBill(1L,bill)).willReturn(expected);

        ResponseEntity<Bill> actual = mockBillController.updateBill(1L, bill);

        verify(mockBillService).updateBill(anyLong(), any(Bill.class));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDeleteBill(){
        ResponseEntity expected = new ResponseEntity(HttpStatus.OK);
        given(mockBillService.deleteBill(bill.getId())).willReturn(expected);

        ResponseEntity actual = mockBillController.deleteBill(bill.getId());

        verify(mockBillService).deleteBill(anyLong());
        Assert.assertEquals(expected, actual);
    }
}
