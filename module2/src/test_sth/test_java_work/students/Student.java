package test_sth.test_java_work.students;

public class Student {
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public boolean isScienceMajor() {
        return this.isScienceMajor;
    }

    public char getGender() {
        return this.gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setScienceMajor(boolean scienceMajor) {
        isScienceMajor = scienceMajor;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    private String name;
    private Integer age;
    private Boolean isScienceMajor;
    private Character gender;

    public Student() {
    }
}
