package com.codegym.controller;

import com.codegym.model.Declaration;
import com.codegym.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeclarationController {
    @Autowired
    private IDeclarationService iDeclarationService ;

    @GetMapping("/")
    public String goHome(Model model){
        model.addAttribute("declaration", new Declaration());
        model.addAttribute("listDay", iDeclarationService.dayList());
        model.addAttribute("listMonth",iDeclarationService.monthList());
        model.addAttribute("listYear",iDeclarationService.yearList());
        model.addAttribute("listGender",iDeclarationService.genderList());
        model.addAttribute("listVehicles",iDeclarationService.vehiclesList());
        model.addAttribute("listNation",iDeclarationService.nationList());
        return "/display";
    }

    @PostMapping("/send")
    public String newDeclaration(@ModelAttribute Declaration declaration, Model model){
        model.addAttribute("newList", declaration);
        return "list";
    }
}
