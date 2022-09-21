package ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service.impl;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.model.Teacher;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service.ITeacherService;

import java.util.ArrayList;
import java.util.List;

public class TeacherService implements ITeacherService {
    private static List<Teacher> teacherList = new ArrayList<>();

    private Teacher inputInformation() {
        String name = "giáo viên";

        System.out.printf("\nNhập vào mã %s: ", name);
        String codeStudent = scanner.nextLine();

        System.out.printf("\nNhập vào họ và tên %s: ", name);
        String nameStudent = scanner.nextLine();

        System.out.printf("\nNhập vào ngày sinh của %s: ", name);
        String birthdayStudent = scanner.nextLine();

        System.out.printf("\nNhập vào giới tính của %s: ", name);
        String tempGender = scanner.nextLine();
        Boolean gender = checkGender(tempGender);

        System.out.print("\nNhập vào chuyên môn của sinh viên: ");
        String specialize = scanner.nextLine();

        return new Teacher(codeStudent, nameStudent, birthdayStudent, gender, specialize);
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
        teacherList.add(inputInformation());
        System.out.println("\nThêm mới thành công!");
    }

    @Override
    public void display() {
        if (teacherList.size() == 0) {
            System.out.println("\nKhông có giáo viên nào trong danh sách. Hãy thêm mới!");
        } else {
            for (Teacher teacher : teacherList) {
                System.out.println(teacher);
            }
        }
    }

    @Override
    public void remove() {
        if (teacherList.size() == 0) {
            System.out.println("\nKhông có sinh viên nào trong danh sách. Hãy thêm mới!");
        } else {
            String className = "giáo viên";
            System.out.printf("\nMời bạn nhập mã %s cần xóa: ", className);
            String code = scanner.nextLine();
            boolean flagDelete = false;
            for (int index = 0; index < teacherList.size(); index++) {
                if ((teacherList.get(index)).getCode().equals(code)) {
                    System.out.printf("\nBạn có chắc muốn xóa %s này không? Nhập Y: yes, N: no\n", className);
                    String choice = scanner.nextLine();
                    if (choice.equals("Y")) {
                        teacherList.remove(index);
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

    public static List<Teacher> getTeacherList() {
        return teacherList;
    }
}
