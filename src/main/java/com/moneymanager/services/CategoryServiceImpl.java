package com.moneymanager.services;

import java.util.List;

import com.moneymanager.domain.Category;
import com.moneymanager.exceptions.EtBadRequestException;
import com.moneymanager.exceptions.EtResourceNotFoundException;
import com.moneymanager.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  CategoryRepository categoryRepository;
  
  @Override
  public List<Category> fetchAllCategories(Integer userId) {
   
    return null;
  }

  @Override
  public Category fetchCategoryById(Integer userId, Integer categoryId) throws EtResourceNotFoundException {
   
    return null;
  }

  @Override
  public Category addCategory(Integer userId, String title, String description) throws EtBadRequestException {
   
    return null;
  }

  @Override
  public void updateCategory(Integer userId, Integer categoryId, Category category) throws EtBadRequestException {
   
    
  }

  @Override
  public void removeCategoryWithAllTransactions(Integer userId, Integer categoryId)
      throws EtResourceNotFoundException {
    
  }
}