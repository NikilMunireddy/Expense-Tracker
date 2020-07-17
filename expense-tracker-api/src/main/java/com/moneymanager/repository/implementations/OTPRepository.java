package com.moneymanager.repository.implementations;

import com.moneymanager.repository.OTPRepositoryInterface;

public class OTPRepository implements OTPRepositoryInterface{

  private static final String ADD_OTP ="INSERT INTO otp_service (email, otpexpirytime, otp )"+
  " VALUES(?, ?, ?)";

  private static final String UPDATE_USER_VALIDITY_STATUS = "UPDATE exp_tracker_users SET is_valid = ? WHERE email = ?";

  private static final String SQL_DELETE_OTP = "DELETE FROM otp_service WHERE email = ?";

  private static final String GET_OTP ="SELECT email, otpexpirytime, otp FROM otp_service WHERE email=? ";


  @Override
  public void createOTP(String user) {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteOTP(String email) {
    // TODO Auto-generated method stub

  }

  @Override
  public Integer getOTP(String email) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Boolean isValidUser(String email) {
    // TODO Auto-generated method stub
    return null;
  }
  
}