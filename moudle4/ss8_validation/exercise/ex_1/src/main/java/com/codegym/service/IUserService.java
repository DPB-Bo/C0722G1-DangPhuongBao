package com.codegym.service;

import com.codegym.dto.UserDto;
import com.codegym.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Page<UserDto> findByEmailContaining(Pageable pageable);
    void save(User user);
}
