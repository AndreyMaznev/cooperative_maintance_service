package com.manv.cooperative_maintenance_service.service;


import com.manv.cooperative_maintenance_service.model.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonService {
    ResponseEntity <List<Person>> getAllPersonList ();
    ResponseEntity<Person> createNewPerson(Person person);
}
