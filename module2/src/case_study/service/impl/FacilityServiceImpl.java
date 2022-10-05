package case_study.service.impl;

import case_study.enum_package.FacilityEnum;
import case_study.model.facility.Facility;
import case_study.model.facility.House;
import case_study.model.facility.Room;
import case_study.model.facility.Villa;
import case_study.service.FacilityService;
import case_study.utils.validate.FacilityValidate;
import case_study.utils.validate.HouseValidate;
import case_study.utils.validate.RoomValidate;
import case_study.utils.validate.VillaValidate;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

import static case_study.enum_package.FacilityEnum.HOUSE;
import static case_study.enum_package.FacilityEnum.VILLA;

public class FacilityServiceImpl implements FacilityService {

    private final Scanner SCANNER = new Scanner(System.in);

    private LinkedHashMap<Facility, Integer> facilityList = new LinkedHashMap<>();

    private Set<Facility> facilityKeys = facilityList.keySet();

    private FacilityValidate facilityValidate = new FacilityValidate();

    private VillaValidate villaValidate = new VillaValidate();

    private HouseValidate houseValidate = new HouseValidate();

    private RoomValidate roomValidate = new RoomValidate();

    @Override
    public void add() {
        System.out.print("-------------- ADD NEW FACILITY MENU --------------" +
                "1\tAdd new Villa\n" +
                "2\tAdd new House\n" +
                "3\tAdd new Room\n" +
                "4\tDisplay list facility maintenance\n" +
                "5\tReturn main menu\n");

        int choice = inputChoice();
        switch (choice) {
            case 1:
                addVilla();
                break;
            case 2:
                addHouse();
                break;
            case 3:
                addRoom();
                break;
            case 4:
                displayFacilityMaintenance();
                break;
            case 5:
                return;
            default:
                System.out.print("\nKhông có lựa chọn này!");
                break;
        }
    }

    private int inputChoice() {
        System.out.print("Enter your choice: ");
        int choice;
        try {
            choice = Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            choice = 0;
        }
        return choice;
    }

    @Override
    public void display() {

    }

    @Override
    public void displayFacilityMaintenance() {
    }


    private void addVilla() {
        Villa villa = new Villa();
        setAttributeFacility(VILLA, villa);

        String roomStandard = villaValidate.validateRoomStandards();
        villa.setRoomStandard(roomStandard);

        Double poolArea = villaValidate.validatePoorArea();
        villa.setPoolArea(poolArea);

        Integer floor = villaValidate.validateFloor();
        villa.setFloor(floor);

        facilityList.put(villa, 0);
    }


    private void addHouse() {
        House house = new House();
        setAttributeFacility(HOUSE, house);

        String roomStandard = houseValidate.validateRoomStandards();
        house.setRoomStandard(roomStandard);

        Integer floor = houseValidate.validateFloor();
        house.setFloor(floor);

        facilityList.put(house, 0);
    }


    private void addRoom() {
        Room room = new Room();
        setAttributeFacility(HOUSE, room);

        String freeServiceIncluded = roomValidate.validateFreeService();
        room.setFreeServiceIncluded(freeServiceIncluded);

        facilityList.put(room, 0);
    }

    private <E extends Facility> void setAttributeFacility(FacilityEnum facilityEnum, E e) {
        String code;
        do {
            code = facilityValidate.validateCode(facilityEnum);
        } while (checkContainsCode(code));
        e.setServiceCode(code);

        String name = facilityValidate.validateName(facilityEnum);
        e.setServiceName(name);

        Double area = facilityValidate.validateArea(facilityEnum);
        e.setServiceArea(area);

        Double price = facilityValidate.validatePrice(facilityEnum);
        e.setServicePrice(price);

        Integer maxPeople = facilityValidate.validateMaxPeople(facilityEnum);
        e.setMaxPeople(maxPeople);

        String rentalType = facilityValidate.validateRental(facilityEnum);
        e.setRentalType(rentalType);
    }

    private boolean checkContainsCode(String code) {
        for (Facility facility : facilityKeys) {
            if (facility.getServiceCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

}
