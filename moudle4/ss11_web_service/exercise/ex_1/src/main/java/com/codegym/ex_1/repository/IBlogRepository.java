package com.codegym.ex_1.repository;

import com.codegym.ex_1.model.Blog;
import com.codegym.ex_1.model.Category;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByTitleContainingOrAuthorContaining(String title, String author, Pageable pageable);
    @Query(value = "UPDATE blog SET deleted = true WHERE id = :id",nativeQuery = true)
    void softDelete(@Param("id") Integer id);

    Page<Blog> findByDeleted(boolean deleted,Pageable pageable);

    Page<Blog> findByCategory(Category category, Pageable pageable);
}