package com.apl.brokr.web.controllers;

import com.apl.brokr.dto.RegistrationDataDto;
import com.apl.brokr.model.Role;
import com.apl.brokr.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class RegistrationController {

    private RegistrationService service;

    @Autowired
    public RegistrationController(RegistrationService service) {
        this.service = service;
    }

    @GetMapping("/register")
    public String displayRegistrationForm(Model model) {

        RegistrationDataDto dataDto = new RegistrationDataDto();
        model.addAttribute("data", dataDto);
        return "registration-form";
    }

    @PostMapping("/register")
    public String processRegistrationForm(@Valid @ModelAttribute("data") RegistrationDataDto dataDto, BindingResult bindingResult) {

        System.out.println(dataDto.toString());
        if (bindingResult.hasErrors()) {
            System.out.println("form has error(s)");
            return "registration-form";
        }


        if (dataDto.getId() == null) {
         //   dataDto.setRole("client");
            service.save(dataDto);
        } else {
            service.update(dataDto);
        }
        // return "redirect:/login";
        return "main-menu";
    }

    @GetMapping("/edit")
    public String editUserData(Model model, Principal principal) {
        RegistrationDataDto dataDto = service.getRegistrationDataDto(principal.getName());
        model.addAttribute("data", dataDto);

        return "registration-form";
    }
}
//        List<String> authorities = userDetails.getAuthorities().stream().map(o -> o.getAuthority()).collect(Collectors.toList());
//        dataDto = service.getRegistrationDataDto(userDetails.getUsername(), authorities);