package com.example.service.impl;

import com.example.service.IDisplayService;
import org.springframework.stereotype.Service;

@Service
public class DisplayService implements IDisplayService {
    @Override
    public Double calculate(Double number1, Double number2, String sign) {
        switch (sign) {
            case "Addition(+)":
                return number1 + number2;
            case "Subtraction(-)":
                return number1 - number2;
            case "Multiplication(x)":
                return number1 * number2;
            case "Division(/)":
                return number1 / number2;
        }
        return 0d;
    }
}
