package com.moneymanager.controller;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.moneymanager.model.Debt;
import com.moneymanager.service.DebtServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/moneymanager/debt")
public class DebtController {

  @Autowired
  DebtServiceInterface debtService;

  @PostMapping()
  public ResponseEntity<Map<String, Boolean>> addExpense(HttpServletRequest request,
      @RequestBody Map<String, Object> expense) {
    
    String email = (String) expense.get("email");
    String debtID = new StringBuilder().append(Instant.now().getEpochSecond()).toString();
    String title = (String) expense.get("title");
    String description = (String) expense.get("description");
    Long date = Long.valueOf(((Integer) expense.get("date")).longValue());
    Double amount = (Double) expense.get("amount");
    String month = (String) expense.get("month");
    Integer year = (Integer) expense.get("year");

    debtService.addDebt(email, debtID, title, description, date, amount, month, year);
    Map<String, Boolean> map = new HashMap<>();
    map.put("success", true);
    return new ResponseEntity<>(map, HttpStatus.OK);
  }


  @PutMapping()
  public ResponseEntity<Map<String, Boolean>> updateExpense(HttpServletRequest request,
      @RequestBody Map<String, Object> expense){

    String email = (String) expense.get("email");
    String debtID = (String) expense.get("debtID");
    String title = (String) expense.get("title");
    String description = (String) expense.get("description");
    Long date = Long.valueOf(((Integer) expense.get("date")).longValue());
    Double amount = (Double) expense.get("amount");
    String month = (String) expense.get("month");
    Integer year = (Integer) expense.get("year");
    
    debtService.removeDebt(email, debtID);
    debtService.addDebt(email, debtID, title, description, date, amount, month, year);
    Map<String, Boolean> map = new HashMap<>();
    map.put("success", true);
    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @GetMapping()
  public ResponseEntity<List<Debt>> getAllExpense(HttpServletRequest request){
    String email = (String) request.getAttribute("email");
    List<Debt> allExpenss= debtService.fetchAllDebts(email);
    return new ResponseEntity<>(allExpenss,HttpStatus.OK);
  }

  @DeleteMapping("/{debtID}")
  public ResponseEntity<Map<String, Boolean>> deleteExpense(HttpServletRequest request, @PathVariable("debtID") String debtID){
    String email = (String) request.getAttribute("email");
    debtService.removeDebt(email, debtID);
    Map<String, Boolean> map = new HashMap<>();
    map.put("status", true);
    return new ResponseEntity<>(map, HttpStatus.OK);
  }
  
}