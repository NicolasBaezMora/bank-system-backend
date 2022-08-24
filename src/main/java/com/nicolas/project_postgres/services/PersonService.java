package com.nicolas.project_postgres.services;

import com.nicolas.project_postgres.exceptions.GeneralServiceException;
import com.nicolas.project_postgres.exceptions.NoDataFoundException;
import com.nicolas.project_postgres.exceptions.ValidateServiceException;
import com.nicolas.project_postgres.models.Person;
import com.nicolas.project_postgres.repositories.PersonRepository;
import com.nicolas.project_postgres.validators.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository pr;

    public List<Person> getAllPersons() {
        return pr.findAll();
    }

//    @Transactional
//    public Person createNewPerson(Person person) {
//        return pr.save(person);
//    }

    @Transactional
    public Person savePerson(Person person) {

        try {
            //VALIDATE OBJECT
            PersonValidator.validatePerson(person);
            //----------------
            if (person.getId() == null) return pr.save(person);
            Person personToUpdate = pr.findById(person.getId())
                    .orElseThrow(() -> new NoDataFoundException("The person with id " + person.getId() + " is not found"));

            personToUpdate.setName(person.getName());
            personToUpdate.setLastname(person.getLastname());
            personToUpdate.setEmail(person.getEmail());
            personToUpdate.setPhone(person.getPhone());
            return pr.save(personToUpdate);

        } catch (ValidateServiceException | NoDataFoundException e) {
            System.out.println("ERROR --> " + e);
            throw e;
        } catch (Exception e) {
            throw new GeneralServiceException(e.getMessage());
        }


    }

}
