package com.example.ex_1;

import java.util.Date;

public class Customer {
    private String name;
    private String birthDate;
    private String address;
    private String imgLink;

    public Customer(String name, String birthDate, String address, String imgLink) {
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.imgLink = imgLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", imgLink='" + imgLink + '\'' +
                '}';
    }
}
