package test_sth.test_java_work.polymorphism_java;

public class Employee extends Person {
    public Employee() {
        this("Employ 1 nè");
        System.out.println("Employ 2 nè");
    }

    public Employee(String employee) {
        System.out.println(employee);
    }
}
