package case_study.model.person;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Person {
    private String code;
    private String name;
    private Date birthDate;
    private Boolean gender;
    private String identityCard;
    private Integer phoneNumber;
    private String email;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Person() {
    }

    public Person(String code, String name, Date birthDate, Boolean gender, String identityCard, Integer phoneNumber, String email) {
        this.code = code;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.identityCard = identityCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        String genderToString = "Third Gender";
        if (!this.gender) {
            genderToString = "Female";
        }
        if (this.gender) {
            genderToString = "Male";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + dateFormat.format(this.birthDate) +
                ", gender=" + genderToString +
                ", identityCard='" + identityCard + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'';
    }
}
