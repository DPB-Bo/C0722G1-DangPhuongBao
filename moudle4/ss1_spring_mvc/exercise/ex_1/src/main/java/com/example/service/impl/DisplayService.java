package com.example.service.impl;

import com.example.service.IDisplayService;
import org.springframework.stereotype.Service;

@Service
public class DisplayService implements IDisplayService {

    @Override
    public int calculate(int value) {
        return value*21000;
    }
}
