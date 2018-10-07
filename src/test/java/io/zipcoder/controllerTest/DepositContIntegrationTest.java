package io.zipcoder.controllerTest;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.zipcoder.controller.AccountController;
import io.zipcoder.controller.DepositController;
import io.zipcoder.domain.Account;
import io.zipcoder.domain.Deposit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
@WebMvcTest(DepositController.class)
public class DepositContIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepositController mockDepositController;


    private ObjectMapper mapper = new ObjectMapper();

    private Deposit deposit1 = new Deposit();
    private Deposit deposit2 = new Deposit();
    private Account account;

    @Before
    public void setUp(){
        account = new Account();
        account.setId(1L);
        deposit1.setAccount(account);
        deposit1.setId(2L);
        deposit2.setAccount(account);
        deposit2.setId(3L);
    }

    @Test
    public void getDepositsForAccountIntegTest() throws Exception {
        Iterable<Deposit> deposits = Arrays.asList(deposit1,deposit2);
        ResponseEntity<Iterable<Deposit>> expected = new ResponseEntity<>(deposits,OK);
        given(mockDepositController.getDepositsByAccount(account.getId())).willReturn(expected);

        mockMvc.perform(get("/accounts/{accountId}/deposits",account.getId())
                .characterEncoding("utf-8")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getDepositByIdIntegTest() throws Exception{
        ResponseEntity<Deposit> entity = new ResponseEntity<>(deposit1,OK);
        given(mockDepositController.getDepositById(anyLong())).willReturn(entity);

        mockMvc.perform(get("/deposits/{depositId}",2L)
                .contentType(APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk());
    }

    @Test
    public void createDepositIntegTest() throws Exception{

    }

    @Test
    public void updateDepositIntegTest() throws Exception{

    }

    @Test
    public void deleteDepositIntegTest() throws Exception{

    }

}
