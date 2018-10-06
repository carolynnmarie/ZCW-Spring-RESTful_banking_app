package io.zipcoder.repositoryTest;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Deposit;
import io.zipcoder.repository.DepositRepository;
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
public class DepositRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DepositRepository mockDepositRepo;

    private Deposit deposit = new Deposit();
    private Deposit deposit1 = new Deposit();
    private Account account = new Account();

    @Test
    public void findAllByAccountIdTest(){
        deposit.setAccount(account);
        deposit1.setAccount(account);
        Long accountId = entityManager.persistAndGetId(account, Long.class);
        entityManager.persist(deposit);
        entityManager.persist(deposit1);

        Iterable<Deposit> deposits = mockDepositRepo.findAllByAccount_Id(accountId);
        assertThat(deposits).containsExactly(deposit,deposit1);
    }
}

/*
Iterable<Deposit>findAllByAccount_Id(Long payeeId);
 */