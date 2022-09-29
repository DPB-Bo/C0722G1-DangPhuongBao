package ss10_arraylist_linkedlist.exercise.mvc_exercise_2.model;

public abstract class Car {
    private String code;
    private Producer producer;
    private Integer year;
    private String owner;

    private String path;

    public Car() {
    }

    public Car(String code, Producer producer, Integer year, String owner) {
        this.code = code;
        this.producer = producer;
        this.year = year;
        this.owner = owner;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getInformation() {
        return String.format("%s,%s,%s,%s,", this.code, this.producer.getInformation(), this.year, this.owner);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Biển kiểm soát: " + code +
                ", Hãng sản xuất: " + producer +
                ", Năm sản xuất: " + year +
                ", Chủ sở hữu: " + owner;
    }
}
