package repository;

import model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getCustomers();

    boolean addCustomer(Customer customer);

    boolean removeCustomer(int id);

    boolean editCustomer(int id, Customer customer);

    Customer findByID(int id);

    List<Customer> searchByName(String name);
}
