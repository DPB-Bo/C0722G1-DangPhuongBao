package com.codegym.service.facility;

import com.codegym.dto.facility.FacilityDto;
import com.codegym.model.facility.Facility;
import com.codegym.model.facility.FacilityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    void save (Facility facility);
    FacilityDto findById(int id);
    void deleteById(int id);
    Page<FacilityDto> findByNameContainingAndFacilityType(String name, FacilityType facilityType, Pageable pageable);
    Page<FacilityDto> findByNameContaining(String name,Pageable pageable);
    List<FacilityDto> findByDeleted();
}
