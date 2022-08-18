package com.codegym.service.impl;

import com.codegym.model.Declaration;
import com.codegym.repository.IDeclarationRepository;
import com.codegym.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeclarationService implements IDeclarationService {

    @Autowired
    private IDeclarationRepository iDeclarationRepository;

    @Override
    public void create(Declaration declaration) {
        iDeclarationRepository.create(declaration);
    }

    @Override
    public List<Declaration> listDeclaration() {
        return iDeclarationRepository.listDeclaration();
    }

    @Override
    public void update(int id, Declaration declaration) {
        iDeclarationRepository.update(id, declaration);
    }

    @Override
    public Declaration findById(int id) {
        return iDeclarationRepository.findById(id);
    }

    @Override
    public List<String> dayList() {
        return iDeclarationRepository.dayList();
    }

    @Override
    public List<String> monthList() {
        return iDeclarationRepository.monthList();
    }

    @Override
    public List<String> yearList() {
        return iDeclarationRepository.yearList();
    }

    @Override
    public List<String> genderList() {
        return iDeclarationRepository.genderList();
    }

    @Override
    public List<String> vehiclesList() {
        return iDeclarationRepository.vehiclesList();
    }

    @Override
    public List<String> nationList() {
        return iDeclarationRepository.nationList();
    }

}
