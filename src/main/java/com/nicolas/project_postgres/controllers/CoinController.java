package com.nicolas.project_postgres.controllers;


import com.nicolas.project_postgres.converters.CoinConverter;
import com.nicolas.project_postgres.dtos.CoinDTO;
import com.nicolas.project_postgres.services.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoinController {

    @Autowired
    private CoinService cs;

    @Autowired
    private CoinConverter cc;

    @GetMapping(value = "coins")
    public ResponseEntity<List<CoinDTO>> getCoins() {
        List<CoinDTO> coins = cc.fromEntity(cs.getAllCoins());
        return new ResponseEntity<>(coins, HttpStatus.OK);
    }

    @PostMapping(value = "coins")
    public ResponseEntity<CoinDTO> addCoin(
            @RequestBody CoinDTO coinDTO
    ) {
        CoinDTO newCoin = cc.fromEntity(cs.createNewCoin(cc.fromDTO(coinDTO)));
        return new ResponseEntity<>(newCoin, HttpStatus.OK);
    }



}
