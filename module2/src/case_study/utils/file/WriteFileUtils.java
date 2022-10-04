package case_study.utils.file;

import case_study.model.person.Customer;
import case_study.model.person.Employee;
import case_study.utils.exception.file_exception.FilePersonException;
import case_study.utils.generic_list.PersonList;
import case_study.utils.person_enum.PersonEnum;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
}
