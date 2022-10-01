package ss17_binary_serialization.exercise.exercise1.service.impl;

import ss17_binary_serialization.exercise.exercise1.model.Product;
import ss17_binary_serialization.exercise.exercise1.service.IProductService;
import ss17_binary_serialization.exercise.exercise1.utils.exception.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    private List<Product> productList;

    @Override
    public void add() {
        readFile();

        Product product = new Product();
        product.setCode(validCode());
        product.setName(validName());
        product.setProducer(validProducer());
        product.setPrice(validPrice());
        product.setDescription(validDescription());
        productList.add(product);

        writeFile();
    }

    @Override
    public String validCode() {
        String code;
        while (true) {
            try {
                System.out.print("Nhập vào mã sản phẩm: ");
                boolean validCode = (code = scanner.nextLine()).length() != 6;
                if (!validCode) {
                    throw new CodeException("Mã sản phẩm không hợp lệ (6 kí tự)");
                }
                break;
            } catch (CodeException e) {
                System.out.println(e.getMessage());
            }
        }
        return code;
    }

    @Override
    public String validName() {
        String name;
        while (true) {
            try {
                System.out.print("Nhập vào tên sản phẩm: ");
                boolean validName = (name = scanner.nextLine()).length() > 2 && checkContainsNumbers(name);
                if (!validName) {
                    throw new NameException("Tên sản phẩm không hợp lệ (nhiều hơn 2 kí tự)");
                }
                break;
            } catch (NameException e) {
                System.out.println(e.getMessage());
            }
        }
        return name;
    }

    @Override
    public boolean checkContainsNumbers(String string) {
        char[] chars = string.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String validProducer() {
        String producer;
        while (true) {
            try {
                System.out.print("Nhập vào tên nhà sản xuất: ");
                boolean validName = (producer = scanner.nextLine()).length() > 2 && checkContainsNumbers(producer);
                if (!validName) {
                    throw new ProducerException("Tên nhà sản xuất không hợp lệ (nhiều hơn 2 kí tự,không chứa số)");
                }
                break;
            } catch (ProducerException e) {
                System.out.println(e.getMessage());
            }
        }
        return producer;
    }

    @Override
    public Integer validPrice() {
        Integer price;
        while (true) {
            try {
                System.out.print("Nhập vào giá sản phẩm: ");
                boolean validName = (price = Integer.parseInt(scanner.nextLine())) > 1000 && (price = Integer.parseInt(scanner.nextLine())) < 10000000;
                if (!validName) {
                    throw new PriceException("Giá sản phẩm không hợp lệ (>1000 và < 10 triệu)");
                }
                break;
            } catch (PriceException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Giá sản phẩm chứa ký tự!");
            }
        }
        return price;
    }

    @Override
    public String validDescription() {
        String description;
        while (true) {
            try {
                System.out.print("Nhập vào tên nhà sản xuất: ");
                boolean validName = (description = scanner.nextLine()).length() > 0;
                if (!validName) {
                    throw new DescriptionException("");
                }
                break;
            } catch (DescriptionException e) {
                description = "Không có ghi chú nào!";
            }
        }
        return description;
    }

    @Override
    public void display() {
        readFile();

        for (Product product : productList) {
            System.out.println(product);
        }
    }

    @Override
    public void search() {
        readFile();

        System.out.print("Nhập vào mã sản phẩm cần tìm kiếm: ");
        String code = scanner.nextLine();

        boolean flagFound = false;
        for (Product product : productList) {
            if (product.getCode().contains(code)) {
                System.out.println(product);
                flagFound = true;
            }
        }

        if (!flagFound) {
            System.out.println("Không tìm thấy sản phẩm");
        }
    }

    @Override
    public void readFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/ss17_binary_serialization/exercise/exercise1/data/product_data.dat");
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);

            productList = (List<Product>) ois.readObject();
            ois.close();
        } catch (IOException e) {
            productList = new ArrayList<>();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/ss17_binary_serialization/exercise/exercise1/data/product_data.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);

            oos.writeObject(productList);
            oos.close();
        } catch (IOException e) {
        }
    }


}
