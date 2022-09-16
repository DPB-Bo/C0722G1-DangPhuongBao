package ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.model.Student;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.model.Teacher;

public interface ITeacherService extends IPeopleService {
    static Teacher inputInformation() {
        return (Teacher) IPeopleService.inputInformation("giáo viên");
    }

}
