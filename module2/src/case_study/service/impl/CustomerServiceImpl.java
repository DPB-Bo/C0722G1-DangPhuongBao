package case_study.service.impl;

import case_study.model.person.Customer;
import case_study.service.CustomerService;
import case_study.utils.file.ReadFileUtils;
import case_study.utils.file.WriteFileUtils;
import case_study.utils.generic_list.PersonList;
import case_study.utils.validate.CustomerValidate;

import static case_study.enum_package.PersonEnum.CUSTOMER;

public class CustomerServiceImpl implements CustomerService {

    private PersonList<Customer> customerPersonList = new PersonList<>();

    private CustomerValidate customerValidate = new CustomerValidate();
    private final String PATH = "src/case_study/data/customer.csv";

    public PersonList<Customer> getCustomerPersonList() {
        ReadFileUtils.readFilePerson(PATH, customerPersonList, CUSTOMER);
        return customerPersonList;
    }

    @Override
    public void add() {
        ReadFileUtils.readFilePerson(PATH, customerPersonList, CUSTOMER);
        customerPersonList.add(createCustomer());
        WriteFileUtils.writePersonFile(PATH, customerPersonList, CUSTOMER);
        System.out.println("Thêm mới thahh công!");
    }

    @Override
    public void display() {
        ReadFileUtils.readFilePerson(PATH, customerPersonList, CUSTOMER);
        if (customerPersonList.size() == 0) {
            customerPersonList.display();
        } else {
            System.out.println("Không có dữ liệu từ file hoặc chương trình để hiển thị!");
        }
    }

    @Override
    public void edit() {
        ReadFileUtils.readFilePerson(PATH, customerPersonList, CUSTOMER);
        customerPersonList.edit("khách hàng", CUSTOMER);
        WriteFileUtils.writePersonFile(PATH, customerPersonList, CUSTOMER);
    }

    private Customer createCustomer() {
        Customer customer = new Customer();
        customerPersonList.createAttributePerson(customer, "khách hàng");

        String rank = customerValidate.validateRank();
        customer.setCustomerRank(rank);

        String address = customerValidate.validateAddress();
        customer.setCustomerAddress(address);

        return customer;
    }
}
