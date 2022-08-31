package com.codegym.service;

import com.codegym.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAllCategory();

    void save(Category category);

    Category findByIdCategory(Integer id);

    void delete(Integer id);

}
