package io.zipcoder.controllerTest;

import io.zipcoder.controller.DepositController;
import io.zipcoder.domain.Account;
import io.zipcoder.domain.Deposit;
import io.zipcoder.service.DepositService;
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
public class DepositControllerTest {

    @Mock
    private DepositService mockDepositService;

    @InjectMocks
    private DepositController mockDepositController;

    private Deposit deposit;
    private Account account;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        deposit = new Deposit();
        account = new Account();
        account.setId(2L);
        deposit.setAccount(account);
        deposit.setId(1L);
    }

    @Test
    public void testGetDepositsByAccount(){
        Iterable<Deposit> deposits = singletonList(deposit);
        ResponseEntity<Iterable<Deposit>> expected = new ResponseEntity<>(deposits, HttpStatus.OK);

        given(mockDepositService.getDepositsByAccount(2L)).willReturn(expected);
        ResponseEntity<Iterable<Deposit>> actual = mockDepositController.getDepositsByAccount(2L);

        verify(mockDepositService).getDepositsByAccount(anyLong());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetDeposit(){
        ResponseEntity<Deposit> expected = new ResponseEntity<>(deposit, HttpStatus.OK);
        given(mockDepositService.getDeposit(1L)).willReturn(expected);
        ResponseEntity<Deposit> actual = mockDepositController.getDepositById(1L);

        verify(mockDepositService).getDeposit(anyLong());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCreateDeposit(){
        ResponseEntity<Deposit> expected = new ResponseEntity<>(deposit, HttpStatus.CREATED);
        given(mockDepositService.createDeposit(2L, deposit)).willReturn(expected);
        ResponseEntity<Deposit> actual = mockDepositController.createDeposit(2L, deposit);

        verify(mockDepositService).createDeposit(anyLong(),any(Deposit.class));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUpdateDeposit(){
        ResponseEntity<Deposit> expected = new ResponseEntity<>(deposit, HttpStatus.OK);
        given(mockDepositService.updateDeposit(1L, deposit)).willReturn(expected);
        ResponseEntity<Deposit> actual = mockDepositController.updateDeposit(1L, deposit);

        verify(mockDepositService).updateDeposit(anyLong(), any(Deposit.class));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDeleteDeposit(){
        ResponseEntity expected = new ResponseEntity(HttpStatus.OK);
        given(mockDepositService.deleteDeposit(1L)).willReturn(expected);
        ResponseEntity actual = mockDepositController.deleteDeposit(1L);

        verify(mockDepositService).deleteDeposit(anyLong());
        Assert.assertEquals(expected, actual);
    }
}
