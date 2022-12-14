package com.codegym.dto.contract.sub;

import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.facility.Facility;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
public class ContractDto {
    private Long id;
    private String startDate;
    private String endDate;
    private double deposit;
    private Customer customer;
    private Employee employee;
    private Facility facility;
}
