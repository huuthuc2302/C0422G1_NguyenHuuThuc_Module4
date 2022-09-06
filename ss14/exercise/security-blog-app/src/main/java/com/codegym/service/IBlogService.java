package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {

    Page<Blog> findAllBlog(Pageable pageable);

    void save(Blog blog);

    Blog findByIdBlog(Integer id);

    void update(Blog blog);

    void delete(Integer id);

    Page<Blog> findAllBlogByName(Pageable pageable, String txt);

}
