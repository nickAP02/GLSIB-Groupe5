package com.example.demo.model.repository;

import com.example.demo.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Integer> {

    //@Transactional
    //@Modifying
    //@Query("update produits p set p.qteStock = p.qteStock + :qte where p.id = :id")
    //void UpdateQteProduit(@Param("id") int id, @Param("qte") int qte);
}
