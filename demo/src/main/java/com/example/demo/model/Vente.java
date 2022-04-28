package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="ventes")
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_vente", nullable = false)
    private int codeVente;
    private LocalDate dateVente;
    @ManyToOne
    @JoinColumn(name = "ligne_id",insertable = false,updatable = false)
    private LigneVente ligne;
    private int ligne_id;
    @ManyToOne
    @JoinColumn(name = "client_id",insertable = false,updatable = false)
    private Client client;
    private int client_id;
}
