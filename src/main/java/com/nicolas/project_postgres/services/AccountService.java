package com.nicolas.project_postgres.services;

import com.nicolas.project_postgres.exceptions.GeneralServiceException;
import com.nicolas.project_postgres.exceptions.NoDataFoundException;
import com.nicolas.project_postgres.exceptions.ValidateServiceException;
import com.nicolas.project_postgres.models.Account;
import com.nicolas.project_postgres.models.Person;
import com.nicolas.project_postgres.repositories.AccountRepository;
import com.nicolas.project_postgres.validators.AccountValidator;
import com.nicolas.project_postgres.validators.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository ar;

    public List<Account> getAllAccounts() {
        return ar.getAccountsOrdered();
    }

    public Account getAccountById(Long id) throws Exception {
        return ar.findById(id)
                .orElseThrow(() -> new Exception("The account with id " + " is not found"));
    }

//    public Account createNewAccount(Account account) {
//        return ar.save(account);
//    }

    @Transactional
    public Account saveAccount(Account account) {

        try {
            //VALIDATE OBJECT
            AccountValidator.validateAccount(account);
            //----------------
            if (account.getId() == null) return ar.save(account);
            Account accountToUpdate = ar.findById(account.getId())
                    .orElseThrow(() -> new NoDataFoundException("The account with id " + " is not found"));
            accountToUpdate.setDescription(account.getDescription());
            accountToUpdate.setPerson(account.getPerson());
            accountToUpdate.setBank(account.getBank());
            accountToUpdate.setCoin(account.getCoin());
            return ar.save(accountToUpdate);
        } catch (ValidateServiceException | NoDataFoundException e) {
            System.out.println("ERROR --> " + e);
            throw e;
        } catch (Exception e) {
            throw new GeneralServiceException(e.getMessage());
        }

    }

}
