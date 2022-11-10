package service;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getCustomer();
    boolean addCustomer(Customer customer);
    boolean removeCustomer(int id);
    boolean editCustomer(int id,Customer customer);
    Customer findByID(int id);
    List<Customer> searchByName(String name);

}
