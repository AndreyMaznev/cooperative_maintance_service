package com.manv.cooperative_maintenance_service.controller;

import com.manv.cooperative_maintenance_service.service.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonController {

    PersonDetailsService personDetailsService;

    @Autowired
    public PersonController(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @GetMapping("/allPersonList")
    public String getAllPersonList (Model model) {
        model.addAttribute("allPersonList", personDetailsService.findAll());
        return "/profile/allPersonList";
    }
}
