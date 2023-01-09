package com.service;

import com.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(Integer id);

    void save(Product customerType);

    void remove(Integer id);
}
