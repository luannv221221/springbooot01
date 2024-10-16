package com.ra.session01.service;

import com.ra.session01.model.entity.Category;
import com.ra.session01.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveOrUpdate(Category category) {
        return null;
    }

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
