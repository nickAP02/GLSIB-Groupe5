package com.example.demo.repository;

import com.example.demo.model.Produit;
import com.example.demo.model.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenteRepository extends JpaRepository<Vente,Integer> {
}
