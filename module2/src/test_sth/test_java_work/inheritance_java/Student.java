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
