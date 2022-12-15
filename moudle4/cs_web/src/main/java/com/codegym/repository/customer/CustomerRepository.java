package com.codegym.repository.customer;

import com.codegym.dto.customer.CustomerDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Page<CustomerDto> findByNameContainingAndEmailContainingAndCustomerType(String name, String email, CustomerType customerType, Pageable pageable);
    Page<CustomerDto> findByNameContainingAndEmailContaining(String name, String email, Pageable pageable);
    List<CustomerDto> findByDeleted(boolean deleted);
}