package service;

import model.Product;
import repository.ProductRepository;
import repository.impl.IProductRepository;
import service.impl.IProductService;

import java.util.List;

public class ProductService implements IProductService {

    private IProductRepository productRepository = new ProductRepository();


    @Override
    public List<Product> getAvailable() {
        return productRepository.getAvailable();
    }

    @Override
    public void create(Product product) {
        productRepository.add(product);
    }

    @Override
    public void update(Integer id, Product product) {
        productRepository.update(id, product);
    }

    @Override
    public void search() {

    }

    @Override
    public void displayDetails() {

    }

    @Override
    public void delete(Integer id) {
        productRepository.delete(id);
    }
}
