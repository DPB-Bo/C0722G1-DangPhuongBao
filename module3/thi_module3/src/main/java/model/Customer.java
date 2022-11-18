package model;

import java.util.Date;

public class Customer {
    private String customerId;
    private String sickTypeId;
    private String customerName;
    private String sickTypeName;
    private String dayIn;
    private String dayOut;
    private String description;

    public Customer(String customerId, String sickTypeId, String customerName, String sickTypeName, String dayIn, String dayOut, String description) {
        this.customerId = customerId;
        this.sickTypeId = sickTypeId;
        this.customerName = customerName;
        this.sickTypeName = sickTypeName;
        this.dayIn = dayIn;
        this.dayOut = dayOut;
        this.description = description;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSickTypeId() {
        return sickTypeId;
    }

    public void setSickTypeId(String sickTypeId) {
        this.sickTypeId = sickTypeId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSickTypeName() {
        return sickTypeName;
    }

    public void setSickTypeName(String sickTypeName) {
        this.sickTypeName = sickTypeName;
    }

    public String getDayIn() {
        return dayIn;
    }

    public void setDayIn(String dayIn) {
        this.dayIn = dayIn;
    }

    public String getDayOut() {
        return dayOut;
    }

    public void setDayOut(String dayOut) {
        this.dayOut = dayOut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
