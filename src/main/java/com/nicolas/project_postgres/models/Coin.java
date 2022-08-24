package com.nicolas.project_postgres.models;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Coins")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 150, nullable = false)
    private String name;

}
