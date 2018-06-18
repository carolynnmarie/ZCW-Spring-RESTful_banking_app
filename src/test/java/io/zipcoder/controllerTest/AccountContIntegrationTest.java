package io.zipcoder.controllerTest;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.zipcoder.controller.AccountController;
import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Collections.singletonList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountContIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountController accountController;

    private Account account;
    private Customer customer;
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp(){
        customer = new Customer();
        customer.setId(2L);
        account = new Account();
        account.setId(1L);
        account.setCustomer(customer);
    }

    @Test
    public void testGetAllAccountsInt() throws Exception {
        Iterable<Account> accounts = singletonList(account);
        ResponseEntity<Iterable<Account>> expected = new ResponseEntity<>(accounts, HttpStatus.OK);
        given(accountController.getAllAccounts()).willReturn(expected);

        mockMvc.perform(get("/accounts")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
