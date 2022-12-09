package com.codegym.service.impl.customer;

import com.codegym.model.customer.CustomerType;
import com.codegym.repository.customer.CustomerTypeRepository;
import com.codegym.service.customer.ICustomerTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    private final CustomerTypeRepository customerTypeRepository;

    public CustomerTypeService(CustomerTypeRepository customerTypeRepository) {
        this.customerTypeRepository = customerTypeRepository;
    }

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public CustomerType findById(int id) {
        return customerTypeRepository.findById(id).isPresent()?customerTypeRepository.findById(id).get():null;
    }
}
