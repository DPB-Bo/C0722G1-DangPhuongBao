package ss12_collection_java.exercise.exercise_1.model;

public class Product {
    private String name;
    private Integer price;
    private String type;

    private String id;

    public Product() {
    }

    public Product(String name, Integer price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Tên: " + name +
                ", Giá: " + price +
                ", Loại: " + type;
    }
}
