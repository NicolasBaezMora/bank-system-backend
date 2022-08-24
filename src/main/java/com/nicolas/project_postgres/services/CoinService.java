package com.nicolas.project_postgres.services;

import com.nicolas.project_postgres.converters.CoinConverter;
import com.nicolas.project_postgres.exceptions.GeneralServiceException;
import com.nicolas.project_postgres.exceptions.NoDataFoundException;
import com.nicolas.project_postgres.exceptions.ValidateServiceException;
import com.nicolas.project_postgres.models.Coin;
import com.nicolas.project_postgres.repositories.CoinRepository;
import com.nicolas.project_postgres.validators.BankValidator;
import com.nicolas.project_postgres.validators.CoinValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CoinService {

    @Autowired
    private CoinRepository cr;

    public List<Coin> getAllCoins() {
        return cr.findAll();
    }

    @Transactional
    public Coin createNewCoin(Coin coin) {
        try {
            //VALIDATE OBJECT
            CoinValidator.validateCoin(coin);
            //----------------

            return cr.save(coin);

        } catch (ValidateServiceException | NoDataFoundException e) {
            System.out.println("ERROR --> " + e);
            throw e;
        } catch (Exception e) {
            throw new GeneralServiceException(e.getMessage());
        }
    }

}
