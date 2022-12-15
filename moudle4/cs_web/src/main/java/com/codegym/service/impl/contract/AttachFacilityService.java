package com.codegym.service.impl.contract;

import com.codegym.model.contract.AttachFacility;
import com.codegym.repository.contract.AttachFacilityRepository;
import com.codegym.service.contract.IAttachFacilityService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachFacilityService implements IAttachFacilityService {
    private final AttachFacilityRepository attachFacilityRepository;

    public AttachFacilityService(AttachFacilityRepository attachFacilityRepository) {
        this.attachFacilityRepository = attachFacilityRepository;
    }

    @Override
    public List<AttachFacility> findByDeleted() {
        return attachFacilityRepository.findByDeleted(false);
    }
}
