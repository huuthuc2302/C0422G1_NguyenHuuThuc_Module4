package com.codegym.repository.impl;

import com.codegym.repository.ITranslateRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TranslateRepository implements ITranslateRepository {

    @Override
    public String convert(String keywork) {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("book", "sách");
        stringMap.put("pen", "bút");
        stringMap.put("red", "đỏ");
        stringMap.put("black", "đen");
        return stringMap.get(keywork);
    }
}
