package case_study.model.person;


import java.util.Date;

public class Customer extends Person {
    private String customerRank;
    private String customerAddress;

    public String getCustomerRank() {
        return customerRank;
    }

    public void setCustomerRank(String customerRank) {
        this.customerRank = customerRank;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Customer() {
    }

    public Customer(String code, String name, Date birthDate, Boolean gender, String identityCard, Integer phoneNumber, String email, String customerRank, String customerAddress) {
        super(code, name, birthDate, gender, identityCard, phoneNumber, email);
        this.customerRank = customerRank;
        this.customerAddress = customerAddress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                super.toString() +
                "customerRank='" + customerRank + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                '}';
    }
}
