package com.moneymanager.repository.implementations;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import com.moneymanager.exceptions.LendingBadRequest;
import com.moneymanager.exceptions.LendingResourceNotFoundException;
import com.moneymanager.model.Lending;
import com.moneymanager.repository.LendingRepositoryInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class LendingRepository implements LendingRepositoryInterface {

  private static final String SQL_CREATE = "INSERT INTO exp_tracker_lending (lending_id, title, description, email, transaction_date, amount, month, year )"+
  " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
  private static final String SQL_COUNT_BY_EMAIL = "SELECT COUNT(*) FROM exp_tracker_lending WHERE EMAIL = ?";
  private static final String SQL_FIND_BY_ID = "SELECT lending_id, title, description, email, transaction_date, amount, month, year " +
  "FROM exp_tracker_lending WHERE lending_id = ?";
  private static final String SQL_FIND_BY_EMAIL =  "SELECT lending_id, title, description, email, transaction_date, amount, month, year " +
  "FROM exp_tracker_lending WHERE email = ?";
  private static final String SQL_DELETE_SAVING = "DELETE FROM exp_tracker_lending WHERE email = ? AND lending_id = ?";

  @Autowired
  JdbcTemplate jdbcTemplate;

  private RowMapper<Lending> lendingRowMapper = ((rs, rowNum) -> {
    return new Lending(rs.getString("email"),
            rs.getString("lending_id"),
            rs.getString("title"),
            rs.getString("description"),
            rs.getLong("transaction_date"),
            rs.getDouble("amount"),
            rs.getString("month"),
            rs.getInt("year"));
  });

  @Override
  public List<Lending> findAll(String email) throws LendingResourceNotFoundException {
    return jdbcTemplate.query(SQL_FIND_BY_EMAIL, new Object[] { email }, lendingRowMapper);
  }

  @Override
  public List<Lending> findById(String email, String lendingID) throws LendingResourceNotFoundException {
    return jdbcTemplate.query(SQL_FIND_BY_ID, new Object[] { email, lendingID }, lendingRowMapper);
  }

  @Override
  public void create(String email, String lendingID, String title, String description, Long date, Double amount,
      String month, Integer year) throws LendingBadRequest {
        try {
          KeyHolder keyHolder = new GeneratedKeyHolder();
          jdbcTemplate.update(connection ->{
            PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, lendingID);
            ps.setString(2, title);
            ps.setString(3, description);
            ps.setString(4, email);
            ps.setLong(5, date);
            ps.setDouble(6, amount);
            ps.setString(7, month);
            ps.setInt(8, year);
            return ps;
          }, keyHolder);
  
        } catch (Exception e) {
          throw new LendingBadRequest(e.toString());
        }
  }

  @Override
  public void update(String email, String lendingID, String title, String description, Long date, Double amount,
      String month, Integer year) throws LendingBadRequest {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(String email, String lendingID) throws LendingBadRequest {
    jdbcTemplate.update(SQL_DELETE_SAVING, new Object[] { email, lendingID });
  }
  
}