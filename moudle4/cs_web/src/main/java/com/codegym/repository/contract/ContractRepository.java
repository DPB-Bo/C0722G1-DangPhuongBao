package com.codegym.repository.contract;

import com.codegym.dto.contract.ContractDto;
import com.codegym.dto.contract.sub.ContractDtoList;
import com.codegym.model.contract.Contract;
import com.codegym.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    Page<ContractDto> findByDeleted(Pageable pageable, boolean deleted);

    Contract findById(int id);

    Contract findByStartDateAndEndDateAndFacility(String startDate, String endDate, Facility facility);
    @Query(value = "SELECT c.id, c.start_date as startDate, c.end_date as endDate, c.deposit, cus.name as nameCustomer,f.name as nameFacility, (sum(ifnull(cd.quantity, 0) * ifnull(af.cost, 0)) + f.cost) AS totalValue FROM contract c LEFT JOIN contract_detail cd ON c.id = cd.contract_id LEFT JOIN attach_facility af ON cd.attach_facility_id = af.id LEFT JOIN facility f ON c.facility_id = f.id join customer as cus on c.customer_id = cus.id GROUP BY c.id ORDER BY c.id"
            , countQuery = "SELECT c.id, c.start_date as startDate, c.end_date as endDate, c.deposit, cus.name as nameCustomer,f.name as nameFacility, (sum(ifnull(cd.quantity, 0) * ifnull(af.cost, 0)) + f.cost) AS totalValue FROM contract c LEFT JOIN contract_detail cd ON c.id = cd.contract_id LEFT JOIN attach_facility af ON cd.attach_facility_id = af.id LEFT JOIN facility f ON c.facility_id = f.id join customer as cus on c.customer_id = cus.id GROUP BY c.id ORDER BY c.id"
            , nativeQuery = true)
    Page<ContractDtoList> showListContractSub(Pageable pageable);
}