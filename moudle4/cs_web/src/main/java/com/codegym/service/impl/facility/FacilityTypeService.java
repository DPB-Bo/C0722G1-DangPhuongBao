package com.codegym.service.impl.facility;

import com.codegym.model.facility.FacilityType;
import com.codegym.repository.facility.FacilityRepository;
import com.codegym.repository.facility.FacilityTypeRepository;
import com.codegym.service.facility.IFacilityTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService {
    private final FacilityTypeRepository facilityTypeRepository;
    public FacilityTypeService(FacilityTypeRepository facilityTypeRepository) {
        this.facilityTypeRepository = facilityTypeRepository;
    }

    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }

    @Override
    public FacilityType findById(int id) {
            return facilityTypeRepository.findById(id).isPresent() ? facilityTypeRepository.findById(id).get():null;
    }
}
