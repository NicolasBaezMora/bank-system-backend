package com.nicolas.project_postgres.dtos;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankDTO {
    private Long id;
    private String name;
    private List<AccountDTO> accounts;
}
