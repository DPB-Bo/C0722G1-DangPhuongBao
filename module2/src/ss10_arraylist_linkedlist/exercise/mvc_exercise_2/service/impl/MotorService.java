package ss10_arraylist_linkedlist.exercise.mvc_exercise_2.service.impl;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.exception.coach_exception.AmountSeatException;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.exception.motor_exception.VehicleCapacityException;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.model.Motor;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.service.IMotorService;

public class MotorService implements IMotorService {
    CarList<Motor> motorCarList = new CarList<>();

    @Override
    public Object inputInformation() {
        Motor motor = new Motor();
        motorCarList.inputInformation(motor);

        motor.setVehicleCapacity(checkVehicleCapacity());

        return motor;
    }

    private int checkVehicleCapacity() {
        int vehicleCapacity;

        while (true) {
            try {
                System.out.print("\nNhập vào công suất của xe: ");
                vehicleCapacity = Integer.parseInt(scanner.nextLine());
                boolean isNotValidVehicleCapacity = vehicleCapacity < 50 || vehicleCapacity > 200;
                if (isNotValidVehicleCapacity) {
                    throw new VehicleCapacityException("Công suất xe không hợp lệ(>50 và <200).Vui lòng nhập lại!");
                }
                break;
            } catch (VehicleCapacityException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }

        return vehicleCapacity;
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
