package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/blogs")
public class BlogRestController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping("")
    public ResponseEntity<?> home(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("name_blog").ascending();
        Page<Blog> blogList = iBlogService.findAllBlog(PageRequest.of(page, 2, sort));
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ModelAndView getBlogList(@RequestParam(name = "page", defaultValue = "0") int page) {
        Sort sort = Sort.by("name_blog").ascending();
        Page<Blog> blogList = iBlogService.findAllBlog(PageRequest.of(page, 2, sort));
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("blogList", blogList);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdBlog(@PathVariable Integer id) {
        Blog blog = iBlogService.findByIdBlog(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        iBlogService.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/search/{txt}")
    public ResponseEntity<?> searchByAjax(@PathVariable String txt) {
        Sort sort = Sort.by("name_blog").ascending();
        Page<Blog> blogList = iBlogService.findAllBlogByName(PageRequest.of(0, 100, sort), txt);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/load/{number}")
    public ResponseEntity<?> load(@PathVariable Integer number) {
        Sort sort = Sort.by("name_blog").ascending();
        Page<Blog> blogList = iBlogService.findAllBlog(PageRequest.of(0, number, sort));
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

}
