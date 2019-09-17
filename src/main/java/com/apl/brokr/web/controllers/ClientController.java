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

        Map<GeneralInsuranceCategory, Set<InsuranceSubcategory>> map = clientRequestService.getCompleteMapOfInsuranceCategories();
        model.addAttribute("data", new RequestDataDto());
        model.addAttribute("mapa", map);
        return "request-form";
    }


    @PostMapping("/request/add")
    public String proceedRequestForm(@ModelAttribute("data") RequestDataDto dataDto, Principal principal) {

        RequestDataDto filledDto = dataDto;
        System.out.println("Principal: " + principal.getName());
        filledDto.setClient(userService.findByUsername(principal.getName()));
        System.out.println(filledDto.toString());
        clientRequestService.save(dataDto);

        System.out.println(dataDto.toString());

        return "main-menu";
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
