package com.codegym.service.contract;

import com.codegym.dto.contract.ContractDto;
import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<ContractDto> showListContract(Pageable pageable);

    Contract findById(int id);
}
