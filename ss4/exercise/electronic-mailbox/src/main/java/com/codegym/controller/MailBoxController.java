package com.codegym.controller;

import com.codegym.model.MailBox;
import com.codegym.service.IMailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailBoxController {

    @Autowired
    private IMailBoxService iMailBoxService;

    @GetMapping("/")
    public String goHome(Model model) {
        model.addAttribute("boxMail", new MailBox());
        model.addAttribute("listLanguage", iMailBoxService.languageList());
        model.addAttribute("listSize", iMailBoxService.sizeList());
        return "/display";
    }

    @PostMapping("/update")
    public String updateEmail(@ModelAttribute MailBox mailBox , Model model) {
        model.addAttribute("boxMail", mailBox);
        return "info";
    }
}
