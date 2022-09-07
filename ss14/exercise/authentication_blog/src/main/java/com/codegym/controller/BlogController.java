package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/list")
    public String list(Model model, Principal principal) {
        model.addAttribute("blogList", iBlogService.findAll());
        model.addAttribute("category", iCategoryService.findAll());
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        Set<GrantedAuthority> setGrant = new HashSet<GrantedAuthority>(loginedUser.getAuthorities());
        for (GrantedAuthority s : setGrant) {
            if (s.getAuthority().equals(
                    "ROLE_ADMIN")) {
                String a = "ADMIN";
                model.addAttribute("a", a);
            } else
                model.addAttribute("a", ' ');
        }

        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("category", iCategoryService.findAll());
        return "create";
    }

    @PostMapping("/saveCreate")
    public String saveCreate(@ModelAttribute Blog blog) {
        iBlogService.save(blog);
        return "redirect:/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        iBlogService.delete(id);
        return "redirect:/list";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam int id, Model model) {
        Optional<Blog> blog = iBlogService.findId(id);
        model.addAttribute("blog", blog.get());
        model.addAttribute("category", iCategoryService.findAll());
        return "update";
    }

    @PostMapping("/saveUpdate")
    public String saveUpdate(@ModelAttribute Blog blog) {
        iBlogService.update(blog);
        return "redirect:/list";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam int id, Model model) {
        Optional<Blog> blog = iBlogService.findId(id);
        model.addAttribute("blog", blog.get());
        return "detail";
    }

    @GetMapping("/search")
    public String search(@RequestParam(defaultValue = "") String categoryId, Model model) {
        model.addAttribute("blogList", iBlogService.findAllByCategoryBlog_NameOfCategoryContains(categoryId));
        model.addAttribute("category", iCategoryService.findAll());
        return "list";
    }

}
