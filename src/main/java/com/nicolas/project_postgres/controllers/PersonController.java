package com.nicolas.project_postgres.controllers;

import com.nicolas.project_postgres.converters.PersonConverter;
import com.nicolas.project_postgres.dtos.PersonDTO;
import com.nicolas.project_postgres.models.Person;
import com.nicolas.project_postgres.repositories.PersonRepository;
import com.nicolas.project_postgres.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonConverter pc;

    @Autowired
    private PersonService ps;

    @RequestMapping(method = RequestMethod.GET, value = "helloworld")
    public String helloWorld() {
        return "Hello world";
    }

    @RequestMapping(method = RequestMethod.GET, value = "persons")
    public ResponseEntity<List<Person>> getPersons() {
        List<Person> persons = ps.getAllPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @PostMapping(value = "persons")
    public ResponseEntity<PersonDTO> addPerson(
            @RequestBody PersonDTO personDTO
    ) {
        PersonDTO newPerson = pc.fromEntity(ps.savePerson(pc.fromDTO(personDTO)));
        return new ResponseEntity<>(newPerson, HttpStatus.OK);
    }

    @PutMapping(value = "persons")
    public ResponseEntity<PersonDTO> updatePerson(
            @RequestBody PersonDTO personDTO
    ) {
        PersonDTO personDtoUpdated = pc.fromEntity(ps.savePerson(pc.fromDTO(personDTO)));
        return new ResponseEntity<>(personDtoUpdated, HttpStatus.OK);
    }


}
