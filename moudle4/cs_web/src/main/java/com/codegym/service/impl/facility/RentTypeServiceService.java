package com.codegym.service.impl.facility;

import com.codegym.model.facility.RentType;
import com.codegym.repository.facility.RentTypeRepository;
import com.codegym.service.facility.IRentTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceService implements IRentTypeService {
    private final RentTypeRepository rentTypeRepository;

    public RentTypeServiceService(RentTypeRepository rentTypeRepository) {
        this.rentTypeRepository = rentTypeRepository;
    }

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public RentType findById(int id) {
        return rentTypeRepository.findById(id).isPresent()?rentTypeRepository.findById(id).get(): null;
    }
}
