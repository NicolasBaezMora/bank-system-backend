package com.nicolas.project_postgres.converters;

import com.nicolas.project_postgres.dtos.PersonDTO;
import com.nicolas.project_postgres.models.Person;

public class PersonConverter extends AbstractConverter<Person, PersonDTO> {
    @Override
    public PersonDTO fromEntity(Person entity) {
        if (entity == null) return null;
        return PersonDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .lastname(entity.getLastname())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .build();
    }

    @Override
    public Person fromDTO(PersonDTO dto) {
        if (dto == null) return null;
        return Person.builder()
                .id(dto.getId())
                .name(dto.getName())
                .lastname(dto.getLastname())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .build();
    }
}
