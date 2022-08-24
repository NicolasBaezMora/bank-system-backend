package com.nicolas.project_postgres.dtos;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String phone;
}
