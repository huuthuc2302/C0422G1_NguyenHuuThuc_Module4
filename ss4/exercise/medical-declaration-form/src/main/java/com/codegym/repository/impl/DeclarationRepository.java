package com.codegym.repository.impl;

import com.codegym.model.Declaration;
import com.codegym.repository.IDeclarationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DeclarationRepository implements IDeclarationRepository {

    private static Map<Integer, Declaration> declarationMap = new HashMap<>();

    @Override
    public void create(Declaration declaration) {
        int id = declarationMap.size() + 1;
        declaration.setId(id);
        declarationMap.put(id, declaration);
    }

    @Override
    public List<Declaration> listDeclaration() {
        return new ArrayList<>(declarationMap.values());
    }

    @Override
    public void update(int id, Declaration declaration) {
        declarationMap.put(id, declaration);
    }

    @Override
    public Declaration findById(int id) {
        return declarationMap.get(id);
    }

    @Override
    public List<String> dayList() {
        List<String> dayList = new ArrayList<>();
        for (int i = 1; i < 31; i++) {
            dayList.add(String.valueOf(i));
        }
        return dayList;
    }

    @Override
    public List<String> monthList() {
        List<String> monthList = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            monthList.add(String.valueOf(i));
        }
        return monthList;
    }

    @Override
    public List<String> yearList() {
        List<String> yearList = new ArrayList<>();
        for (int i = 1990; i < 2023; i++) {
            yearList.add(String.valueOf(i));
        }
        return yearList;
    }

    @Override
    public List<String> genderList() {
        List<String> genderList = new ArrayList<>();
        genderList.add("Nam");
        genderList.add("Nữ");
        genderList.add("Khác");
        return genderList;
    }

    @Override
    public List<String> vehiclesList() {
        List<String> vehiclesList = new ArrayList<>();
        vehiclesList.add("Tàu bay");
        vehiclesList.add("Tàu thuyền");
        vehiclesList.add("Ô tô");
        vehiclesList.add("Khác (Ghi rõ)");
        return vehiclesList;
    }

    @Override
    public List<String> nationList() {
        List<String> nationList = new ArrayList<>();
        nationList.add("Việt Nam");
        nationList.add("Thái Lan");
        nationList.add("Lào");
        nationList.add("Singapore");
        nationList.add("America");
        nationList.add("China");
        nationList.add("Russia");
        nationList.add("Malaysia");
        return nationList;
    }

}
