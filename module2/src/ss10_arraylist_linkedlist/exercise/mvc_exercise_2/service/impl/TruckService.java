package ss10_arraylist_linkedlist.exercise.mvc_exercise_2.service.impl;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.model.Truck;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.service.ICarService;

public class TruckService implements ICarService {
    CarList<Truck> truckCarList = new CarList<>();

    @Override
    public Object inputInformation() {
        Truck truck = new Truck();
        truckCarList.inputInformation(truck);

        System.out.print("\nNhập vào trọng tải của xe: ");
        Integer vehicleLoad = Integer.parseInt(scanner.nextLine());

        return truck;
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
