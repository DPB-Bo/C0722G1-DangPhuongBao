package ss10_arraylist_linkedlist.exercise.mvc_exercise_2.model;

public class Coach extends Car {
    private String typeCar;
    private Integer amountSeat;

    public Coach() {
        super.setPath("src/ss10_arraylist_linkedlist/exercise/mvc_exercise_2/data/coach/coach.csv");
    }

    public Coach(String code, Producer producer, Integer year, String owner) {
        super(code, producer, year, owner);
        super.setPath("src/ss10_arraylist_linkedlist/exercise/mvc_exercise_2/data/coach/coach.csv");
    }

    public Coach(String code, Producer producer, Integer year, String owner, String typeCar, Integer amountSeat) {
        super(code, producer, year, owner);
        this.typeCar = typeCar;
        this.amountSeat = amountSeat;
        super.setPath("src/ss10_arraylist_linkedlist/exercise/mvc_exercise_2/data/coach/coach.csv");
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
        return "\nÔ tô{" +
                super.toString() +
                ", Kiểu xe: " + typeCar +
                ", Số chỗ ngồi: " + amountSeat +
                "}\n";
    }

    @Override
    public String getInformation() {
        return super.getInformation() + String.format("%s,%s", this.typeCar, this.amountSeat);
    }
}
