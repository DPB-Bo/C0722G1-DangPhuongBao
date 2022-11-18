package repository;

import model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getCustomer();
    boolean updateCustomer(String id,Customer customer);
    boolean removeCustomer(String id);
}