package com.nicolas.project_postgres.validators;

import com.nicolas.project_postgres.exceptions.ValidateServiceException;
import com.nicolas.project_postgres.models.Account;

public class AccountValidator {

    public static void validateAccount(Account account) {
        if (account.getDescription() == null || account.getDescription().trim().isEmpty())
            throw new ValidateServiceException("The account description is not valid or is missing");
        if (account.getPerson() == null)
            throw new ValidateServiceException("The person is missing");
        if (account.getCoin() == null)
            throw new ValidateServiceException("The coin is missing");
        if (account.getBank() == null)
            throw new ValidateServiceException("The bank is missing");
    }

}
