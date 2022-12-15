package com.codegym.service.impl.contract;

import com.codegym.dto.contract.ContractDetailDto;
import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
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
    public List<ContractDetailDto> findByDeleted() {
        return contractDetailRepository.findByDeleted( false);
    }

    @Override
    public void saveContractDetail(Integer[][] attachFacilityList) {
        int size = attachFacilityList[0].length;
        for (int i=0; i<size; i++){
            if (attachFacilityList[1][i]!=0){
                ContractDetail contractDetail = ContractDetail.builder()
                        .attachFacility(AttachFacility.builder().id(attachFacilityList[0][i]).build())
                                .contract(Contract.builder().id(attachFacilityList[2][0]).build())
                                        .quantity(attachFacilityList[1][i]).build();
                contractDetailRepository.save(contractDetail);
            }
        }
    }

    @Override
    public List<ContractDetailDto> findContractDetailsByContract(Contract contract) {
        return contractDetailRepository.findContractDetailsByContract(contract);
    }
}
