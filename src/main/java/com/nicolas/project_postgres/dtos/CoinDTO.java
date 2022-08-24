package com.nicolas.project_postgres.dtos;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoinDTO {
    private Long id;
    private String name;
}
