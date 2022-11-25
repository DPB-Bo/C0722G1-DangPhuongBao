package com.codegym.ex_1.service;

import com.codegym.ex_1.model.Blog;

import java.util.List;

public interface Service<T> {
    List<Blog> findByTitleContainingOrAuthorContaining(String name);

    T save(Blog blog);

    void deleteById(Integer id);

    T findById(Integer id);
}
