package com.codegym.ex_1.service.impl;

import com.codegym.ex_1.model.Blog;
import com.codegym.ex_1.model.Category;
import com.codegym.ex_1.repository.ICategoryRepository;
import com.codegym.ex_1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> categoryList() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> findByTitleContainingOrAuthorContaining(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Category> findByDeleted(Pageable pageable) {
        return categoryRepository.findByDeleted(false,pageable);
    }

    @Override
    public Category save(Blog blog) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).isPresent()?categoryRepository.findById(id).get() : null;
    }
}
