package com.moneymanager.service;

import java.util.List;

import com.moneymanager.exceptions.ExpenseBadRequest;
import com.moneymanager.exceptions.ExpenseResourceNotFoundException;
import com.moneymanager.model.Expense;

public interface ExpenseServiceInterface {

  List<Expense> fetchAllExpenses(String email);

  List<Expense> fetchByExpenseId(String email, String expenseID) throws ExpenseResourceNotFoundException;

  Expense addExpense(String email, String expenseID, String title,  String description, Long date, Double amount, String month, Integer year) throws ExpenseBadRequest;

  void updateExpense() throws ExpenseBadRequest;

  void removeExpense(String email, String expenseID) throws ExpenseResourceNotFoundException;

}