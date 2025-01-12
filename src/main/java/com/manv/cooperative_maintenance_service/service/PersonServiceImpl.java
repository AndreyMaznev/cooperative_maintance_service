package com.manv.cooperative_maintenance_service.service;

import com.manv.cooperative_maintenance_service.model.Person;
import com.manv.cooperative_maintenance_service.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public ResponseEntity<List<Person>> getAllPersonList() {
        List<Person> personList = personRepository.findAll();
        if (personList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }
}
