package case_study.model.facility;

public class House extends Facility {
    private String roomStandard;
    private Integer floor;

    public House() {
    }

    public House(String roomStandard, Integer floor) {
        this.roomStandard = roomStandard;
        this.floor = floor;
    }

    public House(String serviceName, Double serviceArea, Double servicePrice, Integer maxPeople, Double rentalType, String roomStandard, Integer floor) {
        super(serviceName, serviceArea, servicePrice, maxPeople, rentalType);
        this.roomStandard = roomStandard;
        this.floor = floor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "House{" +
                "roomStandard='" + roomStandard + '\'' +
                ", floor=" + floor +
                '}';
    }
}
