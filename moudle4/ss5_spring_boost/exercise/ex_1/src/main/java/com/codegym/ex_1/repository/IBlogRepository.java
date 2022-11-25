package com.codegym.ex_1.repository;

import com.codegym.ex_1.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByTitleContainingOrAuthorContaining(String title, String author);
}