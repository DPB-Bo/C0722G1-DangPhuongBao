package case_study.service.impl;

import case_study.enum_package.FacilityEnum;
import case_study.model.facility.Facility;
import case_study.model.facility.House;
import case_study.model.facility.Room;
import case_study.model.facility.Villa;
import case_study.service.FacilityService;
import case_study.utils.file.ReadFileUtils;
import case_study.utils.file.WriteFileUtils;
import case_study.utils.validate.FacilityValidate;
import case_study.utils.validate.HouseValidate;
import case_study.utils.validate.RoomValidate;
import case_study.utils.validate.VillaValidate;

import java.util.LinkedHashMap;
import java.util.Map;
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

    private final String PATH = "src/case_study/data/facility.csv";

    public String getPATH() {
        return PATH;
    }

    public LinkedHashMap<Facility, Integer> getFacilityList() {
        ReadFileUtils.readFileFacility(PATH, facilityList);
        return facilityList;
    }

    @Override
    public void add() {
        while (true) {
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
        ReadFileUtils.readFileFacility(PATH, facilityList);
        for (Facility facility : facilityKeys) {
            System.out.println(facility);
        }
    }

    @Override
    public void displayFacilityMaintenance() {
        boolean flag = false;
        for (Map.Entry<Facility, Integer> entry : facilityList.entrySet()) {
            if (entry.getValue() > 4) {
                flag = true;
                System.out.println(entry.getKey());
            }
        }
        if (!flag) {
            System.out.println("Hiện tại không có dịch vụ bảo trì!");
        }
    }


    private void addVilla() {
        ReadFileUtils.readFileFacility(PATH, facilityList);

        Villa villa = new Villa();
        setAttributeFacility(VILLA, villa);

        String roomStandard = villaValidate.validateRoomStandards();
        villa.setRoomStandard(roomStandard);

        Double poolArea = villaValidate.validatePoorArea();
        villa.setPoolArea(poolArea);

        Integer floor = villaValidate.validateFloor();
        villa.setFloor(floor);

        facilityList.put(villa, 0);

        WriteFileUtils.writeFacilityFile(PATH, facilityList);
    }


    private void addHouse() {
        ReadFileUtils.readFileFacility(PATH, facilityList);

        House house = new House();
        setAttributeFacility(HOUSE, house);

        String roomStandard = houseValidate.validateRoomStandards();
        house.setRoomStandard(roomStandard);

        Integer floor = houseValidate.validateFloor();
        house.setFloor(floor);

        facilityList.put(house, 0);

        WriteFileUtils.writeFacilityFile(PATH, facilityList);
    }


    private void addRoom() {
        ReadFileUtils.readFileFacility(PATH, facilityList);

        Room room = new Room();
        setAttributeFacility(HOUSE, room);

        String freeServiceIncluded = roomValidate.validateFreeService();
        room.setFreeServiceIncluded(freeServiceIncluded);

        facilityList.put(room, 0);

        WriteFileUtils.writeFacilityFile(PATH, facilityList);
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
