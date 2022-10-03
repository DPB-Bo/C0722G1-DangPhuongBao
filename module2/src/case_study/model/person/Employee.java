package case_study.model.person;

import java.util.Date;

public class Employee extends Person {
    private String employeeLevel;
    private String employeePosition;
    private String employeeWage;

    public Employee() {
    }

    public Employee(String code, String name, Date birthDate, Boolean gender, String identityCard, Integer phoneNumber, String email, String employeeLevel, String employeePosition, String employeeWage) {
        super(code, name, birthDate, gender, identityCard, phoneNumber, email);
        this.employeeLevel = employeeLevel;
        this.employeePosition = employeePosition;
        this.employeeWage = employeeWage;
    }

    public String getEmployeeLevel() {
        return employeeLevel;
    }

    public void setEmployeeLevel(String employeeLevel) {
        this.employeeLevel = employeeLevel;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    public String getEmployeeWage() {
        return employeeWage;
    }

    public void setEmployeeWage(String employeeWage) {
        this.employeeWage = employeeWage;
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                "Level='" + employeeLevel + '\'' +
                ", Position='" + employeePosition + '\'' +
                ", Wage='" + employeeWage + '\'' +
                '}';
    }
}
