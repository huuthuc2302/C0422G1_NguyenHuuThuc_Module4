package com.codegym.repository;

import com.codegym.model.Declaration;

import java.util.List;

public interface IDeclarationRepository {


    void create(Declaration declaration);

    void update(Declaration declaration);

    List<String> dayList();

    List<String> monthList();

    List<String> yearList();

    List<String> genderList();

    List<String> vehiclesList();

    List<String> nationList();

}
