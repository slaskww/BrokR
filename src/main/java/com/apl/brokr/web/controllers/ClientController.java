package com.apl.brokr.web.controllers;

import com.apl.brokr.dto.RequestDataDto;
import com.apl.brokr.model.entities.GeneralInsuranceCategory;
import com.apl.brokr.model.entities.InsuranceSubcategory;
import com.apl.brokr.services.ClientRequestService;
import com.apl.brokr.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Controller
@RequestMapping("/client")
public class ClientController {

    private ClientRequestService clientRequestService;
    private UserService userService;


    public ClientController(ClientRequestService clientRequestService, UserService userService) {
        this.clientRequestService = clientRequestService;
        this.userService = userService;
    }

    @GetMapping("/request/add")
    public String displayRequestForm(Model model) {

        List<GeneralInsuranceCategory> generalCat = clientRequestService.getAllGenralInsCat();
        List<InsuranceSubcategory> subcategories = new ArrayList<>();

        model.addAttribute("data", new RequestDataDto());
        model.addAttribute("generalCat", generalCat);
        model.addAttribute("subcategories", subcategories);
        return "request-form";
    }


    @PostMapping(value = "/request/add", params = ("save"))
    public String proceedRequestForm(@ModelAttribute("data") RequestDataDto dataDto, Principal principal) {
        dataDto.setClient(userService.findByUsername(principal.getName()));
        clientRequestService.save(dataDto);
        System.out.println(dataDto.toString());
        return "main-menu";
    }

    @PostMapping(value = "/request/add", params = ("generalInsuranceCategory"))
    public String displayRequestFormWithChosenGeneralCat(GeneralInsuranceCategory generalInsuranceCategory, Model model) {
        RequestDataDto data = new RequestDataDto();
        data.setGeneralInsuranceCategory(generalInsuranceCategory);
        model.addAttribute("data", data);
        model.addAttribute("generalCat", clientRequestService.getAllGenralInsCat());
        model.addAttribute("subcategories", clientRequestService.getAllInsSubcstByGeneralCategName(generalInsuranceCategory.getName()));
        return "request-form";
    }
    @GetMapping("/request/all")
    public String displayRequestList(Model model, Principal principal) {

        List<RequestDataDto> requests = clientRequestService.getAllByUsername(principal.getName());
        model.addAttribute("requests", requests);
        return "request-list";
    }

    @GetMapping("/request/{id}")
    public String displayChosenRequest(@PathVariable Long id, Model model) {

        RequestDataDto data = clientRequestService.getOneById(id);
        model.addAttribute("request", data);

        return "request-single";
    }
}
