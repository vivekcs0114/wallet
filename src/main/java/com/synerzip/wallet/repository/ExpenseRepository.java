package com.synerzip.wallet.repository;

import com.synerzip.wallet.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

    public Expense findByTitle(String title);
}
