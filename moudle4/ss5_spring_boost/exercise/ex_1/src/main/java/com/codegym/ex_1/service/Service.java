package com.codegym.ex_1.service;

import com.codegym.ex_1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Service<T> {
    Page<Blog> findByTitleContainingOrAuthorContaining(String name, Pageable pageable);

    T save(Blog blog);

    void deleteById(Integer id);

    T findById(Integer id);
}
