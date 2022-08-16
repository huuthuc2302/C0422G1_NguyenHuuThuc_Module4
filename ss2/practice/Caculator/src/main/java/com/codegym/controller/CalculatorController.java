package com.codegym.controller;

import com.codegym.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService iCalculatorService;

    @GetMapping("/")
    public String goDisplay() {
        return "/Display";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam double numberOne,
                            @RequestParam double numberTwo,
                            @RequestParam String operator,
                            Model model) {
        String result = iCalculatorService.calculate(numberOne, numberTwo, operator);
        model.addAttribute("finalResult", result);
        return "/Display";
    }
}
