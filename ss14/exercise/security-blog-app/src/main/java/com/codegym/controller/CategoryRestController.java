package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/category")
public class CategoryRestController {

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public ResponseEntity<?> home() {
        List<Category> categories = iCategoryService.findAllCategory();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdCategory(@PathVariable Integer id) {
        Category category = iCategoryService.findByIdCategory(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping("/list-blog/{id}")
    public ResponseEntity<?> getListBlogInCategory(@PathVariable Integer id) {
        Category category = iCategoryService.findByIdCategory(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Set<Blog> blogSet = category.getBlogs();
        return new ResponseEntity<>(blogSet, HttpStatus.OK);
    }

}
