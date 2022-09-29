package ss10_arraylist_linkedlist.exercise.mvc_exercise_2.service.impl;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.model.Coach;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.model.Producer;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.utils.exception.motor_exception.VehicleCapacityException;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.model.Motor;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.service.IMotorService;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.utils.generic_list.CarList;

import java.util.List;

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
        motorCarList.writeFile(motor);
    }

    @Override
    public void readDataFile() {
        Motor motor = new Motor();
        List<String[]> lists = motorCarList.readFile(motor);
        for (String[] list : lists) {
            motor = new Motor();
            motor.setCode(list[0]);
            motor.setProducer(new Producer(list[1], list[2], list[3]));
            motor.setYear(Integer.parseInt(list[4]));
            motor.setOwner(list[5]);
            motor.setVehicleCapacity(Integer.parseInt(list[6]));
            motorCarList.add(motor);
        }
    }

    @Override
    public void display() {
        motorCarList.display();
    }

    @Override
    public boolean remove(String code) {
        return motorCarList.remove(code, motorCarList);
    }

    @Override
    public boolean search(String code) {
        return motorCarList.search(code);
    }
}
