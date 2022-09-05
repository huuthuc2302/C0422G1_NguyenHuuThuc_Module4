package com.codegym.service;

import com.codegym.model.Smartphone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISmartphoneService {

    Page<Smartphone> findAll(Pageable pageable);

    Smartphone findById(Long id);

    Smartphone save(Smartphone smartPhone);

    void delete(Long id);

}
