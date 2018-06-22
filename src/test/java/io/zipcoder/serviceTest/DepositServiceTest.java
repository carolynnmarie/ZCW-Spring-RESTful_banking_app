package io.zipcoder.serviceTest;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Deposit;
import io.zipcoder.repository.AccountRepository;
import io.zipcoder.repository.DepositRepository;
import io.zipcoder.service.DepositService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static java.util.Collections.singletonList;

public class DepositServiceTest {

    @InjectMocks
    private DepositService mockDepositService;

    @Mock
    private DepositRepository mockDepositRepo;

    @Mock
    private AccountRepository mockAccountRepo;

    Deposit deposit;
    Account account;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        deposit = new Deposit();
        deposit.setId(1L);
        account = new Account();
        account.setId(2L);
        deposit.setAccount(account);
    }

    @Test
    public void testGetDepositsByAccount(){
        Iterable<Deposit> deposits = singletonList(deposit);
        given(mockDepositRepo.findAllByAccount_Id(2L)).willReturn(deposits);
        ResponseEntity<Iterable<Deposit>> expected = new ResponseEntity<>(deposits, HttpStatus.OK);
        ResponseEntity<Iterable<Deposit>> actual = mockDepositService.getDepositsByAccount(2L);

        verify(mockDepositRepo).findAllByAccount_Id(anyLong());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetDeposit(){
        given(mockDepositRepo.findOne(1L)).willReturn(deposit);
        ResponseEntity<Deposit> expected = new ResponseEntity<>(deposit, HttpStatus.OK);
        ResponseEntity<Deposit> actual = mockDepositService.getDeposit(1L);

        verify(mockDepositRepo).findOne(anyLong());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCreateDeposit(){
        given(mockAccountRepo.findOne(anyLong())).willReturn(deposit.getAccount());
        given(mockDepositRepo.save(any(Deposit.class))).willReturn(deposit);

        ResponseEntity<Deposit> expected = new ResponseEntity<>(deposit, HttpStatus.CREATED);
        ResponseEntity<Deposit> actual = mockDepositService.createDeposit(2L, deposit);

        verify(mockAccountRepo).findOne(anyLong());
        verify(mockDepositRepo).save(any(Deposit.class));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUpdateDeposit(){
        given(mockDepositRepo.save(any(Deposit.class))).willReturn(deposit);
        ResponseEntity<Deposit> expected = new ResponseEntity<>(deposit, HttpStatus.OK);
        ResponseEntity<Deposit> actual = mockDepositService.updateDeposit(1L, deposit);

        verify(mockDepositRepo).save(any(Deposit.class));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDeleteDeposit(){
        ResponseEntity<Account> expected = new ResponseEntity<>(HttpStatus.OK);
        ResponseEntity<Account> actual = mockDepositService.deleteDeposit(1L);

        verify(mockDepositRepo).delete(anyLong());
        Assert.assertEquals(expected, actual);
    }
}
