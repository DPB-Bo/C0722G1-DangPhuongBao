package com.codegym.service.customer;

import com.codegym.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
    CustomerType findById(int id);
}
