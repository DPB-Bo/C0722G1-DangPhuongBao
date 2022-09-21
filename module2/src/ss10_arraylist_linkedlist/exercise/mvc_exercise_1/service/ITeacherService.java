package ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.model.Teacher;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_1.service.impl.TeacherService;

public interface ITeacherService extends IPeopleService {
    @Override
    void add();

    @Override
    void display();

    @Override
    void remove();
}
