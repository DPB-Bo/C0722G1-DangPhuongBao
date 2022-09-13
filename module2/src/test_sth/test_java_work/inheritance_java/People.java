package test_sth.test_java_work.inheritance_java;

public class People {
    private String name;
    private Integer age;

    public People() {
    }

    public People(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void saySth() {
        System.out.println("people");
    }

//    public void printX(int x) {
//        System.out.println(x);
//    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
