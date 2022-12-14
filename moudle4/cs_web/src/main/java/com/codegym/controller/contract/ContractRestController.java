package com.codegym.controller.contract;

import com.codegym.dto.contract.ContractDetailDto;
import com.codegym.dto.contract.ContractDto;
import com.codegym.model.contract.Contract;
import com.codegym.service.contract.IContractDetailService;
import com.codegym.service.contract.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("contract")
@CrossOrigin("*")
public class ContractRestController {
    private final IContractService contractService;
    private final IContractDetailService contractDetailService;

    public ContractRestController(IContractService contractService, IContractDetailService contractDetailService) {
        this.contractService = contractService;
        this.contractDetailService = contractDetailService;
    }

    @GetMapping("")
    public ResponseEntity<Page<ContractDto>> findAll(@PageableDefault(size = 3) Pageable pageable) {
        return new ResponseEntity<>(contractService.showListContract(pageable), HttpStatus.OK);
    }

//    @GetMapping("value")
//    public ResponseEntity<Double> getResult() {
//        Contract contract = contractService.findById(2);
//        ContractDto contractDto = ContractDto.builder().;
//        return new ResponseEntity<>(contractDto.getTotalValue(contractDetailService.findContractDetailsByContract(contract)), HttpStatus.OK);
//    }

    @GetMapping("detail")
    public ResponseEntity<Page<ContractDetailDto>> findAllDetail(@PageableDefault(size = 3) Pageable pageable) {
        return new ResponseEntity<>(contractDetailService.findByDeleted(pageable), HttpStatus.OK);
    }
}
