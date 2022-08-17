package com.codegym.service.impl;

import com.codegym.repository.IMailBoxRepository;
import com.codegym.service.IMailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailBoxService implements IMailBoxService {

    @Autowired
    private IMailBoxRepository iMailBoxRepository;

    @Override
    public List<String> languageList() {
        return iMailBoxRepository.languageList();
    }

    @Override
    public List<String> sizeList() {
        return iMailBoxRepository.sizeList();
    }
}
