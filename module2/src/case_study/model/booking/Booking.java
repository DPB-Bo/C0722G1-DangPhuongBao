package case_study.model.booking;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking {
    private String bookingCode;
    private Date startDate;
    private Date endDate;
    private String customerCode;
    private String serviceCode;
    private String serviceType;

    public Booking() {
    }

    public Booking(String bookingCode, String serviceCode, String customerCode, Date startDate, Date endDate, String serviceType) {
        this.bookingCode = bookingCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerCode = customerCode;
        this.serviceCode = serviceCode;
        this.serviceType = serviceType;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getStartDateToString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        return dateFormat.format(this.startDate);
    }

    public String getEndDateToString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        return dateFormat.format(this.endDate);
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingCode='" + bookingCode + '\'' +
                ", startDate=" + getStartDateToString() +
                ", endDate=" + getEndDateToString() +
                ", serviceName='" + serviceCode + '\'' +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }
    
}
