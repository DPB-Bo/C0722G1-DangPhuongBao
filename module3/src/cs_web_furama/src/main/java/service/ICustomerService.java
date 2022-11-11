package service;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getCustomer();
    boolean addCustomer(Customer customer);
    boolean removeCustomer(int id);
    boolean editCustomer(int id,Customer customer);
    List<Customer> searchByNameAndAddress(String name);

}
