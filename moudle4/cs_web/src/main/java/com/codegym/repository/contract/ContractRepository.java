package com.codegym.repository.contract;

import com.codegym.dto.contract.ContractDto;
import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    Page<ContractDto> findByDeleted(Pageable pageable, boolean deleted);

    Contract findById(int id);
}