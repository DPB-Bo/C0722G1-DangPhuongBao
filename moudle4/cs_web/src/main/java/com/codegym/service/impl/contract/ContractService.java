package com.codegym.service.impl.contract;

import com.codegym.dto.contract.ContractCreateDto;
import com.codegym.dto.contract.ContractDto;
import com.codegym.dto.contract.sub.ContractDtoList;
import com.codegym.model.contract.Contract;
import com.codegym.repository.contract.ContractRepository;
import com.codegym.repository.customer.CustomerRepository;
import com.codegym.repository.employee.EmployeeRepository;
import com.codegym.repository.facility.FacilityRepository;
import com.codegym.service.contract.IContractDetailService;
import com.codegym.service.contract.IContractService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {
    private final ContractRepository contractRepository;
    private final CustomerRepository customerRepository;
    private final FacilityRepository facilityRepository;
    private final EmployeeRepository employeeRepository;
    private final IContractDetailService contractDetailService;

    public ContractService(ContractRepository contractRepository, CustomerRepository customerRepository, FacilityRepository facilityRepository, EmployeeRepository employeeRepository, IContractDetailService contractDetailService) {
        this.contractRepository = contractRepository;
        this.customerRepository = customerRepository;
        this.facilityRepository = facilityRepository;
        this.employeeRepository = employeeRepository;
        this.contractDetailService = contractDetailService;
    }

    @Override
    public Page<ContractDto> showListContract(Pageable pageable) {
        return contractRepository.findByDeleted(pageable, false);
    }
    @Override
    public Contract findById(int id) {
        return contractRepository.findById(id);
    }

    @Override
    public Page<ContractDtoList> showListContractSub(Pageable pageable) {
        return contractRepository.showListContractSub(pageable);
    }

    @Override
    public void save(ContractCreateDto contractCreateDto) {
        Contract contract = Contract.builder()
                .startDate(contractCreateDto.getStartDate())
                .endDate(contractCreateDto.getEndDate())
                .deposit(contractCreateDto.getDeposit())
                .employee(employeeRepository.findById(contractCreateDto.getEmployee()).get())
                .customer(customerRepository.findById(contractCreateDto.getCustomer()).get())
                .facility(facilityRepository.findById(contractCreateDto.getFacility()).get())
                .deleted(contractCreateDto.isDeleted()).build();
        contractRepository.save(contract);
        Integer[] id = new Integer[1];
        id[0]= contractRepository.findByStartDateAndEndDateAndFacility(contractCreateDto.getStartDate(), contract.getEndDate(), facilityRepository.findById(contractCreateDto.getFacility()).get()).getId();
        Integer[][] arrTwoDimensional = new Integer[][]{
                contractCreateDto.getAttachFacilityIds(),
                contractCreateDto.getAttachFacilityQuantities(),
                id
        };
        contractDetailService.saveContractDetail(arrTwoDimensional);
    }

}
