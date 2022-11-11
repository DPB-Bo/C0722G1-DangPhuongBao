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
        return false;
    }

    @Override
    public boolean removeFacility(int id) {
        return false;
    }

    @Override
    public boolean editFacility(int id, Facility facility) {
        return false;
    }

    @Override
    public List<Facility> searchByName(String name) {
        return null;
    }
}
