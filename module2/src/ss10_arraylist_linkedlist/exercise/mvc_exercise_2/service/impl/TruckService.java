package ss10_arraylist_linkedlist.exercise.mvc_exercise_2.service.impl;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.model.Producer;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.service.ITruckService;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.utils.exception.truck_exception.VehicleLoadException;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.model.Truck;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.utils.generic_list.CarList;

import java.util.List;

public class TruckService implements ITruckService {
    CarList<Truck> truckCarList = new CarList<>();

    @Override
    public Object inputInformation() {
        readDataFile();

        Truck truck = new Truck();
        truckCarList.inputInformation(truck);

        truck.setVehicleLoad(checkVehicleLoad());

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
        readDataFile();

        Truck truck = (Truck) inputInformation();
        truckCarList.add(truck);
        truckCarList.writeFile(truck);
    }

    @Override
    public void readDataFile() {
        Truck truck = new Truck();
        List<String[]> lists = truckCarList.readFile(truck);
        for (String[] list : lists) {
            truck = new Truck();
            truck.setCode(list[0]);
            truck.setProducer(new Producer(list[1], list[2], list[3]));
            truck.setYear(Integer.parseInt(list[4]));
            truck.setOwner(list[5]);
            truck.setVehicleLoad(Integer.parseInt(list[6]));
            truckCarList.add(truck);
        }
    }

    @Override
    public void display() {
        readDataFile();

        truckCarList.display();
    }

    @Override
    public boolean remove(String code) {
        readDataFile();

        return truckCarList.remove(code, truckCarList);
    }

    @Override
    public boolean search(String code) {
        readDataFile();

        return truckCarList.search(code);
    }
}
