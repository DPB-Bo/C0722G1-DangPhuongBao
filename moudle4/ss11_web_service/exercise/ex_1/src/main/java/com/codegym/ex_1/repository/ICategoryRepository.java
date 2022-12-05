package com.codegym.ex_1.repository;

import com.codegym.ex_1.model.Blog;
import com.codegym.ex_1.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    Page<Category> findByDeleted(boolean deleted, Pageable pageable);
}