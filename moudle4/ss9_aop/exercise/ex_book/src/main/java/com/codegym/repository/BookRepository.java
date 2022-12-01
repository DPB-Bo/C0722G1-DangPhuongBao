package com.codegym.repository;

import com.codegym.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Modifying
    @Query(value = "update book b set b.quantity = b.quantity-1 where b.id = :id",nativeQuery = true)
    void reduceQuantity(@Param("id") Integer id);

    @Modifying
    @Query(value = "update book set quantity = quantity+1 where id = :id",nativeQuery = true)
    void increaseQuantity(@Param("id") Integer id);

}