package com.codegym.controller;

import com.codegym.model.contract.ContractDetail;
import com.codegym.model.employee.Employee;
import com.codegym.service.employee.IDivisionService;
import com.codegym.service.employee.IEducationDegreeService;
import com.codegym.service.employee.IEmployeeService;
import com.codegym.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IDivisionService iDivisionService;

    @Autowired
    private IEducationDegreeService iEducationDegreeService;

    @Autowired
    private IPositionService iPositionService;

    @GetMapping(value = "")
    public String findAll(Model model,
                          @PageableDefault(size = 5) Pageable pageable,
                          @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");

        model.addAttribute("listEmployee",
                iEmployeeService.findByEmployeeNameContaining(keywordVal, pageable));
        model.addAttribute("keywordVal", keywordVal);

        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("educationDegreeList", iEducationDegreeService.findAll());
        model.addAttribute("positionList", iPositionService.findAll());
        model.addAttribute("employee", new Employee());
        return "/employee/display-employee";
    }
}
