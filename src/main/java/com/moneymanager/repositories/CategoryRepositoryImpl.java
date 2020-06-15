package com.moneymanager.repositories;

import java.util.List;

import com.moneymanager.domain.Category;
import com.moneymanager.exceptions.EtBadRequestException;
import com.moneymanager.exceptions.EtResourceNotFoundException;

import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
  
  @Override
  public List<Category> findAll(Integer userId) throws EtResourceNotFoundException {
    
    return null;
  }

  @Override
  public Category findById(Integer userId, Integer categoryId) throws EtResourceNotFoundException {
    
    return null;
  }

  @Override
  public Integer create(Integer userId, String title, String description) throws EtBadRequestException {
    
    return null;
  }

  @Override
  public void update(Integer userId, Integer categoryId, Category category) throws EtBadRequestException {
    
    
  }

  @Override
  public void removeById(Integer userId, Integer categoryId) {
    // TODO Auto-generated method stub
    
  }
}
