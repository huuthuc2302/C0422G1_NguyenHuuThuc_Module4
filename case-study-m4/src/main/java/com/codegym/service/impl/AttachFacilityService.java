package com.codegym.service.impl;

import com.codegym.model.contract.AttachFacility;
import com.codegym.repository.contract.IAttachFacilityRepository;
import com.codegym.service.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {

    @Autowired
    private IAttachFacilityRepository iAttachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return iAttachFacilityRepository.findAll();
    }

}
