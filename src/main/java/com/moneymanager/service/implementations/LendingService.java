package com.moneymanager.service.implementations;

import java.util.List;

import com.moneymanager.exceptions.LendingBadRequest;
import com.moneymanager.exceptions.LendingResourceNotFoundException;
import com.moneymanager.model.Lending;
import com.moneymanager.repository.LendingRepositoryInterface;

public class LendingService implements LendingRepositoryInterface {

  @Override
  public List<Lending> findAll(String email) throws LendingResourceNotFoundException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Lending> findById(String email, String lendingID) throws LendingResourceNotFoundException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void create(String email, String lendingID, String title, String description, Long date, Double amount,
      String month, Integer year) throws LendingBadRequest {
    // TODO Auto-generated method stub

  }

  @Override
  public void update(String email, String lendingID, String title, String description, Long date, Double amount,
      String month, Integer year) throws LendingBadRequest {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(String email, String lendingID) throws LendingBadRequest {
    // TODO Auto-generated method stub

  }
  
}