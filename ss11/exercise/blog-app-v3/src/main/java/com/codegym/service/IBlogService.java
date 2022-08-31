package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Integer id);

    void remove(Integer id);

    List<Blog> findAllByCategory_IdCategory(Integer id);

    Page<Blog> findAllByTitleContaining(String titleBlog, Pageable pageable);

}
