package com.codegym.service;

import com.codegym.model.Declaration;

import java.util.List;

public interface IDeclarationService {

    void create(Declaration declaration);

    List<Declaration> listDeclaration();

    void update(int id, Declaration declaration);

    Declaration findById(int id);

    List<String> dayList();

    List<String> monthList();

    List<String> yearList();

    List<String> genderList();

    List<String> vehiclesList();

    List<String> nationList();

}
