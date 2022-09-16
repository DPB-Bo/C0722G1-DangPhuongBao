package ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service.impl;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.model.Teacher;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service.ITeacherService;

import java.util.ArrayList;
import java.util.List;

public class TeacherService implements ITeacherService {
    private static List<Teacher> teacherList = new ArrayList<>();

    public Teacher inputInformation() {
        Teacher teacher = ITeacherService.inputInformation();

        System.out.println("\nNhập vào chuyên môn của sinh viên: ");
        String specialize = scanner.nextLine();
        teacher.setSpecialize(specialize);

        return teacher;
    }

    public void add() {
        teacherList.add(inputInformation());
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void display() {
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }

    @Override
    public void remove() {
        System.out.print("\nMời bạn nhập mã giáo viên cần xóa: ");
        String code = scanner.nextLine();
        boolean flagDelete = false;
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getCode().equals(code)) {
                System.out.println("\nBạn có chắc muốn xóa giáo viên này không? Nhập Y: yes, N: no");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    teacherList.remove(i);
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
