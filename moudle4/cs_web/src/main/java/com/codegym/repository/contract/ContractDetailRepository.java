package com.codegym.repository.contract;

import com.codegym.dto.contract.ContractDetailDto;
import com.codegym.dto.contract.ContractDto;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
    Page<ContractDetailDto> findByDeleted(Pageable pageable, boolean deleted);

    List<ContractDetailDto> findContractDetailsByContract(Contract contract);
}