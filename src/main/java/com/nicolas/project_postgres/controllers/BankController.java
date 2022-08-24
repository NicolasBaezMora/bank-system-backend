package com.nicolas.project_postgres.controllers;

import com.nicolas.project_postgres.converters.BankConverter;
import com.nicolas.project_postgres.dtos.BankDTO;
import com.nicolas.project_postgres.models.Bank;
import com.nicolas.project_postgres.repositories.BankRepository;
import com.nicolas.project_postgres.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankController {

    @Autowired
    private BankConverter bc;

    @Autowired
    private BankService bs;

    @GetMapping(value = "banks")
    public ResponseEntity<List<BankDTO>> getBanks() {
        List<BankDTO> banks = bc.fromEntity(bs.getAllBanks());
        return new ResponseEntity<>(banks, HttpStatus.OK);
    }

    @PostMapping(value = "banks")
    public ResponseEntity<BankDTO> addBank(
            @RequestBody BankDTO bankDTO
    ) {
        BankDTO newBank = bc.fromEntity(bs.createNewBank(bc.fromDTO(bankDTO)));
        return new ResponseEntity<>(newBank, HttpStatus.OK);
    }

    @DeleteMapping(value = "banks/{id}")
    public ResponseEntity<Boolean> deleteBank(
            @PathVariable Long id
    ) {
        bs.deleteBankById(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
