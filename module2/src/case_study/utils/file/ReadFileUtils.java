package case_study.utils.file;


import case_study.model.person.Customer;
import case_study.model.person.Employee;
import case_study.utils.generic_list.PersonList;
import case_study.utils.person_enum.PersonEnum;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

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
}
