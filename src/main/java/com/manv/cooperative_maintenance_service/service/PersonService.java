package com.manv.cooperative_maintenance_service.service;


import com.manv.cooperative_maintenance_service.model.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface PersonService {
    ResponseEntity <List<Person>> getAllPersonList ();
    ResponseEntity<Person> createNewPerson(Person person);
    ResponseEntity<Person> deletePerson(UUID uuid);
    ResponseEntity<Person> update(UUID uuid, Person person);
}
