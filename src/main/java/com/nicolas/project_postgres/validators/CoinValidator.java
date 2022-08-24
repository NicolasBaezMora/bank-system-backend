package com.nicolas.project_postgres.validators;

import com.nicolas.project_postgres.exceptions.ValidateServiceException;
import com.nicolas.project_postgres.models.Coin;

public class CoinValidator {

    public static void validateCoin(Coin coin) {

        if (coin.getName() == null || coin.getName().trim().isEmpty())
            throw new ValidateServiceException("The coin name is not valid or is missing");

    }

}
