package com.example.demo.repository;

import com.example.demo.model.Approvisionnement;
import com.example.demo.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApproRepository extends JpaRepository<Approvisionnement,Integer> {
}
