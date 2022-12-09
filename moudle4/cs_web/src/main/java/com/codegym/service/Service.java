package com.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Service<DTO,ENT> {
    Page<DTO> findAll(Pageable pageable);
    DTO findById(String id);
    void save(ENT ent);
    void deleteById(int id);
}
