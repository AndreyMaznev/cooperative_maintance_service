package com.manv.cooperative_maintenance_service.controller;

import com.manv.cooperative_maintenance_service.model.User;
import com.manv.cooperative_maintenance_service.model.DTO.UserDTO;
import com.manv.cooperative_maintenance_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class RestUserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity <List<UserDTO>> getAllUserList () {
        List <UserDTO> tempList = userService.getAllUserDTOList();
        if (tempList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tempList, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/create")
    public void createPerson (@RequestBody User user) {
        userService.createUser(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/delete/{id}")
    public void deletePerson (@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/update/{id}")
    public ResponseEntity <User> update(@PathVariable Long id, @RequestBody User user) {
        return new ResponseEntity<>(userService.update(id, user), HttpStatus.OK);
    }
}
