package service;

import model.Facility;

import java.util.List;

public interface IFacilityService {
    List<Facility> getFacility();

    boolean addFacility(Facility facility);

    boolean removeFacility(int id);

    boolean editFacility(int id, Facility facility);

    List<Facility> searchByName(String name);
}
