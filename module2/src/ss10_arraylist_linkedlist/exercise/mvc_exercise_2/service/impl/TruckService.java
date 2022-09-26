package ss10_arraylist_linkedlist.exercise.mvc_exercise_2.service.impl;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.exception.truck_exception.VehicleLoadException;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.model.Truck;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.service.ICarService;

public class TruckService implements ICarService {
    CarList<Truck> truckCarList = new CarList<>();

    @Override
    public Object inputInformation() {
        Truck truck = new Truck();
        truckCarList.inputInformation(truck);


        return truck;
    }

    private int checkVehicleLoad() {
        int vehicleLoad;

        while (true) {
            try {
                System.out.print("\nNhập vào trọng tải của xe: ");
                vehicleLoad = Integer.parseInt(scanner.nextLine());
                boolean isNotValidVehicleLoad = vehicleLoad < 100 || vehicleLoad > 5000;
                if (isNotValidVehicleLoad) {
                    throw new VehicleLoadException("Trọng tải xe không hợp lệ (>100KG và <5000KG).Vui lòng nhập lại");
                }
                break;
            } catch (VehicleLoadException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }

        return vehicleLoad;
    }

    @Override
    public void add() {
        Truck truck = (Truck) inputInformation();
        truckCarList.add(truck);
    }

    @Override
    public void display() {
        truckCarList.display();
    }

    @Override
    public boolean remove(String code) {
        return truckCarList.remove(code);
    }

    @Override
    public boolean search(String code) {
        return truckCarList.search(code);
    }
}
