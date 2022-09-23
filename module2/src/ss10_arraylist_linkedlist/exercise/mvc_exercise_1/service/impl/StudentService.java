package ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service.impl;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.model.Student;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.model.Teacher;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service.IStudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService {
    private static List<Student> studentList = new ArrayList<>();

    private Student inputInformation() {
        String name = "sinh viên";
        System.out.printf("\nNhập vào mã %s: ", name);
        String codeStudent = scanner.nextLine();

        System.out.printf("\nNhập vào họ và tên %s: ", name);
        String nameStudent = scanner.nextLine();

        System.out.printf("\nNhập vào ngày sinh của %s: ", name);
        String birthdayStudent = scanner.nextLine();

        System.out.printf("\nNhập vào giới tính của %s: ", name);
        String tempGender = scanner.nextLine();
        Boolean gender = checkGender(tempGender);


        System.out.print("\nNhập vào lớp của sinh viên: ");
        String classesStudent = scanner.nextLine();


        System.out.print("\nNhập vào điểm số của sinh viên: ");
        Integer score = Integer.parseInt(scanner.nextLine());


        return new Student(codeStudent, nameStudent, birthdayStudent, gender, classesStudent, score);
    }

    private Boolean checkGender(String tempGender) {
        if (tempGender.equals("Trai")) {
            return true;
        } else if (tempGender.equals("Gái")) {
            return false;
        } else {
            return null;
        }
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

    @Override
    public void remove() {
        if (studentList.size() == 0) {
            System.out.println("\nKhông có sinh viên nào trong danh sách. Hãy thêm mới!");
        } else {
            String className = "sinh viên";
            System.out.printf("\nMời bạn nhập mã %s cần xóa: ", className);
            String code = scanner.nextLine();
            boolean flagDelete = false;
            for (int index = 0; index < studentList.size(); index++) {
                if ((studentList.get(index)).getCode().equals(code)) {
                    System.out.printf("\nBạn có chắc muốn xóa %s này không? Nhập Y: yes, N: no\n", className);
                    String choice = scanner.nextLine();
                    if (choice.equals("Y")) {
                        studentList.remove(index);
                        System.out.println("\nXóa thành công");
                    } else {
                        System.out.println("\nXoá không thành công");
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

    @Override
    public boolean search(String code) {
        boolean flagFound = false;
        for (Student item : studentList) {
            if (item.getCode().contains(code)) {
                System.out.println("\n" + item);
                flagFound = true;
            }
        }
        return flagFound;
    }

    @Override
    public void addFakeDate() {
        studentList.add(new Student("1", "A", "01/01", true, "C0722G1", 1));
        studentList.add(new Student("2", "B", "02/01", true, "C0722G1", 2));
        studentList.add(new Student("3", "C", "03/01", true, "C0722G1", 3));
        studentList.add(new Student("4", "D", "04/01", true, "C0722G1", 4));
        studentList.add(new Student("5", "E", "05/01", true, "C0722G1", 5));
        studentList.add(new Student("6", "F", "06/01", true, "C0722G1", 6));
        studentList.add(new Student("7", "G", "07/01", true, "C0722G1", 7));
        studentList.add(new Student("19", "B", "02/01", true, "C0722G1", 2));
        studentList.add(new Student("20", "A", "01/01", true, "C0722G1", 1));

    }

    @Override
    public void sortByName() {
        for (int i = 0; i < studentList.size() - 1; i++) {
            for (int j = studentList.size() - 1; j > i; j--) {
                int compareName = studentList.get(j).getName().compareTo(studentList.get(j - 1).getName());
                if (compareName < 0) {
                    Student temp = studentList.get(j);
                    studentList.set(j, studentList.get(j - 1));
                    studentList.set(j - 1, temp);
                }
                if (compareName == 0) {
                    int compareId = Integer.valueOf(studentList.get(j).getCode()).compareTo(Integer.valueOf(studentList.get(j).getCode()));
                    if (compareId < 0) {
                        Student temp = studentList.get(j);
                        studentList.set(j, studentList.get(j - 1));
                        studentList.set(j - 1, temp);
                    }
                }
            }
        }
    }
}
