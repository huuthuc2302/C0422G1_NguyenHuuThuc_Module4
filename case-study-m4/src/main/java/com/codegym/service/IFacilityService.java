package com.codegym.service;

import com.codegym.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    List<Facility> findAll();

    void save(Facility facility);

    Facility findById(int id);

    void remove(int id);

    Page<Facility> findByFacilityNameContaining(String detailFacility, Pageable pageable);
}
