package com.example.expense_platform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.expense_platform.model.Expense;
import com.example.expense_platform.service.ExpenseService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@Controller
@RequestMapping("/expenses")
public class ExpenseController {
    
    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/view")
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/view/{id}")
    public Expense getExpensesById(@RequestParam String param) {
        return expenseService.getExpenseById(Long.parseLong(param));
    }
    
    @PostMapping("/create")
    public Expense createExpense(@RequestBody Expense expense) {
        expenseService.createExpense(expense.getDescription(), expense.getAmount(), expense.getCategory());
        return expense;
    }

    @PutMapping("update/{id}")
    public Expense updateExpense(@PathVariable String id, @RequestBody Expense expense) {
        Expense updatedExpense = new Expense();

        updatedExpense.setAmount(expense.getAmount());
        updatedExpense.setCategory(expense.getCategory());
        updatedExpense.setDescription(expense.getDescription());
        updatedExpense.setStatus("Pending");
        
        expenseService.updateExpense(Long.parseLong(id), updatedExpense);
        
        return expense;
    }
    
}
