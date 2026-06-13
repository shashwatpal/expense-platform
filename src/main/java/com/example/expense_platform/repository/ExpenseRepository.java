package com.example.expense_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.expense_platform.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
