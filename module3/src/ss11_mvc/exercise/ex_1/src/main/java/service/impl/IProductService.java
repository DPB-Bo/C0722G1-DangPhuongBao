package service.impl;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAvailable();

    void create(Product product);

    void update(Integer id, Product product);

    void search();

    void displayDetails();

    void delete(Integer id);
}
