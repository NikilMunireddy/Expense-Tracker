package com.moneymanager.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.moneymanager.models.Transaction;
import com.moneymanager.services.TransactionService;

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

@RestController()
@RequestMapping("/api/categories/{categoryId}/transactions")
public class TransactionResource {

  @Autowired
  TransactionService transactionService;

  // @Route    GET /api/categories/{categoryId}/transactions
  // @Desc     Get all transactions with Tx ID
  // @Access   Private

  @GetMapping("")
  public ResponseEntity<List<Transaction>> getAllTransactions(HttpServletRequest request,
      @PathVariable("categoryId") Integer categoryId) {
    int userId = (Integer) request.getAttribute("userId");
    List<Transaction> transactions = transactionService.fetchAllTransactions(userId, categoryId);
    return new ResponseEntity<>(transactions, HttpStatus.OK);
  }

  // @Route    GET /api/categories/{categoryId}/transactions/{transactionId}
  // @Desc     Get Transaction with with Tx ID
  // @Access   Private

  @GetMapping("/{transactionId}")
  public ResponseEntity<Transaction> getTransactionById(HttpServletRequest request,
      @PathVariable("categoryId") Integer categoryId, @PathVariable("transactionId") Integer transactionId) {
    int userId = (Integer) request.getAttribute("userId");
    Transaction transaction = transactionService.fetchTransactionById(userId, categoryId, transactionId);
    return new ResponseEntity<>(transaction, HttpStatus.OK);
  }

  // @Route    POST /api/categories/{categoryId}/transactions
  // @Desc     Add Transaction 
  // @Access   Private

  @PostMapping()
  public ResponseEntity<Transaction> addTransaction(HttpServletRequest request,
      @PathVariable("categoryId") Integer categoryId, @RequestBody Map<String, Object> transactionMap) {

    int userId = (Integer) request.getAttribute("userId");
    Double amount = Double.valueOf(transactionMap.get("amount").toString());
    String note = (String) transactionMap.get("note");
    Long transactionDate = (Long) transactionMap.get("transactionDate");
    Transaction transaction = transactionService.addTransaction(userId, categoryId, amount, note, transactionDate);
    return new ResponseEntity<>(transaction, HttpStatus.CREATED);
  }

  // @Route    PUT /api/categories/{categoryId}/transactions/{transactionId}
  // @Desc     Update Transaction with with Tx ID
  // @Access   Private

  @PutMapping("/{transactionId}")
  public ResponseEntity<Map<String, Boolean>> updateTransaction(HttpServletRequest request,
      @PathVariable("categoryId") Integer categoryId, @PathVariable("transactionId") Integer transactionId,
      @RequestBody Transaction transaction) {
    int userId = (Integer) request.getAttribute("userId");
    transactionService.updateTransaction(userId, categoryId, transactionId, transaction);
    Map<String, Boolean> map = new HashMap<>();
    map.put("success", true);
    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  // @Route    DELETE /api/categories/{categoryId}/transactions/{transactionId}
  // @Desc     Delete a Transaction with with Tx ID
  // @Access   Private

  @DeleteMapping("/{transactionId}")
  public ResponseEntity<Map<String, Boolean>> deleteTransaction(HttpServletRequest request,
      @PathVariable("categoryId") Integer categoryId, @PathVariable("transactionId") Integer transactionId) {
    int userId = (Integer) request.getAttribute("userId");
    transactionService.removeTransaction(userId, categoryId, transactionId);
    Map<String, Boolean> map = new HashMap<>();
    map.put("success", true);
    return new ResponseEntity<>(map, HttpStatus.OK);
  }

}