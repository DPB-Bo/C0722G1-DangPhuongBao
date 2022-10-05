package case_study.model.facility;

public class Villa extends Facility {
    private String roomStandard;
    private Double poolArea;
    private Integer floor;

    public Villa() {
    }

    public Villa(String roomStandard, Double poolArea, Integer floor) {
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public Villa(String serviceCode, String serviceName, Double serviceArea, Double servicePrice, Integer maxPeople, String rentalType, String roomStandard, Double poolArea, Integer floor) {
        super(serviceCode, serviceName, serviceArea, servicePrice, maxPeople, rentalType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", floor=" + floor +
                '}';
    }
}
