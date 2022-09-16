package ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service.impl;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.model.Student;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service.IStudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService {
    private static List<Student> studentList = new ArrayList<>();

    public Student inputInformation() {
        Student student = IStudentService.inputInformation();

        System.out.println("\nNhập vào lớp của sinh viên: ");
        String classesStudent = scanner.nextLine();
        student.setClasses(classesStudent);

        System.out.println("\nNhập vào điểm số của sinh viên: ");
        Integer score = Integer.parseInt(scanner.nextLine());
        student.setScore(score);

        return student;
    }

    @Override
    public void add() {
        studentList.add(inputInformation());
        System.out.println("Thêm thành công!");
    }

    @Override
    public void display() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Override
    public void remove() {
        System.out.print("Mời bạn nhập mã sinh viên cần xóa: ");
        String code = scanner.nextLine();
        boolean flagDelete = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getCode().equals(code)) {
                System.out.println("\nBạn có chắc muốn xóa sinh viên này không? Nhập Y: yes, N: no");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    studentList.remove(i);
                    System.out.println("\nXóa thành công");
                }
                flagDelete = true;
                break;
            }
        }
        if (!flagDelete) {
            System.out.println("\nKhông tìm thấy đối tượng cần xóa.");
        }
    }


}
