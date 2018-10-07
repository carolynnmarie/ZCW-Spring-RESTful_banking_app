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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.http.MediaType.APPLICATION_JSON;
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
        account.setBalance(101.11);
    }

    @Test
    public void testGetAllAccountsInt() throws Exception {
        List<Account> accounts = singletonList(account);
        ResponseEntity<List<Account>> expected = new ResponseEntity<>(accounts, HttpStatus.OK);
        given(accountController.getAllAccounts()).willReturn(expected);

        mockMvc.perform(get("/accounts")
                .contentType(APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAccountByIdInt() throws Exception{
        ResponseEntity<Account> entity =  new ResponseEntity<>(account, HttpStatus.OK);
        given(accountController.getAccountById(1L)).willReturn(entity);

        mockMvc.perform(get("/accounts/{accountId}", 1L)
                .contentType(APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAccountsForCustomerInt() throws Exception{
        List<Account> accounts = singletonList(account);
        ResponseEntity<List<Account>> entity = new ResponseEntity<>(accounts, HttpStatus.OK);
        given(accountController.getAccountsForCustomer(2L)).willReturn(entity);

        mockMvc.perform(get("/customers/{customerId}/accounts", 2L)
                .characterEncoding("utf-8")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateAccountInt() throws Exception{
        given(accountController.createAccount(account.getCustomer().getId(),account)).willReturn(mock(ResponseEntity.class));

        String textBody = mapper.writeValueAsString(account);
        mockMvc.perform(post("/customers/{customerId}/accounts",2L)
                .contentType(APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(textBody))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateAccountInt() throws Exception{
        given(accountController.updateAccount(account.getId(), account)).willReturn(new ResponseEntity<>(account, HttpStatus.OK));

        String body = mapper.writeValueAsString(account);
        mockMvc.perform(put("/accounts/{accountId}",1L)
                .contentType(APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(body))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteAccountInt() throws Exception{
        mockMvc.perform(delete("/accounts/{accountId}",1L)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
