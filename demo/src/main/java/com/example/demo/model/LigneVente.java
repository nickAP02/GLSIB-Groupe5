package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class LigneVente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private int quantite;
    private double prixUnitaire;
    @ManyToOne
    @JoinColumn(name = "produit_id",insertable = false,updatable = false)
    private Produit produit;
    private int produit_id;
}
