package ss10_arraylist_linkedlist.exercise.mvc_exercise_2.model;

public class Motor extends Car {
    private Integer vehicleCapacity;

    public Motor() {
        super.setPath("src/ss10_arraylist_linkedlist/exercise/mvc_exercise_2/data/motor/motor.csv");
    }

    public Motor(String code, Producer producer, Integer year, String owner) {
        super(code, producer, year, owner);
        super.setPath("src/ss10_arraylist_linkedlist/exercise/mvc_exercise_2/data/coach/motor.csv");
    }

    public Motor(String code, Producer producer, Integer year, String owner, Integer vehicleCapacity) {
        super(code, producer, year, owner);
        this.vehicleCapacity = vehicleCapacity;
        super.setPath("src/ss10_arraylist_linkedlist/exercise/mvc_exercise_2/data/coach/motor.csv");
    }

    public Integer getVehicleCapacity() {
        return vehicleCapacity;
    }

    public void setVehicleCapacity(Integer vehicleCapacity) {
        this.vehicleCapacity = vehicleCapacity;
    }

    @Override
    public String toString() {
        return "\nXe máy{" +
                super.toString() +
                ", Công suất: " + vehicleCapacity +
                "}\n";
    }

    @Override
    public String getInformation() {
        return super.getInformation() + String.format("%s", this.vehicleCapacity);
    }
}
