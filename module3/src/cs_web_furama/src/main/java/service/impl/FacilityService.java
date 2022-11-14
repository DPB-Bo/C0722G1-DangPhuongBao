package service.impl;

import model.Facility;
import repository.IFacilityRepository;
import repository.impl.FacilityRepository;
import service.IFacilityService;

import java.util.List;

public class FacilityService implements IFacilityService {

    IFacilityRepository facilityRepository = new FacilityRepository();
    @Override
    public List<Facility> getFacility() {
        return facilityRepository.getFacility();
    }

    @Override
    public boolean addFacility(Facility facility) {
        return facilityRepository.addFacility(facility);
    }

    @Override
    public boolean removeFacility(int id) {
        return facilityRepository.removeFacility(id);
    }

    @Override
    public boolean editFacility(int id, Facility facility) {
        return facilityRepository.editFacility(id, facility);
    }

    @Override
    public List<Facility> searchByName(String name) {
        return null;
    }
}
