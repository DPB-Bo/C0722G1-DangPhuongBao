package ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.model.Student;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service.impl.StudentService;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service.impl.TeacherService;

public interface IStudentService extends IPeopleService {

    @Override
    void add();

    @Override
    void display();

    static Student inputInformation() {
        String[] listAttributes = IPeopleService.inputInformation("sinh viên");
        Boolean gender = IPeopleService.checkGender(listAttributes[3]);
        return new Student(listAttributes[0], listAttributes[1], listAttributes[2], gender);
    }

    static void remove() {
        if (TeacherService.getTeacherList().size() == 0) {
            System.out.println("\nKhông có sinh viên nào trong danh sách. Hãy thêm mới!");
        } else {
            IPeopleService.remove(StudentService.getStudentList(), "sinh viên");
        }
    }

}
