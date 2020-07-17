package com.moneymanager.service;

public interface OTPServiceInterface {

  void createOTP(String user);
  
  void deleteOTP(String email);

  Integer getOTP(String email);

  Boolean isValidUser(String email);
}