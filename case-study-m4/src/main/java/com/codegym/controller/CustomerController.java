package com.codegym.controller;

import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @ModelAttribute
    public List<CustomerType> customerTypeList() {
        return iCustomerTypeService.findAll();
    }

    @GetMapping("")
    public String index(Model model,
                        @PageableDefault(size = 5, sort = "customerId", direction = Sort.Direction.DESC) Pageable pageable,
                        @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");

        model.addAttribute("listCustomer",
                iCustomerService.findByCustomerNameContaining(keywordVal, pageable));
        model.addAttribute("keywordVal", keywordVal);
        return "/customer/display-customer";
    }

    @GetMapping("/add")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/customer/create-customer";
    }


    @PostMapping("/add")
    public String add(@ModelAttribute Customer customer, Model model) {
        iCustomerService.save(customer);
        model.addAttribute("msg", "Thêm mới thành công");
        return "redirect:/customers";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Integer id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        return "/customer/edit-customer";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("customer") Customer customer) {
        iCustomerService.save(customer);
        return "redirect:/customers";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int customerId) {
        iCustomerService.remove(customerId);
        return "redirect:/customers";
    }
}
