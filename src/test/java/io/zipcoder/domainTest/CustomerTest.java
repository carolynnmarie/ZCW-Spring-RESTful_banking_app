package io.zipcoder.domainTest;

import io.zipcoder.domain.Address;
import io.zipcoder.domain.Customer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class CustomerTest {

    private Customer customer = new Customer();
    private Customer customer2 = new Customer("Carolynn", "Vansant");


    @Test
    public void getIdTest(){
        customer.setId(1L);
        Long expected = 1L;
        Long actual = customer.getId();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFirstNameTest(){
        String expected = "Carolynn";
        String actual = customer2.getFirst_name();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getLastNameTest(){
        String expected = "Vansant";
        String actual = customer2.getLast_name();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAddressesTest(){
        Address address1 = new Address();
        address1.setStreet_address_line_one("1 Poppy Lane");
        address1.setCity("Kennett Square");
        address1.setState("PA");
        address1.setZip("55555");

        Set<Address> addresses = new LinkedHashSet<>(Arrays.asList(address1));
        customer.setAddress(addresses);

        String expected = "Kennett Square";
        ArrayList<Address> addressAsList = new ArrayList<>(customer.getAddress());
        String actual = addressAsList.get(0).getCity();

        Assert.assertEquals(expected, actual);
    }

}
