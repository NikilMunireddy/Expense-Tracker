package com.moneymanager.repositories;

import com.moneymanager.domain.User;
import com.moneymanager.exceptions.EtAuthException;

public interface UserRepository {
  
  Integer create(String firstName, String lastName, String email, String password) throws EtAuthException;

  User findEmailAndPassword(String email, String password) throws EtAuthException;

  Integer getCounterByEmail(String email);

  User findById(Integer userId);
}