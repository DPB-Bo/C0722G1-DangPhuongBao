package service;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getCustomer();
    boolean updateCustomer(String id,Customer customer);
    boolean removeCustomer(String id);
}
