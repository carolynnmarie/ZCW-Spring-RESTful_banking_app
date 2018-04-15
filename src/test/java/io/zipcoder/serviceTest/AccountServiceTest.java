package io.zipcoder.serviceTest;

import io.zipcoder.repository.AccountRepository;
import io.zipcoder.service.AccountService;
import io.zipcoder.domain.Account;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class AccountServiceTest {
    @Mock
    private AccountRepository mockRepo;

    @InjectMocks
    private AccountService mockService;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllAccounts(){

    }
}
