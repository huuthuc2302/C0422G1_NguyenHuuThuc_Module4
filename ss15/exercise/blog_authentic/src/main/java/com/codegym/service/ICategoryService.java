package com.codegym.service;

import com.codegym.model.CategoryBlog;

import java.util.List;

public interface ICategoryService {

    List<CategoryBlog> findAll();

}
