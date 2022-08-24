package com.nicolas.project_postgres.validators;

import com.nicolas.project_postgres.exceptions.ValidateServiceException;
import com.nicolas.project_postgres.models.Bank;

public class BankValidator {

    public static void validateBank(Bank bank) {
        if (bank.getName() == null || bank.getName().trim().isEmpty())
            throw new ValidateServiceException("The bank name is not valid or is missing");
    }

}
