package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAvailable();

    boolean addProduct(Product product);

    boolean updateProduct(Product product);

    boolean removeProduct(String id);

    Product getProductById(int id);

    List<Product> getAvailableByName(String name);
}
