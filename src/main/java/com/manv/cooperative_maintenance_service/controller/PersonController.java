package com.manv.cooperative_maintenance_service.controller;

import com.manv.cooperative_maintenance_service.model.Person;
import com.manv.cooperative_maintenance_service.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonServiceImpl personService;

    @Autowired
    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    public ResponseEntity <List<Person>> getAllPersonList () {
        return personService.getAllPersonList();
    }
}
