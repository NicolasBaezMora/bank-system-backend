package com.nicolas.project_postgres.validators;

import com.nicolas.project_postgres.exceptions.ValidateServiceException;
import com.nicolas.project_postgres.models.Person;

public class PersonValidator {

    public static void validatePerson(Person person) {
        if (person.getName() == null || person.getName().trim().isEmpty())
            throw new ValidateServiceException("The person name is not valid or is missing");
        if (person.getLastname() == null || person.getLastname().trim().isEmpty())
            throw new ValidateServiceException("The person lastname is not valid or is missing");
        if (person.getEmail() == null || person.getEmail().trim().isEmpty())
            throw new ValidateServiceException("The person email is not valid or is missing");
        if (person.getPhone() == null || person.getPhone().trim().isEmpty())
            throw new ValidateServiceException("The person phone is not valid or is missing");
    }

}
