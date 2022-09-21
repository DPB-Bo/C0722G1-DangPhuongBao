package ss12_collection_java.exercise.exercise_1.service.impl;

import ss12_collection_java.exercise.exercise_1.model.Product;
import ss12_collection_java.exercise.exercise_1.service.IProductService;

import java.security.SecureRandom;
import java.util.*;

public class ProductService implements IProductService {
    private Map<String, Product> productMap = new TreeMap<>();
    private Set<String> productID;

    private List<Product> productList;

//    public ProductService() {
//        productID = productMap.keySet();
//        productList = new ArrayList<>(productMap.values());
//    }

    @Override
    public void add() {
        productID = productMap.keySet();
        String id = generateRandomString();
        while (productID.contains(id)) {
            id = generateRandomString();
        }

        Product product = inputInformation();
        product.setId(id);
        productMap.put(product.getId(), product);
        System.out.println("\nThêm sản phẩm mới thành công! ");
    }

    @Override
    public void update() {
        String id = inputId();

        if (productID.contains(id)) {
            Product tempProduct = inputInformation();
            System.out.print("\nXác nhận chỉnh sửa (Y:yes , N:no) : ");
            String choice = scanner.nextLine();
            if (choice.equals("Y")) {
                productMap.get(id).setName(tempProduct.getName());
                productMap.get(id).setPrice(tempProduct.getPrice());
                productMap.get(id).setType(tempProduct.getType());
                System.out.println("\n Cập nhật thông tin thành công! ");
            } else {
                System.out.println("\nHuỷ cập nhật! ");
            }
        } else {
            System.out.println("\nKhông tìm thấy id sản phẩm! ");
        }
    }

    @Override
    public void remove() {
        String id = inputId();

        if (productID.contains(id)) {
            System.out.print("\nXác nhận xoá (Y:yes , N:no) : ");
            String choice = scanner.nextLine();
            if (choice.equals("Y")) {
                productMap.remove(id);
                System.out.println("\nXoá thành công! ");
            } else {
                System.out.println("\nHuỷ xoá! ");
            }
        } else {
            System.out.print("\nKhông tìm thấy id sản phẩm! ");
        }
    }

    @Override
    public void display() {
        productList = new ArrayList<>(productMap.values());
        for (Product product : productList) {
            System.out.printf("\nID: %s, %s\n", product.getId(), product);
        }
    }

    @Override
    public void search() {
        System.out.print("\nNhập vào tên cần tìm kiếm: ");
        String searchName = scanner.nextLine();

        boolean flagFound = false;

        for (String id : productID) {
            if (productMap.get(id).getName().contains(searchName)) {
                flagFound = true;
                System.out.println("\n" + productMap.get(id));
            }
        }

        if (!flagFound) {
            System.out.println("\nKhông tìm thấy tên sản phẩm!");
        }
    }

    @Override
    public void sortByPrice() {
        productList = new ArrayList<>(productMap.values());
        productList.sort(new PriceComparator());
        for (Product product : productList) {
            System.out.printf("\nID: %s, %s\n", product.getId(), product);
        }
    }

    private String generateRandomString() {
        String rangeID = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom random = new SecureRandom();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            str.append(rangeID.charAt(random.nextInt(rangeID.length())));
        }
        return str.toString();
    }

    private Product inputInformation() {
        System.out.print("\nNhập vào tên sản phẩm: ");
        String productName = scanner.nextLine();

        System.out.print("\nNhập vào giá sản phẩm: ");
        Integer productPrice = Integer.parseInt(scanner.nextLine());

        System.out.print("\nNhập vào loại sản phẩm: ");
        String productType = scanner.nextLine();

        return new Product(productName, productPrice, productType);
    }

    private static String inputId() {
        System.out.print("\nNhập vào id sản phẩm: ");
        return scanner.nextLine();
    }
}
