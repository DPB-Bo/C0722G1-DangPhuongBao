package com.codegym.service.impl.facility;

import com.codegym.dto.customer.CustomerDto;
import com.codegym.dto.facility.FacilityDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.facility.Facility;
import com.codegym.model.facility.FacilityType;
import com.codegym.repository.facility.FacilityRepository;
import com.codegym.repository.facility.FacilityTypeRepository;
import com.codegym.repository.facility.RentTypeRepository;
import com.codegym.service.facility.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {
    private final FacilityRepository facilityRepository;
    private final FacilityTypeRepository facilityTypeRepository;
    private final RentTypeRepository rentTypeRepository;

    public FacilityService(FacilityRepository facilityRepository, FacilityTypeRepository facilityTypeRepository, RentTypeRepository rentTypeRepository) {
        this.facilityRepository = facilityRepository;
        this.facilityTypeRepository = facilityTypeRepository;
        this.rentTypeRepository = rentTypeRepository;
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public FacilityDto findById(int id) {
        FacilityDto facilityDto = FacilityDto.builder().build();
        BeanUtils.copyProperties(facilityRepository.findById(id).get(),facilityDto);
        return facilityDto;
    }

    @Override
    public void deleteById(int id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public Page<FacilityDto> findByNameContainingAndFacilityType(String name, FacilityType facilityType, Pageable pageable) {
        return facilityRepository.findByNameContainingAndFacilityType(name, facilityType, pageable);
    }

    @Override
    public Page<FacilityDto> findByNameContaining(String name, Pageable pageable) {
        return facilityRepository.findByNameContaining(name,pageable);
    }
}
