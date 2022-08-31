package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping("")
    public String index(Model model,
                        @PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                        @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");

        model.addAttribute("listBlog",
                iBlogService.findAllByTitleContaining(keywordVal, pageable));
        model.addAttribute("keywordVal", keywordVal);
        return "/blog/display";
    }

    @GetMapping("/add")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "/blog/create";
    }


    @PostMapping("/add")
    public String add(@ModelAttribute Blog blog) {
        iBlogService.save(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Integer id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "/blog/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog) {
        iBlogService.save(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "/blog/delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id) {
        iBlogService.remove(id);
        return "redirect:/blogs";
    }

    @GetMapping("/view")
    public String view(@RequestParam Integer id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "/blog/view";
    }

}
