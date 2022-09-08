package test_sth.test_java_work.students;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println("name? " + student.getName());
        System.out.println("age? " + student.getAge());
        System.out.println("isScienceMajor? " + student.getGender());
        System.out.println("gender? " + student.isScienceMajor());
    }
}
