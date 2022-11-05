package repository;

import model.Product;
import repository.impl.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product("0", "banh", 1.0f, "khong", "bao", false));
        productList.add(new Product("1", "keo", 2.0f, "co", "dat", false));
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public List<Product> getAvailable() {
        List<Product> products = new ArrayList<>();
        for (Product product : productList) {
            if (!(product.isDelete())) {
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public void getBySearch() {

    }

    @Override
    public void delete(Integer id) {
        productList.get(id).setDelete(true);

    }

    @Override
    public void update(Integer id, Product product) {
        productList.set(id, product);
    }
}
