package case_study.utils.generic_list;

import case_study.model.person.Customer;
import case_study.model.person.Employee;
import case_study.model.person.Person;
import case_study.utils.person_enum.PersonEnum;
import case_study.utils.validate.CustomerValidate;
import case_study.utils.validate.EmployeeValidate;
import case_study.utils.validate.PersonValidate;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PersonList<E extends Person> {
    private final Scanner SCANNER = new Scanner(System.in);
    private ArrayList<E> people;

    private ArrayList<String> personAttributes = new ArrayList<>();

    private PersonValidate personValidate = new PersonValidate();

    public ArrayList<E> getPeople() {
        return people;
    }

    public PersonList() {
        personAttributes.add("Name");
        personAttributes.add("BirthDate");
        personAttributes.add("Gender");
        personAttributes.add("IdentityCard");
        personAttributes.add("Phone");
        personAttributes.add("email");
    }

    public void setPeople(ArrayList<E> people) {
        this.people = people;
    }

    public void add(E e) {
        people.add(e);
    }

    public void display() {
        for (E e : people) {
            System.out.println(e.toString());
        }
    }

    public int size() {
        return people.size();
    }

    public void createAttributePerson(E e, String personName) {
        String code;
        while (true) {
            code = personValidate.validateCode(personName);
            if (!(checkContainsCode(code))) {
                break;
            } else {
                System.out.println("Mã đã tồn tại. Vui lòng nhập lại!");
            }
        }
        e.setCode(code);

        String name = personValidate.validateName(personName);
        e.setName(name);

        Date birthDate = personValidate.validateBirthDate(personName);
        e.setBirthDate(birthDate);

        Boolean gender = personValidate.validateGender(personName);
        e.setGender(gender);

        String idCard = personValidate.validateIdentityCard(personName);
        e.setIdentityCard(idCard);

        String phoneNumber = personValidate.validatePhoneNumber(personName);
        e.setPhoneNumber(phoneNumber);

        String email = personValidate.validateEmail(personName);
        e.setEmail(email);

    }

    private boolean checkContainsCode(String code) {
        for (E e : people) {
            if (code.equals(e.getCode())) {
                return true;
            }
        }
        return false;
    }

    public void edit(String s, PersonEnum personEnum) {
        System.out.printf("Nhập vào mã %s muốn chỉnh sửa: ", s);
        String code = SCANNER.nextLine();
        int indexOfCode = findIndexOfCode(code);
        if (indexOfCode != -1) {
            switch (personEnum) {
                case EMPLOYEE:
                    editEmployee(code, indexOfCode);
                    break;
                case CUSTOMER:
                    editCustomer(code, indexOfCode);
                    break;
            }
        } else {
            System.out.println("Không tìm thấy mã %s cần chỉnh sửa!");
        }
    }

    private void editCustomer(String code, int index) {
        ArrayList<String> customerAttributes = new ArrayList<>(personAttributes);
        customerAttributes.add("Rank");
        customerAttributes.add("Address");

        int choice = getChoiceEditAttribute(code, customerAttributes, "khách hàng");

        boolean flag;
        if (choice < 6) {
            flag = editAttributePerson(index, choice, "khách hàng");
        } else {
            flag = editAttributeCustomer(index, choice);
        }

        System.out.println(flag ? "Chỉnh sửa thành công!" : "Chỉnh sửa thất bại!");
        System.out.println("Thoát chỉnh sửa!");
    }

    private boolean editAttributeCustomer(int index, int choice) {
        CustomerValidate customerValidate = new CustomerValidate();
        switch (choice) {
            case 6:
                String rank = customerValidate.validateRank();
                if (checkAccept()) {
                    ((Customer) people.get(index)).setCustomerRank(rank);
                    return true;
                }
                break;
            case 7:
                String address = customerValidate.validateAddress();
                if (checkAccept()) {
                    ((Customer) people.get(index)).setCustomerAddress(address);
                    return true;
                }
                break;
        }
        return false;
    }

    private int getChoiceEditAttribute(String code, ArrayList<String> customerAttributes, String personName) {
        System.out.printf("Danh sách các thông tin của %s mã %s có thể chỉnh sửa", personName, code);

        for (int i = 0; i < customerAttributes.size(); i++) {
            System.out.printf("\n%s. %s", i, customerAttributes.get(i));
        }

        int choice;
        while (true) {
            try {
                System.out.print("Nhập vào thông tin cần chỉnh sửa(số tương ứng theo list thông tin) :");
                choice = Integer.parseInt(SCANNER.nextLine());
                if (choice < 0 || choice >= customerAttributes.size()) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException nfe) {
                System.out.println("Lựa chọn không hợp lệ\n" +
                        "Thoát chỉnh sửa!");
            }
        }
        return choice;
    }

    private int findIndexOfCode(String code) {
        for (E e : people) {
            if (code.equals(e.getCode())) {
                return people.indexOf(e);
            }
        }
        return -1;
    }

    private void editEmployee(String code, int index) {
        ArrayList<String> employeeAttributes = new ArrayList<>(personAttributes);
        employeeAttributes.add("Level");
        employeeAttributes.add("Position");
        employeeAttributes.add("Wage");

        int choice = getChoiceEditAttribute(code, employeeAttributes, "nhân viên");

        boolean flag;
        if (choice < 6) {
            flag = editAttributePerson(index, choice, "nhân viên");
        } else {
            flag = editAttributeEmployee(index, choice);
        }

        System.out.println(flag ? "Chỉnh sửa thành công!" : "Chỉnh sửa thất bại!");
        System.out.println("Thoát chỉnh sửa!");
    }

    private boolean editAttributeEmployee(int index, int choice) {
        EmployeeValidate employeeValidate = new EmployeeValidate();
        switch (choice) {
            case 6:
                String level = employeeValidate.validateLevel();
                if (checkAccept()) {
                    ((Employee) people.get(index)).setEmployeeLevel(level);
                    return true;
                }
                break;
            case 7:
                String position = employeeValidate.validatePosition();
                if (checkAccept()) {
                    ((Employee) people.get(index)).setEmployeePosition(position);
                    return true;
                }
                break;
            case 8:
                Double wage = employeeValidate.validateWage();
                if (checkAccept()) {
                    ((Employee) people.get(index)).setEmployeeWage(wage);
                    return true;
                }
                break;
        }
        return false;
    }

    private boolean editAttributePerson(int index, int choice, String personName) {
        switch (choice) {
            case 0:
                String name = personValidate.validateName(personName);
                if (checkAccept()) {
                    people.get(index).setName(name);
                    return true;
                }
                break;
            case 1:
                Date birthDate = personValidate.validateBirthDate(personName);
                if (checkAccept()) {
                    people.get(index).setBirthDate(birthDate);
                    return true;
                }
                break;
            case 2:
                Boolean gender = personValidate.validateGender(personName);
                if (checkAccept()) {
                    people.get(index).setGender(gender);
                    return true;
                }
                break;
            case 3:
                String idCard = personValidate.validateIdentityCard(personName);
                if (checkAccept()) {
                    people.get(index).setIdentityCard(idCard);
                    return true;
                }
                break;
            case 4:
                String phoneNumber = personValidate.validatePhoneNumber(personName);
                if (checkAccept()) {
                    people.get(index).setPhoneNumber(phoneNumber);
                    return true;
                }
                break;
            case 5:
                String email = personValidate.validateEmail(personName);
                if (checkAccept()) {
                    people.get(index).setEmail(email);
                    return true;
                }
                break;
        }
        return false;
    }

    private boolean checkAccept() {
        System.out.print("Xác nhận chỉnh sửa (Bất cứ gì ngoại trừ 'Y' là huỷ bỏ) :");
        return SCANNER.nextLine().equals("Y");
    }
}
