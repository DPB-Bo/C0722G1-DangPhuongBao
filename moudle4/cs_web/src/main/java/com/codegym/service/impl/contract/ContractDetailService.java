package com.codegym.service.impl.contract;

import com.codegym.dto.contract.ContractDetailDto;
import com.codegym.model.contract.Contract;
import com.codegym.repository.contract.ContractDetailRepository;
import com.codegym.service.contract.IContractDetailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    private final ContractDetailRepository contractDetailRepository;

    public ContractDetailService(ContractDetailRepository contractDetailRepository) {
        this.contractDetailRepository = contractDetailRepository;
    }


    @Override
    public Page<ContractDetailDto> findByDeleted(Pageable pageable) {
        return contractDetailRepository.findByDeleted(pageable, false);
    }

    @Override
    public List<ContractDetailDto> findContractDetailsByContract(Contract contract) {
        return contractDetailRepository.findContractDetailsByContract(contract);
    }
}
