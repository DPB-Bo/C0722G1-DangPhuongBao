package service.impl;

import model.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> getCustomer() {
        return customerRepository.getCustomers();
    }

    @Override
    public boolean addCustomer(Customer customer) {
        return customerRepository.addCustomer(customer);
    }

    @Override
    public boolean removeCustomer(int id) {
        return customerRepository.removeCustomer(id);
    }

    @Override
    public boolean editCustomer(int id, Customer customer) {
        return customerRepository.editCustomer(id, customer);
    }

    @Override
    public List<Customer> searchByNameAndAddress(String name) {
        return customerRepository.searchByNameAndAddress(name);
    }
}
