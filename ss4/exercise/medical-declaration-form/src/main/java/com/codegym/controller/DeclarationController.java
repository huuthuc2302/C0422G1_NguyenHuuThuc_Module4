package com.codegym.controller;

import com.codegym.model.Declaration;
import com.codegym.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeclarationController {

    @Autowired
    private IDeclarationService iDeclarationService;

    @GetMapping("/")
    public String goDeclarationList(Model model) {
        model.addAttribute("list", iDeclarationService.listDeclaration());
        return "list";
    }

    @GetMapping("/add")
    public String goDeclarationAdd(Model model) {
        model.addAttribute("declaration", new Declaration());
        model.addAttribute("listDay", iDeclarationService.dayList());
        model.addAttribute("listMonth", iDeclarationService.monthList());
        model.addAttribute("listYear", iDeclarationService.yearList());
        model.addAttribute("listGender", iDeclarationService.genderList());
        model.addAttribute("listVehicles", iDeclarationService.vehiclesList());
        model.addAttribute("listNation", iDeclarationService.nationList());
        return "create";
    }

    @PostMapping("/save")
    public String saveDeclaration(@ModelAttribute Declaration declaration) {
        iDeclarationService.create(declaration);
        return "redirect:/";
    }


    @GetMapping("/update/{id}")
    public String goDeclarationUpdate(@PathVariable int id, Model model) {
        model.addAttribute("declaration", iDeclarationService.findById(id));
        model.addAttribute("listDay", iDeclarationService.dayList());
        model.addAttribute("listMonth", iDeclarationService.monthList());
        model.addAttribute("listYear", iDeclarationService.yearList());
        model.addAttribute("listGender", iDeclarationService.genderList());
        model.addAttribute("listVehicles", iDeclarationService.vehiclesList());
        model.addAttribute("listNation", iDeclarationService.nationList());
        return "edit";
    }

    @PostMapping("/saveUpdate/{id}")
    public String saveUpdateDeclaration(@ModelAttribute Declaration declaration,
                                        @PathVariable int id) {
        iDeclarationService.update(id, declaration);
        return "redirect:/";
    }
}
