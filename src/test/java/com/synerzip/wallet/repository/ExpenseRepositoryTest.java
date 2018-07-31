package com.synerzip.wallet.repository;

import com.synerzip.wallet.model.Category;
import com.synerzip.wallet.model.Expense;
import com.synerzip.wallet.model.User;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class ExpenseRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ExpenseRepository expenseRepository;

    @Test
    public void findByTitle_returnExpense() {
        User user = new User("vivek", "vivek@g.com","vivek1234");
        testEntityManager.persist(user);

        Category category = new Category("Electronics");
        testEntityManager.persist(category);

        Expense expense = new Expense("January Expense", user, category, null, 1000, new Date());
        testEntityManager.persist(expense);

        Expense found = expenseRepository.findByTitle(expense.getTitle());
        Assertions.assertThat(found.getTitle()).isEqualTo("January Expense");
    }
}
