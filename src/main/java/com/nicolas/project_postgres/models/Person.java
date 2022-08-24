package com.nicolas.project_postgres.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Persons")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 155, nullable = false)
    private String name;

    @Column(name = "lastname", length = 155, nullable = false)
    private String lastname;

    @Column(name = "email", length = 55, nullable = false)
    private String email;

    @Column(name = "phone", length = 10, nullable = false)
    private String phone;

}
