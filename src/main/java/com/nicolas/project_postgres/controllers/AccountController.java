package com.nicolas.project_postgres.controllers;

import com.nicolas.project_postgres.converters.AccountConverter;
import com.nicolas.project_postgres.dtos.AccountDTO;
import com.nicolas.project_postgres.models.Account;
import com.nicolas.project_postgres.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService as;

    @Autowired
    private AccountConverter ac;

    @GetMapping(value = "accounts")
    public ResponseEntity<List<AccountDTO>> getAccounts() {
        List<AccountDTO> accountDTOS = ac.fromEntity(as.getAllAccounts());
        return new ResponseEntity<>(accountDTOS, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "accounts/{id}")
    public ResponseEntity<AccountDTO> getAccountById(
            @PathVariable(value = "id") Long id
    ) throws Exception {
        AccountDTO account = ac.fromEntity(as.getAccountById(id));
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PostMapping(value = "accounts")
    public ResponseEntity<AccountDTO> addAccount(
            @RequestBody AccountDTO accountDTO
    ) {
        AccountDTO newAccount = ac.fromEntity(as.saveAccount(ac.fromDTO(accountDTO)));
        return new ResponseEntity<>(newAccount, HttpStatus.OK);
    }

    @PutMapping(value = "accounts")
    public ResponseEntity<AccountDTO> updateAccount(
            @RequestBody AccountDTO accountDTO
    ) {
        AccountDTO accountDtoUpdated = ac.fromEntity(as.saveAccount(ac.fromDTO(accountDTO)));
        return new ResponseEntity<>(accountDtoUpdated, HttpStatus.OK);
    }

}
