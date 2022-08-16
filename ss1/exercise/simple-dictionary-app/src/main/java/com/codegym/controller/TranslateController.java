package com.codegym.controller;

import com.codegym.repository.ITranslateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TranslateController {

    @Autowired
    private ITranslateRepository iTranslateRepository;

    @GetMapping("/")
    public String goTranslate() {
        return "/translate";
    }

    @GetMapping("/begin")
    public String resurtBegin(@RequestParam String keywork, Model model) {
        String convert = this.iTranslateRepository.convert(keywork);
        model.addAttribute("resurt", convert);
        return "/translate";
    }
}
