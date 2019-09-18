package com.apl.brokr.web.controllers;

import com.apl.brokr.dto.RequestDataDto;
import com.apl.brokr.model.entities.GeneralInsuranceCategory;
import com.apl.brokr.model.entities.InsuranceSubcategory;
import com.apl.brokr.model.entities.User;
import com.apl.brokr.services.ClientRequestService;
import com.apl.brokr.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/broker")
public class BrokerController {


    private final ClientRequestService clientRequestService;
    private final UserService userService;

    public BrokerController(ClientRequestService clientRequestService, UserService userService) {
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
        filledDto.setClient(userService.findByUsername(principal.getName()));
        clientRequestService.save(dataDto);
        return "main-menu";
    }

    @GetMapping("/request/all")
    public String displayRequestList(Model model, Principal principal) {

        List<RequestDataDto> requests = clientRequestService.getAll();
        model.addAttribute("requests", requests);
        return "request-list";
    }

    @GetMapping("/request/{id}")
    public String displayChosenRequest(@PathVariable Long id, Model model) {

        RequestDataDto data = clientRequestService.getOneById(id);
        model.addAttribute("request", data);
        return "request-single";
    }

    @GetMapping("/clients/all")
    public String displayClients(
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size){

       int currentPage = page.orElse(0);
       int currentSize = size.orElse(8);

       Page<User> clients = userService.getAllClients(PageRequest.of(currentPage, currentSize, Sort.by(Sort.Direction.ASC, "createdOn")));
       model.addAttribute("clients", clients);

       int totalPages = clients.getTotalPages();
       if (totalPages > 0){

           List<Integer> pageNumbers = IntStream.range(0, totalPages).boxed().collect(Collectors.toList());
           model.addAttribute("pageNumbers", pageNumbers);
       }
        return "client-list";
    }

    @GetMapping("/clients/{id}")
    public String displayChosenClient(@PathVariable("id") Long id, Model model){

      User client = userService.findById(id);
      model.addAttribute("client", client);
        return "client-single";
    }

}
