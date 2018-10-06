package io.zipcoder.repositoryTest;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Withdrawal;
import io.zipcoder.repository.WithdrawalRepository;
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
public class WithdrawalRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private WithdrawalRepository mockWithdrawalRepo;

    private Withdrawal withdrawal = new Withdrawal();
    private Withdrawal withdrawal1 = new Withdrawal();
    private Account account = new Account();

    @Test
    public void findAllByAccountIdTest(){
        withdrawal.setAccount(account);
        withdrawal1.setAccount(account);
        Long accountId = entityManager.persistAndGetId(account, Long.class);
        entityManager.persist(withdrawal);
        entityManager.persist(withdrawal1);

        Iterable<Withdrawal> deposits = mockWithdrawalRepo.findAllByAccount_Id(accountId);
        assertThat(deposits).containsExactly(withdrawal,withdrawal1);
    }
}
