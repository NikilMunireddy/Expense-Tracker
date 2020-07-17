package com.moneymanager.repository;

public interface OTPRepositoryInterface {
  
  void createOTP(String user);
  
  void deleteOTP(String email);

  Integer getOTP(String email);

  Boolean isValidUser(String email);
}