package ss10_arraylist_linkedlist.exercise.mvc_exercise_2.model;

public class Truck extends Car {
    private Integer vehicleLoad;

    public Truck() {
    }

    public Truck(String code, Producer producer, Integer year, String owner) {
        super(code, producer, year, owner);
    }

    public Truck(String code, Producer producer, Integer year, String owner, Integer vehicleLoad) {
        super(code, producer, year, owner);
        this.vehicleLoad = vehicleLoad;
    }

    public Integer getVehicleLoad() {
        return vehicleLoad;
    }

    public void setVehicleLoad(Integer vehicleLoad) {
        this.vehicleLoad = vehicleLoad;
    }

    @Override
    public String toString() {
        return "\nXe tải{" +
                super.toString() +
                ", Trọng tải: " + vehicleLoad +
                "}\n";
    }
}
