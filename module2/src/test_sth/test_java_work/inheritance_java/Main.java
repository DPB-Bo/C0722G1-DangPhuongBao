package test_sth.test_java_work.inheritance_java;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Student student = new Student("C0722G1", 1);
//        Teacher teacher = new Teacher();
//        People student1 = new Student("CO822G1", 2);
//        People teacher1 = new Teacher();
//        People people3 = new People("Bao", 22);
        People people3 = new Student("Bao", 22, "C0722G1", 7); // Kiểu dữ liệu là People.
//        System.out.println(people3.toString());
        people3.saySth();
//        ((Student) people3).saySth("a");
//        System.out.println(people3 instanceof Student);
//        System.out.println(people3 instanceof People);
//        + Bên trái:
//        Lưu ở vùng nhớ stack
//        là biến của đối tượng (instance) lưu:
        // Địa chỉ ô nhớ của hắn và giá trị địa chỉ ô nhớ của thằng bên phải.
        // + Bên phải:
        // lưu ở bộ nhớ Heap , vì People là cha của Student nên mới new Student cho kdl People được, còn k thì new bằng niềm tin.
        // nhưng mà hắn vẫn là kdl People nên khi dùng method của Student thì vẫn phải ghi đè.

//        people3 = new Student("C0722G1", 3);
//        people3 = new Teacher("haha1", 5);
//        Student student = new People("hahah",1);

//        System.out.println("Name: " + people3.getName());
//        System.out.println("Age: " + people3.getAge());
//        System.out.println("Class: " + ((Student) people3).getClasses());
//        System.out.println("Class: " + (people3.getClasses());
//        System.out.println("Class: " + ((Teacher) people3).getTeachClassess());

//        Student people4 = new Student("c0722g1", 2);
//        System.out.println(people4.getName());
//        people3 = (Student) people3;

//        People[] list = {student, teacher};
//
//        People[] list1 = {student1, teacher1};
//
//        System.out.println(student.getName());
//        System.out.println(student.getClasses());
//
//        System.out.println(student1.getName());
//        System.out.println(((Student) student1).getClasses());
//
//        System.out.println(Arrays.toString(list));
//
//        System.out.println(Arrays.toString(list1));

//        Bike a = new Splender();
//        a.run();
    }
}
