package com.codegym.service.impl.employee;

import com.codegym.model.employee.Employee;
import com.codegym.repository.employee.EmployeeRepository;
import com.codegym.service.employee.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findByDeleted() {
        return employeeRepository.findByDeleted(false);
    }
}
