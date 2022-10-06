package case_study.utils.file;

import case_study.model.booking.Booking;
import case_study.model.facility.Facility;
import case_study.model.facility.House;
import case_study.model.facility.Room;
import case_study.model.facility.Villa;
import case_study.model.person.Customer;
import case_study.model.person.Employee;
import case_study.utils.exception.file_exception.FileBookingException;
import case_study.utils.exception.file_exception.FileFacilityException;
import case_study.utils.exception.file_exception.FilePersonException;
import case_study.utils.generic_list.PersonList;
import case_study.enum_package.PersonEnum;

import javax.sound.sampled.Line;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

public class WriteFileUtils {

    public static void writePersonFile(String path, PersonList personList, PersonEnum personEnum) {
        try {
            File file = new File(path);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            if (personList.getPeople().size() == 0) {
                writer.close();
                throw new FilePersonException("Danh sách hệ thống trống, không thể ghi vào file csv");
            }
            switch (personEnum) {
                case EMPLOYEE:
                    ArrayList<Employee> employees = personList.getPeople();
                    for (Employee employee : employees) {
                        String employeeInformation = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", employee.getCode(), employee.getName(), employee.getBirthDate(), employee.getGender(), employee.getIdentityCard(), employee.getPhoneNumber(), employee.getEmail(), employee.getEmployeeLevel(), employee.getEmployeePosition(), employee.getEmployeeWage());
                        writer.write(employeeInformation);
                        writer.newLine();
                    }
                    break;
                case CUSTOMER:
                    ArrayList<Customer> customers = personList.getPeople();
                    for (Customer customer : customers) {
                        String customerInformation = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", customer.getCode(), customer.getName(), customer.getBirthDate(), customer.getGender(), customer.getIdentityCard(), customer.getPhoneNumber(), customer.getEmail(), customer.getCustomerRank(), customer.getCustomerAddress());
                        writer.write(customerInformation);
                        writer.newLine();
                    }
                    break;
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (FilePersonException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeFacilityFile(String path, LinkedHashMap<Facility, Integer> facilityMap) {
        try {
            File file = new File(path);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            Set<Facility> facilitySet = facilityMap.keySet();
            if (facilitySet.size() < 1) {
                throw new FileFacilityException("Danh sách hệ thống trống, không thể ghi vào file");
            }
            String info;
            for (Facility facility : facilitySet) {

                if (facility.getServiceCode().contains("VL")) {
                    info = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", facility.getServiceCode(), facility.getServiceName(), facility.getServiceArea(), facility.getServicePrice(), facility.getMaxPeople(), facility.getRentalType(), ((Villa) facility).getRoomStandard(), ((Villa) facility).getPoolArea(), ((Villa) facility).getFloor(), facilityMap.get(facility));
                    writer.write(info);
                    writer.newLine();
                }
                if (facility.getServiceCode().contains("RO")) {
                    info = String.format("%s,%s,%s,%s,%s,%s,%s,%s", facility.getServiceCode(), facility.getServiceName(), facility.getServiceArea(), facility.getServicePrice(), facility.getMaxPeople(), facility.getRentalType(), ((Room) facility).getFreeServiceIncluded(), facilityMap.get(facility));
                    writer.write(info);
                    writer.newLine();
                }
                if (facility.getServiceCode().contains("HO")) {
                    info = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", facility.getServiceCode(), facility.getServiceName(), facility.getServiceArea(), facility.getServicePrice(), facility.getMaxPeople(), facility.getRentalType(), ((House) facility).getRoomStandard(), ((House) facility).getFloor(), facilityMap.get(facility));
                    writer.write(info);
                    writer.newLine();
                }
            }
            writer.close();
        } catch (IOException | FileFacilityException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeBookingFile(String path, ArrayList<Booking> bookings) {
        try {
            File file = new File(path);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            if (bookings.size() < 1) {
                throw new FileBookingException("Danh sách hệ thống trống, không thể ghi vào file");
            }
            String info;
            for (Booking book : bookings) {
                info = String.format("%s,%s,%s,%s,%s,%s", book.getBookingCode(), book.getServiceCode(), book.getCustomerCode(), book.getStartDateToString(), book.getEndDateToString(), book.getServiceType());
                writer.write(info);
                writer.newLine();
            }
            writer.close();
        } catch (IOException | FileBookingException e) {
            System.out.println(e.getMessage());
        }
    }
}
