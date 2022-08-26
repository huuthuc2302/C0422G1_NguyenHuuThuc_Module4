package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService iBookService;

    @GetMapping("")
    public String display(Model model) {
        model.addAttribute("listBook", iBookService.findAll());
        return "/display";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam Integer id, Model model) {
        model.addAttribute("book", iBookService.findById(id));
        return "/detail";
    }

    @PostMapping("/update")
    public String update(@RequestParam Integer id, Model model) throws Exception {
        Book book = iBookService.findById(id);
        if (book == null) {
            throw new Exception();
        }
        if (book.getQuantity() == 0) {
            model.addAttribute("msg", "Đã hết sách");
            model.addAttribute("book", book);
            return "/detail";
        }
        book.setQuantity(book.getQuantity() - 1);
        iBookService.save(book);
        model.addAttribute("book", book);
        model.addAttribute("msg", "Thuê sách thành công");
        return "/detail";
    }

    @GetMapping("/pay")
    public String pay() {
        return "/pay";
    }


    @PostMapping("/pay")
    public String pay(@RequestParam Integer id, Model model) throws Exception {
        Book book = iBookService.findById(id);
        if (book == null) {
            throw new Exception();
        }
        if (book.getQuantity() == book.getTotal()) {
            model.addAttribute("msg", "Số lượng sách đã đủ");
            return "/pay";
        }
        book.setQuantity(book.getQuantity() + 1);
        iBookService.save(book);
        model.addAttribute("msg", "Trả sách thành công");
        return "/pay";
    }

    @ExceptionHandler(value = Exception.class)
    public String error() {
        return "/error";
    }
}
