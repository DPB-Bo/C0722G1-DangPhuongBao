package com.codegym.controller.contract;

import com.codegym.dto.contract.ContractCreateDto;
import com.codegym.dto.contract.ContractDetailDto;
import com.codegym.dto.contract.sub.ContractDtoList;
import com.codegym.dto.customer.CustomerDto;
import com.codegym.dto.facility.FacilityDto;
import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.Contract;
import com.codegym.model.employee.Employee;
import com.codegym.service.contract.IAttachFacilityService;
import com.codegym.service.contract.IContractDetailService;
import com.codegym.service.contract.IContractService;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.employee.IEmployeeService;
import com.codegym.service.facility.IFacilityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("contract")
public class ContractRestController {
    private final IContractService contractService;
    private final IContractDetailService contractDetailService;
    private final IAttachFacilityService attachFacilityService;
    private final IEmployeeService employeeService;
    private final ICustomerService customerService;
    private final IFacilityService facilityService;

    public ContractRestController(IContractService contractService, IContractDetailService contractDetailService, IAttachFacilityService attachFacilityService, IEmployeeService employeeService, ICustomerService customerService, IFacilityService facilityService) {
        this.contractService = contractService;
        this.contractDetailService = contractDetailService;
        this.attachFacilityService = attachFacilityService;
        this.employeeService = employeeService;
        this.customerService = customerService;
        this.facilityService = facilityService;
    }

    @PostMapping("createContract")
    @ResponseBody
    public ResponseEntity<String> create(@RequestBody ContractCreateDto contractCreateDto){
        System.out.println(contractCreateDto);
        return new ResponseEntity<>("It's ok",HttpStatus.OK);
    }

    @GetMapping("getCustomer")
    public ResponseEntity<List<CustomerDto>> findCus(){
        return new ResponseEntity<>(customerService.findByDeleted(), HttpStatus.OK);
    }

    @GetMapping("getFacility")
    public ResponseEntity<List<FacilityDto>> findFac(){
        return new ResponseEntity<>(facilityService.findByDeleted(), HttpStatus.OK);
    }

    @GetMapping("getEmployee")
    public ResponseEntity<List<Employee>> findAll(){
        return new ResponseEntity<>(employeeService.findByDeleted(), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Page<ContractDtoList>> findAll(@PageableDefault(size = 3) Pageable pageable) {
        return new ResponseEntity<>(contractService.showListContractSub(pageable), HttpStatus.OK);
    }

    @GetMapping("getCD/{id}")
    public ResponseEntity<List<ContractDetailDto>> getResult(@PathVariable int id) {
        Contract contract = contractService.findById(id);
        return new ResponseEntity<>(contractDetailService.findContractDetailsByContract(contract), HttpStatus.OK);
    }

    @GetMapping("getAllAF")
    public ResponseEntity<List<AttachFacility>> findAllDetail() {
        return new ResponseEntity<>(attachFacilityService.findByDeleted(), HttpStatus.OK);
    }

    @PostMapping("saveCD")
    @ResponseBody
    public ResponseEntity<String> saveCD(@RequestBody Integer[][] mapFC){
        contractDetailService.saveContractDetail(mapFC);
        return new ResponseEntity<>("IT'S OK", HttpStatus.OK);
    }
}
