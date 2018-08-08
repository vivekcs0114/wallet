package com.synerzip.wallet.controller;

import com.synerzip.wallet.model.Expense;
import com.synerzip.wallet.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public Expense create(Expense expense) {
        return expenseService.create(expense);
    }

    @GetMapping("/{id}")
    public Expense find(@PathVariable("id") int id) {
        return expenseService.find(id);
    }

    @PutMapping("/{id}")
    public Expense update(@PathVariable("id") int id, @RequestBody Expense expense) {
        return expenseService.update(id, expense);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        expenseService.delete(id);
    }
}
