package case_study.utils.file;


import case_study.model.booking.Booking;
import case_study.model.contract.Contract;
import case_study.model.facility.Facility;
import case_study.model.facility.House;
import case_study.model.facility.Room;
import case_study.model.facility.Villa;
import case_study.model.person.Customer;
import case_study.model.person.Employee;
import case_study.utils.generic_list.PersonList;
import case_study.enum_package.PersonEnum;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

public class ReadFileUtils {

    public static void readFilePerson(String path, PersonList personList, PersonEnum personEnum) {
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            String[] info;
            String[] dayParts;
            personList.setPeople(new ArrayList<>());
            while ((line = br.readLine()) != null) {
                info = line.split(",");
                dayParts = info[2].split("/");
                switch (personEnum) {
                    case CUSTOMER:
                        personList.add(new Customer(info[0], info[1], new Date(Integer.parseInt(dayParts[2]) - 1900, Integer.parseInt(dayParts[1]) - 1, Integer.parseInt(dayParts[0])), Boolean.parseBoolean(info[3]), info[4], info[5], info[6], info[7], info[8]));
                        break;
                    case EMPLOYEE:
                        personList.add(new Employee(info[0], info[1], new Date(Integer.parseInt(dayParts[2]) - 1900, Integer.parseInt(dayParts[1]) - 1, Integer.parseInt(dayParts[0])), Boolean.parseBoolean(info[3]), info[4], info[5], info[6], info[7], info[8], Double.parseDouble(info[9])));
                        break;
                }
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readFileFacility(String path, LinkedHashMap<Facility, Integer> facilityList) {
        try {
            File f = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            String[] info;
            facilityList.clear();
            while ((line = br.readLine()) != null) {
                info = line.split(",");
                if (info[0].contains("VL")) {
                    facilityList.put(new Villa(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4]), info[5], info[6], Double.parseDouble(info[7]), Integer.parseInt(info[8])), Integer.parseInt(info[9]));
                }
                if (info[0].contains("HO")) {
                    facilityList.put(new House(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4]), info[5], info[6], Integer.parseInt(info[7])), Integer.parseInt(info[8]));
                }
                if (info[0].contains("RO")) {
                    facilityList.put(new Room(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4]), info[5], info[6]), Integer.parseInt(info[7]));
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Đọc file lỗi!");
        }
    }

    public static void readFileBooking(String path, ArrayList<Booking> bookings) {
        try {
            File f = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            String[] info;
            String[] startDayParts;
            String[] endDayParts;
            bookings.clear();
            while ((line = br.readLine()) != null) {
                info = line.split(",");
                startDayParts = info[3].split("/");
                endDayParts = info[4].split("/");
                bookings.add(new Booking(info[0], info[1], info[2], new Date(Integer.parseInt(startDayParts[2]) - 1900, Integer.parseInt(startDayParts[1]) - 1, Integer.parseInt(startDayParts[0])), new Date(Integer.parseInt(endDayParts[2]) - 1900, Integer.parseInt(endDayParts[1]) - 1, Integer.parseInt(endDayParts[0])), info[5]));
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Đọc file lỗi!");
        }
    }

    public static void readFileContract(String path, ArrayList<Contract> contracts) {
        try {
            File f = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            String[] info;
            contracts.clear();
            while ((line = br.readLine()) != null) {
                info = line.split(",");
                contracts.add(new Contract(info[0], info[1], info[2], Integer.parseInt(info[3]), Integer.parseInt(info[4])));
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Đọc file lỗi!");
        }
    }
}
