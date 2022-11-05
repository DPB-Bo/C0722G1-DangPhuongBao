package repository.impl;

import model.Product;

import java.util.List;

public interface IProductRepository {
    void add(Product product);

    List<Product> getAvailable();

    void getBySearch();

    void delete(Integer id);

    void update(Integer id, Product product);

}
