package com.synerzip.wallet.service;

import com.synerzip.wallet.model.Expense;
import com.synerzip.wallet.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense create(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense find(int id) {
        return expenseRepository.getOne(id);
    }

    public  Expense update(int id, Expense expense) {
        Expense dbExpense = expenseRepository.getOne(id);
        if(null != dbExpense) {
            if(!StringUtils.isEmpty(expense.getTitle())) {
                dbExpense.setTitle(expense.getTitle());
            }
            if(!StringUtils.isEmpty(expense.getDescription())) {
                dbExpense.setDescription(expense.getDescription());
            }
            if(!StringUtils.isEmpty(expense.getAmount())) {
                dbExpense.setAmount(expense.getAmount());
            }
        }
        return expenseRepository.save(dbExpense);
    }

    public void delete(int id) {
        expenseRepository.deleteById(id);
    }
}
