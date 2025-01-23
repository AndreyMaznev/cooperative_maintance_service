//package com.manv.cooperative_maintenance_service.controller;
//
//import com.manv.cooperative_maintenance_service.model.Person;
//import com.manv.cooperative_maintenance_service.service.PersonServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/api/v1/user")
//public class RestUserController {
//
//    private final PersonServiceImpl personService;
//
//    @Autowired
//    public RestPersonController(PersonServiceImpl personService) {
//        this.personService = personService;
//    }
//
//    @GetMapping("/all")
//    public ResponseEntity <List<Person>> getAllPersonList () {
//        return personService.getAllPersonList();
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity <Person> createPerson (@RequestBody Person person) {
//        return personService.createNewPerson(person);
//    }
//
//    @GetMapping("/delete/{uuid}")
//    public ResponseEntity <Person> deletePerson (@PathVariable UUID uuid) {
//        return personService.deletePerson(uuid);
//    }
//
//    @PutMapping(value = "/update/{uuid}")
//    public ResponseEntity <Person> update(@PathVariable( "uuid" ) UUID uuid, @RequestBody Person person) {
//        return personService.update(uuid, person);
//    }
//}
