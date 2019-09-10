package com.apl.brokr.web.controllers;

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

    @GetMapping
    public String displayRegistrationForm(Model model) {

        RegistrationDataDto dataDto = new RegistrationDataDto();
        model.addAttribute("data", dataDto);
        return "registration-form";
    }

    @PostMapping
    public String processRegistrationForm(@Valid @ModelAttribute("data") RegistrationDataDto dataDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "registration-form";
        }
        return "redirect:/login";
    }

}
