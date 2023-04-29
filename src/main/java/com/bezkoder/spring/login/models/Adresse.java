package com.bezkoder.spring.login.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ADRESSE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_adresse;
    private String avenu;
    private String ville;
    private String pays;
    private Integer code_postal;

}
