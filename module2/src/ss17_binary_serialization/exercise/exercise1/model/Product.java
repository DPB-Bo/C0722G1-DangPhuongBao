package ss17_binary_serialization.exercise.exercise1.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String code;
    private String name;
    private String producer;
    private Integer price;
    private String description;

    public Product() {
    }

    public Product(String code, String name, String producer, Integer price, String description) {
        this.code = code;
        this.name = name;
        this.producer = producer;
        this.price = price;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }

    public String getInformation() {
        return String.format("%s,%s,%s,%s,%s", this.code, this.name, this.producer, this.price, this.description);
    }
}
