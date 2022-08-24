package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/genre")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String dispplay(Model model) {
        model.addAttribute("listCategory", iCategoryService.findAllCategory());
        return "category/display-category";
    }

    @GetMapping("/add")
    public String create(Model model) {
        model.addAttribute("category", new Category());
        return "category/create-category";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Category category) {
        iCategoryService.save(category);
        return "redirect:/genre";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Integer idCategory, Model model) {
        model.addAttribute("category", iCategoryService.findByIdCategory(idCategory));
        return "/category/edit-category";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Category category) {
        iCategoryService.save(category);
        return "redirect:/genre";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer idCategory, Model model) {
        model.addAttribute("category", iCategoryService.findByIdCategory(idCategory));
        return "/category/delete-category";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer idCategory) {
        iCategoryService.delete(idCategory);
        return "redirect:/genre";
    }
}
