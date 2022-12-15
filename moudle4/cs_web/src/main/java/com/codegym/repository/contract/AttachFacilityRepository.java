package com.codegym.repository.contract;

import com.codegym.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttachFacilityRepository extends JpaRepository<AttachFacility, Integer> {
    List<AttachFacility> findByDeleted(boolean deleted);
}