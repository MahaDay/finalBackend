package com.bezkoder.spring.login.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TRANSACTION")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Transaction {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id_transaction;
    private Integer montant;
    @Enumerated(EnumType.STRING)
    private MethodePaiement methodePaiement;
    @Enumerated(EnumType.STRING)
    private StatutTransaction statutTransaction;
    @Enumerated(EnumType.STRING)
    private TypeTransaction typeTransaction;
    @ManyToOne
    @JoinColumn(name = "id_Produit",referencedColumnName = "id_produit")
    @JsonIgnore
    private Produit produit ;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_ajout ;


    @ManyToOne
    @JoinColumn(name = "id_Client",referencedColumnName = "id_client")
    @JsonIgnore
    private Client client;


    @ManyToOne
    @JoinColumn(name = "id_user",referencedColumnName = "id")
    @JsonIgnore
    private User user ;


}
