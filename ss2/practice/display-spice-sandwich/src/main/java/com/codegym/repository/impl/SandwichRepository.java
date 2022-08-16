package com.codegym.repository.impl;

import com.codegym.repository.ISandwichRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SandwichRepository implements ISandwichRepository {

    public static List<String> spiceList = new ArrayList<>();

    static {
        spiceList.add("Lettuce");
        spiceList.add("Tomato");
        spiceList.add("Mustard");
        spiceList.add("Sprouts");
    }

    @Override
    public List<String> findAll() {
        return spiceList;
    }
}
