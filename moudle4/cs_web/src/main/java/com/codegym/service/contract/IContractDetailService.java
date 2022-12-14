package com.codegym.service.contract;

import com.codegym.dto.contract.ContractDetailDto;
import com.codegym.dto.contract.ContractDto;
import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractDetailService {
    Page<ContractDetailDto> findByDeleted(Pageable pageable);

    List<ContractDetailDto> findContractDetailsByContract(Contract contractDto);
}
