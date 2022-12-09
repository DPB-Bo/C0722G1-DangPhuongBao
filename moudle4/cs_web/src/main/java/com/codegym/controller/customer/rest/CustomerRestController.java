package com.codegym.controller.customer.rest;

import com.codegym.dto.customer.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer/rest")
public class CustomerRestController {
    @GetMapping("clear")
    public ResponseEntity<CustomerDto> clear() {
        
    }
}
