package com.example.expense_platform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expense_platform.model.Expense;
import com.example.expense_platform.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    
    // ignore the error below, it is due to VSCode not recognizing the Spring annotations
    @Autowired
    private ExpenseRepository expenseRepository;
    
    @Override
    public void createExpense(String description, Double amount, String category) {
        Expense expense = new Expense();

        expense.setDescription(description);
        expense.setAmount(amount);
        expense.setCategory(category);
        expense.setStatus("Pending");
        expenseRepository.save(expense);
    }

    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    @Override
    public void updateExpense(Long id, Expense expense) {
        Expense existingExpense = expenseRepository.findById(id).orElse(null);
        if (existingExpense != null) {
            existingExpense.setDescription(expense.getDescription());
            existingExpense.setAmount(expense.getAmount());
            existingExpense.setCategory(expense.getCategory());
            expenseRepository.save(existingExpense);
        }
    }
}
