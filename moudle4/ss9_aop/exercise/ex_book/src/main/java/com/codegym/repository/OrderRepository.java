package com.codegym.repository;

import com.codegym.model.OrderB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface OrderRepository extends JpaRepository<OrderB, Integer> {
    boolean existsById(String id);

    void deleteById(String id);
}