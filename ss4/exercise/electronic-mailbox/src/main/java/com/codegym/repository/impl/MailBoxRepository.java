package com.codegym.repository.impl;

import com.codegym.repository.IMailBoxRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailBoxRepository implements IMailBoxRepository {

    public static List<String> languageList = new ArrayList<>();

    static {
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
    }

    public static List<String> sizeList = new ArrayList<>();

    static {
        sizeList.add("5");
        sizeList.add("10");
        sizeList.add("15");
        sizeList.add("25");
        sizeList.add("50");
        sizeList.add("100");
    }


    @Override
    public List<String> languageList() {
        return languageList;
    }

    @Override
    public List<String> sizeList() {
        return sizeList;
    }
}
