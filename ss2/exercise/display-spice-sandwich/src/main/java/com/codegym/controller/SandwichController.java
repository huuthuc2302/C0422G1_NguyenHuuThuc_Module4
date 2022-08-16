package com.codegym.controller;

import com.codegym.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SandwichController {
    @Autowired
    private ISandwichService iSpiceService;

    @GetMapping("/")
    public String goSpice(Model model) {
        List<String> spiceList = iSpiceService.findAll();
        model.addAttribute("yourSpiceList", spiceList);
        return "/display";
    }

    @PostMapping("/option")
    public String goOption(@RequestParam String chose, Model model) {
        String listChose = chose;
        model.addAttribute("result", listChose);
        return "/display";
    }
}
