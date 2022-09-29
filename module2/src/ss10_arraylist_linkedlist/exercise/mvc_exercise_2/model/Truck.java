package ss10_arraylist_linkedlist.exercise.mvc_exercise_2.model;

public class Truck extends Car {
    private Integer vehicleLoad;

    public Truck() {
        super.setPath("src/ss10_arraylist_linkedlist/exercise/mvc_exercise_2/data/truck/truck.csv");
    }

    public Truck(String code, Producer producer, Integer year, String owner) {
        super(code, producer, year, owner);
        super.setPath("src/ss10_arraylist_linkedlist/exercise/mvc_exercise_2/data/coach/truck.csv");
    }

    public Truck(String code, Producer producer, Integer year, String owner, Integer vehicleLoad) {
        super(code, producer, year, owner);
        this.vehicleLoad = vehicleLoad;
        super.setPath("src/ss10_arraylist_linkedlist/exercise/mvc_exercise_2/data/coach/truck.csv");
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

    @Override
    public String getInformation() {
        return super.getInformation() + String.format("%s", this.vehicleLoad);
    }
}
