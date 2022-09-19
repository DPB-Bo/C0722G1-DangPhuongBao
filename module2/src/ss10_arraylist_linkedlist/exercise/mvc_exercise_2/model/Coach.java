package ss10_arraylist_linkedlist.exercise.mvc_exercise_2.model;

public class Coach extends Car {
    private String typeCar;
    private Integer amountSeat;

    public Coach() {
    }

    public Coach(String code, Producer producer, Integer year, String owner) {
        super(code, producer, year, owner);
    }

    public Coach(String code, Producer producer, Integer year, String owner, String typeCar, Integer amountSeat) {
        super(code, producer, year, owner);
        this.typeCar = typeCar;
        this.amountSeat = amountSeat;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }

    public Integer getAmountSeat() {
        return amountSeat;
    }

    public void setAmountSeat(Integer amountSeat) {
        this.amountSeat = amountSeat;
    }

    @Override
    public String toString() {
        return "\n Ô tô{" +
                super.toString() +
                ", Kiểu xe: " + typeCar +
                ", Số chỗ ngồi: " + amountSeat +
                "}\n";
    }
}
