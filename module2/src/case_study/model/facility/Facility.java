package case_study.model.facility;

public abstract class Facility {
    private String serviceName;
    private Double serviceArea;
    private Double servicePrice;
    private Integer maxPeople;
    private Double rentalType;

    public Facility() {
    }

    public Facility(String serviceName, Double serviceArea, Double servicePrice, Integer maxPeople, Double rentalType) {
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.servicePrice = servicePrice;
        this.maxPeople = maxPeople;
        this.rentalType = rentalType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Double serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Double servicePrice) {
        this.servicePrice = servicePrice;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public Double getRentalType() {
        return rentalType;
    }

    public void setRentalType(Double rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "serviceName='" + serviceName + '\'' +
                ", serviceArea=" + serviceArea +
                ", servicePrice=" + servicePrice +
                ", maxPeople=" + maxPeople +
                ", rentalType=" + rentalType +
                '}';
    }
}
