package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {

    List<Blog> findAll();

    void update(Blog blog);

    void delete(int id);

    void save(Blog blog);

    Optional<Blog> findId(int id);

    List<Blog> findAllByCategoryBlog_NameOfCategoryContains(String name);

    List<Blog> findAllByCategoryBlog_Id(int id);

}
