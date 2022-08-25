package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public String display(Model model) {
        model.addAttribute("listUser", iUserService.findAll());
        return "/display";
    }

    @GetMapping("/add")
    public String create(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/create";
    }


    @PostMapping("/add")
    public String add(@ModelAttribute @Valid UserDto userDto,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {
        String str = userDto.getAge();
        new UserDto().validate(userDto, bindingResult);

        if (bindingResult.hasErrors()) {
            return "create";
        }

        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setAge(str);
        iUserService.save(user);
        redirectAttributes.addFlashAttribute("msg",
                "Register successfully!");
        return "redirect:/users";
    }

}
