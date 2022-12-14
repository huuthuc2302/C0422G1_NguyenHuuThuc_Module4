package com.codegym.controller;

import com.codegym.dto.ContractDto;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.service.contract.IAttachFacilityService;
import com.codegym.service.contract.IContractService;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService iContractService;

    @Autowired
    private IAttachFacilityService iAttachFacilityService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IFacilityService iFacilityService;

    @GetMapping(value = "")
    public String findAll(Model model,
                          @PageableDefault(size = 5) Pageable pageable,
                          @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");

        model.addAttribute("listContract",
                iContractService.findByCustomerCustomerNameContaining(keywordVal, pageable));
        model.addAttribute("keywordVal", keywordVal);

        model.addAttribute("customerList", iCustomerService.findAll());
        model.addAttribute("facilityList", iFacilityService.findAll());
        model.addAttribute("attachFacilityList", iAttachFacilityService.findAll());
        model.addAttribute("contractDetail", new ContractDetail());
        return "contract/list";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("contractDto", new ContractDto());
        return "contract/create";
    }

    @PostMapping(value = "/create")
    public String save(@ModelAttribute @Valid ContractDto contractDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "contract/create";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        contract.setDeposit(Double.parseDouble(contractDto.getDeposit()));

        iContractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "Register successfully!");
        return "redirect:/contract";
    }

}
