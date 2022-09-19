package ss10_arraylist_linkedlist.exercise.mvc_exercise_2.model;

public class Motor extends Car {
    private Integer vehicleCapacity;

    public Motor() {
    }

    public Motor(String code, Producer producer, Integer year, String owner) {
        super(code, producer, year, owner);
    }

    public Motor(String code, Producer producer, Integer year, String owner, Integer vehicleCapacity) {
        super(code, producer, year, owner);
        this.vehicleCapacity = vehicleCapacity;
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
}
