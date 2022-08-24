package com.nicolas.project_postgres.dtos;

import com.nicolas.project_postgres.models.Bank;
import com.nicolas.project_postgres.models.Coin;
import com.nicolas.project_postgres.models.Person;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private Long id;
    private String description;
    private PersonDTO person;
    private BankDTO bank;
    private CoinDTO coin;
}
