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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codeVente", nullable = false)

    private Integer codeVente;
    private LocalDate dateVente;

    public Integer getCodeVente() {
        return codeVente;
    }

    public void setCodeVente(Integer codeVente) {
        this.codeVente = codeVente;
    }

    public LocalDate getDateVente() {
        return dateVente;
    }

    public void setDateVente(LocalDate dateVente) {
        this.dateVente = dateVente;
    }
}