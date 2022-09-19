package ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.model.Teacher;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service.impl.TeacherService;

public interface ITeacherService extends IPeopleService {
    @Override
    void add();

    @Override
    void display();

    static Teacher inputInformation() {
        String[] listAttributes = IPeopleService.inputInformation("giáo viên");
        Boolean gender = IPeopleService.checkGender(listAttributes[3]);
        return new Teacher(listAttributes[0], listAttributes[1], listAttributes[2], gender);
    }

    static void remove() {
        if (TeacherService.getTeacherList().size() == 0) {
            System.out.println("\nKhông có giáo viên nào trong danh sách. Hãy thêm mới!");
        } else {
            IPeopleService.remove(TeacherService.getTeacherList(), "giáo viên");
        }
    }
}
