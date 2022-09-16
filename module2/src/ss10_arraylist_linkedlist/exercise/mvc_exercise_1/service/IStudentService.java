package ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.model.Student;

public interface IStudentService extends IPeopleService {
    static Student inputInformation() {
        return (Student) IPeopleService.inputInformation("sinh viên");
    }


}
