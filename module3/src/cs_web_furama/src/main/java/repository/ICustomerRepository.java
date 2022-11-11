package repository;

import model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getCustomers();

    boolean addCustomer(Customer customer);

    boolean removeCustomer(int id);

    boolean editCustomer(int id, Customer customer);

    List<Customer> searchByNameAndAddress(String name);
}
