package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import javax.validation.Valid;
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
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
        return "/customer/create-customer";
    }


    @PostMapping("/add")
    public String add(@ModelAttribute @Valid CustomerDto customerDto, Model model,
                      BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
            return "/customer/create-customer";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("mess","Thêm mơi thành công!");
        model.addAttribute("msg", "Thêm mới thành công");
        return "redirect:/customers";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Integer id, Model model) {
        model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
        model.addAttribute("customerDto", iCustomerService.findById(id));
        return "/customer/edit-customer";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("customerDto") @Valid CustomerDto customerDto,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes,
                         Model model) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
            return "customer/edit-customer";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("mess","Cập nhật thành công!");
        return "redirect:/customers";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer customerId) {
        iCustomerService.remove(customerId);
        return "redirect:/customers";
    }
}
