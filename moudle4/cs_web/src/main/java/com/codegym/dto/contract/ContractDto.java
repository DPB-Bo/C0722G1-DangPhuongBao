package com.codegym.dto.contract;

import com.codegym.model.contract.ContractDetail;
import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.facility.Facility;
import com.codegym.repository.contract.ContractRepository;
import com.codegym.service.contract.IContractDetailService;
import com.codegym.service.contract.IContractService;
import com.codegym.service.impl.contract.ContractDetailService;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;

@AllArgsConstructor
@Builder
@Getter
@FieldDefaults(makeFinal = true)
public class ContractDto implements Serializable {
    private Integer id;
    private String startDate;
    private String endDate;
    private double deposit;
    private Employee employee;
    private Customer customer;
    private Facility facility;
    private boolean deleted = false;


}