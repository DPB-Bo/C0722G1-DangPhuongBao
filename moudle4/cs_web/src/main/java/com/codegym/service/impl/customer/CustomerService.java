package com.codegym.service.impl.customer;

import com.codegym.dto.customer.CustomerDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.repository.customer.CustomerRepository;
import com.codegym.service.customer.ICustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Page<CustomerDto> findByNameContainingAndEmailContainingAndCustomerType(String name, String email, CustomerType customerType, Pageable pageable) {
        return customerRepository.findByNameContainingAndEmailContainingAndCustomerType(name, email, customerType, pageable);
    }

    @Override
    public Page<CustomerDto> findByNameContainingAndEmailContaining(String name, String email, Pageable pageable) {
        return customerRepository.findByNameContainingAndEmailContaining(name, email, pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public CustomerDto findById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerDto> findByDeleted() {
        return customerRepository.findByDeleted(false);
    }
}
