package io.zipcoder.serviceTest;


import io.zipcoder.domain.Customer;
import io.zipcoder.repository.CustomerRepository;
import io.zipcoder.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;


public class CustomerServiceTest {
    @Mock
    private CustomerRepository mockRepo;

    @InjectMocks
    private CustomerService mockService;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateCustomer(){

    }

    @Test
    public void testGetAllCustomers(){

    }

    @Test
    public void testGetCustomerById(){

    }

    @Test
    public void testUpdateCustomer(){

    }

    @Test
    public void testGetCustomerOfAccount(){

    }

}
