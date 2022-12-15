package com.codegym.dto.contract;

import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.facility.Facility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder
@Getter
@FieldDefaults(makeFinal = true)
public class ContractCreateDto {
    private String startDate;
    private String endDate;
    private double deposit;
    private Integer employee;
    private Integer customer;
    private Integer facility;
    private boolean deleted;
    private Integer[] attachFacilityIds;
    private Integer[] attachFacilityQuantities;
}
