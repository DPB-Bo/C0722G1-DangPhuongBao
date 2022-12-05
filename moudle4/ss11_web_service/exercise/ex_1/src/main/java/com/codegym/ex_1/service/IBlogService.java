package com.codegym.ex_1.service;

import com.codegym.ex_1.model.Blog;
import com.codegym.ex_1.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends Service<Blog> {
    Page<Blog> findByCategory(Category category, Pageable pageable);
}
