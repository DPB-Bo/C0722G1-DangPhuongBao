package ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service.impl;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.model.Teacher;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service.ITeacherService;

import java.util.ArrayList;
import java.util.List;

public class TeacherService implements ITeacherService {
    private static List<Teacher> teacherList = new ArrayList<>();

    private Teacher inputInformation() {
        Teacher teacher = ITeacherService.inputInformation();

        System.out.print("\nNhập vào chuyên môn của sinh viên: ");
        String specialize = scanner.nextLine();
        teacher.setSpecialize(specialize);

        return teacher;
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

    public static List<Teacher> getTeacherList() {
        return teacherList;
    }
}
