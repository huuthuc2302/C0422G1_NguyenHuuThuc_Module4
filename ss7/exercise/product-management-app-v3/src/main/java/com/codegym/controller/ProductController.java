package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String index(Model model,
                        @PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                        @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");

        model.addAttribute("listProduct",
                iProductService.findAllByProductContaining(keywordVal, pageable));
        model.addAttribute("keywordVal", keywordVal);
        return "/product/display";
    }

    @GetMapping("/add")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/product/create";
    }


    @PostMapping("/add")
    public String add(@ModelAttribute Product product) {
        iProductService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Integer id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/product/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product) {
        iProductService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/product/delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id) {
        iProductService.remove(id);
        return "redirect:/products";
    }

    @GetMapping("/view")
    public String view(@RequestParam Integer id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/product/view";
    }

}
