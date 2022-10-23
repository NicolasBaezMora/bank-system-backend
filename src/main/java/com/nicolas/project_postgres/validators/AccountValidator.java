package com.nicolas.project_postgres.validators;

import com.nicolas.project_postgres.exceptions.ValidateServiceException;
import com.nicolas.project_postgres.models.Account;
import com.nicolas.project_postgres.repositories.AccountRepository;
import com.nicolas.project_postgres.repositories.BankRepository;
import com.nicolas.project_postgres.repositories.CoinRepository;
import com.nicolas.project_postgres.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountValidator {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private CoinRepository coinRepository;

    public void validateAccount(Account account) {
        if (account.getDescription() == null || account.getDescription().trim().isEmpty())
            throw new ValidateServiceException("The account description is not valid or is missing");
        if (account.getPerson() == null)
            throw new ValidateServiceException("The person is missing");
        if (account.getCoin() == null)
            throw new ValidateServiceException("The coin is missing");
        if (account.getBank() == null)
            throw new ValidateServiceException("The bank is missing");

        personRepository.findById(account.getPerson().getId())
                .orElseThrow(() -> new ValidateServiceException("The person with id " + account.getPerson().getId() + " is not found"));

        bankRepository.findById(account.getBank().getId())
                .orElseThrow(() -> new ValidateServiceException("The bank with id " + account.getBank().getId() + " is not found"));

        coinRepository.findById(account.getCoin().getId())
                .orElseThrow(() -> new ValidateServiceException("The coin with id " + account.getCoin().getId() + " is not found"));
    }

}
