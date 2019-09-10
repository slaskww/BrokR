package com.apl.brokr.web.controllers;

import com.apl.brokr.dto.RegistrationDataDto;
import com.apl.brokr.model.Role;
import com.apl.brokr.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private RegistrationService service;

    @Autowired
    public RegistrationController(RegistrationService service) {
        this.service = service;
    }

    @GetMapping
    public String displayRegistrationForm(Model model) {

        RegistrationDataDto dataDto = new RegistrationDataDto();
        model.addAttribute("data", dataDto);
        return "registration-form";
    }

    @PostMapping
    public String processRegistrationForm(@Valid @ModelAttribute("data") RegistrationDataDto dataDto, BindingResult bindingResult) {

        System.out.println(dataDto.toString());
        if (bindingResult.hasErrors()) {
            System.out.println("form has error(s)");
            return "registration-form";
        }

        dataDto.setRole("broker");
        service.save(dataDto);

       // return "redirect:/login";
        return "main-menu";
    }

}
