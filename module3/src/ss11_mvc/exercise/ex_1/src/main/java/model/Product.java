package model;

public class Product {
    private String id;
    private String name;
    private Float productPrice;
    private String description;
    private String producer;

    private boolean isDelete;

    public Product(String id, String name, Float productPrice, String description, String producer, boolean isDelete) {
        this.id = id;
        this.name = name;
        this.productPrice = productPrice;
        this.description = description;
        this.producer = producer;
        this.isDelete = isDelete;
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

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", productPrice=" + productPrice +
                ", description='" + description + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
}
