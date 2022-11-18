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
        return customerRepository.getCustomer();
    }

    @Override
    public boolean updateCustomer(String id, Customer customer) {
        return customerRepository.updateCustomer(id, customer);
    }

    @Override
    public boolean removeCustomer(String id) {
        return customerRepository.removeCustomer(id);
    }
}
