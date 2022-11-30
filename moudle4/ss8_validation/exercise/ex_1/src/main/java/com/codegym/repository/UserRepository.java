package com.codegym.repository;

import com.codegym.dto.UserDto;
import com.codegym.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Page<UserDto> findByEmailContaining(String email, Pageable pageable);
}