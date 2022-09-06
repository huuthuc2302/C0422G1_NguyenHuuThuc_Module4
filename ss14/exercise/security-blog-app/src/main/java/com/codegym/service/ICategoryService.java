package com.codegym.service;

import com.codegym.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAllCategory();

    void save(Category category);

    Category findByIdCategory(Integer id);

    void update(Category category);

    void delete(Integer id);

}
