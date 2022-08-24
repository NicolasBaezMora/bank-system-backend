package com.nicolas.project_postgres.services;

import com.nicolas.project_postgres.exceptions.GeneralServiceException;
import com.nicolas.project_postgres.exceptions.NoDataFoundException;
import com.nicolas.project_postgres.exceptions.ValidateServiceException;
import com.nicolas.project_postgres.models.Account;
import com.nicolas.project_postgres.models.Bank;
import com.nicolas.project_postgres.repositories.BankRepository;
import com.nicolas.project_postgres.validators.AccountValidator;
import com.nicolas.project_postgres.validators.BankValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BankService {

    @Autowired
    private BankRepository br;

    public List<Bank> getAllBanks() {
        return br.findAll();
    }

    @Transactional
    public Bank createNewBank(Bank bank) {
        try {
            //VALIDATE OBJECT
            BankValidator.validateBank(bank);
            //----------------

            return br.save(bank);

        } catch (ValidateServiceException | NoDataFoundException e) {
            System.out.println("ERROR --> " + e);
            throw e;
        } catch (Exception e) {
            throw new GeneralServiceException(e.getMessage());
        }
    }

    @Transactional
    public void deleteBankById(Long id) {
        Bank bankToDelete = br.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank with id " + id + " doesn't exists"));
        br.delete(bankToDelete);
    }

}
