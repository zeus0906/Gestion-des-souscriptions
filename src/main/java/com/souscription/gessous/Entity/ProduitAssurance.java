package com.souscription.gessous.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProduitAssurance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAssurance;

    private String nom;

    private String description;

    private Double montant;
}
