package com.codegym.service.customer;

import com.codegym.dto.customer.CustomerDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<CustomerDto> findByNameContainingAndEmailContainingAndCustomerType(String name, String email, CustomerType customerType, Pageable pageable);
    Page<CustomerDto> findByNameContainingAndEmailContaining(String name, String email, Pageable pageable);
    void save (Customer customer);
    CustomerDto findById(int id);
    void deleteById(int id);
}
