package io.zipcoder.repositoryTest;


import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import io.zipcoder.repository.AccountRepository;
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
public class AccountRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void testFindAllByCustomerId(){
        Customer customer = new Customer();
        Long customerId = entityManager.persistAndGetId(customer, Long.class);
        Account account = new Account();
        account.setCustomer(customer);

        entityManager.persist(account);
        entityManager.flush();

        Iterable<Account> accounts = accountRepository.findAllByCustomer_Id(customerId);
        assertThat(accounts).contains(account);
    }


}
