package com.apl.brokr.web.controllers;

import com.apl.brokr.dto.RequestDataDto;
import com.apl.brokr.model.entities.GeneralInsuranceCategory;
import com.apl.brokr.model.entities.InsuranceSubcategory;
import com.apl.brokr.services.ClientRequestService;
import com.apl.brokr.services.GeneralInsuranceCatService;
import com.apl.brokr.services.InsuranceSubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.Set;


@Controller
@RequestMapping("/client")
public class ClientController {

    private ClientRequestService clientRequestService;


    @Autowired
    public ClientController(ClientRequestService clientRequestService) {
        this.clientRequestService = clientRequestService;

    }

    @GetMapping("/request/add")
    public String displayRequestForm(Model model){

       Map<GeneralInsuranceCategory, Set<InsuranceSubcategory>> map = clientRequestService.getCompleteMapOfInsuranceCategories();
       map.entrySet().forEach(stringSetEntry -> System.out.println(stringSetEntry.getKey() + stringSetEntry.getValue().toString()));

        model.addAttribute("data", new RequestDataDto());
        model.addAttribute("mapa", map);
        return "request-form";
    }


    @PostMapping("/request/add")
    public String proceedRequestForm(){


        return "main-menu";
    }

    @GetMapping("/request/all")
    public String displayRequestList(Model model){

        return "request-list";
    }
}
