package com.codegym.ex_1.service.impl;

import com.codegym.ex_1.model.Category;
import com.codegym.ex_1.repository.ICategoryRepository;
import com.codegym.ex_1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
