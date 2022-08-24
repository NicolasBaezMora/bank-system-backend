package com.nicolas.project_postgres.converters;

import com.nicolas.project_postgres.dtos.AccountDTO;
import com.nicolas.project_postgres.dtos.BankDTO;
import com.nicolas.project_postgres.models.Account;
import com.nicolas.project_postgres.models.Bank;

import java.util.List;
import java.util.stream.Collectors;

public class BankConverter extends AbstractConverter<Bank, BankDTO> {

    private final PersonConverter pc = new PersonConverter();
    private final CoinConverter cc = new CoinConverter();

    @Override
    public BankDTO fromEntity(Bank entity) {
        if (entity == null) return null;
        return BankDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .accounts(fromAccount(entity.getAccounts()))
                .build();
    }

    @Override
    public Bank fromDTO(BankDTO dto) {
        if (dto == null) return null;
        return Bank.builder()
                .id(dto.getId())
                .name(dto.getName())
                .accounts(fromAccountDTO(dto.getAccounts()))
                .build();
    }

    private List<AccountDTO> fromAccount(List<Account> accounts) {
        if (accounts == null) return null;
        return accounts.stream().map(
                account -> AccountDTO.builder()
                        .id(account.getId())
                        .description(account.getDescription())
                        .person(pc.fromEntity(account.getPerson()))
                        .coin(cc.fromEntity(account.getCoin()))
                        .build()
        ).collect(Collectors.toList());
    }

    private List<Account> fromAccountDTO(List<AccountDTO> accountDTOS) {
        if (accountDTOS == null) return null;
        return accountDTOS.stream().map(
                accountDTO -> Account.builder()
                        .id(accountDTO.getId())
                        .description(accountDTO.getDescription())
                        .person(pc.fromDTO(accountDTO.getPerson()))
                        .coin(cc.fromDTO(accountDTO.getCoin()))
                        .build()
        ).collect(Collectors.toList());
    }
}
