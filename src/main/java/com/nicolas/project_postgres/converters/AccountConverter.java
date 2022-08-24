package com.nicolas.project_postgres.converters;

import com.nicolas.project_postgres.dtos.AccountDTO;
import com.nicolas.project_postgres.models.Account;
import com.nicolas.project_postgres.models.Bank;

public class AccountConverter extends AbstractConverter<Account, AccountDTO> {

    private final PersonConverter pc = new PersonConverter();
    private final CoinConverter cc = new CoinConverter();
    private final BankConverter bc = new BankConverter();

    @Override
    public AccountDTO fromEntity(Account entity) {
        if (entity == null) return null;
        return AccountDTO.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .bank(bc.fromEntity(entity.getBank()))
                .person(pc.fromEntity(entity.getPerson()))
                .coin(cc.fromEntity(entity.getCoin()))
                .build();
    }

    @Override
    public Account fromDTO(AccountDTO dto) {
        if (dto == null) return null;
        return Account.builder()
                .id(dto.getId())
                .description(dto.getDescription())
                .bank(bc.fromDTO(dto.getBank()))
                .person(pc.fromDTO(dto.getPerson()))
                .coin(cc.fromDTO(dto.getCoin()))
                .build();
    }
}
