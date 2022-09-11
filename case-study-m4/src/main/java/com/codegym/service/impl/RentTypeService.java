package com.codegym.service.impl;

import com.codegym.model.facility.RentType;
import com.codegym.repository.facility.IRentTypeRepository;
import com.codegym.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {

    @Autowired
    private IRentTypeRepository iRentTypeRepository;

    @Override
    public List<RentType> findAllRentTypeList() {
        return iRentTypeRepository.findAll();
    }
}
