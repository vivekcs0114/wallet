package com.synerzip.wallet.service;

import com.synerzip.wallet.model.Category;
import com.synerzip.wallet.model.Expense;
import com.synerzip.wallet.model.User;
import com.synerzip.wallet.repository.ExpenseRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class ExpenseServiceTest {

    @Autowired
    private ExpenseService expenseService;

    @Mock
    private ExpenseRepository expenseRepository;

    @Before
    public void setup()throws Exception {
        expenseService = new ExpenseService(expenseRepository);
    }

    @Test
    public void findById_returnExpense() {
        User user = new User("vivek", "vivek@gmail.com","vivekt123");
        Category category = new Category("Electronics");
        Expense expense = new Expense("January Expense", user, category,
                "January expenses", 10000, new Date());

        BDDMockito.given(expenseRepository.getOne(11)).willReturn(expense);
        Expense found = expenseService.find(11);
        Assertions.assertThat(found.getTitle()).isEqualTo(expense.getTitle());
    }
}
