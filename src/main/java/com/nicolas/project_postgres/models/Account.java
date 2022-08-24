package com.nicolas.project_postgres.models;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Accounts")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", length = 255, nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "fk_person", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "fk_bank", nullable = false)
    private Bank bank;

    @ManyToOne
    @JoinColumn(name = "fk_coin", nullable = false)
    private Coin coin;


}
