package test_sth.test_java_work.inheritance_java;

public class Student extends People {
    private String classes;
    private Integer level;

    public Student(String name, int age, String classes, Integer number) {
        super(name, age);
        this.classes = classes;
        this.level = number;
    }

    public Student() {
    }

    public Student(String classes, Integer number) {
        this.classes = classes;
        this.level = number;
    }

    public String getClasses() {
        return classes;
    }

    @Override
    public void saySth() {
        System.out.println("student");
    }

//    public void printX(double x) {
//        System.out.println(x);
//    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
