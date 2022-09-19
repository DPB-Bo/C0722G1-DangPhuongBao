package ss10_arraylist_linkedlist.exercise.mvc_exercise_2.service.impl;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.model.Motor;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.service.IMotorService;

public class MotorService implements IMotorService {
    CarList<Motor> motorCarList = new CarList<>();

    @Override
    public Object inputInformation() {
        Motor motor = new Motor();
        motorCarList.inputInformation(motor);

        System.out.print("\nNhập vào trọng tải: ");
        Integer vehicleCapacity = Integer.parseInt(scanner.nextLine());

        return motor;
    }

    @Override
    public void add() {
        Motor motor = (Motor) inputInformation();
        motorCarList.add(motor);
    }

    @Override
    public void display() {
        motorCarList.display();
    }

    @Override
    public boolean remove(String code) {
        return motorCarList.remove(code);
    }

    @Override
    public boolean search(String code) {
        return motorCarList.search(code);
    }
}
