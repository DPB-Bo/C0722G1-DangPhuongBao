package com.codegym.service.impl.contract;

import com.codegym.dto.contract.ContractDto;
import com.codegym.model.contract.Contract;
import com.codegym.repository.contract.ContractRepository;
import com.codegym.service.contract.IContractService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {
    private final ContractRepository contractRepository;

    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public Page<ContractDto> showListContract(Pageable pageable) {
        return contractRepository.findByDeleted(pageable, false);
    }

    @Override
    public Contract findById(int id) {
        return contractRepository.findById(id);
    }
}
