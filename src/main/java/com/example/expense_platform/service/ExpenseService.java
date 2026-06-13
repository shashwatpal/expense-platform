package com.example.expense_platform.service;

import java.util.List;

import com.example.expense_platform.model.Expense;

public interface ExpenseService {

    public void createExpense(String description, Double amount, String category);
    public List<Expense> getAllExpenses();
    public Expense getExpenseById(Long id);
    public void updateExpense(Long id, Expense expense);
    public void deleteExpense(Long id);
}
