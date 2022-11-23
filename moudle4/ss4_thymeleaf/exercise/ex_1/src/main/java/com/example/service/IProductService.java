package com.example.service;

import com.example.model.Product;

import java.util.List;
import java.util.Map;

public interface IProductService {
    List<Product> getAvailable();

    boolean addProduct(Product product);

    boolean updateProduct(Product product);

    boolean removeProduct(String id);

    Product getProductById(String id);

    Map<String, Product> getAvailableByName(String name);
}
