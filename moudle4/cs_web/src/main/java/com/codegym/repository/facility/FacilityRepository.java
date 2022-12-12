package com.codegym.repository.facility;

import com.codegym.dto.facility.FacilityDto;
import com.codegym.model.facility.Facility;
import com.codegym.model.facility.FacilityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Integer> {
    Page<FacilityDto> findByNameContainingAndFacilityType(String name, FacilityType facilityType,Pageable pageable);
    Page<FacilityDto> findByNameContaining(String name,Pageable pageable);

}