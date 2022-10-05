package case_study.service.impl;

import case_study.model.person.Employee;
import case_study.service.EmployeeService;
import case_study.utils.file.ReadFileUtils;
import case_study.utils.file.WriteFileUtils;
import case_study.utils.generic_list.PersonList;
import case_study.utils.validate.EmployeeValidate;


import static case_study.enum_package.PersonEnum.EMPLOYEE;

public class EmployeeServiceImpl implements EmployeeService {
    private PersonList<Employee> employeePersonList = new PersonList<>();
    private EmployeeValidate employeeValidate = new EmployeeValidate();
    private final String PATH = "src/case_study/data/employee.csv";

    @Override
    public void add() {
        ReadFileUtils.readFilePerson(PATH, employeePersonList, EMPLOYEE);
        employeePersonList.add(createEmployee());
        WriteFileUtils.writePersonFile(PATH, employeePersonList, EMPLOYEE);
        System.out.println("Thêm mới thành công!");
    }

    @Override
    public void display() {
        ReadFileUtils.readFilePerson(PATH, employeePersonList, EMPLOYEE);
        if (employeePersonList.size() != 0) {
            employeePersonList.display();
        } else {
            System.out.println("Không có dữ liệu từ file hoặc chương trình để hiển thị!");
        }
    }

    @Override
    public void edit() {
        ReadFileUtils.readFilePerson(PATH, employeePersonList, EMPLOYEE);
        employeePersonList.edit("nhân viên", EMPLOYEE);
        WriteFileUtils.writePersonFile(PATH, employeePersonList, EMPLOYEE);
    }

    private Employee createEmployee() {
        Employee employee = new Employee();
        employeePersonList.createAttributePerson(employee, "nhân viên");

        String level = employeeValidate.validateLevel();
        employee.setEmployeeLevel(level);

        String position = employeeValidate.validatePosition();
        employee.setEmployeePosition(position);

        Double wage = employeeValidate.validateWage();
        employee.setEmployeeWage(wage);

        return employee;
    }
}