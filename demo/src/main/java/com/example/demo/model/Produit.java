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
@Table(name ="produits")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String libelle;
    private int qteStock;
    private int qteSeuil;
    private float prix;
    private LocalDate dateCreation;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    @ManyToOne
    @JoinColumn(name = "categoryId",insertable = false,updatable = false)
    private Category category;
    private int categoryId;
}
