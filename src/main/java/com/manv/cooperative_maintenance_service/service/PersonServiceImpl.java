package com.manv.cooperative_maintenance_service.service;

import com.manv.cooperative_maintenance_service.model.Person;
import com.manv.cooperative_maintenance_service.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public ResponseEntity<Person> createNewPerson(Person person) {
        RestPreconditions.checkNotNull(person);
        personRepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Person> deletePerson(UUID uuid) {
        RestPreconditions.checkNotNull(personRepository.findByUuid(uuid));
        personRepository.deleteByUuid(uuid);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Person> update (UUID uuid, Person person) {
        RestPreconditions.checkNotNull(personRepository.findByUuid(uuid));
        RestPreconditions.checkNotNull(person);
        RestPreconditions.checkThatUuidAreEquals(uuid, person.getUuid());
        personRepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.ACCEPTED);
    }
}
