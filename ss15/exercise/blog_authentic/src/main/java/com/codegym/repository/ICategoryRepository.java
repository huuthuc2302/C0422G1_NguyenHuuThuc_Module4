package com.codegym.repository;

import com.codegym.model.CategoryBlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<CategoryBlog, Integer> {

}
