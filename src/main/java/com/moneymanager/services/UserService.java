package com.moneymanager.services;

import com.moneymanager.models.User;
import com.moneymanager.exceptions.EtAuthException;

public interface UserService {
  
  User validateUser(String email, String password) throws EtAuthException;

  User registerUser( String firstName, String lastName, String email, String password) throws EtAuthException;
}