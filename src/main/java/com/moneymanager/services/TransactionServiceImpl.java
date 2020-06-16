package com.moneymanager.services;

import java.util.List;

import com.moneymanager.domain.Transaction;
import com.moneymanager.exceptions.EtBadRequestException;
import com.moneymanager.exceptions.EtResourceNotFoundException;
import com.moneymanager.repositories.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

  @Autowired
  TransactionRepository trasactionRepository;

  @Override
  public List<Transaction> fetchAllTransactions(Integer userId, Integer categoryId) {
    return trasactionRepository.findAll(userId, categoryId);
  }

  @Override
  public Transaction fetchTransactionById(Integer userId, Integer categoryId, Integer transactionId)
      throws EtResourceNotFoundException {
    return trasactionRepository.findById(userId, categoryId, transactionId);
  }

  @Override
  public Transaction addTransaction(Integer userId, Integer categoryId, Double amount, String note,
      Long transactionDate) throws EtBadRequestException {
    int transactionId = trasactionRepository.create(userId, categoryId, amount, note, transactionDate);
    return trasactionRepository.findById(userId, categoryId, transactionId);
  }

  @Override
  public void updateTransaction(Integer userId, Integer categoryId, Integer transactionId, Transaction transaction) throws EtBadRequestException {
    trasactionRepository.update(userId, categoryId, transactionId, transaction);
  }

  @Override
  public void removeTransaction(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException {
    trasactionRepository.removeById(userId, categoryId, transactionId);
  }
  
}