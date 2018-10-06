package io.zipcoder.repositoryTest;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Bill;
import io.zipcoder.domain.Customer;
import io.zipcoder.repository.BillRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class BillRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BillRepository mockBillRepo;

    private Customer customer;
    private Account account;
    private Bill bill;
    private Bill bill2;

    @Before
    public void setup(){
        customer = new Customer();
        account = new Account();
        account.setCustomer(customer);
        bill = new Bill();
        bill.setAccount(account);
        bill2 = new Bill();
        bill2.setAccount(account);
    }

    @Test
    public void findAllByAccountIdTest(){
        entityManager.persist(customer);
        Long accountId = entityManager.persistAndGetId(account, Long.class);
        entityManager.persist(bill);
        entityManager.persist(bill2);
        entityManager.flush();

        Iterable<Bill> bills = mockBillRepo.findAllByAccount_Id(accountId);
        assertThat(bills).contains(bill,bill2);
    }



}

