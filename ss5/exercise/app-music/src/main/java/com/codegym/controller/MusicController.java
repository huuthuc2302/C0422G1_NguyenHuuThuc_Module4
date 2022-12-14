package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/musics")
public class MusicController {

    @Autowired
    private IMusicService iMusicService;

    @GetMapping("")
    public String home(@RequestParam(required = false,defaultValue = "") String music, Model model) {
        List<Music> musicList = iMusicService.getAll(music);
        model.addAttribute("listMusic", musicList);
        return "/list";

    }

    @GetMapping("/add")
    public String create(Model model) {
        model.addAttribute("music", new Music());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Music music) {
        iMusicService.save(music);
        return "redirect:/musics";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("music", iMusicService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Music music) {
        iMusicService.update(music);
        return "redirect:/musics";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        model.addAttribute("music", iMusicService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Music music, RedirectAttributes redirect) {
        iMusicService.remove(music);
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/musics";
    }

}
