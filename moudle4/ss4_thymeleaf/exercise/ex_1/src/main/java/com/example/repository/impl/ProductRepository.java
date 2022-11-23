package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static Map<String, Product> products = new HashMap<>();

    static {
        products.put("1", new Product("1", "SP1", 1000d, "DES1", "PRODUCER1"));
        products.put("2", new Product("2", "SP2", 2000d, "DES2", "PRODUCER2"));
        products.put("3", new Product("3", "SP3", 3000d, "DES3", "PRODUCER3"));
        products.put("4", new Product("4", "SP4", 4000d, "DES4", "PRODUCER4"));
        products.put("5", new Product("5", "SP5", 5000d, "DES5", "PRODUCER5"));
        products.put("6", new Product("6", "SP6", 6000d, "DES6", "PRODUCER6"));
        products.put("7", new Product("7", "SP7", 7000d, "DES7", "PRODUCER7"));
    }

    @Override
    public List<Product> getAvailable() {
        return new ArrayList<>(products.values());
    }

    @Override
    public boolean addProduct(Product product) {
        products.put(product.getId(), product);
        return true;
    }

    @Override
    public boolean updateProduct(Product product) {
        products.put(product.getId(), product);
        return true;
    }

    @Override
    public boolean removeProduct(String id) {
        products.remove(id);
        return true;
    }

    @Override
    public Product getProductById(String id) {
        return products.get(id);
    }

    @Override
    public Map<String, Product> getAvailableByName(String name) {
        Map<String, Product> availableByName = new HashMap<String, Product>();
        for (Product product : products.values()) {
            if (product.getName().equals(name)) {
                availableByName.put(product.getId(), product);
            }
        }
        return availableByName;
    }


}
