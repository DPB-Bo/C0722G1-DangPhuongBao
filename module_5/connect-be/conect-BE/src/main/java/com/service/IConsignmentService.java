package com.service;

import com.model.Consignment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IConsignmentService {
    Page<Consignment> getList(String productName,String importDate, Pageable pageable);

    void save(Consignment consignment);
    void remove(Integer id);

    Consignment findById(Integer id);
}
