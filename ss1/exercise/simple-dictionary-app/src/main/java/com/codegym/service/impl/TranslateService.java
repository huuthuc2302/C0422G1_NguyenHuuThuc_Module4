package com.codegym.service.impl;

import com.codegym.repository.ITranslateRepository;
import com.codegym.service.ITranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslateService implements ITranslateService {

    @Autowired
    private ITranslateRepository iTranslateRepository;

    @Override
    public String convert(String keywork) {
        return iTranslateRepository.convert(keywork);
    }
}
