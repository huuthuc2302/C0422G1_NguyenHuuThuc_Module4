package com.codegym.controller;

import com.codegym.dto.FacilityDto;
import com.codegym.model.facility.Facility;
import com.codegym.service.facility.IFacilityService;
import com.codegym.service.facility.IFacilityTypeService;
import com.codegym.service.facility.IRentTypeService;
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

import javax.validation.Valid;
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
        model.addAttribute("facilityDto", new FacilityDto());
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAllFacilityTypeList());
        model.addAttribute("rentTypeList", iRentTypeService.findAllRentTypeList());
        return "/facility/create-facility";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute @Valid FacilityDto facilityDto, BindingResult
            bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("facilityTypeList",iFacilityTypeService.findAllFacilityTypeList());
            model.addAttribute("rentTypeList", iRentTypeService.findAllRentTypeList());
            return "facility/create-facility";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess","Thêm mơi thành công!");
        return "redirect:/facility";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Integer id, Model model) {
        model.addAttribute("facilityDto", iFacilityService.findById(id));
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAllFacilityTypeList());
        model.addAttribute("rentTypeList", iRentTypeService.findAllRentTypeList());
        return "/facility/edit-facility";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Valid FacilityDto facilityDto, BindingResult
            bindingResult, RedirectAttributes redirectAttributes,Model model) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("facilityTypeList",iFacilityTypeService.findAllFacilityTypeList());
            model.addAttribute("rentTypeList",iRentTypeService.findAllRentTypeList());
            return "facility/edit-facility";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess", "Cập nhật thành công");
        return "redirect:/facility";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int facilityId) {
        iFacilityService.remove(facilityId);
        return "redirect:/facility";
    }

}
