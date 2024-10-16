package com.ra.session01.service;

import com.ra.session01.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category saveOrUpdate(Category category);
    Category findById(Long id);
    void delete(Long id);
}
