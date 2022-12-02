package com.codegym.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandleExBook {
    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "error_page";
    }
}
