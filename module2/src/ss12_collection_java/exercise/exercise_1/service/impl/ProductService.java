package ss12_collection_java.exercise.exercise_1.service.impl;

import ss12_collection_java.exercise.exercise_1.model.Product;
import ss12_collection_java.exercise.exercise_1.service.IProductService;

import java.security.SecureRandom;
import java.util.*;

public class ProductService implements IProductService {
    private Map<String, Product> productMap = new TreeMap<>();
    private Set<String> productID = productMap.keySet();
    private List<Product> productList;

    @Override
    public void add() {
        String id;
        do {
            id = generateRandomString();
        } while (productID.contains(id));

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
        if (productID.size() <= 0) {
            System.out.println("\nKhông có sản phẩm trong list!");
        } else {
            productList = new ArrayList<>(productMap.values());
            for (Product product : productList) {
                System.out.printf("\nID: %s, %s\n", product.getId(), product);
            }
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
        if (productID.size() <= 0) {
            System.out.println("\nKhông có sản phẩm!");
        } else {
            productList = new ArrayList<>(productMap.values());
            productList.sort(new PriceComparator());
            for (Product product : productList) {
                System.out.printf("\nID: %s, %s\n", product.getId(), product);
            }
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

    private String inputId() {
        System.out.print("\nNhập vào id sản phẩm: ");
        return scanner.nextLine();
    }

    public void addData() {
        productMap.put("ID1", new Product("sp1", 10, "A"));
        productMap.get("ID1").setId("ID1");

        productMap.put("ID2", new Product("sp2", 10, "B"));
        productMap.get("ID2").setId("ID2");

        productMap.put("ID3", new Product("sp3", 10, "C"));
        productMap.get("ID3").setId("ID3");

        productMap.put("ID4", new Product("sp4", 10, "D"));
        productMap.get("ID4").setId("ID4");

        productMap.put("ID5", new Product("sp5", 10, "E"));
        productMap.get("ID5").setId("ID5");

        productMap.put("ID6", new Product("sp6", 10, "F"));
        productMap.get("ID6").setId("ID6");

        productMap.put("ID7", new Product("sp7", 10, "G"));
        productMap.get("ID7").setId("ID7");

        productMap.put("ID8", new Product("sp8", 10, "H"));
        productMap.get("ID8").setId("ID8");

    }
}
