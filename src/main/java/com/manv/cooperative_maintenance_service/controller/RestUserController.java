package com.manv.cooperative_maintenance_service.controller;

import com.manv.cooperative_maintenance_service.model.User;
import com.manv.cooperative_maintenance_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class RestUserController {

    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity <List<User>> getAllUserList () {
        List <User> tempList = userService.getAllPersonList();
        return tempList == null ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(tempList, HttpStatus.OK);
    }

//    @PostMapping("/create")
//    public ResponseEntity <User> createPerson (@RequestBody User person) {
//        return personService.createNewPerson(person);
//    }
//
//    @GetMapping("/delete/{uuid}")
//    public ResponseEntity <User> deletePerson (@PathVariable Long id) {
//        return personService.deletePerson(uuid);
//    }
//
//    @PutMapping(value = "/update/{uuid}")
//    public ResponseEntity <User> update(@PathVariable( "uuid" ) UUID uuid, @RequestBody Person person) {
//        return personService.update(uuid, person);
//    }
}
