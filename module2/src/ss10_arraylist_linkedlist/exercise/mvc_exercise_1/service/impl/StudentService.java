package ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service.impl;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.model.Student;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service.IStudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService {
    private static List<Student> studentList = new ArrayList<>();

    private Student inputInformation() {
        Student student = (Student) IStudentService.inputInformation();

        System.out.print("\nNhập vào lớp của sinh viên: ");
        String classesStudent = scanner.nextLine();
        student.setClasses(classesStudent);

        System.out.print("\nNhập vào điểm số của sinh viên: ");
        Integer score = Integer.parseInt(scanner.nextLine());
        student.setScore(score);

        return student;
    }

    @Override
    public void add() {
        studentList.add(inputInformation());
        System.out.println("\nThêm thành công!");
    }

    @Override
    public void display() {
        if (studentList.size() == 0) {
            System.out.println("\nKhông có sinh viên nào trong danh sách. Hãy thêm mới!");
        } else {
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

    public static List<Student> getStudentList() {
        return studentList;
    }

}
