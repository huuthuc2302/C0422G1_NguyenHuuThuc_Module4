package com.codegym.controller;

import com.codegym.model.facility.Facility;
import com.codegym.service.facility.IFacilityService;
import com.codegym.service.facility.IFacilityTypeService;
import com.codegym.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("facility")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IFacilityTypeService iFacilityTypeService;

    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping("")
    public String index(Model model,
                        @PageableDefault(size = 5, sort = "facilityId", direction = Sort.Direction.DESC) Pageable pageable,
                        @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");

        model.addAttribute("listFacility",
                iFacilityService.findByFacilityNameContaining(keywordVal, pageable));
        model.addAttribute("keywordVal", keywordVal);
        return "/facility/display-facility";
    }


    @GetMapping("/add")
    public String create(Model model) {
        model.addAttribute("facility", new Facility());
        model.addAttribute("facilityTypeList",iFacilityTypeService.findAllFacilityTypeList());
        model.addAttribute("rentTypeList",iRentTypeService.findAllRentTypeList());
        return "/facility/create-facility";
    }


    @PostMapping("/add")
    public String add(@ModelAttribute Facility facility, Model model) {
        iFacilityService.save(facility);
        model.addAttribute("msg", "Thêm mới thành công");
        return "redirect:/facility";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Integer id, Model model) {
        model.addAttribute("facility", iFacilityService.findById(id));
        model.addAttribute("facilityTypeList",iFacilityTypeService.findAllFacilityTypeList());
        model.addAttribute("rentTypeList",iRentTypeService.findAllRentTypeList());
        return "/facility/edit-facility";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Facility facility) {
        iFacilityService.save(facility);
        return "redirect:/facility";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int facilityId) {
        iFacilityService.remove(facilityId);
        return "redirect:/facility";
    }
}
