package com.example.controler;

import com.example.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculatorService iCalculatorService;

    @GetMapping("/")
    public String showFrom() {
        return "/calculator";
    }

    @GetMapping("/app")
    public String resurtApp(@RequestParam double money, Model model){
//        double total = money * 23000;
        double total = this.iCalculatorService.total(money);
        model.addAttribute("resurt", total);
        return "/calculator";
    }
}
