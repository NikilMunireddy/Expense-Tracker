package com.moneymanager.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.moneymanager.model.Expense;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/moneymanager/expense")
public class ExpenseController {

  @PostMapping()
  public ResponseEntity<Map<String, String>> addExpense(HttpServletRequest request, @RequestBody Expense transaction,
  @RequestBody Expense expenseMap){
    String userID = (String) expenseMap.getEmail();
    Map<String, String> map = new HashMap<>();
    map.put("success", userID);
    return new ResponseEntity<>(map,HttpStatus.OK);
  }
  
}