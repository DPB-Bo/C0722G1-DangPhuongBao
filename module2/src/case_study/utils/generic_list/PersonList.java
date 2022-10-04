package case_study.utils.generic_list;

import case_study.model.person.Person;
import case_study.utils.person_enum.PersonEnum;
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

    public void edit(PersonList personList, PersonEnum personEnum) {
        switch (personEnum) {
            case EMPLOYEE:

        }
    }

    private void editEmployees() {
//        ArrayList<String>
    }
}
