package com.codegym.controller;

import com.codegym.dto.MusicDto;
import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/musics")
public class MusicController {

    @Autowired
    private IMusicService iMusicService;

    @GetMapping("")
    public String display(Model model) {
        model.addAttribute("listMusic", iMusicService.findAll());
        return "/display";
    }

    @GetMapping("/add")
    public String create(Model model) {
        model.addAttribute("musicDto", new MusicDto());
        return "/create";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute @Valid MusicDto musicDto,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {

        new MusicDto().validate(musicDto, bindingResult);

        if (bindingResult.hasErrors()) {
            return "create";
        }

        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        iMusicService.save(music);
        redirectAttributes.addFlashAttribute("msg",
                "Register successfully!");
        return "redirect:/musics";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Integer id, Model model) {
        model.addAttribute("music", iMusicService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Valid MusicDto musicDto,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {

        new MusicDto().validate(musicDto, bindingResult);

        if (bindingResult.hasErrors()) {
            return "edit";
        }

        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        iMusicService.save(music);
        redirectAttributes.addFlashAttribute("msg",
                "Register successfully!");
        return "redirect:/musics";
    }
}
