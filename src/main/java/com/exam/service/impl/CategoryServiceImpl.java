package com.exam.service.impl;

import com.exam.entity.exam.Category;
import com.exam.exception.CategoryNotFoundException;
import com.exam.repository.CategoryRepository;
import com.exam.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(()->new CategoryNotFoundException("category","categoryId",categoryId));
    }

    @Override
    public Category updateCategory(Category category) {
         return categoryRepository.save(category);
    }

    @Override
    public Set<Category> getCategories() {
        return new LinkedHashSet<>(categoryRepository.findAll());
    }

    @Override
    public void deleteCategory(Long categoryId) {
                categoryRepository.deleteById(categoryId);
    }
}
