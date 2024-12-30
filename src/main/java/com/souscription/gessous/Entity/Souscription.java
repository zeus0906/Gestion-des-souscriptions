package com.souscription.gessous.Entity;

import com.souscription.gessous.Entity.User.Utilisateur;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Souscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSouscription;

    private Date dateSouscription;

    private Date dateDebutSouscription;

    private Date dateFinSouscription;

    private Double montantTotal;

    @ManyToOne
    @JoinColumn(name = "produit_id", nullable = false)
    private ProduitAssurance produit;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;
}
