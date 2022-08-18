package com.codegym.service;

import com.codegym.model.Declaration;

import java.util.List;

public interface IDeclarationService {

    public void create(Declaration declaration);

    public void update(Declaration declaration);

    List<String> dayList();

    List<String> monthList();

    List<String> yearList();

    List<String> genderList();

    List<String> vehiclesList();

    List<String> nationList();

}
