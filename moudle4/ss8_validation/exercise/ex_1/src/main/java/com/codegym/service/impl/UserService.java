package com.codegym.service.impl;

import com.codegym.model.User;
import com.codegym.repository.UserRepository;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> findByEmailContaining(Pageable pageable) {
        return userRepository.findByEmailContaining("",pageable);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
