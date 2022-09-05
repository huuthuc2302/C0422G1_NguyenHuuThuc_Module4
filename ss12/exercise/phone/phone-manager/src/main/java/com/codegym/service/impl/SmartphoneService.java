package com.codegym.service.impl;

import com.codegym.model.Smartphone;
import com.codegym.repository.ISmartphoneRepository;
import com.codegym.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SmartphoneService implements ISmartphoneService {

    @Autowired
    private ISmartphoneRepository smartPhoneRepository;

    @Override
    public Page<Smartphone> findAll(Pageable pageable) {
        return smartPhoneRepository.findAll(pageable);
    }

    @Override
    public Smartphone findById(Long id) {
        return smartPhoneRepository.findById(id).orElse(null);
    }

    @Override
    public Smartphone save(Smartphone smartPhone) {
        return smartPhoneRepository.save(smartPhone);
    }

    @Override
    public void delete(Long id) {
        smartPhoneRepository.deleteById(id);
    }

}
